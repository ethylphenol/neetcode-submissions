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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> levels = new ArrayList<>();
            dfsLevel(root, 0, levels);
            return levels;
        }

        public void dfsLevel(TreeNode root, int level, List<List<Integer>> levels) {
            if (root == null) return;
            if (levels.size() == level) {
                levels.add(new ArrayList<>());
            }
            levels.get(level).add(root.val);
            dfsLevel(root.left, level + 1, levels);
            dfsLevel(root.right, level + 1, levels);
        }
}
