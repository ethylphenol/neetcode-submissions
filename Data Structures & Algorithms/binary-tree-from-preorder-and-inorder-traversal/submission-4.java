class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder,
                0, preorder.length - 1,
                0, inorder.length - 1);
    }

    public TreeNode buildTree(
            int[] preorder, int[] inorder,
            int preLeft, int preRight,
            int inLeft, int inRight) {

        // preorder root, left, right
        // inorder left, root, right

        if (preLeft > preRight || inLeft > inRight) return null;

        int rootVal = preorder[preLeft];
        int i;

        for (i = inLeft; i <= inRight; i++) {
            if (inorder[i] == rootVal) break;
        }

        int leftSize = i - inLeft;

        TreeNode n = new TreeNode(rootVal,
                buildTree(preorder, inorder,
                        preLeft + 1,
                        preLeft + leftSize,
                        inLeft,
                        i - 1), // left

                buildTree(preorder, inorder,
                        preLeft + leftSize + 1,
                        preRight,
                        i + 1,
                        inRight) // right
        );

        return n;
    }
}