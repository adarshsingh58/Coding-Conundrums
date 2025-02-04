package com.DataStructures_And_Questions.graph;

import com.DataStructures_And_Questions.graph.undirected.adjlist.implmentation.UndirectedGraphAdjacencyListImplementation;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Given an n number of nodes in an undirected graph, compute the total number of edges.
 * <p>
 * Constraints:
 * <p>
 * 0≤0≤n≤102≤102
 * <p>
 * 0≤0≤edges.length ≤n(n−1)/2≤n(n−1)/2
 * <p>
 * edges[i].length ==2==2
 * <p>
 * 1≤x,y≤1≤x,y≤n
 * <p>
 * x≠yx=y
 * <p>
 * There are no multiple edges between any two vertices
 * <p>
 * There are no self-loops
 */
public class CountEdgesUndirectedGraph {

    public static void main(String[] args) {
        List<List<List<Integer>>> edges = Arrays.asList(
                Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2)),
                Arrays.asList(Arrays.asList(0, 1), Arrays.asList(0, 3), Arrays.asList(1, 2)),
                Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(1, 4), Arrays.asList(3, 5)),
                Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 3), Arrays.asList(2, 4), Arrays.asList(3, 2)),
                Arrays.asList(Arrays.asList(0, 6), Arrays.asList(1, 5), Arrays.asList(1, 4), Arrays.asList(2, 4), Arrays.asList(2, 5), Arrays.asList(2, 6), Arrays.asList(3, 4), Arrays.asList(3, 6), Arrays.asList(4, 5), Arrays.asList(5, 6))
        );

        Random rand = new Random();

        for (int i = 0; i < edges.size(); ++i) {
            int vertices = countVertices(edges.get(i));
            UndirectedGraphAdjacencyListImplementation g = new UndirectedGraphAdjacencyListImplementation(new com.datastructures.Graph.undirected.adjlist.implmentation.UndirectedGraphAdjacencyList(vertices));
            List<Integer> edge = edges.get(i).get(rand.nextInt(edges.get(i).size()));
            for (List<Integer> e : edges.get(i)) {
                g.addEdge(e.get(0), e.get(1));
            }

            System.out.println("\nTotal edges: " + countEdges(g) + "\n");
        }
    }

    static int countVertices(List<List<Integer>> edges) {
        int vertices = 0;
        for (List<Integer> edge : edges) {
            for (Integer vertex : edge) {
                vertices = Math.max(vertices, vertex);
            }
        }
        return vertices + 1;
    }

    /*This approach iterates over each vertex in the graph and calculates the sum of the lengths of adjacency lists corresponding to each vertex.
    The idea is to count the number of connections or edges in the graph. Dividing the final sum by 22 ensures that each edge is counted only once
    because, in an undirected graph, each edge is represented twice (once for each vertex it connects). Therefore, dividing by 22 gives the actual
    count of edges in the graph. This method effectively traverses the adjacency list representation of the graph to determine the total number of
    edges.*/
    public static int countEdges(UndirectedGraphAdjacencyListImplementation graph) {

        // Replace this placeholder return statement with your code
        int count = 0;
        for (List<Integer> l : graph.getGraph().getAdjacencyListArray()) {
            count = count + l.size();
        }

        return count / 2;
    }
}
