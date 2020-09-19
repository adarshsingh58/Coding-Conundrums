package com.concepts.KnapSack01;

/**
 * Introduction #
 * <p>
 * Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’. The goal is to get the maximum profit from the items in the knapsack. Each item can only be selected once, as we don’t have multiple quantities of any item.
 * <p>
 * Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit. Here are the weights and profits of the fruits:
 * <p>
 * Items: { Apple, Orange, Banana, Melon }
 * Weights: { 2, 3, 1, 4 }
 * Profits: { 4, 5, 3, 7 }
 * Knapsack capacity: 5
 * <p>
 * Let’s try to put different combinations of fruits in the knapsack, such that their total weight is not more than 5:
 * <p>
 * Apple + Orange (total weight 5) => 9 profit
 * Apple + Banana (total weight 3) => 7 profit
 * Orange + Banana (total weight 4) => 8 profit
 * Banana + Melon (total weight 5) => 10 profit
 * <p>
 * This shows that Banana + Melon is the best combination, as it gives us the maximum profit and the total weight does not exceed the capacity.
 * Problem Statement #
 * <p>
 * Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of these items which will give us maximum profit such that their cumulative weight is not more than a given number ‘C’. Each item can only be selected once, which means either we put an item in the knapsack or we skip it.
 */
public class KnapSack01 {

    public static void main(String[] args) {

    }
}
