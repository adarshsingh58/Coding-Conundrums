package com.pattern.questions.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node
 * n - 1 and return them in any order.
 * <p>
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed
 * edge from node i to node graph[i][j]).
 * <p>
 * Example 1:
 * <p>
 * Input: graph = [[1,2],[3],[3],[]] Output: [[0,1,3],[0,2,3]] Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2
 * -> 3.
 * <p>
 * Example 2:
 * <p>
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]] Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * <p>
 * https://leetcode.com/problems/all-paths-from-source-to-target/description/
 */
public class AllPathsFromSourcetoTarget {

    public static void main(String[] args) {
        AllPathsFromSourcetoTarget obj = new AllPathsFromSourcetoTarget();

        int[][] inp = new int[][]{
                {1, 2},
                {3},
                {3},
                {}
        };
        obj.allPathsSourceTarget(inp);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> op = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        currPath.add(0);
        allPathsSourceTarget(graph, graph.length - 1, 0, currPath, op);
        return op;
    }

    /**
     * The idea was we start from our main method. So. We have the list of candidates i.e. graph. target would be
     * the last Index which is in n-1 where we wanted to reach. We have start variable which is telling
     * us where should I start from and as given we have to start from zero index i.e the
     * very first node in the Directed acyclic graph to n-1 which is your target.So basically 0 to n-1
     * So Our current path more path always have zero.
     * For the start we add zero to the current path and then we move forward and op is about the final output.
     *
     * Now in the recursion array we check our matching condition if the current path contains my target.
     * Then we add to the output list. So if my current path has  n-1 we add it to the output list.
     *
     * Now, So we are checking On starting candidate, we are at writing on the 0th index Of the 2D array.
     * From Zeroth index wher all we can reach. That is our decision is space. So from that decision space we can decide
     * we need to go next.
     * So that is the reason we are doing candidates, we start 0th length, we are getting the very
     * first element from that. Starting  for zero code we are traversing all the nodes that we can reach and
     * again from there also we are trying to figure out from what all can we reach
     * we are traversing that node we are adding it to the current path. And then again we are checking
     * about matching condition, if that is not leading us to the final output, that is when we will remove it.
     *
     * So we are kind of going for every possible solution out there. We have to go through all the nodes to figure out
     * if the. N -1 node can be reached or not.
     */
    public void allPathsSourceTarget(int[][] candidates, int target, int start, List<Integer> currPath, List<List<Integer>> op) {

        if (currPath.contains(target)) {
            op.add(new ArrayList<>(currPath));
            return;
        }

        for (int i = 0; i < candidates[start].length; i++) {
            //find out all the path we can traverse for this candidate
            int candidate = candidates[start][i];
            currPath.add(candidate);
            allPathsSourceTarget(candidates, target, candidate, currPath, op);
            currPath.remove(currPath.size() - 1);
        }

    }
}
