package com.pattern.questions.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use
 * all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick
 * must be used exactly one time. Return true if you can make this square and false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: matchsticks = [1,1,2,2,2] Output: true Explanation: You can form a square with length 2, one side of the
 * square came two sticks with length 1.
 * <p>
 * Example 2:
 * <p>
 * Input: matchsticks = [3,3,3,3,4] Output: false Explanation: You cannot find a way to form a square with all the
 * matchsticks.
 * <p>
 * <p>
 * https://leetcode.com/problems/matchsticks-to-square/description/
 */
public class MatchstickstoSquare {

    public static void main(String[] args) {
        int[] matchsticks = new int[]{1, 1, 2, 2, 2};
        System.out.println(canMakeSquare(matchsticks));
    }

    public static boolean canMakeSquare(int[] candidates) {
        int target = 0;
        List<Integer> currPath = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        return canMakeSquare(candidates, target, 0, currPath);
    }

    private static boolean canMakeSquare(int[] candidates, int target, int start, List<Integer> currPath) {
        if (currPath.get(currPath.size() - 1) > target) {
            return false;
        }
        if (currPath.size() == 4) {
            return true;
        }

        for (int i = start; i < candidates.length; i++) {
            currPath.add(candidates[i]);
            if (candidates[i] > target)
                target = candidates[i];
            canMakeSquare(candidates, i + 1, target, currPath);
        }
        return false;
    }
}
