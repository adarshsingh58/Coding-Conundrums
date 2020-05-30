package com.datastructures.Graph.directed.adjlist.implmentation.copy;

import com.datastructures.Graph.abstraction.GraphInterface_List;

import java.util.List;

public class DirectedGraphAdjacencyListImplementation implements GraphInterface_List {

    private DirectedGraphAdjacencyList graph;

    public DirectedGraphAdjacencyListImplementation(DirectedGraphAdjacencyList graph) {
        this.graph = graph;
    }

    public void addVertex(int src, int dest) {
        graph.getAdjacencyListArray()[src].add(dest);
    }

    @Override
    public boolean isVertex(int src, int dest) {
        List<Integer> sourceList = this.graph.getAdjacencyListArray()[src];
        for (int nodeValue : sourceList) {
            if (nodeValue == dest) {
                return true;
            }
        }
        return false;
    }

    public DirectedGraphAdjacencyList getGraph() {
        return graph;
    }

}
