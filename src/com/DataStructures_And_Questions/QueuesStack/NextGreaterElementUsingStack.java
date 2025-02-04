package com.DataStructures_And_Questions.QueuesStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Implement a nextGreaterElement() function that takes an array of integers, arr, as input and returns the next greater number for every element in the array.
 * <p>
 * The next greater number for a number arr[i] is the first number to its right that is greater than arr[i]. If no such number exists, return -1 for this number.
 * <p>
 * Constraints:
 * <p>
 * 1≤1≤ arr.length ≤103≤103
 * 0≤0≤ arr[i] ≤103≤10
 * <p>
 * eg:
 * inp: 10,5,2,13,15,9,2,16
 * out: 13,13,13,15,16,16,16,-1
 */
public class NextGreaterElementUsingStack {

    /**
     * Time complexity
     * <p>
     * The time complexity of the algorithm is O(n)O(n), where nn is the number of elements in the input array. This is because the algorithm iterates over the array exactly once.
     * <p>
     * Space complexity
     * <p>
     * The space complexity of the algorithm is O(n)O(n), where nn is the number of elements in the input array. In the worst case, the stack will have all the elements in it.
     */
    public static int[] nextGreaterElement(int[] arr) {
        java.util.Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        Arrays.fill(res, -1);

        for (int i = arr.length - 1; i >= 0; i--) {
            // While stack has elements and the current element is greater than peek element, pop all elements
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If the stack has an element, the peek element will be greater than ith element
            if (!stack.isEmpty()) {
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {4, 6, 3, 2, 8, 1, 9, 9, 9},
                {33, 20, 105, 88},
                {12, 5, 44, 56, 46, 78},
                {1, 2, 3, 4, 5},
                {150, 125, 100, 75, 50, 25, 0}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + "\tArray: " + Arrays.toString(inputs[i]));
            System.out.println("\n\tResult: " + Arrays.toString(nextGreaterElement(inputs[i])));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
