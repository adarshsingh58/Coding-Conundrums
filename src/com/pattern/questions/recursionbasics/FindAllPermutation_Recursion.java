package com.pattern.questions.recursionbasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * arr={1,3,2} op={1,2,3}{1,3,2}{2,1,3}{2,3,1}{3,1,2}{3,2,1} #of perm= n! i.e. 3! = 3*2*1=6
 * <p>
 * https://www.youtube.com/watch?v=YK78FU5Ffjw&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=14
 */
public class FindAllPermutation_Recursion {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        List<List<Integer>> opMain = findAllPerm(arr);
        opMain.forEach(op -> {
            op.forEach(v -> {
                System.out.print(v + " ");
            });
            System.out.println();
        });
    }

    private static List<List<Integer>> findAllPerm(int[] arr) {
        List<List<Integer>> opMain = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        boolean[] pickedElementFlag = new boolean[arr.length];
        findAllPerm_Rec(arr, 0, pickedElementFlag, op, opMain);
        return opMain;
    }

    private static void findAllPerm_Rec(int[] arr, int index, boolean[] pickedElementFlag, List<Integer> op, List<List<Integer>> opMain) {
        if (index == arr.length) {
            opMain.add(new ArrayList<>(op));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!pickedElementFlag[i]) {
                op.add(arr[i]);
                pickedElementFlag[i] = true;
                findAllPerm_Rec(arr, index + 1, pickedElementFlag, op, opMain);
                pickedElementFlag[i] = false;
                op.remove(op.size()-1);
            }
        }

    }
}
