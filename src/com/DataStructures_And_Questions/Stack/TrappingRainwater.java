package com.DataStructures_And_Questions.Stack;

/**
 * Problem Statement: Given an array of non-negative integers representation elevation of ground. Your task is to find
 * the water that can be trapped after rain.
 * <p>
 * Examples:
 * <p>
 * Example 1:
 * <p>
 * Input: height= [0,1,0,2,1,0,1,3,2,1,2,1]
 * <p>
 * Output: 6
 * <p>
 * Explanation: As seen from the diagram 1+1+2+1+1=6 unit of water can be trapped
 * <p>
 * Example 2:
 * <p>
 * Input:  [4,2,0,3,2,5]
 * <p>
 * Output:9
 * <p>
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainwater {
    public static void main(String[] args) {

    }

    /* basically find out leftMax and rightMax for each i, and then use the formulae that for
     * any i, the maximum water that can fit will be min of (leftMax & rightMax) - the height of the ith Building.
     *
     * Time O(n)
     * Space O(n) for prefix and suffix arrays
     * */

    public int trap(int[] height) {

        int[] prefixSumHeight = new int[height.length];
        int[] suffixSumHeight = new int[height.length];
        prefixSumHeight[0] = height[0];
        suffixSumHeight[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            prefixSumHeight[i] = Math.max(prefixSumHeight[i - 1], height[i]);
        }
        for (int i = height.length - 2; i > -1; i--) {
            suffixSumHeight[i] = Math.max(suffixSumHeight[i + 1], height[i]);
        }
        int totalTappingWater = 0;
        for (int i = 0; i < height.length; i++) {

            totalTappingWater = totalTappingWater + Math.min(prefixSumHeight[i], suffixSumHeight[i]) - height[i];

        }

        return totalTappingWater;

    }
}
