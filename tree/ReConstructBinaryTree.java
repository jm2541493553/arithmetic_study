public class ReConstructBinaryTree {
    public static TreeNode reConstructBinaryTree0(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        TreeNode root = constructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length-1);
        return root;
    }

    static  TreeNode constructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        // 不符合条件直接返回null
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        // 构建根节点
        TreeNode root = new TreeNode(pre[startPre]);
        for (int index = startIn; index <= endIn; index++) {
            if (in[index] == pre[startPre]) {
                // 左子树
                root.left = constructBinaryTree(pre, startPre + 1, startPre + (index - startIn), in, startIn, index - 1);
                // 右子树
                root.right = constructBinaryTree(pre, (index - startIn) + startPre + 1, endPre, in, index + 1, endIn);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree0(pre,in);
        TreeNode l = root.left;
        TreeNode r = root.right;

        System.out.println(root.val);
        System.out.println(l.val);
        System.out.println(r.val);
    }
}
