package com.pattern.questions.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Write a function to find the common free time for all employees from a list called schedule. Each employee's schedule
 * is represented by a list of non-overlapping intervals sorted by start times. The function should return a list of
 * finite, non-zero length intervals where all employees are free, also sorted in order.
 * <p>
 * Input: schedule = [[[2,4],[7,10]],[[1,5]],[[6,9]]]
 * <p>
 * Output: [(5,6)] Explanation: The three employees collectively have only one common free time interval, which is from
 * 5 to 6. https://www.hellointerview.com/learn/code/intervals/employee-free-time
 */
public class EmployeeFreeTime {
    public static void main(String[] args) {
        List<List<List<Integer>>> inp = new ArrayList<>();


        employeeFreeTime(inp).forEach(v -> System.out.println(v.get(0) + " , " + v.get(0)));
    }
    public static List<List<Integer>> employeeFreeTime(List<List<List<Integer>>> schedule) {
        List<int[]> all = new ArrayList<>();

        // Step 1: Flatten all intervals
        for (List<List<Integer>> employee : schedule) {
            for (List<Integer> interval : employee) {
                all.add(new int[]{interval.get(0), interval.get(1)});
            }
        }

        // Step 2: Sort by start time
        all.sort(Comparator.comparingInt(a -> a[0]));

        // Step 3: Merge and find free times
        List<List<Integer>> result = new ArrayList<>();
        int[] prev = all.get(0);

        for (int i = 1; i < all.size(); i++) {
            int[] curr = all.get(i);
            if (curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]); // merge
            } else {
                result.add(List.of(prev[1], curr[0])); // free time
                prev = curr;
            }
        }

        return result;
    }

}
