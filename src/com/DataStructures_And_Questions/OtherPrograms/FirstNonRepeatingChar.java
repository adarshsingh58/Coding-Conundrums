package com.DataStructures_And_Questions.OtherPrograms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Find first non repeating char from a string
 * input="Adarsh"
 * output=d
 */
public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        String input = "adarsh";
        char c = findFirstNonRepeatingChar(input);
        System.out.println(c);
    }

    private static char findFirstNonRepeatingChar(String input) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : input.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }
        return 0;
    }
}
