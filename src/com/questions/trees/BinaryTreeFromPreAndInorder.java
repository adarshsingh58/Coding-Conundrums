package com.questions.trees;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * <p>
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class BinaryTreeFromPreAndInorder {

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        new BinaryTreeFromPreAndInorder().buildTree(preorder, inorder);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode x = build(preorder, inorder, 0, inorder.length - 1);

        return x;
    }

    int preorderCurr = 0;

    public TreeNode build(int[] preorder, int[] inorder, int inorderLow, int inorderHi) {
        if (inorderHi < inorderLow) return null;
        if (inorderHi < 0 || inorderHi >= inorder.length) return null;
        if (inorderLow < 0 || inorderLow >= inorder.length) return null;
        int index = firstMatch(preorder, inorder, inorderLow, inorderHi);
        TreeNode root = new TreeNode(inorder[index]);
        root.left = build(preorder, inorder, inorderLow, index - 1);
        root.right = build(preorder, inorder, index + 1, inorderHi);
        return root;
    }

    public int firstMatch(int[] preorder, int[] inorder, int inorderLow, int inorderLength) {
        for (int i = preorderCurr; i < preorder.length; i++)
            for (int j = inorderLow; j <= inorderLength; j++)
                if (preorder[i] == inorder[j]) {
                    preorderCurr = i + 1;
                    return j;
                }
        return 0;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
