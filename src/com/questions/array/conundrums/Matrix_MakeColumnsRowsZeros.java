package com.questions.array.conundrums;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a two dimensional array, if any element in it is zero make its whole
 * row and column zero. For example, consider the below matrix.
 * <p>
 * 5 4 3 9
 * 2 0 7 6
 * 1 3 4 0
 * 9 8 3 4
 * <p>
 * There are two zeros in the input matrix i.e. at position (1,1) and (2,3).
 * Output of this should be a matrix in which 2nd and 3rd row becomes zero and
 * 2nd and fourth columns become zeros. Below is the expected output matrix.
 * <p>
 * 5 0 3 0
 * 0 0 0 0
 * 0 0 0 0
 * 9 0 3 0
 */
public class Matrix_MakeColumnsRowsZeros {

    public static void main(String[] args) {
        int[][] inputArr = new int[][]{{5, 4, 3, 9}, {2, 0, 7, 6}, {1, 3, 4, 0}, {9, 8, 3, 4}};
        inputArr = makeRCZero(inputArr);
        for (int[] r : inputArr) {
            for (int c : r) {
                System.out.print(c);
            }
            System.out.println();
        }

    }

    /**
     * We cannot simple find i,j where element is 0 and make all columns in i and all rows in j 0.
     * Because, then while traversing further, we find more 0s then were originally. i.e. we cannot do changes
     * whilst traversing the matrix, if we DO NOT want to use a new array.
     * <p>
     * Here we save the row index which have a 0 in it in a list rowWithZero and
     * we save the column index which have a 0 in it in a list columnWithZero while traversing through the entire matrix. O(n^2)
     * <p>
     * Now, we traverse through rowWithZero an for each encountered row index we make all columns from 0 to inputArr[0].length-1 as 0.
     * We do same for columnWithZero.
     *
     * @TimeComplexity O(mn), where m is number of rows and n number of columnss
     * @SpaceComplexity O(m + n) coz new list of these sizes are used.
     */
    private static int[][] makeRCZero(int[][] inputArr) {
        List<Integer> rowWithZero = new ArrayList<Integer>();
        List<Integer> columnWithZero = new ArrayList<Integer>();
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = 0; j < inputArr.length; j++) {
                if (inputArr[i][j] == 0) {
                    rowWithZero.add(i);
                    columnWithZero.add(j);
                }
            }
        }
        for (int i : rowWithZero) {
            for (int j = 0; j < inputArr[0].length; j++) {
                inputArr[i][j] = 0;
            }
        }
        for (int i : columnWithZero) {
            for (int j = 0; j < inputArr.length; j++) {
                inputArr[j][i] = 0;
            }
        }
        return inputArr;
    }

    /*
     * Even Optimal Solution would be to make all 0 to -1 in one iteration
     * then mark all c r 0 where i,j is -1 then convert all -1 to 0;
     * */
    private static int[][] makeRCZero_NoSpace(int[][] inputArr) {


        return inputArr;
    }

}
