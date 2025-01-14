package diameter.of.binary.tree;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Tworzymy drzewo o strukturze [1, 2, 3, 4, 5]
        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(3)
        );

        int diameter = solution.diameterOfBinaryTree(root);
        System.out.println("Średnica drzewa: " + diameter);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        int max = Integer.MIN_VALUE;

        public int diameterOfBinaryTree(TreeNode root) {
            traverse(root);
            return max;
        }

        private int traverse(TreeNode node) {
            int left = 0, right = 0;

            if (node.left != null) {
                left = traverse(node.left);
            }

            if (node.right != null) {
                right = traverse(node.right);
            }
            max = Math.max(max, left + right);

            return Math.max(left, right) + 1;
        }
    }
}
