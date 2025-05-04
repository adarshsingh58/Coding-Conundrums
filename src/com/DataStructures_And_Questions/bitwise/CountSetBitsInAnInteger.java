package com.DataStructures_And_Questions.bitwise;

/**
 * Count number of 1s in binary representation of an integer.
 * Input : n = 6
 * Output : 2
 * Binary representation of 6 is 110 and has 2 set bits
 *
 * https://leetcode.com/problems/number-of-1-bits/submissions/1515282894/
 */
public class CountSetBitsInAnInteger {
    public static void main(String[] args) {
        int n = 6;
        int setBits = countSetBits(n);
        System.out.println(setBits);
    }

    /**
     * 2 bitwise operator are used here. & and >>
     * <p>
     * >We check if number n is > 0. binary of 0 is 0000 and 1 is 0001
     * >now we calculate n&1. & is a bitwise AND and this will perform and action on
     * binary representation of n and 1. If n is 6, then it is: 0110 & 0001.
     * Because, we are always doing & with 1, we are eseentially checking of last bit of
     * n is 1 or not. If it is 1, result will be 1 else 0.
     * >We add this o/p to count/
     * >We right shift n by 1, because rightmost bit is now processed to check if it is 1 or 0.
     * Now, 110 after 1 right shift will become 011. We now do 011 & 001 -> 1
     * > repeat this
     */
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count = count + (n & 1);
            n = n >> 1;
        }
        return count;
    }
}
