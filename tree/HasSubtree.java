public class HasSubtree {
    public static boolean HasSubtree1(TreeNode root1, TreeNode root2) {
        // 只要一个为null，则返回false
        if (root1 == null || root2 == null) {
            return false;
        }
        // 从当前根节点比较
        if (sameTree(root1, root2)) {
            return true;
        } else {
            // 否则分别使用左子树或者右子树与root2匹配
            return HasSubtree1(root1.left, root2) || HasSubtree1(root1.right, root2);
        }

    }

    public static boolean sameTree(TreeNode root1, TreeNode root2) {
        // 这里需要注意，当子结构遍历结束的时候，应该返回true
        if ( root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                return sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new  TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        TreeNode root2 = new  TreeNode(3);
        root2.left = new TreeNode(6);
        root2.right = new TreeNode(7);

        System.out.println(HasSubtree1(root, root2));
    }
}
