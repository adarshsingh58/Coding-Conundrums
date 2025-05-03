package com.pattern.questions.backtrack;

import java.util.HashSet;
import java.util.Set;

/**
 * You have n  tiles, where each tile has one letter tiles[i] printed on it.
 * <p>
 * Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
 * <p>
 * Example 1:
 * <p>
 * Input: tiles = "AAB" Output: 8 Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA",
 * "BAA".
 * <p>
 * Example 2:
 * <p>
 * Input: tiles = "AAABBC" Output: 188
 * <p>
 * Example 3:
 * <p>
 * Input: tiles = "V" Output: 1
 * <p>
 * https://leetcode.com/problems/letter-tile-possibilities/description/
 */
public class LetterTilePossibilities {
    public static void main(String[] args) {
        tile("AAB").forEach(v ->{
            System.out.println(v);

        });
        System.out.println();
    }

    private static Set<String> tile(String inp) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < inp.toCharArray().length; i++) {
            StringBuilder sb=new StringBuilder();
            sb.append(inp.toCharArray()[i]);
            tile(inp.toCharArray(), i, sb, result);
        }
        return result;
    }

    private static void tile(char[] candidates, int start, StringBuilder currPath, Set<String> result) {
        if (currPath != null) {
            result.add(currPath.toString());
//            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (i == start) continue;
            currPath.append(candidates[i]);
            tile(candidates, i, currPath, result);
            currPath.deleteCharAt(currPath.length() - 1);
        }

    }

}
