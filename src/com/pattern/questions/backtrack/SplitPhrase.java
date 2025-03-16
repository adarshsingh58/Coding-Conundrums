package com.pattern.questions.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SplitPhrase {
    public static void main(String[] args) {

        // should be ["the", "man", "ran"]
        System.out.println(
                SplitPhrase.split("themanran", new String[]{"the", "man", "ran"}).toString());
        SplitPhrase.clearList();

        // should be ["i", "love", "dogs", "John"]
        System.out.println(
                SplitPhrase.split(
                                "ilovedogsJohn", new String[]{"i", "am", "a", "dogs", "lover", "love", "John"})
                        .toString());
        SplitPhrase.clearList();

        // should be []
        System.out.println(
                SplitPhrase.split("themanran", new String[]{"clown", "man", "ran"}).toString());
        SplitPhrase.clearList();
    }

    static Set<String> splitWords = new HashSet<>();

    public static ArrayList<String> split(String phrase, String[] words) {

        for (String word : words)
            if (phrase.startsWith(word)) {
                splitWords.add(word);

                return split(phrase.substring(word.length()), words);
            }

        return new ArrayList<>(splitWords);
    }

    public static void clearList() {
        splitWords.clear();
    }
}
