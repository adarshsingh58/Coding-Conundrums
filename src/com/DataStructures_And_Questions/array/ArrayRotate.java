package com.DataStructures_And_Questions.array;

/**
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adarshs
 */
public class ArrayRotate {


    public static void main(String[] args) {

        List<int[]> inp = new ArrayList<>();
        inp.add(new int[]{1, 2, 3, 4, 5, 6, 7});
        inp.add(new int[]{5, 10, 20, 40});
        inp.add(new int[]{10, 4, 2, 4, 1});
        inp.add(new int[]{30, 10, 10, 5});
        inp.add(new int[]{});

        inp.forEach(i -> {
            System.out.print("output -> ");
            int[] op =  new ArrayRotate().rotateMethod3(i, 2);
            Helper.printArray(op);
        });

    }

    /**
     * @Pseudo If    n = total number of elements
     * i = index
     * d = rotating value
     * then, new index of data at i
     * (i-d), when i-d >= 0
     * (i-d+n), when i-d < 0
     * @Analysis One extra array outputArr of same size as input arr is used hence, space complexity becomes O(n)
     * Since each of the number in the arr is traversed one time, the worst time complexity becomes O(n), {excluding printing of elements}
     */
    public int[] rotateMethod1(int[] inputArr, int d) {
        int n = inputArr.length;
        int[] outputArr = new int[inputArr.length];
        for (int i = 0; i < n; i++) {
            if (i - d >= 0) {
                outputArr[i - d] = inputArr[i];
            } else {
                outputArr[i - d + n] = inputArr[i];
            }
        }

        Helper.printArray(outputArr);
        return outputArr;
    }

    /**
     * @Pseudo For an array of length n, index i and shift parameter d,
     * outputArr = [inputArr from index d to n-1] APPEND [inputArr from index 0 to d-1]
     * Basically we are cutting the index[0 to d-1] and appending at the end of array to get the rotated array
     * @Analysis Again, using extra array of same size n, therefore space complexity is O(n)
     * First for loop runs (d) to (n-1) times and second runs (0) to (d-1), hence 0 to n-1 in total.
     * Therefore time complexity is O(n)
     */
    public void rotateMethod2(int[] inputArr, int d) {
        int[] outputArr = new int[inputArr.length];
        int n = inputArr.length;
        for (int i = d, j = 0; i < n; i++, j++) {
            outputArr[j] = inputArr[i];
        }
        for (int i = 0, j = n - d; i < d; i++, j++) {
            outputArr[j] = inputArr[i];
        }

        Helper.printArray(outputArr);
    }

    /**
     * REVERSAL ALGORITHM FOR ARRAY ROTATION
     *
     * @Pseudo Array arr of size n, indexed elements represented as i and shifting element as d
     * >rotate arr[0] to arr[d-1]
     * >rotate arr[d] to arr[n-1]
     * >rotate arr[0] to arr[n-1]
     * @Analysis
     */
    public int[] rotateMethod3(int[] inputArr, int d) {
        rotateFullArray(inputArr, 0, d - 1);
        rotateFullArray(inputArr, d, inputArr.length - 1);
        rotateFullArray(inputArr, 0, inputArr.length - 1);

        return inputArr;
    }

    /**
     * This method will rotate the entire array, essentially REVERSING it
     *
     * @param inputArr
     * @param start
     * @param end
     */
    private void rotateFullArray(int[] inputArr, int start, int end) {
        while (start < end) {
            int temp = inputArr[start];
            inputArr[start] = inputArr[end];
            inputArr[end] = temp;
            end--;
            start++;

        }
    }


}
