package com.pattern.questions.BinaryTreeTraversal;

import com.DS.TreeNode;

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * */
public class MaxDepthOfBtree {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if(root==null ) return 0;
        int depth=1;
        return dfs(root,depth);

    }

    public int dfs(TreeNode root, int currDepth){
        if(root==null) return currDepth-1;

        return Math.max(dfs(root.left,currDepth+1),dfs(root.right,currDepth+1));

    }
}
