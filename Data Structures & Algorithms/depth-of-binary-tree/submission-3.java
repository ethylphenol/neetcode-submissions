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
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int h = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode n = queue.poll();
                    if (n.left != null)
                        queue.offer(n.left);
                    if (n.right != null)
                        queue.offer(n.right);
                }
                h++;
            }
            return h;
        }
}
