package com.pattern.questions.monotonicStack;

import java.util.Stack;

/**
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
 * is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for
 * which this is possible, keep answer[i] == 0 instead.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: temperatures = [73,74,75,71,69,72,76,73] Output: [1,1,4,2,1,1,0,0]
 * <p>
 * Example 2:
 * <p>
 * Input: temperatures = [30,40,50,60] Output: [1,1,1,0]
 * <p>
 * Example 3:
 * <p>
 * Input: temperatures = [30,60,90] Output: [1,1,0]
 *
 * https://leetcode.com/problems/daily-temperatures/description/
 */
public class DailyTemperatures {
    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> monotonic = new Stack<>();
        int[] op = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!monotonic.isEmpty() && monotonic.peek() <= temperatures[i]) {
                monotonic.pop();
            }
            if (monotonic.isEmpty()) {
                op[i] = 0;
                monotonic.push(temperatures[i]);
            } else if (monotonic.peek() > temperatures[i]) {
                op[i] = monotonic.peek();
                monotonic.push(temperatures[i]);
            }
        }
        return op;
    }

}
