package com.DataStructures_And_Questions.math;

/**
 * Given a perfect square number, write a function to calculate its square root.
 * Square root of 16 is 4 (4 x 4 = 16).
 */
public class CalculateSquareRoot_PerfectSquares {
    public static void main(String[] args) {
        int number = 100;
        int sqrt = findSqrt(number);
        System.out.println(sqrt);
    }

    private static int findSqrt(int number) {
        int upperLimit = 1 + (number / 2);
        return binarySearch(0, upperLimit, number);
    }

    private static int binarySearch(int lowerLimit, int upperLimit, int number) {
        int mid = (lowerLimit + upperLimit) / 2;
        if (mid * mid == number) {
            return mid;
        } else if (mid * mid < number) {
            return binarySearch(mid + 1, upperLimit, number);
        } else {
            return binarySearch(lowerLimit, mid - 1, number);
        }
    }
}
