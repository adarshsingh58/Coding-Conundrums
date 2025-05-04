package com.DataStructures_And_Questions.OtherPrograms;

/**
 * Given a number n=1532, reverse it. O/P = 2351
 */
public class ReversingANumber {

    public static void main(String[] args) {
        int n = 5436;
        n = reverseNumber(n);
        System.out.println(n);
    }

    private static int reverseNumber(int n) {
        int x = 0;
        while (n > 0) {
            x = 10 * x + n % 10;
            n = n / 10;
        }
        return x;
    }

}
