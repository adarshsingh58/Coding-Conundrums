package com.datastructures.Graph.traversal;

import com.graph.directed.adjlist.implmentation.copy.DirectedGraphAdjacencyList;
import com.graph.undirected.adjlist.implmentation.UndirectedGraphAdjacencyList;
import com.graph.undirected.adjlist.implmentation.UndirectedGraphAdjacencyListImplementation;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public static void traverse(DirectedGraphAdjacencyList graph, int startingPoint) {
        int currentNode=startingPoint;
        int[] visited = new int[graph.getMAX_VERTICIES()];
        int count=0;
        Queue<Integer> queue=new LinkedList<>();
        List<Integer>[] adjacencyListArray= graph.getAdjacencyListArray();

        queue.add(currentNode);
        while(!queue.isEmpty() && count<graph.getMAX_VERTICIES()){
            currentNode = queue.poll();
            if(visited[currentNode]==0){
            visited[currentNode]=1;
            System.out.println(currentNode);
            count++;

           queue.addAll(adjacencyListArray[currentNode]);
            }
        }
    }
}
