import java.util.Stack;

public class TreeMirror {
    public static void Mirror01(TreeNode root) {
        if (root == null) {
            return;
        } else {
            root = reverse(root);
        }
    }

    public static TreeNode reverse(TreeNode root) {
        if (root == null) {
            return root;
        } else {
            TreeNode left = reverse(root.right);
            TreeNode right = reverse(root.left);
            root.left = left;
            root.right =right;
            return root;
        }
    }

    public static void Mirror02(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode tempNode = node.left;
            node.left = node.right;
            node.right = tempNode;
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }
}
