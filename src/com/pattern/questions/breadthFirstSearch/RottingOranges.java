package com.pattern.questions.breadthFirstSearch;

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
 *
 * https://leetcode.com/problems/rotting-oranges/description/
 */
public class RottingOranges {
}
