package com.DataStructures_And_Questions.scenarioBasedQues;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * <p>
 * Example 2:
 * <p>
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * <p>
 * Example 3:
 * <p>
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * <p>
 * Example 4:
 * <p>
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * <p>
 * Input: 1000000
 * Output: "One Million"
 * <p>
 * Input: 10000
 * Output: "Ten Thousand"
 */
public class IntegerToEnglishWords {
    public static void main(String[] args) {
        System.out.println(numberToWords(1000000));
    }

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuffer sb = new StringBuffer();
        for (int i = 1; num > 0; i++) {
            int threeDigits = num % 1000;
            num = num / 1000;
            StringBuffer tempsb = convertToLetter(threeDigits);
            if (i == 1) sb.insert(0, tempsb);
            if (i == 2 && tempsb.length() != 0) sb.insert(0, tempsb + "Thousand ");
            if (i == 3 && tempsb.length() != 0) sb.insert(0, tempsb + "Million ");
            if (i == 4 && tempsb.length() != 0) sb.insert(0, tempsb + "Billion ");
        }
        return sb.toString();
    }

    public static StringBuffer convertToLetter(int value) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; value > 0; i++) {
            int lastPlaceValue = value % 10;
            value = value / 10;
            int secondLastPlaceVaue = value % 10;

            if (i == 1) {
                if (secondLastPlaceVaue == 1) {
                    stringBuffer.insert(0, secondPlaceOneLetterMap.get(lastPlaceValue) + " ");
                    value = value / 10;
                    i++;
                } else if (noLetterMap.get(lastPlaceValue) != null)
                    stringBuffer.insert(0, noLetterMap.get(lastPlaceValue) + " ");
            } else if (i == 2 && secondPlaceLetterMap.get(lastPlaceValue) != null)
                stringBuffer.insert(0, secondPlaceLetterMap.get(lastPlaceValue) + " ");
            else if (i == 3 && noLetterMap.get(lastPlaceValue) != null)
                stringBuffer.insert(0, noLetterMap.get(lastPlaceValue) + " Hundred ");

        }
        return stringBuffer;
    }

    static Map<Integer, String> noLetterMap = new HashMap<>();
    static Map<Integer, String> secondPlaceLetterMap = new HashMap<>();
    static Map<Integer, String> secondPlaceOneLetterMap = new HashMap<>();

    static {
//        noLetterMap.put(0, "Zero");
        noLetterMap.put(1, "One");
        noLetterMap.put(2, "Two");
        noLetterMap.put(3, "Three");
        noLetterMap.put(4, "Four");
        noLetterMap.put(5, "Five");
        noLetterMap.put(6, "Six");
        noLetterMap.put(7, "Seven");
        noLetterMap.put(8, "Eight");
        noLetterMap.put(9, "Nine");

        secondPlaceLetterMap.put(2, "Twenty");
        secondPlaceLetterMap.put(3, "Thirty");
        secondPlaceLetterMap.put(4, "Forty");
        secondPlaceLetterMap.put(5, "Fifty");
        secondPlaceLetterMap.put(6, "Sixty");
        secondPlaceLetterMap.put(7, "Seventy");
        secondPlaceLetterMap.put(8, "Eighty");
        secondPlaceLetterMap.put(9, "Ninety");

        secondPlaceOneLetterMap.put(0, "Ten");
        secondPlaceOneLetterMap.put(1, "Eleven");
        secondPlaceOneLetterMap.put(2, "Twelve");
        secondPlaceOneLetterMap.put(3, "Thirteen");
        secondPlaceOneLetterMap.put(4, "Fourteen");
        secondPlaceOneLetterMap.put(5, "Fifteen");
        secondPlaceOneLetterMap.put(6, "Sixteen");
        secondPlaceOneLetterMap.put(7, "Seventeen");
        secondPlaceOneLetterMap.put(8, "Eighteen");
        secondPlaceOneLetterMap.put(9, "Nineteen");

    }

}
