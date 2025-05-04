package com.DataStructures_And_Questions.array;

import java.util.*;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Example:
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * <p>
 * Note:
 * <p>
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * <p>
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(arr));
    }

    public static int lengthOfLIS_attempt(int[] nums) {
        int op = 0;
        List<Integer> largestSubSeq=new ArrayList<>();
        Map<Integer, Integer> m = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i],i);
        }

        m.forEach((k,v) ->{


        });

        return op;
    }


    public static int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int smallerKeyWithMaxLengthSoFar = smallerKeyWithMaxLengthSoFar(map, nums[i]);
            if (smallerKeyWithMaxLengthSoFar == -1) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(smallerKeyWithMaxLengthSoFar) + 1);
                if (map.get(smallerKeyWithMaxLengthSoFar) + 1 > max) {
                    max = map.get(smallerKeyWithMaxLengthSoFar) + 1;
                }
            }
        }


        return max;
    }

    private static int smallerKeyWithMaxLengthSoFar(Map<Integer, Integer> map, int num) {
        int maxKey = -1, maxValue = -1;
        for (Map.Entry<Integer, Integer> key : map.entrySet()) {
            if (key.getKey() < num && key.getValue() > maxValue) {
                maxKey = key.getKey();
                maxValue = key.getValue();
            }
        }
        return maxKey;
    }
}
