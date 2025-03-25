package com.pattern.questions.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations
 * of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency of at least one of the chosen numbers is different.
 * <p>
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150
 * combinations for the given input.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7 Output: [[2,2,3],[7]] Explanation: 2 and 3 are candidates, and 2 + 2 + 3 =
 * 7. Note that 2 can be used multiple times. 7 is a candidate, and 7 = 7. These are the only two combinations.
 * <p>
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8 Output: [[2,2,2,2],[2,3,3],[3,5]]
 * <p>
 * Example 3:
 * <p>
 * Input: candidates = [2], target = 1 Output: []
 * <p>
 * https://leetcode.com/problems/combination-sum/description/
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] inp = {2, 3, 5};
        int target = 8;

        List<List<Integer>> opMain = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        combSum(target, inp, inp.length - 1, op, opMain);
        opMain.forEach(h -> {
                    h.forEach(y -> {
                        System.out.print(y + " ");
                    });
            System.out.println();
                }
        );

    }

    private static void combSum(int target, int[] inp, int currIndex, List<Integer> op, List<List<Integer>> opMain) {
        if (target == 0) {
            opMain.add(new ArrayList<>(op));
            return;
        }
        if (currIndex < 0 || target < 0)
            return;
        op.add(inp[currIndex]);
        combSum(target - inp[currIndex], inp, currIndex, op, opMain);
        op.remove(op.size() - 1);
        combSum(target, inp, currIndex - 1, op, opMain);
    }
}
