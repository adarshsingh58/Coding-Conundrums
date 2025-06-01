package com.pattern.questions.CommonLogicalProblems_NotDataStructureDependent.KSomething;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result
 * should also be sorted in ascending order.
 * <p>
 * An integer a is closer to x than an integer b if:
 * <p>
 * |a - x| < |b - x|, or |a - x| == |b - x| and a < b
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * <p>
 * Output: [1,2,3,4]
 * <p>
 * Example 2:
 * <p>
 * Input: arr = [1,1,2,3,4,5], k = 4, x = -1
 * <p>
 * Output: [1,1,2,3]
 * <p>
 * <p>
 * https://leetcode.com/problems/find-k-closest-elements/description/
 */
public class FindKClosest {

    public static void main(String[] args) {
        List<int[]> inpList = new ArrayList<>();

//      inpList.add(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8});
        inpList.add(new int[]{1, 10, 15, 25, 35, 45, 50, 59});

        inpList.forEach(inp -> System.out.println(new FindKClosest().findClosestElements(inp, 1, 30)));

    }


    public int binSearch(int[] arr, int x) {
        int s = 0, e = arr.length - 1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (arr[mid] < x) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        // Now s == e
        // Return index of element closest to x
        if (s > 0 && Math.abs(arr[s - 1] - x) <= Math.abs(arr[s] - x)) {
            return s - 1;
        }
        return s;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> op = new ArrayList<>();

        int curr = binSearch(arr, x); // find closest index to x
        int i = curr - 1, j = curr;

        while (op.size() < k) {
            if (i >= 0 && j < arr.length) {
                if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
                    op.add(arr[i--]);
                } else {
                    op.add(arr[j++]);
                }
            } else if (i >= 0) {
                op.add(arr[i--]);
            } else {
                op.add(arr[j++]);
            }
        }

        Collections.sort(op);
        return op;
    }
}
