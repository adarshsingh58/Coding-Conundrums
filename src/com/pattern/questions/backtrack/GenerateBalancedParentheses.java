package com.pattern.questions.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3 Output: ["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * Example 2:
 * <p>
 * Input: n = 1 Output: ["()"]
 * <p>
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class GenerateBalancedParentheses {
    public static void main(String[] args) {
        System.out.println(new GenerateBalancedParentheses().generateValidParentheses(3));
    }

    public List<String> generateValidParentheses(int n) {
        List<String> parentheses = new ArrayList<>();
        generateValidParentheses(n, n, new StringBuilder(""), parentheses);
        return parentheses;
    }

    private void generateValidParentheses(int open, int close, StringBuilder current, List<String> parentheses) {
        if (open == 0 && close == 0) {
            parentheses.add(current.toString());
            return;
        }

        if (open > 0) {
            current.append("(");
            generateValidParentheses(open - 1, close, current, parentheses);
            current.deleteCharAt(current.length() - 1);
        }

        if (close > open) {
            current.append(")");
            generateValidParentheses(open, close - 1, current, parentheses);
            current.deleteCharAt(current.length() - 1);
        }
    }


}
