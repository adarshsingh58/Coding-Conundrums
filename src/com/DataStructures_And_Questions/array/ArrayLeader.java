package com.DataStructures_And_Questions.array;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an array arr of positive integers. Your task is to find all the leaders in the array.
 * An element is considered a leader if it is greater than or equal to all elements to its right.
 * The rightmost element is always a leader.
 *
 * Examples:
 *
 * Input: arr = [16, 17, 4, 3, 5, 2]
 * Output: [17, 5, 2]
 * Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.
 *
 * Input: arr = [10, 4, 2, 4, 1]
 * Output: [10, 4, 4, 1]
 * Explanation: Note that both of the 4s are in output, as to be a leader an equal element is also allowed on the right. side
 *
 * Input: arr = [5, 10, 20, 40]
 * Output: [40]
 * Explanation: When an array is sorted in increasing order, only the rightmost element is leader.
 *
 * Input: arr = [30, 10, 10, 5]
 * Output: [30, 10, 10, 5]
 * Explanation: When an array is sorted in non-increasing order, all elements are leaders.
 *
 * Constraints:
 * 1 <= arr.size() <= 106
 * 0 <= arr[i] <= 106
 *
 *
 * https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=leaders-in-an-array
 *
 * */
public class ArrayLeader {

    public static void main(String[] args) {
        List<int[]> inp = new ArrayList<>();
        inp.add(new int[]{16, 17, 4, 3, 5, 2});
        inp.add(new int[]{5, 10, 20, 40});
        inp.add(new int[]{10, 4, 2, 4, 1});
        inp.add(new int[]{30, 10, 10, 5});
        inp.add(new int[]{});

        inp.forEach(i -> {
            System.out.print("output -> ");
            ArrayList<Integer> op = leaders_attempt(i);
            op.forEach(o -> {
                System.out.print(o + " ");
            });
            System.out.println();
        });
    }

    /*
     * The idea is to start from the last index and keep a var curr_largest initialized to MIN.
     * we check of currValue is >= curr_largest, of so we have the largest number from rightMost side.
     * so we update curr_largest to currValue and add currValue to output list as well.
     *
     * Continue until we reach start of Array.
     *
     * Time Comp: O(n)
     * Space Comp: O(1)
     * */
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> op = new ArrayList<>();
        int curr_largest = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i > -1; i--) {
            if (arr[i] >= curr_largest) {
                op.add(arr[i]);
                curr_largest = arr[i];
            }
        }
        return op;
    }


    static ArrayList<Integer> leaders_attempt(int[] arr) {
        return null;
    }
}
