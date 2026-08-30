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
            int left = root.left != null ? height(root.left) : 0;
            int right = root.right != null ? height(root.right) : 0;
            return (right == left || Math.abs(right - left) == 1) && isBalanced(root.left) && isBalanced(root.right);
        }

        public int height(TreeNode root) {
            if (root == null) return 0;
            return Math.max(height(root.left), height(root.right)) + 1;
        }
}
