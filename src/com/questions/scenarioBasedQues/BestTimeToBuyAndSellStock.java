package com.questions.scenarioBasedQues;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * <p>
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * <p>
 * Input: [2,4,7,18,1,5]
 * Output: 0
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] stock = {1, 4, 1, 4, 3, 1};
        System.out.println(maxProfit(stock));
    }

    /*
     * The idea here is that, we find out min value while traversal and save in a minValue variable.
     * We keep traversing and keep finding the profit from minvalue to currentValue and save in maxProfit variable.
     * we only save value at ith index in minvalue if it is less then minValue and value diff of minValue and ith value if it is > maxProfit.
     * This way, we keep tracking of max profit between the minValue found so far in traversal and current ith value, untill next
     * min value is found. If so,we will again do the same, but since maxProfit is updated only upon getting a higher value than itself,
     * we will always get max value.
     * This way its done in O(n)
     *  */
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxProfit = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            int profit = prices[i] - min;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
    }
}
