package com.pattern.questions.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3] Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0] Output: [[],[0]]
 *
 * https://leetcode.com/problems/subsets/description/
 */
public class Subsets {
    public static void main(String[] args) {
        List<Integer> inp=new ArrayList<>();
        inp.add(1);
        inp.add(2);
        inp.add(3);

        List<List<Integer>> op=subset(inp);
        for (List<Integer> integers : op) {
            for (Integer integer : integers) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> subset(List<Integer> inp) {
        List<Integer> currState=new ArrayList<>();
        List<List<Integer>> op=new ArrayList<>();
        backtrack(inp,inp.size(),op,currState);
        return op;
    }

    private static void backtrack(List<Integer> inp, int i, List<List<Integer>> op, List<Integer> currState) {
        if(currState.size()==i){
            op.add(currState);
            return;
        }
        for (Integer integer : inp) {
            if(currState.contains(integer)) continue;
            currState.add(integer);
            backtrack(inp,i,op,currState);
            currState.add(currState.size()-1);
            i--;
        }
    }
}
