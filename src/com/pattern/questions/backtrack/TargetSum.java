package com.pattern.questions.backtrack;

/**
 * You are given an integer array nums and an integer target.
 * <p>
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and
 * then concatenate all the integers.
 * <p>
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the
 * expression "+2-1".
 * <p>
 * Return the number of different expressions that you can build, which evaluates to target.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,1,1], target = 3 Output: 5 Explanation: There are 5 ways to assign symbols to make the sum of
 * nums be target 3. -1 + 1 + 1 + 1 + 1 = 3 +1 - 1 + 1 + 1 + 1 = 3 +1 + 1 - 1 + 1 + 1 = 3 +1 + 1 + 1 - 1 + 1 = 3 +1 + 1
 * + 1 + 1 - 1 = 3
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1], target = 1 Output: 1
 *
 * https://leetcode.com/problems/target-sum/description/
 */
public class TargetSum {
}
