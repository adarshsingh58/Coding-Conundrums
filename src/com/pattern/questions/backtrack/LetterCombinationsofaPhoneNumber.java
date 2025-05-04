package com.pattern.questions.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
 * represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any
 * letters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: digits = "23" Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * Example 2:
 * <p>
 * Input: digits = "" Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: digits = "2" Output: ["a","b","c"]
 * <p>
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        List<char[]> inp = createInput(digits);

        if(digits.isBlank()) return result;
        // if(digits.size()==1) return inp;
        letterCombinations(inp, inp.size(), 0, new ArrayList<Character>(), result);
        return result;
    }
    public void letterCombinations(List<char[]> candidates, int target, int start, List<Character> currPath,
                                   List<String> result) {

        if (currPath.size() == target) {
            StringBuilder sb = new StringBuilder();
            for (char c : currPath)
                sb.append(c);
            result.add(sb.toString());
            return;
        }
        if (currPath.size() > target)
            return;

        for (int i = start; i < candidates.size(); i++) {
            for (int j = 0; j < candidates.get(i).length; j++) {
                currPath.add(candidates.get(i)[j]);
                letterCombinations(candidates, target, i + 1, currPath, result);
                currPath.remove(currPath.size() - 1);
            }
        }
    }

    public List<char[]> createInput(String digits) {
        List<char[]> op = new ArrayList<>();
        char[] digitsC = digits.toCharArray();
        for (char c : digitsC) {
            char[] temp = new char[1];
            char[] tempspecial = new char[1];

            if (c == '2') {
                temp = new char[]{'a', 'b', 'c'};
            } else if (c == '3') {
                temp = new char[]{'d', 'e', 'f'};
            } else if (c == '4') {
                temp = new char[]{'g', 'h', 'i'};
            } else if (c == '5') {
                temp = new char[]{'j', 'k', 'l'};
            } else if (c == '6') {
                temp = new char[]{'m', 'n', 'o'};
            } else if (c == '7') {
                tempspecial = new char[]{'p', 'q', 'r', 's'};
            } else if (c == '8') {
                temp = new char[]{'t', 'u', 'v'};
            } else if (c == '9') {
                tempspecial = new char[]{'x', 'w', 'y', 'z'};
            }
            if (temp.length != 1)
                op.add(temp);
            else if (tempspecial.length != 1)
                op.add(tempspecial);
        }
        return op;

    }
}
