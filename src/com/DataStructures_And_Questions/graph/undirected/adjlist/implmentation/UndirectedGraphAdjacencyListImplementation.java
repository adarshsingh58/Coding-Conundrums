package com.DataStructures_And_Questions.graph.undirected.adjlist.implmentation;

import com.DataStructures_And_Questions.graph.abstraction.GraphInterface;
import com.datastructures.Graph.undirected.adjlist.implmentation.UndirectedGraphAdjacencyList;

import java.util.List;

public class UndirectedGraphAdjacencyListImplementation implements GraphInterface {

    private com.datastructures.Graph.undirected.adjlist.implmentation.UndirectedGraphAdjacencyList graph;

    public UndirectedGraphAdjacencyListImplementation(com.datastructures.Graph.undirected.adjlist.implmentation.UndirectedGraphAdjacencyList graph) {
        this.graph = graph;
    }

    public void addEdge(int src, int dest) {
        graph.getAdjacencyListArray()[src].add(dest);
        // because this is an undirected graph, vertext from src to dest would also
        // mean a vertex from dest to src
        graph.getAdjacencyListArray()[dest].add(src);

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

    public UndirectedGraphAdjacencyList getGraph() {
        return graph;
    }
}
