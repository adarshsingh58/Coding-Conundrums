package com.questions.math;

/**
 * Given an array of positive numbers from 1 to n, such that all numbers from 1
 * to n are present except one. Find the missing number.
 */
public class FindMissingNumber {
    public static void main(String[] args) {
        int[] inputArr = new int[]{5, 2, 9, 7, 4, 3, 6, 1};
        int size = inputArr.length + 1;
        int missingNumber = findMissingNumber(inputArr, size);
        System.out.println(missingNumber);
    }

    /**
     * A simple mathematical formulae can be used here.
     * Sum of all number from 1 to n is (n(n+1))/2.
     * And in our problem array contains all numbers from 1 to n except for 1 missing number.
     * >we calculate sum of all number from 1 to size, where size is inputArr.length+1, because of the missing number.
     * >we calculate sum of inputArr.
     * >we return totalSumOfAllNumber-SumOfCurrentArray
     */
    private static int findMissingNumber(int[] inputArr, int size) {
        int totalActualSum = (size * (size + 1)) / 2;
        int currentSum = 0;
        for (int digit : inputArr) {
            currentSum = currentSum + digit;
        }
        return totalActualSum - currentSum;
    }
}
