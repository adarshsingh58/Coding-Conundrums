package com.pattern.questions.recursionbasics;

/**
 * We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at
 * the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10. For example, for n = 3,
 * the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110. Given two integer n and k, return the kth (1-indexed)
 * symbol in the nth row of a table of n rows.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1, k = 1 Output: 0 Explanation: row 1: 0
 * <p>
 * Example 2:
 * <p>
 * Input: n = 2, k = 1 Output: 0 Explanation: row 1: 0 row 2: 01
 * <p>
 * Example 3:
 * <p>
 * Input: n = 2, k = 2 Output: 1 Explanation: row 1: 0 row 2: 01
 * <p>
 * <p>
 * https://leetcode.com/problems/k-th-symbol-in-grammar/description/
 */
public class KthSymbolInGrammar {

    public static void main(String[] args) {
        System.out.println(new KthSymbolInGrammar().kthGrammar(4, 5));
    }

    /**
     * If K's current value is less than mid, then there exists a Kth value in the previous row, i.e., in (N - 1)th row
     * and therefore we return the value computed in the (N - 1)th row.
     * Otherwise, if K's current value is greater than
     * mid, then we return the 1's complement of the value computed in the (N - 1)th row.
     */
    public int kthGrammar(int N, int K) {

        if (N == 1 && K == 1) return 0;//Base Case.

        int mid = (int) Math.pow(2, N - 1) / 2;// Calculate the mid position
        if (K <= mid) return kthGrammar(N - 1, K);
        return kthGrammar(N - 1, K - mid) ^ 1;
    }

}
