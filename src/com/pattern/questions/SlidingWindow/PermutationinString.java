package com.pattern.questions.SlidingWindow;

import java.util.Arrays;

/**
 * Given two strings s1 and s2, return true if s2 contains a
 *
 * of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 * https://leetcode.com/problems/permutation-in-string/description/
 *
 * */
public class PermutationinString {

    public static void main(String[] args) {

    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(count1, count2)) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            count2[s2.charAt(i) - 'a']++; // add right char
            count2[s2.charAt(i - s1.length()) - 'a']--; // remove left char

            if (Arrays.equals(count1, count2)) return true;
        }

        return false;
    }

}
