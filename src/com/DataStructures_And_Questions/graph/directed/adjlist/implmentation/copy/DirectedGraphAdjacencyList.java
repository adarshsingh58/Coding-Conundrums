package com.datastructures.Graph.directed.adjlist.implmentation.copy;

import java.util.LinkedList;
import java.util.List;

/**
 * This is the Adjacency Matrix Representataion of Graph
 */
public class DirectedGraphAdjacencyList {

    private final int MAX_VERTICIES;
    private List<Integer>[] adjacencyListArray;

    public DirectedGraphAdjacencyList(int MAX_VERTICIES) {
        this.MAX_VERTICIES = MAX_VERTICIES;
        this.adjacencyListArray = new List[this.MAX_VERTICIES];

        for (int i = 0; i < this.MAX_VERTICIES; i++) {
            adjacencyListArray[i] = new LinkedList<>();
        }
    }

    public List<Integer>[] getAdjacencyListArray() {
        return adjacencyListArray;
    }

    public void setAdjacencyListArray(List<Integer>[] adjacencyList) {
        this.adjacencyListArray = adjacencyList;
    }

    public int getMAX_VERTICIES() {
        return MAX_VERTICIES;
    }

}
