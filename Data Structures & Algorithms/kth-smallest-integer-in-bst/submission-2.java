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
        private void inorder(TreeNode root, int[] i, int k, int[] res) {
            if (root == null || i[0] > k) return;
            inorder(root.left, i, k, res);
            if (i[0]++ == k) {
                res[0] = root.val;
                return;
            }
            inorder(root.right, i, k, res);
        }

        public int kthSmallest(TreeNode root, int k) {
            int[] res = new int[]{-1};
            inorder(root, new int[] {1}, k, res);
            return res[0];
        }
}
