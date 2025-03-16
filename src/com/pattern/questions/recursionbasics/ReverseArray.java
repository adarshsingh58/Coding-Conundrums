package com.pattern.questions.recursionbasics;

import com.DataStructures_And_Questions.array.Helper;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        revArr(arr);
        for (int i : arr)
            System.out.println(i);
    }

    private static void revArr(int[] arr) {
        int i = 0, j = arr.length-1;
        revArrRecursion(arr, i, j);
    }

    private static void revArrRecursion(int[] arr, int i, int j) {
        if (j <= i)
            return;
        Helper.swap(arr, i, j);
        revArrRecursion(arr,i+1,j-1);
    }


}
