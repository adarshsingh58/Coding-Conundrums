package com.questions.scenarioBasedQues;

import java.util.HashMap;
import java.util.Map;

/*
* Given an integer array arr, count element x such that x + 1 is also in arr.

If there're duplicates in arr, count them seperately.



Example 1:

Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.

Example 2:

Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.

Example 3:

Input: arr = [1,3,2,3,5,0]
Output: 3
Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.

Example 4:

Input: arr = [1,1,2,2]
Output: 2
Explanation: Two 1s are counted cause 2 is in arr.

* */
public class CountingElements {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2};
        int n = countElements(arr);
        System.out.println(n);

    }

    private static int countElements(int[] arr) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (numCount.containsKey(arr[i])) {
                numCount.put(arr[i], numCount.get(arr[i]) + 1);
            } else {
                numCount.put(arr[i], 1);
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            if (numCount.containsKey(entry.getKey() + 1)) {
                count = count + entry.getValue();
            }
        }
        return count;
    }


}
