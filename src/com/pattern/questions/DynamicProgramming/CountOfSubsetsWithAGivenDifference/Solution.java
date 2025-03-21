package com.pattern.questions.DynamicProgramming.CountOfSubsetsWithAGivenDifference;

import java.util.Arrays;

/**
 * * Count of Subsets With A Given Difference (Variation of 0/1 Knapsack)
 */
public class Solution {
  public int countOfSubsets(int[] array, int difference) {
    int sum = Arrays.stream(array).sum();

    return countOfSubsetsDP(array, sum, difference);
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(ns)
   * * SC: O(ns)
   */
  private int countOfSubsetsDP(int[] array, int sum, int difference) {
    /**
     * Equation I: S1 - S2 = difference
     * Equation II: S1 + S2 = sum(array)
     *
     * Adding I and II,
     *
     * 2S1 = sum(array) + difference
     * so, S1 = (sum(array) + difference) / 2
     *
     * Now, we need to find the count of
     * subsets equal to a given sum, which
     * is S1
     */
    int target = (sum + difference) / 2;

    return countOfSubsetsDP(array, target);
  }

  private int countOfSubsetsDP(int[] array, int sum) {
    int len = array.length;
    int[][] dp = new int[len + 1][sum + 1];

    for (int i = 0; i < len + 1; i++) dp[i][0] = 1;

    for (int i = 1; i < len + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {
        // If the current item is less than
        // or equal to the current sum, then we
        // need to consider both the scenarios
        // where we include this current item and
        // where we don't include this current item
        if (array[i - 1] <= j) dp[i][j] = dp[i - 1][j] + dp[i - 1][j - array[i - 1]];

        // If the current item is greater
        // than our current sum, then there's
        // only one scenario where we don't
        // include this current item
        else dp[i][j] = dp[i - 1][j];
      }
    }

    return dp[len][sum];
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 3
    System.out.println(solution.countOfSubsets(new int[] {1, 1, 2, 3}, 1));
  }
}
