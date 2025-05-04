package com.DataStructures_And_Questions.graph.main;

import com.DataStructures_And_Questions.graph.undirected.adjlist.implmentation.UndirectedGraphAdjacencyListImplementation;
import com.datastructures.Graph.undirected.adjlist.implmentation.UndirectedGraphAdjacencyList;

public class MainAdjList {

    // Driver program to test above functions
    public static void main(String args[]) {
        // create the graph given in above figure
        int V = 5;
        UndirectedGraphAdjacencyList graph = new UndirectedGraphAdjacencyList(V);
        UndirectedGraphAdjacencyListImplementation graphImpl = new UndirectedGraphAdjacencyListImplementation(graph);
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
    static void printGraph(UndirectedGraphAdjacencyList graph) {
        for (int v = 0; v < graph.getAdjacencyListArray().length; v++) {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for (Integer pCrawl : graph.getAdjacencyListArray()[v]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println("\n");
        }
    }

}
