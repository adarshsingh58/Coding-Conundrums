package com.pattern.questions.recursionbasics;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=AxNNVECce8c&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=6
 */
public class PrintAllSubSequenceOfArrayRecursion {

    public static void main(String[] args) {
        int[] inp = {1, 3, 2, 5};
        getAllSubSeq(inp, 0, new ArrayList<>());
    }

    private static void getAllSubSeq(int[] inp, int i, List<Integer> op) {
        if (i == inp.length) {
            op.forEach(System.out::print);
            System.out.println();
            return;
        }
        op.add(inp[i]);
        getAllSubSeq(inp, i + 1, op);
        op.remove(op.size()-1);
        getAllSubSeq(inp, i + 1, op);
    }
}
