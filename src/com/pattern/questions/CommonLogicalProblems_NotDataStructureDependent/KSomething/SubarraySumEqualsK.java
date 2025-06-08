package com.pattern.questions.CommonLogicalProblems_NotDataStructureDependent.KSomething;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Theme: Finding subarrays whose sum meets a K target (here K is the target sum, not count).
 * <p>
 * Task: Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * <p>
 * Link: https://leetcode.com/problems/subarray-sum-equals-k/
 * https://www.youtube.com/watch?v=xvNwoz-ufXA
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> subNum = new HashMap<>();
        subNum.put(0, 1);
        int total = 0, count = 0;
        for (int n : nums) {
            total += n;
            if (subNum.containsKey(total - k)) {
                count += subNum.get(total - k);
            }
            subNum.put(total, subNum.getOrDefault(total, 0) + 1);
        }
        return count;
    }

    public int subarraySum_BruteForce(int[] nums, int k) {
        List<List<Integer>> op = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int tempSum = nums[i];
            if (tempSum == k) {
                op.add(List.of(tempSum));
            }
            for (int j = i + 1; j < nums.length; j++) {
                tempSum = tempSum + nums[j];
                if (tempSum == k) {
                    op.add(List.of(tempSum));
                }

            }
        }

        return op.size();
    }
}
