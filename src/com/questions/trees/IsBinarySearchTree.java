package com.questions.trees;

import com.questions.trees.TreeBasic.BinarySearchTree;
import com.questions.trees.TreeBasic.Node;

/**
 * Given a binary tree, figure out whether it's a BST.
 * 
 * BSTree: 
 *  	100
 *     /   \
 *    50 	200
 *   / \	  \
 *  25  75     350 
 *  
 * O/P -> True
 * 
 * BSTree: 
 *  	 100
 *     /    \
 *    50 	 200
 *   / \	 / \
 *  25  75   90  350
 *  
 * O/P -> false, coz 90 > 100
 *   
 */
public class IsBinarySearchTree {
	
	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.add(100);
		binarySearchTree.add(50);
		binarySearchTree.add(200);
		binarySearchTree.add(25);
		binarySearchTree.add(75);
		binarySearchTree.add(350);
		
		boolean isValid=isValidBST(binarySearchTree.root);
		System.out.println(isValid);
	}

	static Node lastVisited=null;

	/**
	 * We keep track of lastVisitedNode and check for successor node to be greater than lastVisitedNode.
	 * 
	 *  If not, tree is not BST
	 */
	private static boolean isValidBST(Node root) {
		if (root == null) {
			return true;
		}
		if (!isValidBST(root.left)) {
			return false;
		}
		if (lastVisited != null && lastVisited.data >= root.data) {
			return false;
		}
		lastVisited = root;
		if (!isValidBST(root.right)) {
			return false;
		}

		return true;
	}

}
