package com.pattern.questions.topologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
* Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][], where each entry edges[i] = [u, v] denotes a directed edge u -> v. Return the topological sort for the given graph.

    Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.

Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be true else false.
*
*Input: V = 4, E = 3, edges[][] = [[3, 0], [1, 0], [2, 0]]

Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the given graph are:
[3, 2, 1, 0]
[1, 2, 3, 0]
[2, 3, 1, 0]
*
* Input: V = 6, E = 6, edges[][] = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5,2]]

Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the graph are:
[4, 5, 0, 1, 2, 3]
[5, 2, 4, 0, 1, 3]
* https://www.geeksforgeeks.org/problems/topological-sort/1
*
*
* | Metric          | Value           |
| --------------- | --------------- |
| Time            | O(V + E)        |
| Space (adjList) | O(V + E)        |
| Space (stack)   | O(V)            |
| Call Stack      | O(V) worst case |

*
*
* Two Ways to Do Topological Sort
1. DFS-based (what we used above)

    Recursively detect cycles using a visiting[] array.

    If a back edge is found (i.e., you revisit a visiting[] == true node), the graph has a cycle → return false.

2. Kahn's Algorithm (BFS-based)

    Maintain in-degree (number of incoming edges) for each node.

    Start with nodes with in-degree = 0.

    Process them and reduce in-degrees of neighbors.

    If at the end, you've processed fewer than numCourses, then there’s a cycle → return false.
* */
public class Topologicalsort {

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(5, 2),
                Arrays.asList(5, 0),
                Arrays.asList(4, 0),
                Arrays.asList(4, 1),
                Arrays.asList(2, 3),
                Arrays.asList(3, 1)
        );

        ArrayList<Integer> topoOrder = topoSort(V, edges);
        System.out.println("Topological Order:");
        System.out.println(topoOrder);
        // Expected one of the valid topological sorts: [5, 4, 2, 3, 1, 0] or similar
    }

    public static ArrayList<Integer> topoSort(int V, List<List<Integer>> edges) {
        // Step 0: Build adjacency list from edges
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());
        for (List<Integer> edge : edges) {
            adjList.get(edge.get(0)).add(edge.get(1));
        }

        // Step 1: Initialize visited and result stack
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // Step 2: DFS traversal
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adjList);
            }
        }

        // Step 3: Build result from stack
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private static void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adjList) {
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack, adjList);
            }
        }
        stack.push(node);  // post-order
    }
}
