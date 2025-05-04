package com.DataStructures_And_Questions.scenarioBasedQues;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * <p>
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * <p>
 * Example 3:
 * <p>
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * <p>
 * Example 4:
 * <p>
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * <p>
 * Example 5:
 * <p>
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 */
public class WildcardMatching {

    public static void main(String[] args) {
        String s = "aa";
        String p = "a";
        System.out.println(new WildcardMatching().isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {

        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int j = 0, i = 0;
        for (; i < sArr.length && j < pArr.length; ) {
            if (sArr[i] == pArr[j]) {
                i++;
                j++;
                continue;
            }
            if ('?' == pArr[j]) {
                i++;
                j++;
                continue;
            }
            if ('*' == pArr[j]) {
                int indexInI = findInS(sArr, pArr, j + 1, i);
                if (indexInI == -1) return false;
                i = indexInI + 1;
                j = j + 2;
            } else {
                return false;
            }
        }
        if (i < sArr.length) return false;
        if (j < pArr.length - 1 && allAstrek(pArr, j)) return false;
        return true;
    }

    private boolean allAstrek(char[] pArr, int j) {
        for (int i = j; i < pArr.length; i++) {
            if (pArr[i] != '*') return false;
        }
        return true;
    }

    private int findInS(char[] sArr, char[] pArr, int i, int i1) {
        for (int j = i1; j < sArr.length; j++) {
            if (sArr[j] == pArr[i]) return j;
        }
        return -1;
    }
}
