package lowest.common.ancestor;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        Integer[] rootArray = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = buildTree(rootArray);

        // Przypisanie węzłów p i q
        TreeNode p = findNode(root, 5); // Węzeł o wartości 5
        TreeNode q = findNode(root, 4); // Węzeł o wartości 1

        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("Najniższy wspólny przodek: " + (lca != null ? lca.val : "null"));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;


        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null){
            return root;
        } else{
            return left != null ? left : right;
        }
    }

    // Klasa TreeNode powinna być statyczna, aby działała w kontekście statycznym
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
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

    // Funkcja pomocnicza do wyszukiwania węzła o danej wartości
    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        TreeNode left = findNode(root.left, val);
        if (left != null) return left;

        return findNode(root.right, val);
    }
}
