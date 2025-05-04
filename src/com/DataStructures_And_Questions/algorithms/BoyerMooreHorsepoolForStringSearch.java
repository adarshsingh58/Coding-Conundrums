package com.DataStructures_And_Questions.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.youtube.com/watch?v=PHXAOKQk2dw
 */
public class BoyerMooreHorsepoolForStringSearch {

    public static void main(String[] args) {
        String inputString = "Mister, This world is my Oyester";
        String wordToFind = "ester";

        System.out.println(findStr_BoyerMooreHorspool(inputString, wordToFind));
        System.out.println(attempt(inputString, wordToFind));
    }

    private static int attempt(String inputString, String wordToFind) {
        //badmatch Table
        Map<Character, Integer> badM = new HashMap<>();
        char[] cA = wordToFind.toCharArray();
        for (int i = 0; i < cA.length; i++)
            badM.put(cA[i], cA.length - i );

        char[] inpC = inputString.toCharArray();
        for (int i = cA.length - 1, k = cA.length - 1, j = cA.length - 1; i < inpC.length; ) {
            if (j == -1)
                return i;
            if (inpC[i] == cA[j]) {
                i--;
                j--;
            } else {
                i = k + badM.get(cA[j]);
                k=i;
                j = cA.length - 1;
            }
        }
        return -1;
    }

    /**
     * This is a simplified version of Boyer Moore algo. This is a 2 stage algo. 1> Preprocess the wordToFind and build
     * a table which knows how many char to skip if a bad match or miss occurs. 2> The String to find is searched from
     * last to first char and badMatch table is used to skip char if a bad match occurs
     * <p>
     * Performance: O(mn), m is wordToFind and n is inputString Although its best case scenario is : O(n/m)
     */
    private static int findStr_BoyerMooreHorspool(String inputString, String wordToFind) {
        Map<Character, Integer> badMatch = findBadMatchTable(wordToFind);
        badMatch.entrySet();
        int wordJ = wordToFind.length() - 1;
        // starts match from wordJ th index in inputString, coz matching happens backward
        //and if last word does not match, we skip according to the bad match table
        for (int i = wordJ; i < inputString.length(); ) {
            while (wordJ >= 0) {//i.e. match has nt been found yet, when found wordJ will become -1
                if (inputString.charAt(i) == wordToFind.charAt(wordJ)) {//if the char matches, start matching prev chars
                    wordJ--;
                    i--;
                } else {// if any mismatch occurs, reset wordJ and skip i indexes in inputString based on the mismatched char
                    //from inputString, if the mismatched char from inputString is in badMatch table we skip according int value,
                    //if not, we skip length of wordToFind characters.
                    int skip = badMatch.get(inputString.charAt(i)) == null ? wordToFind.length()
                            : badMatch.get(inputString.charAt(i));
                    wordJ = wordToFind.length() - 1;
                    i = i + skip;
                    break;// we come out of inner loop once match not found
                }
            }
            if (wordJ < 0) {// WordJ will be -1 when wordToFind is fully matched
                return ++i;
            }
        }
        return -1;// when no match found
    }

    /**
     * shift length is the number of char we can shift or skip when a bad match occurs > We store the length of the
     * wordToFind as the default shift length. This will be the shift when inputString char matches none char from
     * wordToFind > For each other char from wordToFind, we store ((length of wordToFind -1) - char'index in wordToFind)
     * >If there is a char already present in badMatch Table, we overwrite it with new value.
     * <p>
     * eg: wordToFind -> truth BADMATCH TABLE:
     * <p>
     * ? -> 5 (length of string) t -> 1 ((5-1)-3) r -> 3 ((5-1)-1) u -> 2 (5-1)-2)
     * <p>
     * For t, first time value would be (5-1)-0) i.e. 4 but when we encounter second t, this value will be overwritten
     * <p>
     * We do not keep bad match value for last char in wordToFind as it will always be 0.
     */
    private static Map<Character, Integer> findBadMatchTable(String wordToFind) {
        Map<Character, Integer> badMatch = new HashMap<>();
        int length = wordToFind.length();
        for (int i = 0; i < length; i++) {
            badMatch.put(wordToFind.charAt(i), length - 1 - i);
        }
        return badMatch;
    }

}
