package com.pattern.questions.DepthFirstSearch;

import com.DataStructures_And_Questions.trees.LowestCommonAncestorofaBinarySearchTree;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree. The diameter of a binary tree is the
 * length of the longest path between any two nodes in a tree. This path may or may not pass through the root. The
 * length of a path between two nodes is represented by the number of edges between them.
 * <p>
 * Example 1: Input: root = [1,2,3,4,5] Output: 3 Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Example 2: Input: root = [1,2] Output: 1
 * <p>
 * https://leetcode.com/problems/diameter-of-binary-tree/description/ https://www.youtube.com/watch?v=bkxqA8Rfv04
 */
public class DiameterofaBinaryTree {
    public static void main(String[] args) {

    }

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int l = dfs(root.left);
        int r = dfs(root.right);

        res = Math.max(res, l + r);

        return 1 + Math.max(l, r);
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
