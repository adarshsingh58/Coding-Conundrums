package com.DataStructures_And_Questions.scenarioBasedQues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters(can be none)
 * deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while
 * "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 * <p>
 * If there is no common subsequence, return 0.
 * Example 1:
 * Input: text1 = "abcde", text2 = "ace" Output: 3 Explanation: The longest common subsequence is "ace" and its length
 * is 3.
 * Example 2:
 * Input: text1 = "abc", text2 = "abc" Output: 3 Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 * Input: text1 = "abc", text2 = "def" Output: 0 Explanation: There is no such common subsequence, so the result is 0.
 * "oxcpqrsvwf" "shmtulqrypy" OP: 2
 * "ezupkr" "ubmrapg" OP: 2
 * "ylqpejqbalahwr" "yrkzavgdmdgtqpg" OP: 3
 * "ylqpejqbalahwr" "yraqp"
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ylqpejqbalahwr", "yrkzavgdmdgtqpg"));
    }


    //    NOt the right solution some test cases failing
    public static int longestCommonSubsequence(String text1, String text2) {
        Map<Character, List<Integer>> characterListMap = new HashMap<>();
        char[] cA = text1.toCharArray();
        for (int i = 0; i < cA.length; i++) {
            if (characterListMap.get(cA[i]) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                characterListMap.put(cA[i], list);
            } else {
                characterListMap.get(cA[i]).add(i);
            }
        }
        char[] cA2 = text2.toCharArray();
        int i = 0;
        int prevBiggest = 0;
        int previndex = 0;
        int currBiggest = 0;
        while (i < cA2.length && characterListMap.get(cA2[i]) == null) {
            i++;
        }
        if (i < cA2.length && characterListMap.get(cA2[i]) != null) {
            previndex = characterListMap.get(cA2[i]).get(characterListMap.get(cA2[i]).size() - 1);
            i++;
            currBiggest++;
        }


        for (; i < cA2.length; i++) {
            if (characterListMap.containsKey(cA2[i])) {
                if (characterListMap.get(cA2[i]).get(characterListMap.get(cA2[i]).size() - 1) > previndex) {
                    previndex = characterListMap.get(cA2[i]).get(characterListMap.get(cA2[i]).size() - 1);
                    currBiggest++;
                } else {
                    previndex = characterListMap.get(cA2[i]).get(characterListMap.get(cA2[i]).size() - 1);
                    if (currBiggest > prevBiggest) {
                        prevBiggest = currBiggest;
                    }
                    currBiggest = 1;
                }
            }
        }

        return prevBiggest > currBiggest ? prevBiggest : currBiggest;
    }
}
