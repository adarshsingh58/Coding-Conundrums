package com.questions.scenarioBasedQues;

import java.util.HashMap;

/*
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:

Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:

Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.


Input : 0,1,1,0,1,1,1,0
output : 4
 */
public class ContiguousArrayOf1And0 {
    /*public static void main(String[] args) {

        int[] inputArr = new int[]{0,1,1,0,1,1,1,0};
        int length = findMaxLength(inputArr);
        System.out.println(length);
    }*/

    private static int findMaxLength(int[] inputArr) {
        int onesCount = 0;
        int zerosCount = 0;

        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == 0) zerosCount++;
            else if (inputArr[i] == 1) onesCount++;
            else System.out.println("wrong input " + inputArr[i]);
        }
        if (onesCount < zerosCount) {
            return onesCount * 2;
        } else {
            return zerosCount * 2;
        }
    }

    static int maxLen(int arr[], int n)
    {
        // Creates an empty hashMap hM

        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        int sum = 0; // Initialize sum of elements
        int max_len = 0; // Initialize result
        int ending_index = -1;
        int start_index = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }

        // Traverse through the given array

        for (int i = 0; i < n; i++) {
            // Add current element to sum

            sum += arr[i];

            // To handle sum=0 at last index

            if (sum == 0) {
                max_len = i + 1;
                ending_index = i;
            }

            // If this sum is seen before, then update max_len
            // if required

            if (hM.containsKey(sum + n)) {
                if (max_len < i - hM.get(sum + n)) {
                    max_len = i - hM.get(sum + n);
                    ending_index = i;
                }
            }
            else // Else put this sum in hash table
                hM.put(sum + n, i);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == -1) ? 0 : 1;
        }

        int end = ending_index - max_len + 1;
        System.out.println(end + " to " + ending_index);

        return max_len;
    }

    /* Driver program to test the above functions */

    public static void main(String[] args)
    {
        int arr[] = { 0,1,1,0,1,1,1,0 };
        int n = arr.length;

        System.out.println(maxLen(arr, n));
    }
}
