package com.DataStructures_And_Questions.sorting;

import java.util.Scanner;

/*
 * Quick sort is one of the most efficient sorting algo. It's worst time complexity is O(n^2) but its average time complexity come upto be O(log n).
 * And with the analysis of the algo, it can be deduced that the algo has a high probability of completing the task in average time complexity in real
 * time scenarios. Hence, is highly efficient.
 *
 * Also, its space complexity is O(1) as it utilizes the input array by sorting various sections based on index.
 *
 * It is based on divide and conquer approach. Following are the steps:
 * Sorting Data
 * {
 *  Base case/ Breaking condition => when start index is greater or equal to end index of the array to sort
 *  1 > Partition
 *  2 > Sorting Left set of data in partition set
 *  3 > Sorting Right set of data in partition set
 * }
 *
 */

public class QuickSort {

    public static void main(String[] args) {

        System.out.println("Enter 10 elemnts");
        Scanner sc = new Scanner(System.in);
        int[] arrayToSort = new int[10];
        for (int i = 0; i < 10; i++) {
            arrayToSort[i] = sc.nextInt();
        }
        arrayToSort = quickSort(0, arrayToSort.length - 1, arrayToSort);

        for (int data : arrayToSort) {
            System.out.println(data);
        }
    }

    /*
     * This method follow divide and conquer approach by
     *  1> dividing/partitioning the arrayToSort in to parts ,ONE having values greater than or equal to pivot and SECOND having values less than
     *      pivot
     *  2> the index at which this partition happens is called the partitioning index. Sub array to left of this index is array ONE and
     *      Sub array at right of this index is SECOND array.
     *  3> Now these sub arrays are again recursively solved reapeating from step 1.
     *
     *  Breaking/Base condition : The partitioning stops when the array is a single element array i.e. startIndex >= endIndex
     *
     */
    private static int[] quickSort(int startIndex, int endIndex, int[] arrayToSort) {
        if (startIndex < endIndex && endIndex < arrayToSort.length) {
            int partitionIndex = partition(startIndex, endIndex, arrayToSort);
            quickSort(startIndex, partitionIndex - 1, arrayToSort);
            quickSort(partitionIndex + 1, endIndex, arrayToSort);
        }
        return arrayToSort;
    }

    /*
     * Goal -> At all point all the values at left of the partitionIndex must be smaller than the pivot
     * Partition Index -> is the index which will, through out this method, will track where to place the element smaller than pivot
     *
     * We have 3 things here :
     * 1.Pivot - This is the one of the data we picked as a base value from the given array to compare all the value against.
     *           All other values inside the given arrayToSort will be compared against this pivot data and then positioned accordingly.
     *           In this algo, we have selected last element as the pivot, but there can many other ways to decide upon a pivot.
     *
     * 2.Partition Index -  This is an index in the array, initialized to startIndex of the arrayToSort. The role of this index is to make sure
     *                      that values smaller than the pivot are places on left of this Partition Index and those greater are placed on right
     *                      of Partition Index or On Partition Index itself. The value at & on right of Partition Index will always be greater than
     *                      value on left of partition index.
     * 3.startIndex and endIndex - This will be the starting index and ending index of the arrayToSort.
     *
     *
     * Purpose of Partitioning: The purpose of this method is that it determines a Pivot and then compares all the values in the arrayToSort
     *                  with the Pivot and partition them in left and right position of a partition index.
     *                  IN A SUCCESSFUL PARTITIONED ARRAY THE ELEMENTS, THE ELMENTS SMALLER THAN PIVOT SHOULD BE ON LEFT OF "PIVOT" AND
     *                  THE EKEMENTS GREATER THAN OR EQUAL TO PIVOT SHOULD BE ON LEFT OF THE "PIVOT".
     *                  And after that it also swaps the pivot data with the data at partitioning Index, because
     *                  * the comparision is done wrt to pivot data i.e. elements smaller then pivot are on left of partiotining index and those
     *                    greater are on right of partitioning Index.
     *                  * but for a successfull partition, elements smaller then pivot should be on left of "pivot" and those
     *                    greater should be on right of "pivot".
     *                  * and because element at partitioning Index is always greater than or equal to pivot, we can swap the pivot and data at
     *                    partitioning Index and the partition will still hold valid and successfull i.e. greater element than pivot will be
     *                    on right of pivot.
     *
     *
     */
    private static int partition(int startIndex, int endIndex, int[] arrayToSort) {
        int pivotData = arrayToSort[endIndex];// selecting pivot as last element on array
        int partitionIndex = startIndex;// selecting partition index as first index of array

        /* CORE LOGIC*/
        for (int i = startIndex; i <= endIndex; i++) {
            if (arrayToSort[i] < pivotData) {
                arrayToSort = swap(i, partitionIndex, arrayToSort);
                partitionIndex++;
            }
        }

        //swapping the pivot data and data at partitionIndex at last to make successful partition.
        arrayToSort = swap(partitionIndex, endIndex, arrayToSort);
        return partitionIndex;
    }

    private static int[] swap(int i, int partitionIndex, int[] arrayToSort) {
        if (i < arrayToSort.length && partitionIndex < arrayToSort.length) {
            int temp = arrayToSort[i];
            arrayToSort[i] = arrayToSort[partitionIndex];
            arrayToSort[partitionIndex] = temp;
        }
        return arrayToSort;
    }


}
