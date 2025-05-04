package com.DataStructures_And_Questions.string;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 * <p>
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting
 * parentheses string is valid and return any valid string.
 * <p>
 * Formally, a parentheses string is valid if and only if:
 * <p>
 * It is the empty string, contains only lowercase characters, or It can be written as AB (A concatenated with B), where
 * A and B are valid strings, or It can be written as (A), where A is a valid string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "lee(t(c)o)de)" Output: "lee(t(c)o)de" Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be
 * accepted.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "a)b(c)d" Output: "ab(c)d"
 * <p>
 * Example 3:
 * <p>
 * Input: s = "))((" Output: "" Explanation: An empty string is also valid.
 * <p>
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
 */
public class MinRemoveToMakeValidParenthesis {
    public static void main(String[] args) {
        System.out.println(new MinRemoveToMakeValidParenthesis().minRemoveToMakeValid("())()((("));
    }

    public String minRemoveToMakeValid(String s) {
        int openCounter = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (openCounter == 0 && s.charAt(i) == ')')
                continue;
            if (s.charAt(i) == ')')
                openCounter--;
            if (s.charAt(i) == '(')
                openCounter++;
            sb.append(s.charAt(i));
        }
        int len = sb.length();
        if (openCounter != 0)
            for (int i = len-1; i > -1; i--) {
                if (openCounter == 0)
                    break;
                if (sb.charAt(i) == '(') {
                    sb.deleteCharAt(i);
                    openCounter--;
                }

            }
        return sb.toString();
    }
}
