/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
        public int heightDFS(TreeNode root, Map<TreeNode, Integer> nodeDia) {
            if (root == null) return 0;
            int left = heightDFS(root.left, nodeDia);
            int right = heightDFS(root.right, nodeDia);
            nodeDia.put(root, left + right);
            return Math.max(left, right) + 1;
        }

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            Map<TreeNode, Integer> nodeDia = new HashMap<>();
            heightDFS(root, nodeDia);
            return nodeDia.values().stream().mapToInt(Integer::intValue).max().getAsInt();
        }
}
