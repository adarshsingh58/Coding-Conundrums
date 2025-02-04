package com.DataStructures_And_Questions.Hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of words wordsArray, determine whether a given target can be formed by combining two words from the array in any order.
 */
public class WordFormationUsingHashTable {

    public static void main(String[] args) {
        String[] wordsArray = {"apple", "banana", "orange", "grape", "kiwi", "melon", "strawberry", "water"};
        String target = "watermelon";
        isFormationPossible(wordsArray, target);
    }

    public static boolean isFormationPossible(String[] wordsArray, String target) {
        Set<String> set = new HashSet<>();
        for (String s : wordsArray)
            set.add(s);
        for (String s : wordsArray) {
            if (set.contains(getSuffix(s, target)))
                return true;
        }
        return false;
    }

    public static String getSuffix(String s, String tar) {
        if (tar.substring(0, s.length()).equals(s))
            return tar.substring(s.length(), tar.length());
        return "";
    }

    /*In this solution, we aim to determine the possibility of forming a target word by combining two words from an array.
     Initially, we check all possible divisions of the target word into two parts. First, we insert all the words in the array
      into the hash table. Then, we iterate over each position in the target word, creating a prefix and a suffix.
      For each division, we check if the prefix and suffix exist in the hash table. If both are found in the hash table,
      we return TRUE, confirming that the target word can be formed. If no such combination is found in the hash table after
      checking all possible divisions, we return FALSE, indicating that the target word cannot be formed using two words from
      the given array.

      The time complexity of this solution is O(n+m), where n is the number of elements in wordsArray, and m is the length of the target.
      This is because insertion in the hash table requires n time, and iterating over the target requires m time.
      The space complexity of this solution is O(n), where n is the number of elements in wordsArray.
      This is because the hash table takes n space to store the words.*/
    public static boolean isFormationPossible1(String[] wordsArray, String target) {
        // Initialize an empty hash table
        HashMap<String, Boolean> hashTable = new HashMap<>();

        // Insert each word from the words array into the hash table as a key
        for (String word : wordsArray) {
            hashTable.put(word, true);
        }

        // Iterate over each index of the word to check for possible formations
        for (int i = 1; i < target.length(); i++) {
            String prefix = target.substring(0, i);
            String suffix = target.substring(i);

            // Check if both prefix and suffix exist as keys in the hash table
            if (hashTable.containsKey(prefix) && hashTable.containsKey(suffix)) {
                return true;
            }
        }

        return false;
    }
}
