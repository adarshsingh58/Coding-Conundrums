package com.pattern.questions.CommonLogicalProblems_NotDataStructureDependent.KSomething;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindKClosest {

    public static void main(String[] args) {
        List<int[]> inpList = new ArrayList<>();

//      inpList.add(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8});
        inpList.add(new int[]{1,10,15,25,35,45,50,59});

        inpList.forEach(inp -> System.out.println(new FindKClosest().findClosestElements(inp, 1, 30)));

    }


    public int binSearch(int[] arr, int x) {
        int s = 0, e = arr.length - 1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (arr[mid] < x) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        // Now s == e
        // Return index of element closest to x
        if (s > 0 && Math.abs(arr[s - 1] - x) <= Math.abs(arr[s] - x)) {
            return s - 1;
        }
        return s;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> op = new ArrayList<>();

        int curr = binSearch(arr, x); // find closest index to x
        int i = curr - 1, j = curr;

        while (op.size() < k) {
            if (i >= 0 && j < arr.length) {
                if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
                    op.add(arr[i--]);
                } else {
                    op.add(arr[j++]);
                }
            } else if (i >= 0) {
                op.add(arr[i--]);
            } else {
                op.add(arr[j++]);
            }
        }

        Collections.sort(op);
        return op;
    }
}
