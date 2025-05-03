package com.pattern.questions.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n]. You may
 * return the answer in any order.
 * <p>
 * Example 1: Input: n = 4, k = 2 Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * <p>
 * Explanation: There are 4 choose 2 = 6 total combinations. Note that combinations are unordered, i.e., [1,2] and [2,1]
 * are considered to be the same combination.
 * <p>
 * Example 2: Input: n = 1, k = 1 Output: [[1]] Explanation: There is 1 choose 1 = 1 total combination.
 * <p>
 * https://leetcode.com/problems/combinations/description/
 */
public class Combinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> op = attempt(n, k);
        op.forEach(v -> {
            v.forEach(System.out::print);
            System.out.println();
        });

    }

    private static List<List<Integer>> attempt(int n, int k) {
        List<List<Integer>> opMain = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        attempt(n, k, 1, currPath, opMain);
        return opMain;
    }

    private static void attempt(int candidates, int target, int start, List<Integer> currPath, List<List<Integer>> result) {
        if (currPath.size() == target) {
            result.add(new ArrayList<>(currPath));
            return;
        }

        for (int candidate = start; candidate <= candidates; candidate++) {
            currPath.add(candidate);
            attempt(candidates,target,candidate+1,currPath,result);
            currPath.remove(currPath.size()-1);
        }
    }

}
