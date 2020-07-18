package com.questions.scenarioBasedQues;

import java.util.*;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * board = {
 * {'o','a','a','n'},
 * {'e','t','a','e'},
 * {'i','h','k','r'},
 * {'i','f','l','v'}
 * }
 * words = {"oath","pea","eat","rain"}
 * <p>
 * Output: {"eat","oath"}
 * <p>
 * <p>
 * <p>
 * <p>
 * Input: {{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}}
 * {"aaaaaaaaaaaa","aaaaaaaaaaaaa","aaaaaaaaaaab"}
 * Expected: {"aaaaaaaaaaaa"}
 * <p>
 * <p>
 * Input: {{'a','b','c'},{'a','e','d'},{'a','f','g'}}
 * {"abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"}
 * Expected: {"abcdefg","befa","eaabcdgfa","gfedcbaaa"}
 * Note:
 * <p>
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 */
public class WordSearchInBoard {

    public static void main(String[] args) {

        char[][] board = {
                {'a'}
        };
        String[] words = {"a"};
        findWords(board, words).forEach(s -> System.out.println(s));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> foundWords = new ArrayList<>();
        Map<Character, List<String>> charToPositionMap = getPositionMap(board);
        for (String word : words) {
            if (wordFound(word, board, charToPositionMap))
                foundWords.add(word);
        }

        return foundWords;
    }

    public static Map<String, MetaData> memoization = new HashMap<>();

    private static boolean wordFound(String word, char[][] board, Map<Character, List<String>> charToPositionMap) {

        for (Map.Entry<String, MetaData> entry : memoization.entrySet()) {
            if (word.contains(entry.getKey())) {
                MetaData metaData = entry.getValue();
                if (backtrack(word.toCharArray(), entry.getKey().length(), board, metaData.getX(), metaData.getY(), metaData.getStrings(), metaData)) {
                    memoization.put(word, entry.getValue());
                    return true;
                }
            }
        }
        char[] wordChar = word.toCharArray();
        List<String> charPositionsInBoard = charToPositionMap.get(wordChar[0]);
        if (charPositionsInBoard != null)
            for (String position : charPositionsInBoard) {
                MetaData metaData = new WordSearchInBoard().new MetaData();
                int x = Integer.parseInt(position.split(",")[0]);
                int y = Integer.parseInt(position.split(",")[1]);
                Set<String> positionsAlreadyTracked = new HashSet<>();
                if (backtrack(wordChar, 0, board, x, y, positionsAlreadyTracked, metaData)) {
                    memoization.put(word, metaData);
                    return true;
                }
            }
        return false;
    }

    public static boolean backtrack(char[] wordChar, int i, char[][] board, int x, int y, Set<String> positionsAlreadyTracked, MetaData metaData) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return false;
        if (wordChar[i] != board[x][y]) return false;
        if (i == wordChar.length - 1) {
            metaData.setStrings(positionsAlreadyTracked);
            metaData.setX(x);
            metaData.setY(y);
            return true;
        }
        positionsAlreadyTracked.add(x + "," + y);
        i++;
        if (!positionsAlreadyTracked.contains((x + 1) + "," + y) && backtrack(wordChar, i, board, x + 1, y, positionsAlreadyTracked, metaData))
            return true;
        if (!positionsAlreadyTracked.contains((x - 1) + "," + y) && backtrack(wordChar, i, board, x - 1, y, positionsAlreadyTracked, metaData))
            return true;
        if (!positionsAlreadyTracked.contains(x + "," + (y + 1)) && backtrack(wordChar, i, board, x, y + 1, positionsAlreadyTracked, metaData))
            return true;
        if (!positionsAlreadyTracked.contains(x + "," + (y - 1)) && backtrack(wordChar, i, board, x, y - 1, positionsAlreadyTracked, metaData))
            return true;
        positionsAlreadyTracked.remove(x + "," + y);
        return false;
    }

    private static Map<Character, List<String>> getPositionMap(char[][] board) {
        Map<Character, List<String>> charToPositionMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (charToPositionMap.containsKey(board[i][j])) {
                    charToPositionMap.get(board[i][j]).add(i + "," + j);
                } else {
                    List<String> position = new ArrayList<>();
                    position.add(i + "," + j);
                    charToPositionMap.put(board[i][j], position);
                }
            }
        }
        return charToPositionMap;
    }


    class MetaData {
        Set<String> strings = new HashSet<>();
        int x = -1, y = -1;

        public Set<String> getStrings() {
            return strings;
        }

        public void setStrings(Set<String> strings) {
            this.strings = strings;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}

