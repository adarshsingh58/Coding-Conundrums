package com.DataStructures_And_Questions.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed graph of n nodes and two vertices, src and dest, return the length of the shortest path between src and dest. The shortest path will contain the minimum number of edges.
 * <p>
 * If no path exists between src and dest, return -1.
 */
public class FindShortestPath2Vertices {

    public static void main(String[] args) {
        List l=new ArrayList();

    }

    /*
    In first mind, we would think to use DFS, go to each depth till destination from source and keep counter of distance.
    But, actually BFS is better because we are always moving 1 distance at a time from source, so we can be sure that from any
    path we reach destination, the shortest distance would be discovered in the first attempt, instead of going for each possible paths.

    The solution employs the Breadth-First Search (BFS) algorithm to traverse the graph, starting from the source node.
    It utilizes a Queue data structure to facilitate the BFS process, calculating the distance from the source node to each of its neighbors.
    This distance is invariably the shortest since each node is visited exactly once. Upon encountering the destination node,
    the algorithm returns the calculated distance.
    If the destination node is not found, it returns -1.

    */
    public static int findShortPath() {
        return -1;
    }
}
