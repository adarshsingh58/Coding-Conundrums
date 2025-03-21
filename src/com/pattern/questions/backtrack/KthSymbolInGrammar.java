package com.pattern.questions.backtrack;

/**
 * * Kth Symbol In Grammar
 */
public class KthSymbolInGrammar {
  public int kthGrammar(int N, int K) {
    /**
     * Base Case.
     */
    if (N == 1 && K == 1) return 0;

    // Calculate the mid position
    int mid = (int) Math.pow(2, N - 1) / 2;

    // If K's current value
    // is less than mid, then
    // there exists a Kth value
    // in the previous row, i.e.,
    // in (N - 1)th row and therefore
    // we return the value computed
    // in the (N - 1)th row.
    if (K <= mid) return kthGrammar(N - 1, K);

    // Otherwise, if K's current value
    // is greater than mid, then we return
    // the 1's complement of the value
    // computed in the (N - 1)th row.
    return kthGrammar(N - 1, K - mid) ^ 1;
  }

  public static void main(String[] args) {
    KthSymbolInGrammar solution = new KthSymbolInGrammar();

    System.out.println(solution.kthGrammar(4, 5));
  }
}
