package com.pattern.questions.twopointers;

/**
 * Given a string word and an abbreviation abbr, return TRUE if the abbreviation matches the given string. Otherwise, return FALSE.
 * <p>
 * A certain word "calendar" can be abbreviated as follows:
 * <p>
 * "cal3ar" ("cal end ar" skipping three characters "end" from the word "calendar" still matches the provided abbreviation)
 * <p>
 * "c6r" ("c alenda r" skipping six characters "alenda" from the word "calendar" still matches the provided abbreviation)
 * <p>
 * The word "internationalization" can also be abbreviated as "i18n" (the abbreviation comes from skipping 18 characters in "internationalization",
 * leaving the first and last letters "i" and "n").
 * <p>
 * The following are not valid abbreviations:
 * <p>
 * "c06r" (has leading zeroes)
 * <p>
 * "cale0ndar" (replaces an empty string)
 * <p>
 * "c24r" ("c al enda r" the replaced substrings are adjacent)
 */
public class ValidWordAbbreviation {
}
