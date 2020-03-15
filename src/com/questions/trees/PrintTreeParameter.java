package com.questions.trees;

import java.util.Stack;

import com.questions.trees.TreeBasic.BinarySearchTree;
import com.questions.trees.TreeBasic.Node;

/**
 * Given the root node of a binary tree, print nodes forming the boundary
 * (perimeter). Given the root node of a binary tree, print nodes forming the
 * boundary (perimeter).
 * 
 * In the following tree, the highlighted nodes form the perimeter. The expected
 * output for the below tree would be 1, 2, 4, 9, 8, 10, 7, 3.
 *
 * 					1
 * 				/		\
 * 			  2		     3
 * 			/   \		/ 
 * 			4   5       7
 * 		   /     \     /
 * 		  9 	 8		10
 * 
 * 5 is not the perimeter as it resides inside.	
 * 
 * NOTE: Perimeter should be printed anti clockwise, i.e. right side should be printed bottoms up
 */
public class PrintTreeParameter {

	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.add(50);
		binarySearchTree.add(40);
		binarySearchTree.add(60);
		binarySearchTree.add(35);
		binarySearchTree.add(45);
		binarySearchTree.add(30);
		binarySearchTree.add(37);
		binarySearchTree.add(42);
		binarySearchTree.add(55);
		binarySearchTree.add(63);
		binarySearchTree.add(51);
		binarySearchTree.add(57);
		binarySearchTree.add(70);
		
		printPerimeter(binarySearchTree.root);
	}

	private static void printPerimeter(Node root) {
		if (root != null) {
			System.out.println(root.data);
			printLeftEdges(root.left);
			printLeafNodes(root);
			printRightEdges(root.right,true);
		}
	}

	private static void printLeftEdges(Node root) {

		if(root!=null && !root.isLeafNode()) {// Not printing the leaf nodes
			System.out.println(root.data);
		}
		if(root.left!=null) {
			printLeftEdges(root.left);
		}else if(root.right!=null) {
			printLeftEdges(root.right);
		} else {//for leaf nodes, skip
			
		}
	}

	private static void printLeafNodes(Node root) {
		if (root.left == null && root.right == null) {
			System.out.println(root.data);
		} else if (root.left == null) {
			printLeafNodes(root.right);
		} else if (root.right == null) {
			printLeafNodes(root.left);
		}else {
			printLeafNodes(root.left);
			printLeafNodes(root.right);
		}
	}

	private static void printRightEdges(Node root,boolean printBottomUp) {
		if(printBottomUp) {
			Stack<Node> stack=new Stack<>();
			printRightEdges_BottomsUp(root,stack);
			while(!stack.isEmpty()) {
				System.out.println(stack.pop().data);
			}
		}else {
		if(root!=null && !root.isLeafNode()) {
			System.out.println(root.data);
		}
		if(root.right!=null) {
			printRightEdges(root.right,false);
		}else if(root.left!=null) {
			printRightEdges(root.left,false);
		}
		}
	}
	private static void printRightEdges_BottomsUp(Node root, Stack<Node> stack) {
		if(root!=null && (!root.isLeafNode())) {
			stack.push(root);
		}
		if(root.right!=null) {
			printRightEdges_BottomsUp(root.right,stack);
		}else if(root.left!=null) {
			printRightEdges_BottomsUp(root.left,stack);
		}
		
	}
}
