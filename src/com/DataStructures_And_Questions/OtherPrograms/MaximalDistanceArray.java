package com.DataStructures_And_Questions.OtherPrograms;

/**
 * Given an array arr[], find the maximum (arr[j] - arr[i]) such that arr[j] > arr[i] and j>i.
 * If no max exist return -1.
 * <p>
 * Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
 * Output: 78  (80-2)
 * <p>
 * Input:{5,4,3,2,1}
 * Output: -1
 */
public class MaximalDistanceArray {
    public static void main(String[] args) {
        int[] inputArr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
//		int mDis=findMaximalDis_naive(inputArr);
        int mDis = findMaximalDis_recursion(inputArr);
        System.out.println(mDis);
    }

    private static int findMaximalDis_recursion(int[] inputArr) {

        return 0;
    }

    /**
     * @TimeComplexity O(n ^ 2)
     */
    private static int findMaximalDis_naive(int[] inputArr) {
        int max = -1;
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = i + 1; j < inputArr.length; j++) {
                if (inputArr[j] - inputArr[i] > max) {
                    max = inputArr[j] - inputArr[i];
                }
            }
        }
        return max;
    }
}
