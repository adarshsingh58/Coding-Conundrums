package com.datastructures.Graph.undirected.adjmatrix.implmentation;

import com.graph.abstraction.GraphInterface;

public class UndirectedGraphAdjacencyMatrixImplementation implements GraphInterface {

    private UndirectedGraphAdjacencyMatrix graph;

    public UndirectedGraphAdjacencyMatrixImplementation(UndirectedGraphAdjacencyMatrix graph) {
        this.graph = graph;

    }

    public void addVertex(int src, int dest) {
        this.graph.getGraph()[src][dest] = 1;
        this.graph.getGraph()[dest][src] = 1;// because the graph is undirected hence vertex is added both ways

    }

    @Override
    public boolean isVertex(int src, int dest) {
        if (this.graph.getGraph()[src][dest] == 1) {
            return true;
        }
        return false;
    }

}
