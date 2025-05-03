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
        int[] inp = {-1, 0, 1, 2, -1, -4};
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

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicate 'i'
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    op.add(List.of(nums[i], nums[j], nums[k]));
                    break;
                } else if (nums[i] +nums[j] + nums[k]>0) {
                    k--;
                } else if (nums[i] +nums[j] + nums[k] < 0) {
                    j++;
                }
            }
        }

        return op;

    }

}
