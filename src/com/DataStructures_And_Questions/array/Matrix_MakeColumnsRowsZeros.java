package com.DataStructures_And_Questions.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    /*
       Can we make use of 2 pointers? No
       Can we make use of new Set/Map/Array? Yes
       Can we make use of recursion? No

       With new Set we can try to store indexes(i,j) with 0 value in a set
       Now iterate on this set of (i,j) and mark (0,j) to (n-1,j) as 0 AND
       (i,0) to (i, m-1) as 0.

       With mn space we can solve this
       */
    public static void setZeroes_set(int[][] matrix) {

        Set<String> zeroIndexes=new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0) zeroIndexes.add(i+","+j);
            }
        }

        for(String index:zeroIndexes){
            int i = Integer.parseInt(index.split(",")[0]);
            int j = Integer.parseInt(index.split(",")[1]);
            for(int n=0;n<matrix.length;n++){
                matrix[n][j]=0;
            }

            for(int m=0;m<matrix[0].length;m++){
                matrix[i][m]=0;
            }
        }
    }

    /**
     https://www.youtube.com/watch?v=N0MgLvceX7M
     */
    public static void setZeroes(int[][] matrix) {
        int[] row=new int[matrix.length];
        int[] col=new int[matrix[0].length];
        for(int i=0;i<row.length;i++){
            row[i]=0;
        }
        for(int i=0;i<col.length;i++){
            col[i]=0;
        }


        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0) {
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(row[i]==1 || col[j]==1){
                    matrix[i][j]=0;
                }
            }
        }

    }
}
