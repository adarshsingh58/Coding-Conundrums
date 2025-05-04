package com.pattern.questions.backtrack;

import com.DS.TreeNode;

/**
 * Statement
 * <p>
 * <p>
 * A thief has discovered a new neighborhood to target, where the houses can be represented as nodes in a binary tree.
 * The money in the house is the data of the respective node. The thief can enter the neighborhood from a house
 * represented as root of the binary tree. Each house has only one parent house. The thief knows that if he robs two
 * houses that are directly connected, the police will be notified. The thief wants to know the maximum amount of money
 * he can steal from the houses without getting caught by the police. The thief needs your help determining the maximum
 * amount of money he can rob without alerting the police.
 * <p>
 * <p>
 * https://leetcode.com/problems/house-robber-iii/description/
 */
public class HouseRobberIII {
    public static void main(String[] args) {

    }

    /**
     * The idea is simple, we just have to find the sum of all the nodes with 1 condition: - either we skip first level
     * or we skip second level Maximum of these two sums is our answer.
     */
    public int rob(TreeNode root) {
        return Math.max(robRec(root, false), robRec(root, true));
    }

    public int robRec(TreeNode root, boolean skip) {
        if (root == null)
            return 0;
        int currLoot = 0;
        if (skip) {
            skip = false;
        } else {
            skip = true;
            currLoot = root.val;
        }
        return currLoot + robRec(root.left, skip) + robRec(root.right, skip);
    }
}

