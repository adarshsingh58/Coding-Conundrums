package com.questions.bitwise;

/**
 * Check if two numbers are equal without using arithmetic and comparison
 * operators
 */
public class If2NumberEqual {
    public static void main(String[] args) {
        int i = 100;
        int j = 100;
        boolean areEqual = areEqual(i, j);
        System.out.println(areEqual);
    }

    /**
     * XOR of same numbers is always 0.
     * We simple XOR the integers and see if result is 0.
     * If yes, return true else false;
     */
    private static boolean areEqual(int i, int j) {
        if ((i ^ j) == 0)
            return true;
        else
            return false;
    }
}
