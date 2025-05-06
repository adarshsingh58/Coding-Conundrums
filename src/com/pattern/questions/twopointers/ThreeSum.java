package com.pattern.questions.twopointers;

import java.util.*;

/**
 * Given an integer array nums, find and return all unique triplets [nums[i], nums[j], nums[k]], where the indexes
 * satisfy i≠j, * i≠k, and j≠k, and the sum of the elements nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Constraints:
 * <p>
 * 3≤3≤ nums.length ≤500≤500
 * <p>
 * −103≤−103≤ nums[i] ≤103≤10
 * <p>
 * https://leetcode.com/problems/3sum/description/
 */
public class ThreeSum {

    public static void main(String[] args) {
//        int[] inp = {-1, 0, 1, 2, -1, -4};
//        int[] inp = {0,0,0};
        int[] inp = {-2, 0, 1, 1, 2};
//        int[] inp = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
        List<List<Integer>> op = new ThreeSum().threeSum(inp);
        op.forEach(integers -> {
            integers.forEach(integer -> {
                System.out.print(integer + " ");
            });
            System.out.println();
        });
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> op = new ArrayList<>();

        //initialization
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip trying to compute 3 sum for same i value. since input is sorted we skip i+1
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if (0 == nums[i] + nums[j] + nums[k]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    op.add(temp);
                    // For a given ith value, if duplicates are present, we can have same jth and kth values appearing multiple times hence skipping
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    //modifying j and k to look for next value
                    j++;
                    k--;

                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }
            }
        }

        return op;

    }

}
