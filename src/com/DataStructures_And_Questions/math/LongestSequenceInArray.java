package com.DataStructures_And_Questions.math;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array findout the longest numerical sequence with consecutive numbers.
 * eg: input={2,4,9,1,3,6}
 * output: 1,2,3,4
 */
public class LongestSequenceInArray {

    public static void main(String[] args) {
        int[] input = {2, 4, 9, 1, 3, 6,};
        printLongestSeq_sortAndCheck(input);
    }

    /**
     * @TimeComplexity O(n log n)
     */
    private static void printLongestSeq_sortAndCheck(int[] input) {
        Arrays.sort(input);
        input = new int[]{1, 2, 3, 4, 6, 9};
        StringBuffer stringBuffer = new StringBuffer();
        int globalSize = 0;
        boolean flag = true;
        for (int i = 0; i < input.length - 1; i++) {
            {
                if (input[i + 1] == input[i] + 1) {
                    if (flag) {
//					size++;
                        stringBuffer.append(input[i + 1]);
                    } else {
                        flag = true;
                    }
                } else {
                    flag = false;
                }
            }

        }
    }

    private static void printLongestSeq_Set(int[] input) {

        Set<Integer> set = new HashSet<>();
        for (int i : input) {
            set.add(i);
        }
        int[] sizeArr = new int[input.length];
        int curSize = 0;
        for (int i = 0; i < input.length; i++) {

        }
    }
}
