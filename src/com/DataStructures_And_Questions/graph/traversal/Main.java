package com.DataStructures_And_Questions.graph.traversal;

import com.DataStructures_And_Questions.graph.directed.adjlist.implmentation.copy.DirectedGraphAdjacencyListImplementation;
import com.datastructures.Graph.directed.adjlist.implmentation.copy.DirectedGraphAdjacencyList;

public class Main {

    public static void main(String[] args) {

        // create the graph given in above figure
        int V = 4;
        DirectedGraphAdjacencyList graph = new DirectedGraphAdjacencyList(V);
        DirectedGraphAdjacencyListImplementation graphImpl = new DirectedGraphAdjacencyListImplementation(graph);
        graphImpl.addVertex(0, 1);
        graphImpl.addVertex(0, 2);
        graphImpl.addVertex(1, 2);
        graphImpl.addVertex(2, 3);
        graphImpl.addVertex(2, 0);
        graphImpl.addVertex(3, 3);

        //Traversal via BFS
        System.out.println("Traversal via BFS");
        com.datastructures.Graph.traversal.BFS.traverse(graphImpl.getGraph(), 2);

        System.out.println(" \n \n Traversal via DFS");
        com.datastructures.Graph.traversal.DFS.traverse(graphImpl.getGraph(), 2);
    }
//
//    graphImpl.addVertex(0, 1);
//        graphImpl.addVertex(0, 2);
//        graphImpl.addVertex(1,3);
//        graphImpl.addVertex(2,3);
//        graphImpl.addVertex(2,4);
}
