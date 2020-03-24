package com.questions.bitwise;

/**
 * Given a positive integer, write a function to find if it is a power of two or
 * not.
 * Input : n = 32 Output : Yes
 */
public class NumberPowerOfTwo {
    public static void main(String[] args) {
        int n = 128;
        boolean isPowerOf2 = findIfPowerOf2(n);
        System.out.println(isPowerOf2);
    }

    /**
     * Rule: A number which is power of 2, will always have only
     * 1 set bit in its binary representation.
     * <p>
     * > Find count of set bits in the number n
     * > If it is == 1, then it is a number with power of 2
     */
    private static boolean findIfPowerOf2(int n) {
        int setBits = CountSetBitsInAnInteger.countSetBits(n);
        if (setBits == 1)
            return true;
        else
            return false;
    }
}
