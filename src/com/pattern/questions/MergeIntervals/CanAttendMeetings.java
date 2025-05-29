package com.pattern.questions.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
*

Write a function to check if a person can attend all the meetings scheduled without any time conflicts. Given an array intervals, where each element [s1, e1] represents a meeting starting at time s1 and ending at time e1, determine if there are any overlapping meetings. If there is no overlap between any meetings, return true; otherwise, return false.
Note that meetings ending and starting at the same time, such as (0,5) and (5,10), do not conflict.

Input:
intervals = [(1,5),(3,9),(6,8)]
Output:
false
Explanation: The meetings (1,5) and (3,9) overlap.

Input:
intervals = [(10,12),(6,9),(13,15)]

Output:
true
Explanation: There are no overlapping meetings, so the person can attend all.
* */
public class CanAttendMeetings {

    public static void main(String[] args) {
        List<List<Integer>> intervalList = new ArrayList<>();
        intervalList.add(List.of(1, 5));
        intervalList.add(List.of(3, 9));
        intervalList.add(List.of(6, 8));
        System.out.println(canAttendMeetings(intervalList));
    }

    public static boolean canAttendMeetings(List<List<Integer>> intervalList) {
        Collections.sort(intervalList, (v1, v2) -> {
            return v1.get(0) - v2.get(0);
        });

        for (int i = 1; i < intervalList.size(); i++) {
            if (intervalList.get(i - 1).get(1) > intervalList.get(i).get(0)) return false;
        }
        return true;
    }
}
