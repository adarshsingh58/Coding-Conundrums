package com.datastructures.Graph.traversal;

import com.graph.directed.adjlist.implmentation.copy.DirectedGraphAdjacencyList;

import java.util.Stack;

public class DFS {
    public static void traverse(DirectedGraphAdjacencyList graph, int startingPoint) {
        int currentNode = startingPoint;
        int[] visited = new int[graph.getMAX_VERTICIES()];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(currentNode);

        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            if (visited[currentNode] == 0) {
                System.out.println(currentNode);
                stack.addAll(graph.getAdjacencyListArray()[currentNode]);
                visited[currentNode] = 1;
            }
        }

    }


}
