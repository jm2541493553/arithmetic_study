import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {
    public static void main(String[] args) {
        TreeNode root = new  TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(TreeDepth2(root));
    }
    public static int TreeDepth1(TreeNode root) {
        if(root==null)
            return 0;
        return Math.max(TreeDepth1(root.left),TreeDepth1(root.right))+1;
    }

    public static int TreeDepth2(TreeNode root) {
        Queue<TreeNode> tree = new LinkedList<>();
        if (root != null) {
            tree.add(root);
        }
        int length = 0;
        while (!tree.isEmpty()) {
            int size = tree.size();
            while (size > 0) {
                TreeNode node = tree.peek();
                if (node.left != null) {
                    tree.add(node.left);
                }
                if (node.right != null) {
                    tree.add(node.right);
                }
                tree.remove(node);
                size--;
            }
            length++;
        }
        return length;
    }
}
