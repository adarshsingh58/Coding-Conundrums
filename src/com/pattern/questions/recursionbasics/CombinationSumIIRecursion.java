package com.pattern.questions.recursionbasics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given and array of distinct integers and a target integer, we need to return a list of all unique combination whose
 * sum is equal to the target. One index must be chosen only 1 time op should be in sorted order One combination should
 * only come one time i.e. unique combinations
 * <p>
 * eg: arr=[1 2 1 2 1] target=4 op: [[1 1 2],[2 2]]
 * <p>
 * https://www.youtube.com/watch?v=G1fRTGRxXU8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=11
 */
public class CombinationSumIIRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 1};
        int target = 4;
        List<List<Integer>> opMain = getCombinations(arr, target);
        opMain.forEach(op -> {
            op.forEach(v -> {
                System.out.print(v + " ");
            });
            System.out.println();
        });

    }

    private static List<List<Integer>> getCombinations(int[] arr, int target) {
        Arrays.sort(arr);//SORT IT FIRST
        List<List<Integer>> opMain = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        getCombinations_Rec(arr, target, 0, op, opMain);
        return opMain;
    }

    private static void getCombinations_Rec(int[] arr, int target, int i, List<Integer> op, List<List<Integer>> opMain) {
        int sumSoFar = op.stream().reduce(0, (s1, s2) -> s1 + s2); //1 1 1 2 2
        if (sumSoFar == target) {
            opMain.add(new ArrayList<>(op));
            return;
        }
        if (i == arr.length || sumSoFar > target)
            return;

        op.add(arr[i]);
        getCombinations_Rec(arr, target, i+1, op, opMain);
        op.remove(op.size()-1);
        int j = i + 1;
        while (j<arr.length && arr[i] == arr[j])
            j++;
        getCombinations_Rec(arr, target, j, op, opMain);
    }

}
