package com.DataStructures_And_Questions.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an integer array nums, find the with the largest sum, and return its sum.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1] Output: 1 Explanation: The subarray [1] has the largest sum 1.
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [5,4,-1,7,8] Output: 23 Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 * <p>
 * https://leetcode.com/problems/maximum-subarray/
 */
public class KadaneAlgoForMaxSumSubArray {

    public static void main(String[] args) {
        List<Integer[]> inps = new ArrayList<>();
        inps.add(new Integer[]{-2, -3, 4, -1, -2, 1, 5, -3});
        inps.add(new Integer[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        inps.add(new Integer[]{5, 4, -1, 7, 8});
        inps.add(new Integer[]{-2, 1});

        inps.forEach(inp -> {
            System.out.println("Maximum contiguous sum is " + maxSubArraySum(inp));
            System.out.println("Maximum contiguous sum is " + attempt(inp));
        });

    }

    private static int attempt(Integer[] inputArr) {
        int max = -100;
        int tempSum = 0;
        for (int i : inputArr) {
            tempSum = tempSum + i;
            if (tempSum > max)
                max = tempSum;
            if (tempSum < 0)
                tempSum = 0;
        }
        return max;
    }

    /*
     * The simplest approach here would be to do a BRUTE FORCE where we find sum of every sub array in the array \
     * and keep track of max sum. This would take O(n*n) time complexity.
     *
     * With Kadane's algo, this could be done in O(n) time.
     *
     * The idea is that, at a given index the maximum sub array will ALWAYS be maximum of
     * (MaxSubArrayBeforeCurrentIndex+valueAtCurrentIndex OR valueAtCurrentIndex). This is because we are talking about
     * contiguous sub array.
     *
     * In a = {-2, -3, 4, -1, -2, 1, 5, -3}; at index say 2, maximum sub array would be
     * (maxumum sub array till index 1 + value at index 2 OR value at index 2)
     * (-5 + 4 OR 4) Hence 4.
     *
     * So,  we take a variable max_ending_here and make it 0 as soon as its value become <0. The reason is that
     * max_ending_here being negative can NEVER create maximum sub array upon adding to value at current index.
     *
     */
    static int maxSubArraySum(Integer[] inputArr) {
        int max = Integer.MIN_VALUE, temp = 0;
        for (int i = 0; i < inputArr.length; i++) {
            temp = temp + inputArr[i];
            if (max < temp)
                max = temp;
            if (temp < 0)
                temp = 0;
        }
        return max;
    }
}
