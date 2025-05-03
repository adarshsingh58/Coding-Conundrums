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
 * <p>
 * https://leetcode.com/problems/combination-sum/description/
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] inp = {2, 3, 5};
        int target = 8;


        List<List<Integer>> opMain = combSum(inp, target);
        opMain.forEach(h -> {
                    h.forEach(y -> {
                        System.out.print(y + " ");
                    });
                    System.out.println();
                }
        );

    }

    private static List<List<Integer>> combSum(int[] inp, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combSum(inp, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void combSum(int[] candidates, int target, int currIndex, List<Integer> currPath, List<List<Integer>> result) {
        if (currPath != null && !currPath.isEmpty() && target == 0) {
            result.add(new ArrayList<>(currPath));
            return;
        }
        for (int i = currIndex; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                currPath.add(candidates[i]);
                combSum(candidates, target-candidates[i], i, currPath, result);
                currPath.remove(currPath.size() - 1);
            }
        }
    }
}
