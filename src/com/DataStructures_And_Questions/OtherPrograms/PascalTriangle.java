package com.DataStructures_And_Questions.OtherPrograms;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * <p>
 * https://leetcode.com/problems/pascals-triangle/description/
 * <p>
 * Example 1:
 * <p>
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: numRows = 1
 * Output: [[1]]
 */
public class PascalTriangle {

    public static void main(String[] args) {

        List<List<Integer>> op=generate(5);
       op.forEach(row -> {
           System.out.println();
           row.forEach(value -> System.out.print(value + " "));
       });
    }

    /*
    * Each value(i,j) if we see in a pascal traingle is made of (i-1) row's (j-1) + (j) value
    * we will use this same formula after initializing the triangle with first row i.e. i=0;
    * with one modification that when j-1 < 0 i.e. in previous row there is now value to left of
    * j and when j>i i.e. in prev row the length itself is less than current j then we will output 0.
    * these 2 are corner index cases.
    *
    *  */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> op = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        op.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> insideOp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int prevRowPrevVal = j == 0 ? 0 : op.get(i - 1).get(j - 1);
                int prevRowNextVal = j == i ? 0 : op.get(i - 1).get(j);
                int value = prevRowPrevVal + prevRowNextVal;
                insideOp.add(value);
            }
            op.add(insideOp);
        }
        return op;
    }
}
