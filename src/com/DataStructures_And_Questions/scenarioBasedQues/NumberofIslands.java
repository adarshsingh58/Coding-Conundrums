package com.DataStructures_And_Questions.scenarioBasedQues;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input: 11110 11010 11000 00000
 * <p>
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: 11000 11000 00100 00011
 * <p>
 * Output: 3
 * <p>
 * https://leetcode.com/problems/number-of-islands/
 */

public class NumberofIslands {

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '1'},

        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int noOfisland = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    noOfisland = noOfisland + 1;
                    markLandAsVisited(grid, i, j);
                }
            }
        }
        return noOfisland;
    }

    public static void markLandAsVisited(char[][] grid, int i, int j) {
        if (i > -1 && j > -1 && i < grid.length && j < grid[0].length && grid[i][j] == '1')
            grid[i][j] = '0';
        else
            return;
        markLandAsVisited(grid, i + 1, j);
        markLandAsVisited(grid, i, j + 1);
        markLandAsVisited(grid, i - 1, j);
        markLandAsVisited(grid, i, j - 1);
    }

}
