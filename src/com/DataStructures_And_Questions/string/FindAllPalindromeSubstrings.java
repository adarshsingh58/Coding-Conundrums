package com.DataStructures_And_Questions.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string find all substrings that are palindromes.
 * Input String:aabbbaa
 * PalindromeSubstrings: aa, bb, bbb, abbba, aabbbaa, bb, aa
 */
public class FindAllPalindromeSubstrings {
    public static void main(String[] args) {
        String input = "redder";
        List<String> subs = findSubStr(input);

        for (String s : subs) {
            System.out.println(s);
        }
    }

    /**
     * Palindromes are words which are same from front and back
     * like civic,radar, redder.
     * <p>
     * In an input string we have to find all the palindromes which are substring
     * <p>
     * Palindromes are of 2 types:
     * >Odd: where number of chars are odd like level(5 chars). we have a middle letter here.
     * >Even: where number of chars are even like redder(6 chars). we have no middle letter here.s
     * <p>
     * In our algo, for each index, we find possible odd and even palindromes and add to the list.
     * Idea is that for an index we match its left char to its right char, if same then palindrome
     * found and left-1 and right +1 is checked and so on
     * else we move to next index.
     */
    private static List<String> findSubStr(String input) {
        List<String> subs = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            findOddSubs(input, i, subs);
            findEvenSubs(input, i, subs);
        }
        return subs;
    }

    /**
     * For finding even palindromes we start with current
     * index i marked as j and next index i+1 marked as k
     * <p>
     * eg: for redder, i=2 -> j=2 i.e. letter (first) d. and k=3
     * Because there is no middle char we assigned j to i
     */
    private static void findEvenSubs(String input, int i, List<String> subs) {
        int j = i;
        int k = i + 1;
        findPalindromesForGivenIndex(j, k, input, subs);
    }

    /**
     * For finding odd palindromes we start with
     * (current index i-1) marked as j and next index i+1 marked as k
     * <p>
     * eg: for level, i=2 -> j=i-1=1 i.e. letter (first) e. and k=i+1=3
     * Because here we have middle char hence, middle char is represented by i
     * while j as its left char and k as its right char
     */
    private static void findOddSubs(String input, int i, List<String> subs) {
        int j = i - 1;
        int k = i + 1;
        findPalindromesForGivenIndex(j, k, input, subs);
    }

    /**
     * We keep matching if value at j and k are equal or not.
     * If yes, we add the substring from j to k+1 (k+1 coz java substring
     * method select substring till k-1) to list else we break coz no more palindrome can
     * be found further, if current substring is not a palindrome
     */
    private static List<String> findPalindromesForGivenIndex(int j, int k, String input, List<String> subs) {
        while (j >= 0 && k < input.length()) {
            if (input.charAt(j) == input.charAt(k)) {
                subs.add(input.substring(j, k + 1));
            } else {
                break;
            }
            j--;
            k++;
        }
        return subs;
    }
}
