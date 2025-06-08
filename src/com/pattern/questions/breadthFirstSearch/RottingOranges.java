package com.pattern.questions.breadthFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * <p>
 * 0 representing an empty cell, 1 representing a fresh orange, or 2 representing a rotten orange.
 * <p>
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return
 * -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]] Output: 4
 * <p>
 * Example 2:
 * <p>
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]] Output: -1 Explanation: The orange in the bottom left corner (row 2, column
 * 0) is never rotten, because rotting only happens 4-directionally.
 * <p>
 * Example 3:
 * <p>
 * Input: grid = [[0,2]] Output: 0 Explanation: Since there are already no fresh oranges at minute 0, the answer is just
 * 0.
 * <p>
 * https://leetcode.com/problems/rotting-oranges/description/
 */
public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(new RottingOranges().orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int time = 0;
        Set<String> rottenOrEmpty = new HashSet<>();
        Queue<String> bfsQ = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2 && !rottenOrEmpty.contains(i + "," + j)) {
                    bfsQ.add(i + "," + j);
                    int prebfsSize = bfsQ.size();

                    while (!bfsQ.isEmpty()) {
                        if (prebfsSize == 0) {
                            time++;
                            prebfsSize = bfsQ.size();
                        }
                        String position = bfsQ.poll();
                        int m = Integer.parseInt(position.split(",")[0]);
                        int n = Integer.parseInt(position.split(",")[1]);
                        if (rottenOrEmpty.contains(m + "," + n)) continue;
                        rottenOrEmpty.add(m + "," + n);
                        if (m < grid.length - 1 && grid[m + 1][n] == 1) bfsQ.add((m + 1) + "," + n);
                        if (m > 0 && grid[m - 1][n] == 1) bfsQ.add((m - 1) + "," + n);
                        if (n < grid[0].length - 1 && grid[m][n + 1] == 1) bfsQ.add((m) + "," + (n + 1));
                        if (n > 0 && grid[m][n - 1] == 1) bfsQ.add((m) + "," + (n - 1));
                        prebfsSize--;
                    }

                } else {
                    rottenOrEmpty.add(i + "," + j);
                }
                if (rottenOrEmpty.size() == grid.length * grid[0].length) {
                    return time;
                }
            }
        }

        return time;
    }
}
