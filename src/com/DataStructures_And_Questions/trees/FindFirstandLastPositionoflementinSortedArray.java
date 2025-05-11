package com.DataStructures_And_Questions.trees;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given
 * target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [], target = 0 Output: [-1,-1]
 * <p>
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstandLastPositionoflementinSortedArray {

    public static void main(String[] args) {

    }

    /**
     * To achieve strict O(log n) time, perform two separate binary searches:
     * <p>
     * One for the first occurrence
     * <p>
     * One for the last occurrence
     *
     */
    public int[] searchRange_better(int[] nums, int target) {
        int first = findBound(nums, target, true);
        if (first == -1) return new int[]{-1, -1}; // target not found
        int last = findBound(nums, target, false);
        return new int[]{first, last};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int start = 0, end = nums.length - 1, bound = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                bound = mid;
                if (isFirst) {
                    end = mid - 1;  // move left
                } else {
                    start = mid + 1; // move right
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return bound;
    }

    /**
     * 🔍 Approach:
     * <p>
     * You perform binary search to find one occurrence of the target → O(log n)
     * <p>
     * Then you linearly expand to the left and right to find the full range of the target → can be O(n) in worst case
     */
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            if (nums[(start + end) / 2] == target) {
                int i = (start + end) / 2, j = (start + end) / 2;
                System.out.println("found at " + i);
                while (i > -1 && nums[i] == target) {
                    i--;
                }
                while (j < nums.length && nums[j] == target) {
                    j++;
                }
                return new int[]{++i, --j};
            } else if (nums[(start + end) / 2] < target) {
                start = ((start + end) / 2) + 1;
            } else {
                end = ((start + end) / 2) - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
