package com.DataStructures_And_Questions.string;

/**
 * Given a null terminated string, remove any white spaces (tabs or spaces). For
 * example: All greek to	me.
 * <p>
 * After removing the white spaces, the string should look like: Allgreektome.
 */
public class RemoveWhiteSpaces {

    public static void main(String[] args) {
        String input = "All greek to 	me";
        String output = removeWhiteSpace(input);
    }

    /**
     * This problem is SAME as shifting all 0s to left side in an array of integers.
     * we will take 2 pointers here, read i and write j.
     * When we keep getting space we will swap i and j.
     * Look for Array problem for more details.
     *
     * @TimeComplexity O(n)
     * @SpaceComplexity O(n), char array of size n used.
     */
    private static String removeWhiteSpace(String input) {
        int i = 0, j = 0;
        char[] ca = input.toCharArray();

        while (i < input.length()) {
            if (ca[i] != ' ' && ca[i] != '\t') {
                char temp = ca[i];
                ca[i] = ca[j];
                ca[j] = temp;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return ca.toString();
    }
}
