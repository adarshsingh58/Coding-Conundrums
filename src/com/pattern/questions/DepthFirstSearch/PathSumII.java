package com.pattern.questions.DepthFirstSearch;

import java.util.List;

/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node
 * values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 * <p>
 * Example 1: Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22 Output: [[5,4,11,2],[5,8,4,5]]
 * <p>
 * Explanation: There are two paths whose sum equals targetSum: 5 + 4 + 11 + 2 = 22 5 + 8 + 4 + 5 = 22
 * <p>
 * Example 2: Input: root = [1,2,3], targetSum = 5 Output: []
 * <p>
 * Example 3: Input: root = [1,2], targetSum = 0 Output: []
 * <p>
 * https://leetcode.com/problems/path-sum-ii/description/
 */
public class PathSumII {
    public static void main(String[] args) {

    }

    public void hasPathSum(PathSum.TreeNode root, int targetSum, List<Integer> curr, List<List<Integer>> op) {
        if (targetSum == 0) {
            op.add(curr);
            return;
        }

        if (root == null) return;
        curr.add(root.val);
        hasPathSum(root.left, targetSum - root.val, curr, op);

        hasPathSum(root.right, targetSum - root.val, curr, op);
    }
}
