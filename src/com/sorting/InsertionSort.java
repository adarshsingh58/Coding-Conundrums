package com.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] inputArr = new int[]{2, 8, 4, 3, 9, 44, 1, 2, 52, 1};
        inputArr = insertionSort(inputArr);
        for (int a : inputArr) {
            System.out.println(a);
        }
    }

    /**
     * In Insertion sort, we have 2 pointers i and j, unlike in bubble sort where we
     * have one pointer j.
     * In Bubble Sort -> neighbor elements are compared and at
     * end of each iteration i.e. j and j+1. In bubble at end of one outer
     * iteration, the largest number is at the rightmost side.
     * <p>
     * In insertion sort,(where j=i+1), we have two pointer i and j. i remains fixed
     * per iteration while, j compare value at i from rest of the array and a
     * smaller value than value at i is found. swap happens. This process happens
     * for each index i of array.
     * <p>
     * At end of each outer iteration we have smallest number from the right
     * unsorted array to the left side i.e. at index i.
     *
     * @TimeComplexity is O(n2) i.e. quadratic
     * @SpaceComplexity is O(1) as operation performed on same array
     */
    private static int[] insertionSort(int[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = i + 1; j < inputArr.length; j++) {
                if (inputArr[j] < inputArr[i]) {
                    int temp = inputArr[j];
                    inputArr[j] = inputArr[i];
                    inputArr[i] = temp;
                }
            }
        }
        return inputArr;
    }
}
