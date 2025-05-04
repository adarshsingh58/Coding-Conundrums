package com.pattern.questions.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any
 * order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1 Output: [1]
 * <p>
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequentElements {


    public static void main(String[] args) {
        int[] inp = {1, 1, 1, 2, 2, 3};
        new TopKFrequentElements().topKFrequent(inp, 2);
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((v1, v2) -> {
            return v2.getValue() - v1.getValue();
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        for (Map.Entry<Integer, Integer> es : map.entrySet()) {
            pq.add(es);
        }

        int[] op = new int[k];
        for (int i = 0; i < k; i++)
            op[i] = pq.poll().getKey();

        return op;

    }
}
