package com.DataStructures_And_Questions.OtherPrograms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Check if two strings are angaram
 */
public class Anagram {

    public static void main(String[] args) {
        String a = "listen", b = "silent";
        boolean isAnagram_sort = ifAnagram_sort(a, b);
        boolean isAnagram_Set = ifAnagram_Set(a, b);
        boolean ifAnagram_BetterApproach = ifAnagram_BetterApproach(a, b);
        System.out.println(isAnagram_sort);
        System.out.println(isAnagram_Set);
        System.out.println(ifAnagram_BetterApproach);
    }

    /**
     * @TimeComplexity O(nlogn)
     * @SpaceComplexity O(1). No new DS used (char arrays are not counted here)
     */
    private static boolean ifAnagram_sort(String a, String b) {
        if (a.length() == b.length()) {
            char[] ac = a.toCharArray(), bc = b.toCharArray();
            Arrays.sort(ac);
            Arrays.sort(bc);
            if (new String(ac).equals(new String(bc))) {
                return true;
            }
        }
        return false;
    }

    /**
     * @TimeComplexity O(n)
     * @SpaceComplexity O(n). set of size of strings used
     */
    private static boolean ifAnagram_Set(String a, String b) {
        if (a.length() == b.length()) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < a.length(); i++) {
                set.add(a.charAt(i));
            }

            for (int i = 0; i < b.length(); i++) {
                set.remove(b.charAt(i));
            }

            if (set.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /*
     * here, we have assumed that system stores  char in 8bit and one char uses 2bit, hence total combination possible 2^8 i.e. 256.
     * we take a char[256], each index represnets a char in ascii value. This array is initialized to 0, each index's value will be  increased by 1
     * if that char is foind in string 1 and reduced by 1 if char is found in string 2, hence for anagrams in the end, array will have all 0s.
     * */
    private static boolean ifAnagram_BetterApproach(String a, String b) {
        if (a.length() != b.length()) return false;
        char[] ca = new char[256];
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();

        for (int i = 0; i < a.length(); i++) {
            ca[c1[i]]++;
            ca[c2[i]]--;
        }
        for (char c : ca) {
            if (c != 0) return false;
        }
        return true;
    }
}
