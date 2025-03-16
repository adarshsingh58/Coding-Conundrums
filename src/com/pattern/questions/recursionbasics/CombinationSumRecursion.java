package com.pattern.questions.recursionbasics;

import java.util.ArrayList;
import java.util.List;

/**
 * Given and array of distinct integers and a target integer, we need to return a list of all unique combination whose
 * sum is equal to the target. Same number may be choosen from the array any number of time.
 * <p>
 * eg: arr=[2,3,6,7] target=7 op: [[2,2,3],[7]]
 * <p>
 * https://www.youtube.com/watch?v=OyZFFqQtu98&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=12
 */
public class CombinationSumRecursion {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;
        List<List<Integer>> opMain = getCombinations(arr, target);
        opMain.forEach(op -> {
            op.forEach(v -> {
                System.out.print(v + " ");
            });
            System.out.println();
        });

    }

    private static List<List<Integer>> getCombinations(int[] arr, int target) {
        List<List<Integer>> opMain = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        getCombinations_Rec(arr, target, 0, op, opMain);
        return opMain;
    }

    private static void getCombinations_Rec(int[] arr, int target, int i, List<Integer> op, List<List<Integer>> opMain) {
        int sumSoFar = op.stream().reduce(0, (s1, s2) -> s1 + s2);
        if (sumSoFar == target) {
            opMain.add(new ArrayList<>(op));
            return;
        }
        if (i == arr.length || sumSoFar > target)
            return;

        op.add(arr[i]);
        getCombinations_Rec(arr, target, i , op, opMain);
        op.remove(op.size() - 1);
        getCombinations_Rec(arr, target, i + 1, op, opMain);
    }

}
