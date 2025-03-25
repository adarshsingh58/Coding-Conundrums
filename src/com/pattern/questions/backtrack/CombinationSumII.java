package com.pattern.questions.backtrack;

import java.util.*;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in
 * candidates where the candidate numbers sum to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note: The solution set must not contain duplicate combinations.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8 Output: [ [1,1,6], [1,2,5], [1,7], [2,6] ]
 * <p>
 * Example 2:
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5 Output: [ [1,2,2], [5] ]
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 */
public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates={10,1,2,7,6,1,5};
        int target=8;
        Set<List<Integer>> opMain=findCombinationForSum(candidates,target);
        opMain.forEach(v->
                {
                    v.forEach( b-> System.out.print(b+" "));
                    System.out.println();
                }
        );
    }

    private static Set<List<Integer>> findCombinationForSum(int[] candidates, int target) {
        Set<List<Integer>> opMain=new TreeSet<>((a,b)->{
            if(a.size()!=b.size()) return -1;
            for (int i = 0; i < a.size(); i++) {
                if(a.get(i)!=b.get(i)) return -1;
            }
            return 0;
        });
        List<Integer> op=new ArrayList<>();
        findCombinationForSumRec(candidates, target, candidates.length - 1, op, opMain);
        return opMain;
    }

    private static void findCombinationForSumRec(int[] candidates, int target, int currIndex, List<Integer> op, Set<List<Integer>> opMain) {
        if(target==0){
            opMain.add(new ArrayList<>(op));
            return;
        }
        if(target<0 || currIndex<0)
            return;

        op.add(candidates[currIndex]);
        findCombinationForSumRec(candidates, target - candidates[currIndex], currIndex-1, op, opMain);
        op.remove(op.size()-1);
        findCombinationForSumRec(candidates, target , currIndex-1, op, opMain);
    }
}
