package com.questions.array.conundrums.rotation;

import com.questions.array.utilites.Helper;

/**
 * Given a sorted and rotated array, find if there is a pair with a given sum
 *
 * @author Adarshs
 */
public class CombinationOf2WithSumXinSortedRotatedArray {

    public static void main(String[] args) {

        int inputArr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int sumToFind = 8;
        int pivot = Helper.findPivot(inputArr);

        method1(inputArr, sumToFind, pivot);
    }

    /**
     * @param inputArr
     * @param sumToFind
     * @param pivot
     * @Pseudo > Find Pivot
     * > Add arr[pivot] and arr[pivot+1] to check for the expected sum.
     * Idea is that the value at arr[pivot] will be the largest and value at arr[pivot+1] will be the smallest.
     * > If the sum of these two numbers is > the expected sum, then we need to bring the calculated sum down and
     * to do that we will reduce the pivot element or i element to i-1 coz arr[i-1] is the next smallest number after arr[i].
     * >  If the sum of these two numbers is < the expected sum, then we need to bring the calculated sum up. To do that we will
     * increase the pivot+1 element or j element to j+1 as that is the next largest number after arr[j].
     * > when the calculated sum matches the expected we have our answer.
     * @Analysis since we are traversing all the index in worst case scenario which is 19, time complexity is O(n).
     * No extra arrays are created only temp i and j hence space complexity is O(2) -> O(1	)
     */
    private static void method1(int[] inputArr, int sumToFind, int pivot) {
        for (int i = pivot, j = pivot + 1; j != i; ) {
            if (inputArr[i] + inputArr[j] == sumToFind) {
                System.out.println("Numbers found:" + inputArr[i] + " and " + inputArr[j]);
                break;
            } else if (inputArr[i] + inputArr[j] > sumToFind) {
                if (i <= 0)
                    i = inputArr.length - 1;
                else
                    i--;
            } else {
                j++;
                if (j >= inputArr.length) {
                    j = j % inputArr.length;
                }

            }
        }
    }

}
