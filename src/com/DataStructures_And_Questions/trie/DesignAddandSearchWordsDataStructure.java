package com.DataStructures_And_Questions.trie;

import com.DS.TrieNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 *Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *     WordDictionary() Initializes the object.
 *     void addWord(word) Adds word to the data structure, it can be matched later.
 *     bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 *
 * Example:
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 * */
public class DesignAddandSearchWordsDataStructure {
    public static void main(String[] args) {
        DesignAddandSearchWordsDataStructure sol = new DesignAddandSearchWordsDataStructure();
        sol.addWord("bad");
        sol.addWord("bud");
        sol.addWord("dad");
        sol.addWord("bass");
        sol.addWord("mad");
        System.out.println(sol.search("pad"));
        System.out.println(sol.search("bad"));
        System.out.println(sol.search(".ad"));
        System.out.println(sol.search("b.."));
    }

    TrieNode root = new TrieNode();

    public void addWord(String word) {

        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.charMap.containsKey(c)) {
                curr = curr.charMap.get(c);
            } else {
                curr.charMap.put(c, new TrieNode());
                curr = curr.charMap.get(c);
            }
        }
        curr.endOfWord = true;

    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int i, TrieNode curr) {
        if (i == word.length()) {
            if (curr.endOfWord)
                return true;
            return false;
        }

        if (curr.charMap.containsKey(word.charAt(i))) {
            return search(word, i + 1, curr.charMap.get(word.charAt(i)));
        } else if (word.charAt(i) == '.') {
            boolean foundAnyMatch = false;
            for (Map.Entry<Character, TrieNode> entrySet : curr.charMap.entrySet()) {
                foundAnyMatch = foundAnyMatch || search(word, i + 1, entrySet.getValue());
                if (foundAnyMatch) return foundAnyMatch;
            }
        }

        return false;
    }
}
