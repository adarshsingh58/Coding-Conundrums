package com.pattern.questions.backtrack;

import java.util.*;

/**
 * Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create. Return the output in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "a1b2" Output: ["a1b2","a1B2","A1b2","A1B2"]
 * <p>
 * Example 2:
 * <p>
 * Input: s = "3z4" Output: ["3z4","3Z4"]
 * <p>
 * https://leetcode.com/problems/letter-case-permutation/description/
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
        String inp = "3z4";
        List<String> op = letCasePerm(inp);
        op.forEach(System.out::println);
    }

    private static List<String> letCasePerm(String inp) {
        Set<String> op = new HashSet<>();
        letCasePermRec(inp.toCharArray(), 0, op, new StringBuilder());
        return new ArrayList<>(op);
    }

    private static void letCasePermRec(char[] inp, int index, Set<String> op, StringBuilder sb) {
        if (sb.length() == inp.length) {
            op.add(sb.toString());
            return;
        }
        if (index >= inp.length)
            return;

        int idx = index;
        boolean isAplhaAdded = Character.isAlphabetic(inp[idx]);
        sb.append(inp[idx]);
        idx++;
        while (idx < inp.length && Character.isDigit(inp[idx])) {
            sb.append(inp[idx]);
            idx++;
        }
        if(idx < inp.length && !isAplhaAdded) {
            sb.append(inp[idx]);
            idx++;
        }
        letCasePermRec(inp, idx, op, sb);
        sb.replace(index, index + 1, String.valueOf(Character.toUpperCase(inp[index])));
        letCasePermRec(inp, idx , op, sb);
        sb.delete(index,idx);
    }
}
