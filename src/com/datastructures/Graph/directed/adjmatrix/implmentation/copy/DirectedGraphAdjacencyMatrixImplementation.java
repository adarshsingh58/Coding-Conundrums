package com.datastructures.Graph.directed.adjmatrix.implmentation.copy;

import com.graph.abstraction.GraphInterface;
import com.graph.directed.adjlist.implmentation.copy.DirectedGraphAdjacencyList;

public class DirectedGraphAdjacencyMatrixImplementation implements GraphInterface {

	private DirectedGraphAdjacencyMatrix graph;

	public DirectedGraphAdjacencyMatrixImplementation(DirectedGraphAdjacencyMatrix graph) {
		this.graph = graph;

	}

	public void addVertex(int src, int dest) {
		this.graph.getGraph()[src][dest]=1;
	}

	@Override
	public boolean isVertex(int src, int dest) {
		if(this.graph.getGraph()[src][dest]==1) {
			return true;
		}
		return false;
	}
}
