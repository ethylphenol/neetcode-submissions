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
        private void inorder(TreeNode root, List<Integer> l, int k) {
            if (root == null) return;
            inorder(root.left, l, k);
            if (l.size() == k) return;
            l.add(root.val);
            inorder(root.right, l, k);
        }

        public int kthSmallest(TreeNode root, int k) {
            List<Integer> l = new ArrayList<>();
            inorder(root, l, k);
            return l.getLast();
        }
}
