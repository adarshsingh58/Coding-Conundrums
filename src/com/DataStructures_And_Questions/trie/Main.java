package com.DataStructures_And_Questions.trie;

import com.DS.Trie.Trie;

public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("adarsh");
        trie.insert("adah");
        trie.insert("combah");
        trie.insert("combat");
        System.out.println(trie.contains("comb"));
    }
}