package com.DataStructures_And_Questions.graph;

import com.DataStructures_And_Questions.graph.directed.adjlist.implmentation.copy.DirectedGraphAdjacencyListImplementation;
import com.datastructures.Graph.directed.adjlist.implmentation.copy.DirectedGraphAdjacencyList;

import java.util.List;

/**
 * Given an adjacency list of a directed graph consisting of n vertices,
 * modify the list after removing an edge between the source and destination vertices.
 */
public class RemoveEdgeFromDirectedGraph {

    public static void main(String[] args) {

    }

    static DirectedGraphAdjacencyListImplementation removeEdge(DirectedGraphAdjacencyListImplementation graph, int source, int destination) {
        DirectedGraphAdjacencyListImplementation result = new DirectedGraphAdjacencyListImplementation(new DirectedGraphAdjacencyList(0));

        // Replace this placeholder return statement with your code
        List<Integer> adjList=graph.getGraph().getAdjacencyListArray()[source];
        removeNode(adjList, destination);
        return graph;
    }

    public static void removeNode(List<Integer> adjList, int destination){
        adjList.remove(destination);
    }
}
