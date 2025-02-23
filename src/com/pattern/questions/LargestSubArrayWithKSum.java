package com.pattern.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Sub-Array with Sum K
 * Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray
 * where the sum of its elements is equal to the given value k. It is guaranteed that a valid subarray exists.
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = [10, 5, 2, 7, 1, 9], k = 15
 * Output: 4
 * Explanation: The subarray [5, 2, 7, 1] has a sum of 15 and length 4.
 * <p>
 * Input: arr[] = [-1, 2, -3], k = -2
 * Output: 3
 * Explanation: The subarray [-1, 2, -3] has a sum of -2 and length 3.
 * <p>
 * Input: arr[] = [1, -1, 5, -2, 3], k = 3
 * Output: 4
 * Explanation: The subarray [1, -1, 5, -2] has a sum of 3 and a length 4.
 * <p>
 * Constraints:
 * 1 ≤ arr.size() ≤ 106
 * -109 ≤ arr[i], k ≤ 109
 * <p>
 * <p>
 * LINK: https://www.geeksforgeeks.org/longest-sub-array-sum-k/
 */
public class LargestSubArrayWithKSum {

    /*
     * Since we need sub array, we CANNOT SORT the array, since the elements that will form sum K will be from sorted subarray
     * and not original sub array
     * */
    public static void main(String[] args) {


    }

    /*  Using Hash Map and Prefix Sum – O(n) Time and O(n) Space
        If you take a closer look at this problem, this is mainly an extension of Longest Subarray with 0 sum.
        The idea is base on the fact that if Sj – Si = k (where Si and Sj are prefix sums till index i and j respectively, and i < j),
        then the subarray between i+1 to j has k sum. For example, [5, 2, -3, 4, 7] and k = 3. The value of S3 – S0 = 3,
        it means the subarray from index 1 to 3 has sum equals to 3. So we mainly compute prefix sums in the array and store these prefix
        sums in a hash table. And check if current prefix sum – k is already present.

        Below are the main points to consider in your implementation.

        If we have the whole prefix having sum equal to k, we should prefer it as it would be the longest possible so till that pointe.
        For example, [1, -2, 1, 0, 4, 3] and k = 0, the prefix, [1, -2, 1, 0] has sum k.
        If there are multiple occurrences of a prefixSum, we must store index of the earliest prefixSum in our hash map because we need to find the
        longest subarray. For example, [5, -10, 5, 2, 3, 20] and k = 20, we have prefix sum 5 at index 0 and 4 we need to store index 0 in hash map,
        because when we come to index 5, we search for current prefix sum – k in map, the current prefix sum is 25, we find 25 – 20 = 5 at map gives us
        0 and hence we get the longest subarray from 1 to 5.
        */
    private int findLongestLength(int[] arr,int k) {

        Map<Integer, Integer> mp = new HashMap();
        int resultLength = 0;
        int prefixSumTilli = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSumTilli = prefixSumTilli + arr[i];
            if(prefixSumTilli==k){
                resultLength=i+1;
            }
            if(mp.containsKey(prefixSumTilli-k)){
                resultLength = Math.max(resultLength, mp.get(prefixSumTilli - k) - i);
            }
            if(!mp.containsKey(prefixSumTilli)){
                mp.put(prefixSumTilli,i);
            }
        }
        return resultLength;
    }
}
