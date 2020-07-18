package com.questions.array.conundrums.rotation;

/**
 * uppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * The array may contain duplicates.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5]
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: [2,2,2,0,1]
 * Output: 0
 *
 * ip:3, 1, 3
 * ip:1,1,1
 * ip:1
 *
 */
public class MinElementSortedRotatedDuplicateArr {

    public static void main(String[] i) {
        int[] inputArr = {1,3,5};
        MinElementSortedRotatedDuplicateArr elementSortedRotated = new MinElementSortedRotatedDuplicateArr();
        System.out.println(elementSortedRotated.findMin(inputArr));
    }

    /**
     * @Pseudo start = 0 and end = n
     * while start!=end
     * >find currIndex=(start+end)/2.
     * >if(inputArr[currIndex]<inputArr[currIndex-1] && inputArr[currIndex] <inputArr[currIndex+1])
     * print <MIN NUMBER FOUND>
     * >else if(inputArr[currIndex]>inputArr[currIndex-1] && inputArr[currIndex] < inputArr[currIndex+1])
     * start=0 and end = currIndex
     * currIndex=start+currIndex/2;
     * >else if(inputArr[currIndex]>inputArr[currIndex-1] && inputArr[currIndex] > inputArr[currIndex+1])
     * print <MIN NUMBER at inputARR[currIndex+1]>
     * @Analysis Since we are divinding the inputs to work on by 2 evreytime. Timc complexity is O(log n)
     * and space complexity is O(1)
     */
    public int findMin(int[] inputArr) {
        int start = 0, end = inputArr.length - 1;
        int mid = (start + end) / 2;
        if (start == end) return inputArr[end];
        while (start < end) {
            if (start == end - 1) return Math.min(inputArr[start], inputArr[end]);
            if (inputArr[mid] >= inputArr[start] && inputArr[mid] > inputArr[end]) {
                start = mid;
                mid = (start + end) / 2;
            } else if (inputArr[mid] < inputArr[start]) {
                end = mid;
                mid = (start + end) / 2;
            } else if (inputArr[mid] == inputArr[start] && inputArr[mid] < inputArr[end]) {
                return inputArr[mid];
            }
        }
        return 0;
    }
    /*
     * Same method can be use for Question: Find the Rotation Count in Rotated Sorted array
     */
}
