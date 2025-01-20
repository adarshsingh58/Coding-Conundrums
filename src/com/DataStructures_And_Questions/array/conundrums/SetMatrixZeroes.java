package com.DataStructures_And_Questions.array.conundrums;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 * You must do it in place.
 *
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 *
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 *
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 *
 * */
public class SetMatrixZeroes {

    public static void main(String[] args) {

        int[][] matrix=new int[3][3];
        setZeroes_set(matrix);

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
