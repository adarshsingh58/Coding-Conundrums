package com.pattern.questions.recursionbasics;

import java.util.*;

public class CoinChange_I_recursion {

    public static void main(String[] args) {

       /* // should be 1
        CoinChange_I_recursion.minCoinsRequired(10, new ArrayList<>(Arrays.asList(1, 5, 10)));
*/
        // should be 4
        CoinChange_I_recursion.minCoinsRequired(10, new ArrayList<>(Arrays.asList(1, 3, 7)));

        // should be 3
        CoinChange_I_recursion.minCoinsRequired(40, new ArrayList<>(Arrays.asList(1, 5, 10, 25)));

        // should be 5
        CoinChange_I_recursion.minCoinsRequired(11, new ArrayList<>(Arrays.asList(1, 5, 10, 25)));

        // should be 8
        CoinChange_I_recursion.minCoinsRequired(6, new ArrayList<>(Arrays.asList(1, 5, 10, 25)));
    }

    private static int minCoinsRequired(int target, List<Integer> coins) {
        List<List<Integer>> opMain = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        minCoinsRequired(coins, target, coins.size() - 1, op, opMain);
        opMain.forEach(o -> {
            System.out.print(o+" ");

        });
        return opMain.size();
    }

    private static void minCoinsRequired(List<Integer> coins, int target, int index, List<Integer> results, List<List<Integer>> opMain) {
        int sum = results.stream().reduce(0, (v1, v2) -> v1 + v2);
        if (sum == target) {
            opMain.add(new ArrayList<>(results));
            return;
        }
        if (index < 0) {
            return;
        }
        results.add(coins.get(index));
        minCoinsRequired(coins, target, index - 1, results, opMain);
        results.remove(results.size() - 1);
        minCoinsRequired(coins, target, index - 1, results, opMain);
    }

}
