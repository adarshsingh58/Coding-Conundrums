package com.DS;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<Character, TrieNode> charMap;
    public boolean endOfWord;

    public TrieNode() {
        endOfWord = false;
        charMap = new HashMap<>();
    }
}