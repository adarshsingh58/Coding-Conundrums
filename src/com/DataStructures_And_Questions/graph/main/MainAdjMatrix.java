package com.DataStructures_And_Questions.graph.main;

import com.DataStructures_And_Questions.graph.undirected.adjmatrix.implmentation.UndirectedGraphAdjacencyMatrixImplementation;
import com.datastructures.Graph.undirected.adjmatrix.implmentation.UndirectedGraphAdjacencyMatrix;

public class MainAdjMatrix {
    // Driver program to test above functions
    public static void main(String args[]) {
        // create the graph given in above figure
        int V = 5;
        UndirectedGraphAdjacencyMatrix graph = new UndirectedGraphAdjacencyMatrix(V);
        UndirectedGraphAdjacencyMatrixImplementation graphImpl = new UndirectedGraphAdjacencyMatrixImplementation(graph);
        graphImpl.addEdge(0, 1);
        graphImpl.addEdge(0, 4);
        graphImpl.addEdge(1, 2);
        graphImpl.addEdge(1, 3);
        graphImpl.addEdge(1, 4);
        graphImpl.addEdge(2, 3);
        graphImpl.addEdge(3, 4);

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
