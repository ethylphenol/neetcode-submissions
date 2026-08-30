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
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            boolean[] balanced = new boolean[] {true};
            balancedDFS(root, balanced);
            return balanced[0];
        }

        public int balancedDFS(TreeNode root, boolean[] balanced) {
            if (root == null) return 0;
            int left = balancedDFS(root.left, balanced);
            int right = balancedDFS(root.right, balanced);
            if (Math.abs(left - right) > 1) {
                balanced[0] = false;
            }
            return Math.max(left, right) + 1;
        }
}
