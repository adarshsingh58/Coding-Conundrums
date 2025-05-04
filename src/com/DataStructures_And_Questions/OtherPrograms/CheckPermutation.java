package com.DataStructures_And_Questions.OtherPrograms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings, decide if one is permutation of other
 * eg:
 * abcd and dcab -> Yes
 * abcd and ascb -> No
 */
public class CheckPermutation {
    public static void main(String[] args) {
        String input1 = "abwcd";
        String input2 = "wdcab";
        System.out.println(isPermute_sort(input1, input2));
        System.out.println(isPermute_map(input1, input2));
    }

    /**
     * In this approach,
     * >we test if length of both string is same. If not return false. If yes, follow:
     * >we sort both the strings
     * >both strings are compared now to be equal or not.
     * >if equal, they are permutation of each other else not
     *
     * @TimeComplexity O(nlogn) i.e. time taken to sort the arrays
     * @SpaceComplexity O(n) 2 char arrays are used
     */
    private static boolean isPermute_sort(String input1, String input2) {
        if (input1.length() == input2.length()) {
            char[] inpChar1 = input1.toCharArray();
            char[] inpChar2 = input2.toCharArray();
            Arrays.sort(inpChar1);
            Arrays.sort(inpChar2);
            if (new String(inpChar1).equals(new String(inpChar2))) {
                return true;
            }
        }
        return false;
    }

    /**
     * >A better approach will be to use a Map containing count of each char from string1
     * >Now traverse through string2 and for each of its char see if an entry in map exist
     * >If not then it means there was no char in string1 as current char in string2. So return false
     * >If yes, then reduce the count of the char in map marking that this char has been asserted
     * in both strings.
     *
     * @TimeComplexity O(n). We are traversing both array once. n is the length of both arrays
     * @SpaceComplexity O(n). Map of size n used.
     */
    private static boolean isPermute_map(String input1, String input2) {
        if (input1.length() == input2.length()) {
            Map<Character, Integer> countMap = new HashMap<>();
            for (char c : input1.toCharArray()) {
                if (countMap.get(c) == null) {
                    countMap.put(c, 1);
                } else {
                    countMap.put(c, countMap.get(c));
                }
            }
            for (char c : input2.toCharArray()) {
                if (countMap.get(c) == null || countMap.get(c) == 0) {
                    return false;
                } else {
                    countMap.put(c, countMap.get(c) - 1);
                }
            }
            return true;
        }
        return false;
    }
}
