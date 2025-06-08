package com.pattern.questions.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an m×nm×n 2D grid of characters and word as a string, we need to determine if the word can be constructed from
 * letters of sequentially adjacent cells. The cells are considered sequentially adjacent when they are neighbors to
 * each other either horizontally or vertically. The function should return TRUE if the word can be constructed and
 * FALSE otherwise.
 * <p>
 * https://leetcode.com/problems/word-search/description/
 */
public class WordSearch {

    public static void main(String[] args) {
//        char[][] inp = {{'A', 'B', 'C', 'E' }, {'S', 'F', 'C', 'S' }, {'A', 'D', 'E', 'E' }};
        char[][] inp = {{'C', 'A', 'A' }, {'A', 'A', 'A' }, {'B', 'C', 'D' }};
        new WordSearch().exist(inp, "AAB");
    }

    public boolean exist(char[][] board, String word) {
        Set<String> visited;
        List<String> possibleStartIndexes = findStartIndexes(board, word);
        for (String possibleStartIndex : possibleStartIndexes) {
            visited = new HashSet<>();
            boolean found = exist(board, word, Character.getNumericValue(possibleStartIndex.charAt(0)), Character.getNumericValue(0 + possibleStartIndex.charAt(1)), new StringBuilder(), visited);
            if (found) return true;
        }
        return false;
    }

    private List<String> findStartIndexes(char[][] board, String word) {
        List<String> op = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[0].length; i1++) {
                if (board[i][i1] == word.charAt(0))
                    op.add(i + "" + i1);
            }
        }
        return op;
    }

    public boolean exist(char[][] candidates, String target, int i, int j, StringBuilder currString,
                         Set<String> visitedNodes) {
        if (currString.toString().equals(target))
            return true;
        if (visitedNodes.contains(i + "" + j) || i >= candidates.length || i < 0 || j < 0 || j >= candidates[0].length)
            return false;

        currString.append(candidates[i][j]);
        visitedNodes.add(i + "" + j);

        if (currString.length() > 0 && currString.charAt(currString.length() - 1) != target.charAt(currString.length() - 1)) {
            currString.deleteCharAt(currString.length() - 1);
            visitedNodes.remove(i + "" + j);
            return false;
        }
        if (exist(candidates, target, i + 1, j, currString, visitedNodes) ||
                exist(candidates, target, i, j + 1, currString, visitedNodes) ||
                exist(candidates, target, i - 1, j, currString, visitedNodes) ||
                exist(candidates, target, i, j - 1, currString, visitedNodes))
            return true;
        else{
            // At the end of the function, after all recursive calls fail
            currString.deleteCharAt(currString.length() - 1);
            visitedNodes.remove(i + "" + j);
            return false;
            }
    }
}
