package com.datastructures.Graph.undirected.adjlist.implmentation;

import java.util.LinkedList;
import java.util.List;

/**
 * This is the Adjacency List Representataion of Graph
 */
public class UndirectedGraphAdjacencyList {

	private final int MAX_VERTICIES;
	private List<Integer>[] adjacencyListArray;

	public UndirectedGraphAdjacencyList(int MAX_VERTICIES) {
		this.MAX_VERTICIES = MAX_VERTICIES;
		this.adjacencyListArray=new List[this.MAX_VERTICIES];
		
		for(int i=0;i<this.MAX_VERTICIES;i++) {
			adjacencyListArray[i]=new LinkedList<>();
		}
	}

	public List<Integer>[] getAdjacencyListArray() {
		return adjacencyListArray;
	}

	public void setAdjacencyListArray(List<Integer>[] adjacencyList) {
		this.adjacencyListArray = adjacencyList;
	}

	public int getMAX_VERTICIES(){
		return MAX_VERTICIES;
	}
	
}
