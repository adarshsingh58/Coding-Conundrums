package com.questions.array.conundrums;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

* */
public class TraverseMatrixInSpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9}, {2, 4, 8}, {2, 4, 8}};
        TraverseMatrixInSpiralOrder.spiralOrder(matrix);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        Set<String> traversedIndex = new HashSet<>();
        boolean traverse = true;
        int i = 0, j = 0;
        int dir = 1;
        while (traverse) {
            if (traversedIndex.size() == (matrix.length * matrix[0].length)) {
                break;
            }
            if (!traversedIndex.contains(i + "," + j)) {
                integers.add(matrix[i][j]);
                traversedIndex.add(i + "," + j);
            }

            if (dir == 1 && (j + 1 >= matrix[0].length || traversedIndex.contains(i + "," + (j + 1)))) {
                dir = 2;
            } else if (dir == 2 && (i + 1 >= matrix.length || traversedIndex.contains((i + 1) + "," + (j)))) {
                dir = 3;
            } else if (dir == 3 && (j - 1 < 0 || traversedIndex.contains(i + "," + (j - 1)))) {
                dir = 4;
            } else if (dir == 4 && (i - 1 < 0 || traversedIndex.contains((i - 1) + "," + (j)))) {
                dir = 1;
            }

            if (dir == 1) j++;
            if (dir == 2) i++;
            if (dir == 3) j--;
            if (dir == 4) i--;
        }

        return integers;
    }
}
