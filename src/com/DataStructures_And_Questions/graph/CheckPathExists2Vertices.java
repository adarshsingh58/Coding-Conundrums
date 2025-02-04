package com.DataStructures_And_Questions.graph;

import java.util.*;

/**
 * Given a 2D array, edges, representing a bidirectional graph, where each vertex is labeled from 00 to n−1n−1. Each edge in the graph is represented as a pair, [xi,yi][xi​,yi​], showing a bidirectional edge between xixi​ and yiyi​. Each pair of vertices is connected by at most one edge, and no vertex is connected to itself.
 * <p>
 * Determine whether a valid path exists from the source vertex to the destination vertex. If it exists, return TRUE, otherwise return FALSE.
 */
public class CheckPathExists2Vertices {

    public static void main(String[] args) {
        int[] n = {3, 4, 6, 5, 7};
        int[][][] edges = {
                {{0, 1}, {1, 2}},
                {{0, 1}, {0, 3}},
                {{0, 1}, {1, 2}, {1, 3}, {1, 4}, {3, 5}},
                {{0, 3}, {1, 3}, {2, 4}},
                {{0, 6}, {1, 5}, {1, 4}, {2, 4}, {2, 5}, {2, 6}, {3, 4}, {3, 6}, {4, 5}, {5, 6}}
        };
        int[] sources = {2, 0, 0, 3, 5};
        int[] destinations = {0, 2, 5, 4, 3};

        for (int i = 0; i < edges.length; i++) {
            System.out.println((i+1) + ".\tn: " + n[i]);
            System.out.println("\tEdges: " + Arrays.deepToString(edges[i]));
            System.out.println("\tSource: " + sources[i]);
            System.out.println("\tDestination: " + destinations[i]);
            System.out.println("\tPath exists: " + checkPath(n[i], edges[i], sources[i], destinations[i]));

            StringBuilder dashes = new StringBuilder();
            for (int k = 0; k < 100; k++) {
                dashes.append("-");
            }
            System.out.println(dashes.toString());
        }
    }
/*In this solution, we use the breadth-first search (BFS) approach to determine if a path exists from the source vertex to the destination vertex in a given graph. To do this, we represent the graph using an adjacency matrix where adjacency[i][j] is 1 if there is an edge between vertex i and vertex j, and 0 otherwise.

We use a queue to store the nodes to explore, and a set to store the nodes that have been visited. We start by pushing the source node to the queue, and while there are still vertices to explore in the queue, we will repeat the following steps:

    Dequeue a vertex from the queue.

    Check if this vertex is the destination we’re looking for. If it is, there’s a path from the source to the destination, and we return TRUE.

    Otherwise, we visit all of its neighboring vertices using the adjacency matrix of the graph:

        If any of these neighbors haven’t been visited yet, add them to the queue to explore later, mark them as visited so we don’t explore them again, and continue the breadth-first search.

If we’ve explored all possible paths from the source vertex and still haven’t found the destination, then there’s no path from the source to the destination, and we return FALSE.*/
    public static boolean checkPath(int n, int[][] edges, int source, int destination) {

        // Replace this placeholder return statement with your code
        Set<String> visitedEdge=new HashSet<>();
        Queue<Integer> bfsQueue=new LinkedList<>();
        for(int i=0;i<edges.length;i++){
            if(source==edges[i][0])
                bfsQueue.add(i);
        }

        while(!bfsQueue.isEmpty()){
            int currIndex=bfsQueue.poll();
            if(edges[currIndex][1] == destination)
                return true;
            if(visitedEdge.contains(edges[currIndex][0]+""+edges[currIndex][1]))
                continue;
            addAdjNodesToQueue(bfsQueue,edges[currIndex][1],edges);
            visitedEdge.add(edges[currIndex][0]+""+edges[currIndex][1]);
        }

        return false;
    }

    public static void addAdjNodesToQueue(Queue<Integer> bfsQueue,int source, int[][] edges ){
        for(int i=0;i<edges.length;i++){
            if(source==edges[i][0])
                bfsQueue.add(i);
        }
    }
}
