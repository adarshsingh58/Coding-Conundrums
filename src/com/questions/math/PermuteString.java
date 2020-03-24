package com.questions.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a method to print all permutations of a given string. For instance,
 * all permutations of string "bad" are: bad,bda,abd,dba,adb,dab
 * <p>
 * We know that n! (factorial) is the number of permutations of a set of size n.
 * Another obvious and important concept is that if we choose an element for
 * first position then the total permutations of remaining elements are (n-1)!
 * For example, if we are given the string "abcd" and we pick "a" as our first
 * element then for remaining elements we have the following permutations:
 * bcd,bdc,cbd,dbc,cdb,dcb. Similarly if we pick "b" as the first element and
 * permute "acd" and prepend each permutation with "b" that will give us all
 * permutations starting with "b". To find all permutations we need to do this
 * process for each character in the string AND this can be done recursively to
 * help us find all permutations of substrings e.g."bcd", acd" etc.
 */
public class PermuteString {
    public static void main(String[] args) {
        String input = "bad";
        printAllPermutation(input);
    }

    /**
     * Taking above eg, if we are given the string "abcd" and we pick "a" as our
     * first element then for remaining elements we have the following permutations:
     * bcd,bdc,cbd,dbc,cdb,dcb.
     * If we look closely here, for n-1! possibilities, one of each letter is fixed
     * on first place and other are permuted. (bcd,bdc),(cbd,cdb),(dbc,dcb).
     * And here, the char 'a' is already fixed as first char, above permutations
     * are after fixing a as first. So, we understand here that we need to fix the very first
     * char and permute left over char by following same algo of fixing first letter of left over
     * chars and again and again utill there is only one char left i.e. the last char hence no further
     * permutations possible.
     * We will backtrack and do the same for all chars.
     *
     * @return
     */
    public static List<String> printAllPermutation(String input) {
        printAllPermutation(input.toCharArray(), 0, input.length() - 1);
        return list;
    }

    private static List<String> list = new ArrayList<>();

    private static void printAllPermutation(char[] charArray, int currentIndex, int endIndex) {

        if (currentIndex == endIndex) {
            list.add(new String(charArray));
            System.out.println(new String(charArray));
            return;
        }
        for (int i = currentIndex; i <= endIndex; i++) {
            swap_char(charArray, currentIndex, i);
            printAllPermutation(charArray, currentIndex + 1, endIndex);
            swap_char(charArray, currentIndex, i);
        }

    }

    static void swap_char(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
