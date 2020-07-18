package com.questions.array.conundrums.rotation;

/**
 * Find the minimum element in a sorted and rotated array
 * <p>
 * A sorted array is rotated at some unknown point, find the minimum element in
 * it.
 * <p>
 * Following solution assumes that all elements are distinct.
 * <p>
 * Examples
 * <p>
 * Input: {5, 6, 1, 2, 3, 4} Output: 1
 * <p>
 * Input: {1, 2, 3, 4} Output: 1
 * <p>
 * Input: {2, 1} Output: 1
 */
public class MinElementSortedRotated {

    public static void main(String[] i) {
        int[] inputArr = {2, 3, 1};
        MinElementSortedRotated elementSortedRotated = new MinElementSortedRotated();
        System.out.println(elementSortedRotated.method1(inputArr));
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
    public int method1(int[] inputArr) {
        int start = 0, end = inputArr.length - 1;
        int min = inputArr[0];
        int currIndex = (start + end) / 2;

        while (start < end) {
            if (start == end) return inputArr[end];
            if (start == end - 1) return Math.min(inputArr[start], inputArr[end]);
            if (inputArr[start] < inputArr[end]) {
                return inputArr[start];
            }
            if (inputArr[currIndex] > inputArr[start] && inputArr[currIndex] > inputArr[end]) {
                start = currIndex;
                currIndex = (start + end) / 2;
            } else if (inputArr[currIndex] < inputArr[start]) {
                end = currIndex;
                currIndex = (start + end) / 2;
            }
        }
        return min;
    }

    /*
     * Same method can be use for Question: Find the Rotation Count in Rotated Sorted array
     */
}
