package com.pattern.questions.CommonLogicalProblems_NotDataStructureDependent;

import java.util.ArrayList;
import java.util.List;

/**
 *You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * https://leetcode.com/problems/climbing-stairs/submissions/1655276762/
 * */
public class ClimbingStairs {
    public static void main(String[] args) {

    }










    // Problem here is 2^n complexity. For >35 values this will throw Timeout exception.
    public int climbStairs(int n) {
        int[] candidates = new int[] { 1, 2 };
        List<List<Integer>> result = new ArrayList<>();
        climbStairs(candidates, n, new ArrayList<>(), result);
        return result.size();
    }

    public void climbStairs(int[] candidates, int target, List<Integer> curr, List<List<Integer>> result) {
        if (!curr.isEmpty()) {
            int stepsSoFar = curr.stream().reduce((v1, v2) -> v1 + v2).get();
            if (stepsSoFar > target)
                return;
            if (stepsSoFar == target) {
                result.add(curr);
                return;
            }
        }

        for (int i = 0; i < candidates.length; i++) {
            curr.add(candidates[i]);
            climbStairs(candidates, target, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
