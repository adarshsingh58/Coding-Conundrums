package com.datastructures.Graph.main;

import com.datastructures.Graph.undirected.adjlist.implmentation.UndirectedGraphAdjacencyList;
import com.datastructures.Graph.undirected.adjlist.implmentation.UndirectedGraphAdjacencyListImplementation;

public class MainAdjList {

    // Driver program to test above functions
    public static void main(String args[]) {
        // create the graph given in above figure
        int V = 5;
        UndirectedGraphAdjacencyList graph = new UndirectedGraphAdjacencyList(V);
        UndirectedGraphAdjacencyListImplementation graphImpl = new UndirectedGraphAdjacencyListImplementation(graph);
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
