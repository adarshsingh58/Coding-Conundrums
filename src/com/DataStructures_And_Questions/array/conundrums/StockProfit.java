package com.DataStructures_And_Questions.array.conundrums;

/**
 * ou are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * <p>
 * Example 2:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * <p>
 * SIMPLIFIED: problem says an array of +ve integers, find max positive diff b/w any 2 numbers
 */
public class StockProfit {

    /* optimized solution: we start with 0th index and assume its the min value
         now we keep track of diff for next elements and keepb track of maxDiff
         and if any other min value is found we change min_Number to that.
         */
    public int maxProfit(int[] prices) {
        int maxDiff = 0;
        int min_Number = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxDiff = Math.max(maxDiff, prices[i] - min_Number);
            min_Number = Math.min(min_Number, prices[i]);
        }
        return maxDiff;
    }

    //in brute force, for each element we can check the max dofference for all other element
    public int maxProfit_brute(int[] prices) {
        int maxDiff = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > maxDiff)
                    maxDiff = prices[j] - prices[i];
            }
        }
        return maxDiff;
    }
}
