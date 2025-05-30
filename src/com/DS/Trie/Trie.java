package com.DS.Trie;

import com.DS.TrieNode;

/**
 * Insert and search costs O(key_length), however the memory requirements of Trie is O(ALPHABET_SIZE * key_length * N)
 * where N is number of keys in Trie.
 * <p>
 * <p>
 * https://leetcode.com/problems/implement-trie-prefix-tree/submissions/1630842796/ Reference:
 * https://www.youtube.com/watch?v=AXjmTQ8LEoI
 */
public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
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

    public boolean contains(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.charMap.containsKey(c)) {
                curr = curr.charMap.get(c);
            } else {
                return false;
            }
        }
        return true;
    }


}
