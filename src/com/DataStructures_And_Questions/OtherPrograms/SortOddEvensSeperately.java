package com.DataStructures_And_Questions.OtherPrograms;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given an array of integers (both odd and even), sort them in such a way that the first part of the array contains odd numbers sorted in descending order, rest portion contains even numbers sorted in ascending order.
 * Examples:
 * <p>
 * <p>
 * Input: arr[] = {1, 2, 3, 5, 4, 7, 10}
 * Output: arr[] = {7, 5, 3, 1, 2, 4, 10}
 * <p>
 * Input: arr[] = {0, 4, 5, 3, 7, 2, 1}
 * Output: arr[] = {7, 5, 3, 1, 0, 2, 4}
 */
public class SortOddEvensSeperately {

    public static void main(String[] args) {
        int[] arr = {0, 4, 5, 3, 7, 2, 1};
        int[] op = sortOddEven(arr);
        for (int o : op)
            System.out.print(o);
    }

    /**
     * Method 2 (Using negative multiplication) :
     * <p>
     * Make all odd numbers negative.
     * Sort all numbers.
     * Revert the changes made in step 1 to get original elements back.
     */
    public static int[] sortOddEven(int[] arr) {
        negateOddNumbers(arr);
        Arrays.sort(arr);
        negateOddNumbers(arr);
        return arr;
    }

    private static void negateOddNumbers(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0)
                arr[i] = arr[i] * -1;
        }
    }
}
