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
            private void dfsRight(TreeNode root, int level, List<Integer> rightVals, Set<Integer> levelsCovered) {
            if (root == null) return;
            if (!levelsCovered.contains(level)) {
                rightVals.add(root.val);
                levelsCovered.add(level);
            }
            dfsRight(root.right, level + 1, rightVals, levelsCovered);
            dfsRight(root.left, level + 1, rightVals, levelsCovered);
        }

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> rightVals = new ArrayList<>();
            Set<Integer> levelsCovered = new HashSet<>();
            dfsRight(root, 0, rightVals, levelsCovered);
            return rightVals;
        }
}
