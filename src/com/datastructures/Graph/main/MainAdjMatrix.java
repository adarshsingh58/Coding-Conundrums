package com.datastructures.Graph.main;

import com.datastructures.Graph.undirected.adjmatrix.implmentation.UndirectedGraphAdjacencyMatrix;
import com.datastructures.Graph.undirected.adjmatrix.implmentation.UndirectedGraphAdjacencyMatrixImplementation;

public class MainAdjMatrix {
    // Driver program to test above functions
    public static void main(String args[]) {
        // create the graph given in above figure
        int V = 5;
        UndirectedGraphAdjacencyMatrix graph = new UndirectedGraphAdjacencyMatrix(V);
        UndirectedGraphAdjacencyMatrixImplementation graphImpl = new UndirectedGraphAdjacencyMatrixImplementation(graph);
        graphImpl.addVertex(0, 1);
        graphImpl.addVertex(0, 4);
        graphImpl.addVertex(1, 2);
        graphImpl.addVertex(1, 3);
        graphImpl.addVertex(1, 4);
        graphImpl.addVertex(2, 3);
        graphImpl.addVertex(3, 4);

        // print the adjacency list representation of 
        // the above graph
        printGraph(graph);

        System.out.println(graphImpl.isVertex(3, 0));
    }

    // A utility function to print the adjacency list 
    // representation of graph
    static void printGraph(UndirectedGraphAdjacencyMatrix graph) {
        for (int v = 0; v < graph.getGraph().length; v++) {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for (Integer pCrawl : graph.getGraph()[v]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println("\n");
        }
    }

}
