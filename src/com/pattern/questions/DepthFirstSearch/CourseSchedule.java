package com.pattern.questions.DepthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
 * prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * <p>
 * Return true if you can finish all courses. Otherwise, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]] Output: true Explanation: There are a total of 2 courses to take. To
 * take course 1 you should have finished course 0. So it is possible.
 * <p>
 * Example 2:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]] Output: false Explanation: There are a total of 2 courses to
 * take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course
 * 1. So it is impossible.
 * <p>
 * https://leetcode.com/problems/course-schedule/description/
 */
public class CourseSchedule {

    public static void main(String[] args) {
        int[][] prerequisites ={{1,0},{0,4},{0,2},{2,4}};
        System.out.println(new CourseSchedule().canFinish(2,prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list
        Map<Integer, List<Integer>> courseGraph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            courseGraph.put(i, new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            courseGraph.get(pair[1]).add(pair[0]); // edge from prereq to course
        }

        boolean[] visited = new boolean[numCourses];   // permanently visited
        boolean[] visiting = new boolean[numCourses];  // visiting in current recursion

        // Check for cycles using DFS
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(courseGraph, i, visited, visiting)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int node, boolean[] visited, boolean[] visiting) {
        if (visiting[node]) return true;  // cycle found
        if (visited[node]) return false;  // already processed

        visiting[node] = true;
        for (int neighbor : graph.get(node)) {
            if (hasCycle(graph, neighbor, visited, visiting)) {
                return true;
            }
        }
        visiting[node] = false;
        visited[node] = true;
        return false;
    }

}
