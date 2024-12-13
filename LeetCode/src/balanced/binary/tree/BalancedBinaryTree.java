package balanced.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Integer[] rootArray = {3,9,20,null,null,15,7};

        TreeNode root = buildTree(rootArray);
        System.out.println(isBalanced(root));


    }

    public static boolean isBalanced(TreeNode root) {
        return size(root) != -1;
    }

    private static int size(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = size(node.left);
        int rightHeight = size(node.right);

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }


    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
