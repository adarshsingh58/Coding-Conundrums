package com.questions.array.conundrums;

import com.questions.array.utilites.Helper;

/**
 * Given an integer array, move all elements containing '0' to the left while
 * maintaining the order of other elements in the array.
 * e.g.
 * inputArr= 10, 20, 0, 59, 63, 0, 88, 0
 * O/P = 0, 0, 0, 10, 20, 59, 63, 88
 */
public class MoveZerosToLeft {

    public static void main(String[] args) {
//		int[] inputArr= new int[]{10, 20, 0, 59, 63, 0, 88, 0};
        int[] inputArr = new int[]{10, 20, 0, 59, 63, 0, 85, 5};
        inputArr = shiftZeros(inputArr);
        Helper.printArray(inputArr);
    }

    /**
     * We will use 2 pointers here, read i and write j.
     * The idea is that we will read the data at i and if it is not 0 we will replace it with data at j.
     * And data at j will be 0, coz j will stop decrementing if data at i is 0.
     * This ensures that actual logic starts when j points to zero for the first time, untill then
     * j and i will decrement together.
     * And when j and i encounter their first 0, j will stop decrement but i will and eventually
     * when i encounters a non zero element this will swapped with 0.
     * <p>
     * The reason we cannot simply sort it is because we need the order of number as they were before.
     *
     * @TimeComplexity O(n)
     * @SpaceComplexity O(1)
     */
    private static int[] shiftZeros(int[] inputArr) {

        int i = inputArr.length - 1;// read pointer
        int j = inputArr.length - 1; // write pointer
        while (i >= 0 && j >= 0) {
            if (inputArr[i] != 0) {
                int temp = inputArr[i];
                inputArr[i] = inputArr[j];
                inputArr[j] = temp;
                i--;
                j--;
            } else {
                i--;
            }
        }

        return inputArr;
    }
}
