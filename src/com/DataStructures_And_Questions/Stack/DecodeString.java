package com.DataStructures_And_Questions.Stack;

/*
*Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"


* https://leetcode.com/problems/decode-string
* */
public class DecodeString {

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
    }

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int repeat = 0;
        StringBuilder tempSb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                repeat = Character.getNumericValue(s.charAt(i));
            } else if (s.charAt(i) == '[') {
                i++;
                while (i < s.length() && s.charAt(i) != ']')
                    tempSb.append(s.charAt(i++));
                while (repeat > 0) {
                    sb.append(tempSb);
                    repeat--;
                }
                tempSb = new StringBuilder();
            }
        }
        return sb.toString();
    }

}
