package com.pattern.questions.recursionbasics;

import java.util.ArrayList;

public class SubSeqWithKSumRecursion {
    public static void main(String[] args) {

        int[] inp = {1, 3, 2, 5, 9, 7};
        int sum = 10;
        getAllSubSeq(inp, 0, sum, new ArrayList<Integer>());

    }

    private static void getAllSubSeq(int[] inp, int i, int sum, ArrayList<Integer> op) {
        int s = op.stream().reduce(0, (val1, val2) -> val1 + val2);
        if (s == sum) {
            op.forEach(System.out::print);
            System.out.println();
        }
        if (i == inp.length) {
            return;
        }

        op.add(inp[i]);
        getAllSubSeq(inp, i + 1, sum, op);
        op.remove(op.size() - 1);
        getAllSubSeq(inp, i + 1, sum, op);
    }


}
