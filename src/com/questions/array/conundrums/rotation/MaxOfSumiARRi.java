package com.questions.array.conundrums.rotation;

/**
 * https://www.geeksforgeeks.org/maximum-sum-iarri-among-rotations-given-array/
 * <p>
 * Find maximum value of Sum( i*arr[i]) with only rotations on given array
 * allowed Given an array, only rotation operation is allowed on array. We can
 * rotate the array as many times as we want. Return the maximum possbile of
 * summation of i*arr[i].
 * <p>
 * Example:
 * <p>
 * Input: arr[] = {1, 20, 2, 10} Output: 72 We can 72 by rotating array twice.
 * {2, 10, 1, 20}
 * 20*3 + 1*2 + 10*1 + 2*0 = 72
 * <p>
 * Input: arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9}; Output: 330
 * We can 330 by * rotating array 9 times. {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 0*1 + 1*2 + 2*3 ...
 * 9*10 = 330
 */
public class MaxOfSumiARRi {

    public static void main(String[] args) {
        int[] arr = {1, 20, 2, 10};
        MaxOfSumiARRi arRi = new MaxOfSumiARRi();
        arRi.findSum(arr);
    }

    /**
     * @param inputArr
     * @return
     */
    private int findSum(int[] inputArr) {
        int maxSum = 0;
        int temp = 0;

        return 0;
    }
}
