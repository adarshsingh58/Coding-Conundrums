package com.DataStructures_And_Questions.array;

import static com.DataStructures_And_Questions.array.Helper.swap;

/**
 * Given an integer array, move all elements containing '0' to the left while
 * maintaining the order of other elements in the array.
 * e.g.
 * inputArr= 10, 20, 0, 59, 63, 0, 88, 0
 * O/P = 0, 0, 0, 10, 20, 59, 63, 88
 *
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZerosToLeft {

    public static void main(String[] args) {
		int[] inputArr= new int[]{10, 20, 0, 59, 63, 0, 88, 0};
//        int[] inputArr = new int[]{10, 20, 0, 59, 63, 0, 85, 5};
//        inputArr = shiftZeros(inputArr);
        inputArr = attempt(inputArr);
        Helper.printArray(inputArr);
    }

    private static int[] attempt(int[] inputArr) {
        return null;
    }


    /*
     * One idea is to find #ofZeros and create a new array and fill #ofzeros at start.
     * Then traverse the inputArr and append non-zero numbers in the op array.
     * Here time is O(n) but space is also O(n)
     *
     * But we see that
     *
     * "WE HAVE TO WORK ON "2 TYPES" OF VALUES IN ARRAY O AND NON 0. SO IN THESE SITUATIONS WE CAN TRY TWO POINTER APPROACH"
     *
     * To improve this We will use 2 pointers here, read i and write j.
     * The idea is that we will read the data at i and if it is not 0 we will replace it with data at j.
     * And data at j will be 0, coz j will stop decrementing if data at i is 0.
     * This ensures that actual logic starts when j points to zero for the first time, until then
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

    /*
     * We can use sliding window here as well.
     * We start from the end index. If we found a zero, we mark that index as
     * start and end of our sliding window.
     * Now we check is start-1 index is non-zero or not.
     * If So, we swap end of our sliding window with this number and decrement the start and end of window by 1.
     * If Not, we have another 0 and its time to increase the size of our window, so we decrease start but not end of window.
     *
     * continue till sliding window reaches the start.
     *
     * Time: O(n)
     * Space O(1)
     *
     *  */
    private static int[] shiftZeros_SlideWindow(int[] inputArr) {
        int slideWinZeroStart = inputArr.length - 1, slideWinZeroEnd = slideWinZeroStart;
        while (slideWinZeroStart > 0) {
            if (inputArr[slideWinZeroStart] != 0) {
                slideWinZeroStart--;
                slideWinZeroEnd--;
            } else {

                if (slideWinZeroStart > 0) {
                    if (inputArr[slideWinZeroStart - 1] != 0) {
                        swap(inputArr, slideWinZeroStart - 1, slideWinZeroEnd);
                        slideWinZeroStart--;
                        slideWinZeroEnd--;
                    } else {
                        slideWinZeroStart--;
                    }
                }
            }
        }
        return inputArr;
    }
}
