package com.DataStructures_And_Questions.scenarioBasedQues;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * Example 1:
 * <p>
 * Input: "A"
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: "AB"
 * Output: 28
 * <p>
 * Example 3:
 * <p>
 * Input: "ZY"
 * Output: 701
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumber(String s) {
        s = s.toUpperCase();
        int col = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            col = col + ((ch[i] - 64) * (int) Math.pow(26, ch.length - 1 - i));
        }
        return col;
    }
}
