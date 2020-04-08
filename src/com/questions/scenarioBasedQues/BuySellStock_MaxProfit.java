package com.questions.scenarioBasedQues;

public class BuySellStock_MaxProfit {

    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};
        int n = price.length;
        System.out.println(maxProfit(price, n));
    }


    static int maxProfit(int[] price, int n) {

        int[][] profit = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            profit[i][0] = 0;
        for (int j = 0; j <= n; j++)
            profit[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                int max_so_far = 0;
                for (int m = 0; m < j; m++)
                    max_so_far = Math.max(max_so_far, price[j] - price[m] + profit[i - 1][m]);
                profit[i][j] = Math.max(profit[i][j - 1], max_so_far);
            }
        }
        return profit[n][n - 1];
    }


}
