package com.pattern.questions.heap;

import java.util.*;

/**
 You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

 The right interval for an interval i is an interval j such that startj >= endi and startj is minimized. Note that i may equal j.

 Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.

 Example 1:

 Input: intervals = [[1,2]]
 Output: [-1]
 Explanation: There is only one interval in the collection, so it outputs -1.

 Example 2:

 Input: intervals = [[3,4],[2,3],[1,2]]
 Output: [-1,0,1]
 Explanation: There is no right interval for [3,4].
 The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
 The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.

 Example 3:

 Input: intervals = [[1,4],[2,3],[3,4]]
 Output: [-1,2,-1]
 Explanation: There is no right interval for [1,4] and [3,4].
 The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.

 https://leetcode.com/problems/find-right-interval/description/
 */
public class FindRightInterval {

    public static void main(String[] args) {
//        int[][] inp = new int[][]{{3, 4}, {2, 3}, {1, 2}};
        int[][] inp = new int[][]{{1,4},{2,3},{3,4}};

        int[] op=new FindRightInterval().findRightInterval(inp);
        for (int i = 0; i < op.length; i++) {
            System.out.println(op[i]);
        }
    }

    public int[] findRightInterval(int[][] intervals) {
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> a[0] > b[1] ? 0 : 1);
        Map<int[],Integer> map=new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            maxheap.offer(intervals[i]);
            map.put(intervals[i],i);
        }

        Stack<Integer> stack=new Stack<>();
        int[] op=new int[intervals.length];
        int i=0;
        while(!maxheap.isEmpty()){
            if(stack.isEmpty()) {
                op[i]=-1;
                i++;
                stack.push(map.get(maxheap.poll()));
            }else{
                op[i]=stack.pop();
                stack.push(map.get(maxheap.poll()));
                i++;
            }
        }
        return op;
    }

}
