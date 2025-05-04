package com.pattern.questions.TopKElements;

import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * <p>
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Can you solve it without sorting?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,1,5,6,4], k = 2 Output: 5
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4 Output: 4
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class KthLargestElementinanArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:nums){
            pq.add(num);
        }
        for(int i=0;i<(nums.length-k);i++){
            pq.poll();
        }
        return pq.poll();
    }
}
