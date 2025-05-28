package com.DataStructures_And_Questions.trie;

/**
 * You are asked to design an autocomplete system that:
 * Suggests the top 3 most frequent sentences that start with the current typed prefix.
 * Handles user input character by character, including the special character '#', which indicates the end of a
 * sentence.
 *
 * Functional Requirements
 *     Initialization:
 *         You're given a list of sentences[] and corresponding times[] indicating how many times each sentence was typed previously.
 *     User Input:
 *         On each character input c:
 *             If c != '#', return up to 3 sentences that match the current prefix.
 *                 Sentences are sorted by highest frequency, then lexicographical order.
 *             If c == '#', treat the current input as a completed sentence:
 *                 Add it to the system or update its frequency.
 *                 Return an empty list.
 * Input:
 * sentences = ["i love you", "island", "ironman", "i love leetcode"]
 * times = [5, 3, 2, 2]
 *
 * User types: 'i' → Returns ["i love you", "i love leetcode", "island"]
 * User types: ' ' → Returns ["i love you", "i love leetcode"]
 * User types: 'a' → Returns []
 * User types: '#' → Sentence "i a" is added to the system
 *
 * Design Tips
 *     Use a Trie for prefix matching.
 *     Store a Map<String, Integer> in each node to track frequency of all sentences under that prefix (or use a min-heap).
 *     Use priority queues (min-heaps) to sort top 3 sentences efficiently.
 *     Use a StringBuilder to accumulate the current input prefix.
 *
 */
public class AutoComplete {
}
