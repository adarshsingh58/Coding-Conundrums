package com.questions.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string that contains duplicate occurrences of characters, remove
 * these duplicate occurrences.
 * <p>
 * For example, if the input string is "abbabcddbabcdeedebc", after removing
 * duplicates it should become "abcde".
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        String input = "abbabcddbabcdeedebc";
        String output = eliminateDuplicates(input);
        System.out.println(output);
    }

    /**
     * Here, we have used a HashSet to store each char from input String.
     * While checking if hashset already have the char.
     * If it does not, we add the char to the output string and
     * if it does we skip that char from output.
     *
     * @TimeComplexity O(n). We are traversing through all the chars of the string
     * @SpaceComplexity O(n). We are using a hashset and its size in worst case can be equal to the
     * size of the string(when all chars are unique)
     */
    private static String eliminateDuplicates(String input) {
        Set<Character> set = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            if (!set.contains(input.charAt(i))) {
                set.add(input.charAt(i));
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }
}
