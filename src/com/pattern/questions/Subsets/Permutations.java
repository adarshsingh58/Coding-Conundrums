package com.pattern.questions.Subsets;

import java.util.ArrayList;

/**
 * Given an input string, word, return all possible permutations of the string.
 */
public class Permutations {

    /**
     * Pattern: Subsets Problems such as this one, where we need to find the combinations or permutations of a given
     * string, are good examples to solve using the subsets pattern as it describes an efficient Depth-First Search
     * (DFS) approach to handle all these problems. Solution Let’s discuss a few basics first. We know that n!n! is the
     * number of permutations for a set of size nn. Another obvious and important concept is that if we choose an
     * element for the first position, then the total permutations of the remaining elements are (n−1)!(n−1)!. For
     * example, if we’re given the string “abcd” and we pick “a” as our first element, then for the remaining elements
     * we have the following permutations:
     */
    public static String swapChar(String word, int i, int j) {
        char[] swapIndex = word.toCharArray();
        char temp = swapIndex[i];
        swapIndex[i] = swapIndex[j];
        swapIndex[j] = temp;

        return new String(swapIndex);
    }

    public static void permuteStringRec(String word, int currentIndex, ArrayList<String> results) {
        if (currentIndex == word.length() - 1) {
            results.add(word);
            return;
        }
        for (int index = currentIndex; index < word.length(); index++) {
            String swappedStr = swapChar(word, currentIndex, index);
            permuteStringRec(swappedStr, currentIndex + 1, results);
        }
    }

    public static ArrayList<String> permuteWord(String word) {
        ArrayList<String> results = new ArrayList<String>();
        permuteStringRec(word, 0, results);
        return results;
    }

    // Driver code
    public static void main(String args[]) {
        String[] inputWord = {"ab", "bad", "abcd"};
        for (int index = 0; index < inputWord.length; index++) {
            ArrayList<String> permutedWords = permuteWord(inputWord[index]);
            System.out.println(index + 1 + ".\t Input string: '" + inputWord[index] + "'");
            System.out.println("\t All possible permutations are: " + permutedWords);
        }
    }
}
