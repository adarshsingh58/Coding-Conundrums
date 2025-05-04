package com.DataStructures_And_Questions.array;

/**
 * Given a sorted array of integers, return the low and high index of the given
 * key. Return -1 if not found. The array length can be in millions with lots of
 * duplicates.
 * e.g.
 * inputArr: 1,2,5,5,5,5,5,5,5,5,20
 * key: 5
 * o/p: low index-> 2 high index -> 9
 * key: 20
 * o/p: low index-> 10 high index -> 10
 */
public class FindLowHighIndex {

    public static void main(String[] args) {
        int[] inputArr = new int[]{1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 20};
        String indexes1 = findLowHighIndex(inputArr, 5);
        System.out.println("low index: " + indexes1.split(",")[0] + "\nhigh index:" + indexes1.split(",")[1]);

        String indexes2 = findLowHighIndex(inputArr, 20);
        System.out.println("low index: " + indexes2.split(",")[0] + "\nhigh index:" + indexes2.split(",")[1]);

        String indexes3 = findLowHighIndex(inputArr, 1);
        System.out.println("low index: " + indexes3.split(",")[0] + "\nhigh index:" + indexes3.split(",")[1]);
    }

    /*
     * Since the arr is sorted, we can leverage Binary Search to find the occurence of number.
     * There may be duplicates but the numbers are still sorted so binary search will work.
     *
     * Once we have any occurrence of the key, we can use 2 pointers to move left and right from it to find
     * the low and high point.
     * */
    private static String findLowHighIndex(int[] inputArr, int key) {
        int start = 0, end = inputArr.length - 1;
        int findKeyIndex = binarySearch(inputArr, start, end, key);

        int i = findKeyIndex, j = findKeyIndex;
        while ( (i>0 && inputArr[i] == key) || (j<inputArr.length && inputArr[j] == key)) {// we need these edge index check to take care of last index finds.
            if (inputArr[i] == key)
                i--;
            if (inputArr[j] == key )
                j++;
        }

        return ++i + "," + --j;
    }

    private static int binarySearch(int[] inputArr, int start, int end, int key) {
        while (start <= end) {//Mistake 1: not doing <=. If we just do <, then at last standing index where key is found, we will never reach.
            int midIndex = (start + end) / 2;

            if (inputArr[midIndex] == key)
                return midIndex;

            if (key < inputArr[midIndex])
                end = midIndex - 1;
            else
                start = midIndex + 1;
        }
        return -1;
    }

}
