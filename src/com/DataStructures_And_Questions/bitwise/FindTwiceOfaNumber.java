package com.DataStructures_And_Questions.bitwise;

/**
 * Given a number n, find 2n without using *
 * eg: n=5; output=10
 */
public class FindTwiceOfaNumber {
    public static void main(String[] args) {
        int n = 9;
        int output = findTwice(n);
        System.out.println(output);
    }

    /**
     * We use the left shift operator here.
     * When we left shift any number by 1, that number is multiplied by 2
     */
    private static int findTwice(int n) {
        return n << 1;
    }
}
