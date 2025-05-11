package com.pattern.questions.backtrack;

/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a
 * valid dictionary word. Return all such possible sentences in any order.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"] Output: ["cats and dog","cat sand dog"]
 * <p>
 * Example 2:
 * <p>
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"] Output: ["pine apple pen
 * apple","pineapple pen apple","pine applepen apple"] Explanation: Note that you are allowed to reuse a dictionary
 * word.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"] Output: []
 *
 * Example 4:
 * we cannot do search char by char with wordDict in a set thing, because below case will fail.
 * s ="goalspecial"
 * wordDict =["go","goal","goals","special"]
 *
 * https://leetcode.com/problems/word-break-ii/description/
 */
public class WordBreakII {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
    }
}
