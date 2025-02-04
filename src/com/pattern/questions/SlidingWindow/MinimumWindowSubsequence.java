package com.pattern.questions.SlidingWindow;

/**
 * Given two strings, str1 and str2, find the shortest substring in str1 such that str2 is a subsequence of that substring.
 * <p>
 * A substring is defined as a contiguous sequence of characters within a string. A subsequence is a
 * sequence that can be derived from another sequence by deleting zero or more elements without
 * changing the order of the remaining elements.
 * <p>
 * Let’s say you have the following two strings:
 * <p>
 * str1 = “abbcbabbcb”
 * <p>
 * str2 = “acac”
 * <p>
 * In this example, “abbcabbc” is a substring of str1, from which we can derive str2 simply by deleting
 * both the instances of the character bb. Therefore, str2 is a subsequence of this substring. Since this
 * substring is the shortest among all the substrings in which str2 is present as a subsequence, the function
 * should return this substring, that is, “abbcabbc”.
 * <p>
 * If there is no substring in str1 that covers all characters in str2, return an empty string.
 * <p>
 * If there are multiple minimum-length substrings that meet the subsequence requirement, return the one with the
 * left-most starting index.
 *
 *
 */
public class MinimumWindowSubsequence {
}
