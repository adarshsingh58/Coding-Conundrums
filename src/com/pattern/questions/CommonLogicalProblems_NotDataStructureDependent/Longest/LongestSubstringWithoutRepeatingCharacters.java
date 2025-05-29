package com.pattern.questions.CommonLogicalProblems_NotDataStructureDependent.Longest;

/*
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * Common Techniques: Sliding Window, Hash Set/Map.
 * <p>
 * Difficulty: Medium
 *
 * Problem Summary
 *
 * Longest Substring Without Repeating Characters
 * Goal: Return the length of the longest substring without repeating characters.
 * 🔍 Your Approach
 * Summary:
 *
 *     You're using a HashMap<Character, Integer> to track last seen indices.
 *
 *     On encountering a duplicate character, you're resetting the map and moving the index i forward.
 *
 *     That leads to a nested traversal because you go back to earlier parts of the string.
 *
 * ❌ Time Complexity: O(n²)
 *
 * Because you're restarting the search from i = map.get(c) + 1, then continuing the outer loop, you may visit some characters multiple times.
 * ✅ Optimal Approach: Sliding Window with HashMap
 * Idea:
 *
 *     Use two pointers: start and end to mark the current window.
 *
 *     Store the last seen index of each character in a HashMap.
 *
 *     If you see a duplicate within the current window, move start to lastSeen + 1.
 *
 *     Track the max length of window as you go.
 *
 * ✅ Time Complexity: O(n)
 *
 * Each character is visited at most twice — once by end, once by start.
 */
public class LongestSubstringWithoutRepeatingCharacters {
}
