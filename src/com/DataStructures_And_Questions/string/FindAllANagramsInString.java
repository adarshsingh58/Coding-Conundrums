package com.DataStructures_And_Questions.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two strings s and p, return an array of all the start indices of p's
 *
 * in s. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 * */
public class FindAllANagramsInString {
    public static void main(String[] args) {
        String s1="cbaebabacd",p1="abc";
        String s2="aa",p2="bb";
         new FindAllANagramsInString().findAnagrams("aa","bb").forEach(System.out::println);
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> op=new ArrayList<>();
        int startW=0,endW=p.length()-1;
        while(endW<s.length()){
            if(isAnagram(s.substring(startW,endW+1),p)){
                op.add(startW);
            }
            startW++;
            endW++;
        }

        return op;
    }

    public boolean isAnagram(String s1, String s2){
        Set<Character> set=new HashSet<>();
        int[] charArray=new int[26];
        for(char c:s1.toCharArray())
            charArray[c-97]++;
        for(char c:s2.toCharArray())
            charArray[c-97]--;
        for(int c:charArray)
            if(c!=0) return false;
        return true;
    }
}
