package com.DataStructures_And_Questions.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [100,4,200,1,3,2] Output: 4 Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,3,7,2,5,8,4,6,0,1] Output: 9
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1,0,1,2] Output: 3
 */
public class LongestConsecutiveSequence {


/**
 * This has better complexity where we are using additional space of HashSet
 * But parsing the nums array only once so O(n)
 * Idea is to add all num in set and then traverse the array and look for num-1,
 * if num-1 is present that means that is part of a sequence
 * When we see num+1, we contnue because our logic is for num-1, so when we encounter num+1 say k we know that there would be a value j for which num-1 would be true.
 * So we basically check for the last number of the sequence and then from that last number we look for -1 sequence unless there is no sequence.
 * For multiple possible sequence, we keep currLength and reset it to 1 when we found a sequence to look for next one.
 * We remove the num from set when num-1 and num+1 either is not present, because that num is not needed then,
 * */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int maxLength = 1;

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] + 1)) {
                continue;
            }
            if (set.contains(nums[i] - 1)) {
                int currLength = 1;
                int currNumber = nums[i];
                while (set.contains(currNumber)) {
                    set.remove(currNumber);
                    currLength++;
                    currNumber--;
                }
                currLength--;
                maxLength = Math.max(currLength, maxLength);
            } else {
                set.remove(nums[i]);
            }
        }
        return maxLength;
    }
    /*
     * Obvious solution, where we sort the arr and look for consecutive i.e. +1 values while increasing the count,
     * Complexity: O(nlong) + O(n) i.e. sorting + traversing
     * */
    public int longestConsecutive1(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 1, tempCount = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) continue;
            if (nums[i] + 1 == nums[i + 1]) {
                tempCount++;
            } else {
                count = Math.max(count, tempCount);
                tempCount = 1;
            }
        }
        return Math.max(count, tempCount);
    }
}
