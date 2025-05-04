package com.pattern.questions.twopointers;

/**
 * Given a string word and an abbreviation abbr, return TRUE if the abbreviation matches the given string. Otherwise,
 * return FALSE.
 * <p>
 * A certain word "calendar" can be abbreviated as follows:
 * <p>
 * "cal3ar" ("cal end ar" skipping three characters "end" from the word "calendar" still matches the provided
 * abbreviation)
 * <p>
 * "c6r" ("c alenda r" skipping six characters "alenda" from the word "calendar" still matches the provided
 * abbreviation)
 * <p>
 * The word "internationalization" can also be abbreviated as "i18n" (the abbreviation comes from skipping 18 characters
 * in "internationalization", leaving the first and last letters "i" and "n").
 * <p>
 * The following are not valid abbreviations:
 * <p>
 * "c06r" (has leading zeroes)
 * <p>
 * "cale0ndar" (replaces an empty string)
 * <p>
 * "c24r" ("c al enda r" the replaced substrings are adjacent)
 * <p>
 * https://leetcode.com/problems/valid-word-abbreviation/description/
 */
public class ValidWordAbbreviation {

    public static void main(String[] args) {
        System.out.println( new ValidWordAbbreviation().validAbbr("internationalization", "i12iz4n"));
        System.out.println( new ValidWordAbbreviation().validAbbr("apple", "5"));
        System.out.println( new ValidWordAbbreviation().validAbbr("apple", "a01e"));
        System.out.println( new ValidWordAbbreviation().validAbbr("apple", "a2e"));
    }

    public boolean validAbbr(String word, String abbr) {
        int i = 0, j = 0;

        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                String skip = "";
                while ( j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    skip = skip + abbr.charAt(j);
                    j++;
                }
                i = i + Integer.valueOf(skip);
            } else if (word.charAt(i) != abbr.charAt(j))
                return false;
            else {
                i++;
                j++;
            }
        }

        if(j!=abbr.length() & i!=word.length())
            return false;

        return true;
    }
}
