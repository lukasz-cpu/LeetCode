package binary.tree.max.depth;

public class BinaryTreeMaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        int maxDepth = getMaxDepth(root);
        System.out.println("Max depth " + maxDepth);


    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getMaxDepth(root.left);
        int rightDepth = getMaxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
