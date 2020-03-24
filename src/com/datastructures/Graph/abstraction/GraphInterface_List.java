package com.datastructures.Graph.abstraction;

import com.graph.directed.adjlist.implmentation.copy.DirectedGraphAdjacencyList;

public interface GraphInterface_List {

    public void addVertex(int src, int dest);

    public boolean isVertex(int src, int dest);

    public DirectedGraphAdjacencyList getGraph();
}
