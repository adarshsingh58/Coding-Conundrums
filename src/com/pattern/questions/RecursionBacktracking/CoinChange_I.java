package com.pattern.questions.RecursionBacktracking;

import java.util.*;

public class CoinChange_I {

    public static void main(String[] args) {

        // should be 1
        System.out.println(CoinChange_I.minCoinsRequired(10, new ArrayList<>(Arrays.asList(1, 5, 10))));

        // should be 4
        System.out.println(CoinChange_I.minCoinsRequired(12, new ArrayList<>(Arrays.asList(1, 3, 7))));

        // should be 3
        System.out.println(
                CoinChange_I.minCoinsRequired(45, new ArrayList<>(Arrays.asList(1, 5, 10, 25))));

        // should be 5
        System.out.println(
                CoinChange_I.minCoinsRequired(23, new ArrayList<>(Arrays.asList(1, 5, 10, 25))));

        // should be 8
        System.out.println(
                CoinChange_I.minCoinsRequired(74, new ArrayList<>(Arrays.asList(1, 5, 10, 25))));
    }

    /**
     * * CoinChange_I: This is the first variation of the Coin Change Problem. In this variation, you're asked to return
     * the minimum number of coins needed to make the change amount.
     */

    // ? Efficient solution, as it uses DP
    // ? to store the previously calculated results
    private static int minCoinsRequired(
            int target, List<Integer> coins, Map<Integer, Integer> results) {

        int minimumCoins = target;

        // * Base case
        if (coins.contains(target)) {
            results.put(target, 1);
            return 1;
        } else if (results.containsKey(target) && results.get(target) > 0) return results.get(target);
        else
            for (Integer coin : coins)
                if (coin <= target) {
                    int numberOfCoins = 1 + minCoinsRequired(target - coin, coins, results);

                    if (numberOfCoins < minimumCoins) {
                        minimumCoins = numberOfCoins;
                        results.put(target, minimumCoins);
                    }
                }

        return minimumCoins;
    }

    public static int minCoinsRequired(int target, List<Integer> coins) {

        /**
         * ? Works only for American-Style coins.
         * ? WON'T work with odd/prime coin values.
         *
         * ! Inefficient, as it constantly makes a lot
         * ! of similar recursive calls.
         */
        // int minimumCoins = target;

        // *  Base Case
        // if (coins.contains(target))
        //   return 1;

        // for (Integer coin : coins)
        //   if (coin <= target) {

        //     int numberOfCoins = 1 + minCoinsRequired(target - coin, coins);
        //     minimumCoins = Math.min(numberOfCoins, minimumCoins);
        //   }

        // return minimumCoins;

        return minCoinsRequired(target, coins, new HashMap<>());
    }
}
