package com.DataStructures_And_Questions.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array (list) of intervals as input where each interval has a start
 * and end timestamps. Input array is sorted by starting timestamps. You are
 * required to merge overlapping intervals and return output array (list).
 * <p>
 * Consider below input array.
 * inputArr = (1, 5), (3, 7), (4, 6), (6, 8), (10, 12) and (12, 15)
 * <p>
 * Intervals (1, 5), (3, 7), (4, 6), (6, 8) are
 * overlapping so should be merged to one big interval (1, 8).
 * Similarly intervals (10, 12) and (12, 15) are also overlapping intervals and should be
 * merged to (10, 15).
 * O/P =  (1, 8), (10,15)
 *
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        List<String> inputArr = new ArrayList<>();
        inputArr.add("1,5");
        inputArr.add("3,7");
        inputArr.add("4,6");
        inputArr.add("6,8");
        inputArr.add("10,12");
        inputArr.add("12,15");

//        List<String> mergedList = getMergedList(inputArr);
//        System.out.println(mergedList);

       /* int[][] intervals = new int[4][2];
        intervals[0][0] = 1;
        intervals[0][1] = 3;
        intervals[1][0] = 2;
        intervals[1][1] = 6;
        intervals[2][0] = 8;
        intervals[2][1] = 10;
        intervals[3][0] = 15;
        intervals[3][1] = 18;
        getMergedList2(intervals);*/
    }

    /**
     *
     */
    private static List<String> getMergedList(List<String> inputArr) {
        List<String> outputArr = new ArrayList<>();
        int globalX = Integer.parseInt(inputArr.get(0).split(",")[0]);
        int globalY = Integer.parseInt(inputArr.get(0).split(",")[1]);
        for (int i = 0; i < inputArr.size(); i++) {
            String tuple = inputArr.get(i);
            int tupleX = Integer.parseInt(tuple.split(",")[0]);
            int tupleY = Integer.parseInt(tuple.split(",")[1]);
            if (tupleX <= globalY) {
                globalY = tupleY;
            } else {
                outputArr.add(globalX + "," + globalY);
                globalX = tupleX;
                globalY = tupleY;
            }
        }
        outputArr.add(globalX + "," + globalY);
        return outputArr;
    }

    private static int[][] getMergedList2(int[][] intervals) {
        int[][] op = new int[intervals.length][intervals[0].length];
        int i = 0, j = 0, k = 0;
        boolean lastIndexLeft = true;
        while (i < intervals.length && j + 1 < intervals.length) {
            if (intervals[j + 1][0] <= intervals[i][1]) {
                j++;
                if (j == intervals.length - 1) {
                    op[k][0] = intervals[i][0];
                    op[k][1] = intervals[j][1];
                    i = j + 1;
                    k++;
                    lastIndexLeft = false;
                }
            } else {
                op[k][0] = intervals[i][0];
                op[k][1] = intervals[j][1];
                i = j + 1;
                j = i;
                k++;
            }
        }

        if (lastIndexLeft)
            op[k] = intervals[j];

        return op;
    }
}
