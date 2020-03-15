package com.datastructures.Graph.directed.adjmatrix.implmentation.copy;

public class DirectedGraphAdjacencyMatrix {
	private final int MAX_NODES;
	private int[][] graph;
	
	public DirectedGraphAdjacencyMatrix(int MAX_NODES) {
		this.MAX_NODES=MAX_NODES;
		graph=new int[this.MAX_NODES][this.MAX_NODES];// coz number of rows and columns are euqal to number of vericies
	}

	public int[][] getGraph() {
		return graph;
	}

	public void setGraph(int[][] graph) {
		this.graph = graph;
	}
	
}
