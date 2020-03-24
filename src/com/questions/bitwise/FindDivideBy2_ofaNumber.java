package com.questions.bitwise;

/**
 * Given a number n, find n/2 without using /
 * eg: n=6; output=3
 */
public class FindDivideBy2_ofaNumber {

    public static void main(String[] args) {
        int n = 10;
        int output = divideBy2(n);
        System.out.println(output);
    }

    /**
     * We utilize right shift operator here.
     * When doing a right shift by 1, on a number n
     * we get n/2.
     * Remember this will give you int result and not decimal
     */
    private static int divideBy2(int n) {
        return n >> 1;
    }
}
