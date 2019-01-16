package com.trees;

import com.trees.TreeBasic.BinarySearchTree;
import com.trees.TreeBasic.Node;

/**
 * Inorder successor of a node in binary Search Tree (BST) is the next node in
 * inorder traversal. Write a method to find the inorder successor of a given
 * value "d" in a BST
 * 
 */
public class InorderSuccessorBST {

	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.add(7);
		binarySearchTree.add(5);
		binarySearchTree.add(30);
		binarySearchTree.add(2);
		binarySearchTree.add(9);

		int x = findInorderSuccessor(binarySearchTree.root, 5);
		System.out.println(x);
	}

	private static int findInorderSuccessor(Node root, int input) {
		if (root.data == input) {
			if (root.right == null) {
				return root.parent.data;
			} else if (root.right.left == null) {
				return root.right.data;
			} else {
				while (root.left != null) {
					root = root.left;
				}
				return root.data;
			}
		} else if (input < root.data) {
			return findInorderSuccessor(root.left, input);
		} else {
			return findInorderSuccessor(root.right, input);
		}

	}
}
