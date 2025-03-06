package com.pattern.questions.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations . You can return the answer in any
 * order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3] Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,1] Output: [[0,1],[1,0]]
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1] Output: [[1]]
 *
 * https://leetcode.com/problems/permutations/description/
 */
public class Permutations {

    public static void main(String[] args) {
        int[] inp=new int[]{1,2,3};

        List<List<Integer>> op=permute(inp);
        for (List<Integer> ints : op) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> permute(int[] inp) {
        List<List<Integer>> op=new ArrayList<>();
        List<Integer> currPerm=new ArrayList<>();
        backtrack(inp,op,currPerm);
        return op;
    }

    private static void backtrack(int[] inp, List<List<Integer>> op, List<Integer> currPerm) {
        if(currPerm.size()==inp.length) {
            op.add(new ArrayList<>(currPerm));
            return;
        }

        for (int i : inp) {
            if(currPerm.contains(i)) continue;
            currPerm.add(i);
            backtrack(inp, op, currPerm);
            currPerm.remove(currPerm.size()-1);
        }
    }
}
