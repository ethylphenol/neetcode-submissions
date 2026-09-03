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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder root, left, right
        // inorder left, root, right
        if (preorder.length == 0 || inorder.length == 0) return null;
        int rootVal = preorder[0];
        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) break;
        }
        TreeNode n = new TreeNode(rootVal,
                buildTree(Arrays.copyOfRange(preorder, 1, i + 1), // left
                        Arrays.copyOfRange(inorder, 0, i)),
                buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length), // right
                        Arrays.copyOfRange(inorder, i+1, inorder.length))
        );
        return n;
    }
}
