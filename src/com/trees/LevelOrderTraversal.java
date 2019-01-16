package com.trees;

import java.util.LinkedList;
import java.util.Queue;

import com.trees.TreeBasic.BinarySearchTree;
import com.trees.TreeBasic.Node;

/**
 * Given root of a binary tree, display node values at each level. Node values
 * for all levels should be displayed on separate lines.
 * 
 * BSTree: 
 *  	100
 *     /   \
 *    50 	200
 *   / \	  \
 *  25  75     350 
 *    
 *  Level order traversal for this tree should look like:
 *  100
 *  50, 200
 *  25, 75, 350  
 */
public class LevelOrderTraversal {

	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.add(100);
		binarySearchTree.add(50);
		binarySearchTree.add(200);
		binarySearchTree.add(25);
		binarySearchTree.add(75);
		binarySearchTree.add(350);
		
		printLevelOrder(binarySearchTree.root);
		
	}

	private static void printLevelOrder(Node root) {
		Queue<Node> mainQ = new LinkedList<>();
		Queue<Node> levelDataQ = new LinkedList<>();

		if (root != null) {
			levelDataQ.add(root);
		}

		while (!levelDataQ.isEmpty() || !mainQ.isEmpty()) {
			if(!levelDataQ.isEmpty()) {
			Node curr = levelDataQ.poll();
			if (curr.left != null)
				mainQ.add(curr.left);
			if (curr.right != null)
				mainQ.add(curr.right);
			System.out.print(curr.data+" ");
			}else {
				System.out.println();
				levelDataQ.addAll(mainQ);
				mainQ=new LinkedList<>();
			}
		}

	}
}
