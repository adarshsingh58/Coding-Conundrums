package com.pattern.questions.topologicalSort;

/**
 * Given a sorted dictionary of an alien language having N words and K starting alphabets of a standard dictionary. Find
 * the order of characters in the alien language.
 * <p>
 * There may be multiple valid orders for a particular test case, thus you may return any valid order. The output will
 * be True if the order returned by the function is correct, else False denoting an incorrect order. Examples:
 * <p>
 * Input: N = 5, K = 4, dict = ["baa","abcd","abca","cab","cad"]
 * Output: b d a c
 * Explanation:
 * We will analyze every consecutive pair to find out the order of the characters.
 * The pair “baa” and “abcd” suggests ‘b’ appears before ‘a’ in the alien dictionary.
 * The pair “abcd” and “abca” suggests ‘d’ appears before ‘a’ in the alien dictionary.
 * The pair “abca” and “cab” suggests ‘a’ appears before ‘c’ in the alien dictionary.
 * The pair “cab” and “cad” suggests ‘b’ appears before ‘d’ in the alien dictionary.
 * So, [‘b’, ‘d’, ‘a’, ‘c’] is a valid ordering.
 * Input: N = 3, K = 3, dict = ["caa","aaa","aab"]
 * Output: c a b
 * Explanation: Similarly, if we analyze the consecutive pair
 * for this example, we will figure out [‘c’, ‘a’, ‘b’] is
 * a valid ordering.
 * <p>
 * https://takeuforward.org/plus/dsa/problems/alient-dictionary
 */
public class AlienDictionary {
    public static void main(String[] args) {

    }


}
