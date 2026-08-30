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
        public TreeNode invertTree(TreeNode root) {
            Deque<TreeNode> queue = new ArrayDeque<>();
            if (root == null) return null;
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode n = queue.poll();
                TreeNode left = n.left;
                TreeNode right = n.right;
                n.right = left;
                n.left = right;
                if (left != null)
                    queue.offer(left);
                if (right != null)
                    queue.offer(right);
            }
            return root;
        }
}
