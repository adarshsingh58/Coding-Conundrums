package com.DataStructures_And_Questions.graph.directed.adjmatrix.implmentation.copy;


import com.DataStructures_And_Questions.graph.abstraction.GraphInterface;

public class DirectedGraphAdjacencyMatrixImplementation implements GraphInterface {

    private com.datastructures.Graph.directed.adjmatrix.implmentation.copy.DirectedGraphAdjacencyMatrix graph;

    public DirectedGraphAdjacencyMatrixImplementation(com.datastructures.Graph.directed.adjmatrix.implmentation.copy.DirectedGraphAdjacencyMatrix graph) {
        this.graph = graph;

    }

    public void addEdge(int src, int dest) {
        this.graph.getGraph()[src][dest] = 1;
    }

    @Override
    public boolean isVertex(int src, int dest) {
        if (this.graph.getGraph()[src][dest] == 1) {
            return true;
        }
        return false;
    }
}
