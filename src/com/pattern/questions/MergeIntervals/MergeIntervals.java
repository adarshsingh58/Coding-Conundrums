package com.pattern.questions.MergeIntervals;

import java.util.Arrays;

/**
 * We are given an array of closed intervals
 * <p>
 * , intervals, where each interval has a start time and an end time. The input array is sorted with respect to the
 * start times of each interval. For example, intervals = [ [1,4], [3,6], [7,9] ][ [1,4], [3,6], [7,9] ] is sorted in
 * terms of start times 1, 31, 3, and 77.
 * <p>
 * Your task is to merge the overlapping intervals and return a new output array consisting of only the non-overlapping
 * intervals. eg: intervals: 1,5  3,7  4,6  6,8 op: 1,8
 *
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] inp = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18},

        };
        new MergeIntervals().merge(inp);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] op = new int[intervals.length][2];

        int prevstart = intervals[0][0];
        int prevend = intervals[0][1];
        int i = 1, k = 0;
        for (; i < intervals.length; i++) {

            if (intervals[i][0] <= prevend && intervals[i][1] <= prevend) {
                continue;
            } else if (intervals[i][0] <= prevend) { //This is needed to consider cases where next interval is fully part of prev interval like [1,7], [2,4], [8,10]
                prevend = intervals[i][1];
            } else {
                op[k][0] = prevstart;
                op[k][1] = prevend;
                k++;
                prevstart = intervals[i][0];
                prevend = intervals[i][1];
            }
        }
        op[k][0] = prevstart;
        op[k][1] = prevend;

        int[][] op1 = new int[k + 1][2];
        for (int q = 0; q <= k; q++) {
            op1[q][0] = op[q][0];
            op1[q][1] = op[q][1];
        }
        return op1;
    }
}
