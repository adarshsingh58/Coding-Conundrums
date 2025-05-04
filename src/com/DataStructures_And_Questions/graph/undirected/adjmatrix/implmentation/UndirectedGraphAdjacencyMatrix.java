package com.datastructures.Graph.undirected.adjmatrix.implmentation;

public class UndirectedGraphAdjacencyMatrix {
    private final int MAX_NODES;
    private int[][] graph;

    public UndirectedGraphAdjacencyMatrix(int MAX_NODES) {
        this.MAX_NODES = MAX_NODES;
        graph = new int[this.MAX_NODES][this.MAX_NODES];// coz number of rows and columns are euqal to number of vericies
    }

    public int[][] getGraph() {
        return graph;
    }

    public void setGraph(int[][] graph) {
        this.graph = graph;
    }

}
