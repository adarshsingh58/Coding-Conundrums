package com.DataStructures_And_Questions.array.twopointers;

import java.util.HashSet;
import java.util.Set;

/**
 * Two Integer Sum II
 * <p>
 * Given an array of integers numbers that is sorted in non-decreasing order.
 * <p>
 * Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number
 * target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element
 * twice.
 * <p>
 * There will always be exactly one valid solution.
 * <p>
 * Your solution must use O(1)O(1) additional space.
 * <p>
 * Example 1:
 * <p>
 * Input: numbers = [1,2,3,4], target = 3
 * <p>
 * Output: [1,2]
 * <p>
 * Explanation: The sum of 1 and 2 is 3. Since we are assuming a 1-indexed array, index1 = 1, index2 = 2. We return [1,
 * 2].
 * <p>
 * Constraints:
 * <p>
 * 2 <= numbers.length <= 1000 -1000 <= numbers[i] <= 1000 -1000 <= target <= 1000
 *
 * https://neetcode.io/problems/two-integer-sum-ii
 */
public class SumOfTwoValuesII {

    public static void main(String[] args) {
        int[] inputArr = new int[]{5, 7, 1, 2, 8, 4, 3};
        int targetNumber = 10;

        int[] op = twoSum(inputArr, targetNumber);
        System.out.println(op[0] + " " + op[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{numbers[i], numbers[j]};
            }
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[2];
    }
}
