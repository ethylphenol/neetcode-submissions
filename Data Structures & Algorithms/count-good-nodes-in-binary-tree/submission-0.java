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
        public void dfsCount (TreeNode root, int [] count, int currentMax) {
            if (root == null) return;
            if (root.val >= currentMax) {
                count[0]++;
                dfsCount(root.right, count, root.val);
                dfsCount(root.left, count, root.val);
                return;
            }
            dfsCount(root.right, count, currentMax);
            dfsCount(root.left, count, currentMax);
        
        }
        public int goodNodes(TreeNode root) {
            int [] count = new int[] {0};
            dfsCount (root, count, Integer.MIN_VALUE);
            return count[0];
        }
}
