package com.questions.bitwise;

/**
 * Given two signed integers, write a function that returns true if the signs of
 * given integers are different, otherwise false
 * -1 and +100 -> true,
 * -100 and -200 -> false
 */
public class DetectIfTwoIntegersHaveOppositeSigns {
    public static void main(String[] args) {
        boolean x = areDiffSignedIntegers(10, -80);
        System.out.println(x);
    }

    /**
     * We utilize the XOR operator here. If we XOR 1 and 0, o/p will be 1 and will
     * always be 0 for 1 XOR 1 and 0 XOR 0.
     * <p>
     * Let the given integers be x and y. The sign bit is 1 in negative numbers, and
     * 0 in positive numbers. The XOR of x and y will have the sign bit as 1 iff
     * they have opposite sign. In other words, XOR of x and y will be negative
     * number number iff x and y have opposite signs.
     */
    private static boolean areDiffSignedIntegers(int i, int j) {
        if ((i ^ j) > 0)
            return false;
        else
            return true;
    }
}
