package com.pattern.questions.RecursionBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange_II {

    public static void main(String[] args) {

        // should be 4
        System.out.println(CoinChange_II.numberOfWays(10, new ArrayList<>(Arrays.asList(1, 5, 10))));

        // should be 7
        System.out.println(CoinChange_II.numberOfWays(12, new ArrayList<>(Arrays.asList(1, 3, 7))));

        // should be 39
        System.out.println(CoinChange_II.numberOfWays(45, new ArrayList<>(Arrays.asList(1, 5, 10, 25))));

        // should be 9
        System.out.println(CoinChange_II.numberOfWays(23, new ArrayList<>(Arrays.asList(1, 5, 10, 25))));

        // should be 103
        System.out.println(CoinChange_II.numberOfWays(74, new ArrayList<>(Arrays.asList(1, 5, 10, 25))));
    }

    /**
     * * CoinChange_II: This is the second variation of the Coin Change Problem. In this variation, you're asked to
     * return the possible number of ways in which the coins can satisfy the target amount.
     */

    // ? Inefficient solution, as it makes
    // ? similar recursive calls multiple times.

    // private static int numberOfWays(
    //   int target,
    //   List<Integer> coins,
    //   int index
    // ) {

    //   // * Base Case
    //   if (target == 0)
    //     return 1;

    //   // If target is negative, or
    //  // target is present but coins are not
    //   if (
    //     target < 0 ||
    //     (target > 0 && index < 0)
    //   )
    //     return 0;

    //   return
    //     numberOfWays(target, coins, index - 1) +
    //     numberOfWays(target - coins.get(index), coins, index);

    // }
    public static int numberOfWays(int target, List<Integer> coins) {

        // return numberOfWays(target, coins, coins.size() - 1);

        // ? Efficient solution, as it uses DP
        // ? to store the intermediate results.

        int length = coins.size();

        int[][] dp = new int[length + 1][target + 1];

        // Since, we can satisfy any target value
        // with 0 in 0 possible ways
        for (int i = 1; i <= target; i++) dp[0][i] = 0;

        // Since, we can satisfy target value 0
        // with any coin value in 1 possible way
        for (int i = 0; i <= length; i++) dp[i][0] = 1;

        for (int i = 1; i <= length; i++)
            for (int j = 1; j <= target; j++)

                // If the current target value is
                // greater than or equal to the
                // current coin value
                if (j >= coins.get(i - 1))
                    // Then, possible ways to satisfy target value =
                    // including this coin + excluding this coin
                    dp[i][j] = dp[i][j - coins.get(i - 1)] + dp[i - 1][j];
                else
                    // Otherwise, we just have to exclude this coin
                    dp[i][j] = dp[i - 1][j];

        // return the last cell of the table
        return dp[length][target];
    }
}
