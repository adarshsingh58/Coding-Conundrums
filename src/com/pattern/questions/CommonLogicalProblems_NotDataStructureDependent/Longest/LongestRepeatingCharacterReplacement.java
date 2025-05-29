package com.pattern.questions.CommonLogicalProblems_NotDataStructureDependent.Longest;

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other
 * uppercase English character. You can perform this operation at most k times.
 * <p>
 * Return the length of the longest substring containing the same letter you can get after performing the above
 * operations.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ABAB", k = 2 Output: 4 Explanation: Replace the two 'A's with two 'B's or vice versa.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "AABABBA", k = 1 Output: 4 Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA". The
 * substring "BBBB" has the longest repeating letters, which is 4. There may exists other ways to achieve this answer
 * too.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105 s consists of only uppercase English letters. 0 <= k <= s.length
 * <p>
 * <p>
 * <p>
 * <p>
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */
public class LongestRepeatingCharacterReplacement {

    /**
     * Approach:
     *  have output variable Maxlength
     I am thinking to loop from i-> 0 to n-1 and have a local variable templength;
     keep increasing i till arr[i]==arr[i-1] and tempLength++;
     if arr[i]!=arr[i-1] && k> 0 keep increasing i again and tempLength++;
     if k==0, reset i to last i where arr[i]!=arr[i-1] and do  Maxlength= max(Maxlength, templength)
     return maxLength

     Time COmpl: O(n^2)
     * Loop from i = 0 to n - 1
     Try to grow a window as long as characters are the same, allowing up to k mismatches
     On exhausting k, reset and continue

     Optimal Solution: Sliding Window (O(n))
     🧠 Core Idea
     Use a sliding window:
     Track the count of most frequent character in the window
     If the number of characters to change (window size - maxCharFreq) > k, shrink the window
     Else, expand the window and update max length
     We don’t need to shrink on character mismatch — we just maintain the invariant:
     * */
    public static void main(String[] args) {

    }
/*| Operation | Complexity              |
| --------- | ----------------------- |
| Time      | O(n)                    |
| Space     | O(1) (fixed 26 letters) |
*/
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxFreq = 0, maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            // If we need to replace more than k characters, shrink window
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

}
