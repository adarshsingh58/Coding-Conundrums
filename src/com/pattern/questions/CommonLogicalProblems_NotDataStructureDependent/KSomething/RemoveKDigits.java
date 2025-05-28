package com.pattern.questions.CommonLogicalProblems_NotDataStructureDependent.KSomething;

import java.util.LinkedList;
import java.util.Stack;

/*
*
* Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.



Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

* https://leetcode.com/problems/remove-k-digits/description/
* */
public class RemoveKDigits {

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits().removeKdigits("1432219", 3));
//        System.out.println(new RemoveKDigits().removeKdigits("33526", 3));
//        System.out.println(new RemoveKDigits().removeKdigits("33526221184202197273", 19));
    }

    public String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";
        if (k <= 0)
            return num;
        Stack<Integer> monotonic = new Stack<>();
        char[] charArr = num.toCharArray();
        int i = 0;
        StringBuilder op = new StringBuilder();
        while (i < charArr.length) {
            while (!monotonic.isEmpty() && k != 0 && monotonic.peek() > Character.getNumericValue(charArr[i])) {
                monotonic.pop();
                k--;
            }
            monotonic.add(Character.getNumericValue(charArr[i]));
            i++;
        }
        while (i < charArr.length) {
            monotonic.add(Character.getNumericValue(charArr[i]));
            i++;
        }
        while (k > 0) {
            monotonic.pop();
            k--;
        }

        while (!monotonic.isEmpty()) {
            op.append(monotonic.pop());
        }

        //removing trailing zeros
        StringBuilder result = op.reverse();
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.toString();

    }
}
