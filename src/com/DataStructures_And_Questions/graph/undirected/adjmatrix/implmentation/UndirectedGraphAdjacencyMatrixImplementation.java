package com.DataStructures_And_Questions.graph.undirected.adjmatrix.implmentation;


import com.DataStructures_And_Questions.graph.abstraction.GraphInterface;

public class UndirectedGraphAdjacencyMatrixImplementation implements GraphInterface {

    private com.datastructures.Graph.undirected.adjmatrix.implmentation.UndirectedGraphAdjacencyMatrix graph;

    public UndirectedGraphAdjacencyMatrixImplementation(com.datastructures.Graph.undirected.adjmatrix.implmentation.UndirectedGraphAdjacencyMatrix graph) {
        this.graph = graph;

    }

    public void addEdge(int src, int dest) {
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
