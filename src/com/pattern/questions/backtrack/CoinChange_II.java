package com.pattern.questions.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * * CoinChange_II: This is the second variation of the Coin Change Problem. In this variation, you're asked to return
 * the possible number of ways in which the coins can satisfy the target amount.
 */

public class CoinChange_II {

    public static void main(String[] args) {

        /*
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
        */

        // should be 4
        CoinChange_II.allPossibleWays(10, new ArrayList<>(Arrays.asList(1, 5, 10)));
        // should be 7
        CoinChange_II.allPossibleWays(12, new ArrayList<>(Arrays.asList(1, 3, 7)));
        // should be 39
        CoinChange_II.allPossibleWays(45, new ArrayList<>(Arrays.asList(1, 5, 10, 25)));
        // should be 9
        CoinChange_II.allPossibleWays(23, new ArrayList<>(Arrays.asList(1, 5, 10, 25)));
        // should be 103
        CoinChange_II.allPossibleWays(74, new ArrayList<>(Arrays.asList(1, 5, 10, 25)));
    }

    private static int allPossibleWays(int target, List<Integer> coins) {
        List<List<Integer>> opMain = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        minCoinsRequired_whenAnyNumOfCoinofEachCanBeUsed(target, coins, coins.size() - 1, op, opMain);
        System.out.println(opMain.size());
        return 0;
    }

    /**
     * This is the same solution from CoinChange_I. But here, we are not returning true/false because we dont want to
     * stop once the first solution is found. We want to find all the solutions, so the process continues until entire
     * recursion tree is exhausted.
     * Once we have all the solutions, we get the size of the solution List.
     */
    private static void minCoinsRequired_whenAnyNumOfCoinofEachCanBeUsed(int target, List<Integer> coins, int index, List<Integer> coinsConsideredSofar, List<List<Integer>> opMain) {
        if (target < 0 || index < 0)
            return;
        if (target == 0) {
            opMain.add(coinsConsideredSofar);
            return;
        }
        coinsConsideredSofar.add(coins.get(index));
        minCoinsRequired_whenAnyNumOfCoinofEachCanBeUsed(target - coins.get(index), coins, index, coinsConsideredSofar, opMain);
        coinsConsideredSofar.remove(coinsConsideredSofar.size() - 1);
        minCoinsRequired_whenAnyNumOfCoinofEachCanBeUsed(target, coins, index - 1, coinsConsideredSofar, opMain);
    }


    public static int numberOfWays(int target, List<Integer> coins) {
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
