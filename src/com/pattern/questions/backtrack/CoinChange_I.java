package com.pattern.questions.backtrack;

import java.util.*;
/**
 * * CoinChange_I: This is the first variation of the Coin Change Problem. In this variation, you're asked to return
 * the minimum number of coins needed to make the change amount.
 */
public class CoinChange_I {

    public static void main(String[] args) {

        // should be 1
        System.out.println(CoinChange_I.minCoinsRequired(10, new ArrayList<>(Arrays.asList(1, 5, 10))));

        // should be 4
        System.out.println(CoinChange_I.minCoinsRequired(12, new ArrayList<>(Arrays.asList(1, 3, 7))));

        // should be 3
        System.out.println(CoinChange_I.minCoinsRequired(45, new ArrayList<>(Arrays.asList(1, 5, 10, 25))));
        // should be 5
        System.out.println(CoinChange_I.minCoinsRequired(23, new ArrayList<>(Arrays.asList(1, 5, 10, 25))));

        // should be 8
        System.out.println(CoinChange_I.minCoinsRequired(75, new ArrayList<>(Arrays.asList(1, 5, 10, 25))));
    }

    private static int minCoinsRequired(int target, List<Integer> coins) {
//        return minCoinsRequired_whenOnly1CoinofEachCanBeUsed(target, coins, new HashMap<>());

        List<List<Integer>> opMain = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        minCoinsRequired_whenAnyNumOfCoinofEachCanBeUsed(target, coins, coins.size() - 1, op,opMain);
        opMain.forEach(h->h.forEach( y->{
            System.out.print(y+" ");
        }));
        System.out.println();
        return 0;
    }

    private static boolean minCoinsRequired_whenAnyNumOfCoinofEachCanBeUsed(int target, List<Integer> coins, int index, List<Integer> coinsConsideredSofar,List<List<Integer>> opMain) {
        if (target < 0)
            return false;
        if (target == 0) {
            opMain.add(coinsConsideredSofar);
            return true;
        }
        coinsConsideredSofar.add(coins.get(index));
        if (minCoinsRequired_whenAnyNumOfCoinofEachCanBeUsed(target - coins.get(index), coins, index, coinsConsideredSofar, opMain)) {
            return true;
        } else {
            coinsConsideredSofar.remove(coinsConsideredSofar.size() - 1);
            index--;
            return minCoinsRequired_whenAnyNumOfCoinofEachCanBeUsed(target, coins, index , coinsConsideredSofar, opMain);
        }
    }


    /**
     * Here of the given coins, only 1 of each can be used to get the final target. Basically for a given array we need
     * to find if any subset adds up to the target Sum.
     */
    private static int minCoinsRequired_whenOnly1CoinofEachCanBeUsed(int target, List<Integer> coins, Map<Integer, Integer> results) {

        int minimumCoins = target;

        // * Base case
        if (coins.contains(target)) {
            results.put(target, 1);
            return 1;
        } else if (results.containsKey(target) && results.get(target) > 0) return results.get(target);
        else
            for (Integer coin : coins)
                if (coin <= target) {
                    int numberOfCoins = 1 + minCoinsRequired_whenOnly1CoinofEachCanBeUsed(target - coin, coins, results);

                    if (numberOfCoins < minimumCoins) {
                        minimumCoins = numberOfCoins;
                        results.put(target, minimumCoins);
                    }
                }

        return minimumCoins;
    }

}
