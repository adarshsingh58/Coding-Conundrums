package com.DataStructures_And_Questions.array;

/**
 * An element in a sorted array can be found in O(log n) time via binary search.
 * But suppose we rotate an ascending order sorted array at some pivot unknown
 * to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise
 * a way to find an element in the rotated array in O(log n) time.
 * <p>
 * Input : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}; key = 3 Output : Found at index
 * 8
 * <p>
 * Input : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}; key = 30 Output : Not found
 * <p>
 * Input : arr[] = {30, 40, 50, 10, 20} key = 10 Output : Found at index 3
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * @author Adarshs
 */
public class ArraySearchRotated {

    public static void main(String[] args) {
        ArraySearchRotated arraySearch = new ArraySearchRotated();
        int inputArr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int indexFoundAt = arraySearch.method1(inputArr, 1);
        System.out.println(indexFoundAt);

    }

    /**
     * @Pseudo > Find pivot element. Put var pivot=pivotElement-1; > For First
     * Iteration: Y= pivot and X=a[0]; For other iteration: Y=(endOfArr
     * - startOfArr)/2 and X=Y; > If (numberToFind == arr[X]) else
     * If(numberToFind < arr[X]) BinarySearch(arr, pivot+1, n-1) else
     * BinaySearch(arr, 0 , pivot)
     */
    public int method1(int[] inputArr, int numberToSearch) {
        int pivot = Helper.findPivot(inputArr);
        int x, y;
        y = pivot;
        x = inputArr[0];

        if (pivot == -1) {
            System.out.println("No Pivot found, array not rotated");
        } else {
            if (numberToSearch == inputArr[x]) {
                return x;
            } else if (numberToSearch < x) {
                return binarySearch(inputArr, pivot + 1, inputArr.length - 1, numberToSearch);
            } else {
                return binarySearch(inputArr, 0, pivot, numberToSearch);
            }

        }
        return -1;
    }

    /**
     * Binary Search
     *
     * @param inputArr
     * @param start
     * @param end
     * @param numberToSearch
     * @return
     */
    public int binarySearch(int[] inputArr, int start, int end, int numberToSearch) {
        if (start <= end && end < inputArr.length) {
            int x = (start + end) / 2;
            if (numberToSearch == inputArr[x]) {
                return x;
            } else if (numberToSearch < x) {
                return binarySearch(inputArr, start, x - 1, numberToSearch);
            } else {
                return binarySearch(inputArr, x + 1, end, numberToSearch);
            }
        }
        return -1;
    }


}
