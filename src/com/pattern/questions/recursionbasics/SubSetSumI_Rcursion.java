package com.pattern.questions.recursionbasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array, print all subset's sum in sorted order arr={3,1,4} op: {0,1,3,4,4,5,7,8} total subset= 2^n=8 and
 * hence 8 sums are possible
 * <p>
 * https://www.youtube.com/watch?v=rYkfBRtMJr8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=12
 */
public class SubSetSumI_Rcursion {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4};
        List<Integer> opMain = getSums(arr);
        Collections.sort(opMain);
        opMain.forEach(v -> {
            System.out.print(v + " ");
        });
    }

    private static List<Integer> getSums(int[] arr) {
        List<Integer> op = new ArrayList<>();
        getSumsRec(arr, 0, 0, op);
        return op;
    }

    private static void getSumsRec(int[] arr, int index, int sumSoFar, List<Integer> op) {
        if (index == arr.length) {
            op.add(sumSoFar);
            return;
        }
        //pick and element
        getSumsRec(arr, (index + 1), (sumSoFar + arr[index]), op);
        //Do not pick and element
        getSumsRec(arr, (index + 1), sumSoFar, op);
    }
}
