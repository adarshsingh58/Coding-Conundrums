package com.pattern.questions.recursionbasics;

import java.util.*;

/**
 * Given an array, print all possible UNIQUE subsets. Arr may have duplicates Print/return them in any order arr={1,2,2}
 * op: {{},{1},{2},{1,2},{2,2},{1,2,2}} total subset= 2^n=8 but 1,2 and 2 are duplicate subsets hence omitted from op
 * <p>
 * <p>
 * https://www.youtube.com/watch?v=RIn3gOkbhQE&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=13
 */
public class SUbSetII_Recursion {

    public static void main(String[] args) {
        int[] arr = {2, 1, 2};
        Set<List<Integer>> opMain = getUniqSubSets(arr);
        opMain.forEach(op -> {
            op.forEach(v -> {
                System.out.print(v + " ");
            });
            System.out.println();
        });
    }

    private static Set<List<Integer>> getUniqSubSets(int[] arr) {
        Set<List<Integer>> opMain = new TreeSet<>(
                (v1,v2) -> {
                    if(v1.size()!=v2.size()) return 1;
                    Collections.sort(v1);
                    Collections.sort(v2);
                    for (int i = 0; i < v1.size(); i++) {
                        if(v1.get(i)!=v2.get(i)) return -1;
                    }
                    return 0;
                }
        );
        List<Integer> op = new ArrayList<>();
        getUniqSubSetsRec(arr, 0, op, opMain);

        return opMain;
    }

    private static void getUniqSubSetsRec(int[] arr, int index, List<Integer> op, Set<List<Integer>> opMain) {
        if (index == arr.length) {
            opMain.add(new ArrayList<>(op));
            return;
        }
        op.add(arr[index]);
        getUniqSubSetsRec(arr, index + 1, op, opMain);
        op.remove(op.size() - 1);
        getUniqSubSetsRec(arr, index + 1, op, opMain);
    }


}
