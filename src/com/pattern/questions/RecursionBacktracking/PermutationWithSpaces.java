package com.pattern.questions.RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

/**
 * * Permutations With Spaces
 */
public class PermutationWithSpaces {
  private void getPermutationsWithSpaces(
      String input, int index, String output, List<String> perms) {
    /**
     * * TC: Since the number of spaces is n - 1,
     * * there are total 2^(n-1) patterns each having
     * * length ranging from n to 2n-1. Thus, overall
     * * complexity would be O(n*(2^n)).
     */

    /**
     * Base Case.
     *
     * If the current index is
     * equal to the input string
     * length, then we've found
     * a potential permutation.
     */
    if (index == input.length()) {
      perms.add(output.toString());
      return;
    }

    // First, we consider placing a space
    // before the current character and
    // then we try out all the possibilities
    // in that scenario
    getPermutationsWithSpaces(input, index + 1, output + " " + input.charAt(index), perms);

    // Second, we don't consider placing a space
    // before the current character and
    // then we try out all the possibilities
    // in that scenario
    getPermutationsWithSpaces(input, index + 1, output + input.charAt(index), perms);
  }

  public List<String> getPermutationsWithSpaces(String string) {
    List<String> perms = new ArrayList<>();

    getPermutationsWithSpaces(string, 1, "" + string.charAt(0), perms);

    return perms;
  }

  public static void main(String[] args) {
    PermutationWithSpaces solution = new PermutationWithSpaces();

    System.out.println(solution.getPermutationsWithSpaces("ABCD"));
  }
}
