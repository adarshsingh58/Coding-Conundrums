package com.DataStructures_And_Questions.scenarioBasedQues;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * <p>
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: "III"
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: "IV"
 * Output: 4
 * <p>
 * Example 3:
 * <p>
 * Input: "IX"
 * Output: 9
 * <p>
 * Example 4:
 * <p>
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * <p>
 * Example 5:
 * <p>
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomanToInteger {

    public static void main(String[] args) {
        String romanNo = "MCMXCIV";
        System.out.println(romanToInt(romanNo));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> charIntMap = buildMap();
        char[] ch = s.toCharArray();
        int value = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'I' && i < ch.length - 1 && (ch[i + 1] == 'V' || ch[i + 1] == 'X')) {
                value = value - charIntMap.get(ch[i]);
            } else if (ch[i] == 'X' && i < ch.length - 1 && (ch[i + 1] == 'L' || ch[i + 1] == 'C')) {
                value = value - charIntMap.get(ch[i]);
            } else if (ch[i] == 'C' && i < ch.length - 1 && (ch[i + 1] == 'D' || ch[i + 1] == 'M')) {
                value = value - charIntMap.get(ch[i]);
            } else {
                value = value + charIntMap.get(ch[i]);
            }
        }
        return value;
    }

    private static Map<Character, Integer> buildMap() {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        characterIntegerMap.put('I', 1);
        characterIntegerMap.put('V', 5);
        characterIntegerMap.put('X', 10);
        characterIntegerMap.put('L', 50);
        characterIntegerMap.put('C', 100);
        characterIntegerMap.put('D', 500);
        characterIntegerMap.put('M', 1000);
        return characterIntegerMap;
    }
}
