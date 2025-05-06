package com.DataStructures_And_Questions.OtherPrograms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String inp = "wpwkew";
        System.out.println(longSubStr(inp));
    }

    /*
     * Using Sliding Window approach here.
     * we keep track of 1 char at a time and see if it present in set.
     * If not we add it and increase the slidingWindow Count.
     * If it is present that means we have a repeating character
     * and we stop the window by resetting the slidingWindow Count and the map.
     * We also decrease the indexCounter i to start from this repeating character,
     *
     * It is important that we set the  i = map.get(inp.charAt(i))+1; when we find a repeat
     * which we are sliding the window by only that much where first repeated char is found.
     * */
    public static int lengthOfLongestSubstring(String inp) {
        if (inp.isEmpty())
            return 0;
        if (inp.length() != 0 && inp.trim().isEmpty())
            return 1;
        Map<Character, Integer> map = new HashMap<>();
        int count = 1;
        int windowCount = 0;
        for (int i = 0; i < inp.length(); i++) {
            if (map.containsKey(inp.charAt(i))) {
                count = Math.max(count, windowCount);
                windowCount = 0;
                i = map.get(inp.charAt(i));
                map = new HashMap<>();
            } else {
                map.put(inp.charAt(i), i);
                windowCount++;
            }

        }
        return Math.max(count, windowCount);
    }


}
