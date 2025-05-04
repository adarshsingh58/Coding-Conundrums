package com.DataStructures_And_Questions.trees;

import com.DataStructures_And_Questions.trees.BST.BinarySearchTree;
import com.DataStructures_And_Questions.trees.BST.BinarySearchTree.Node;

public class FindHeightOfBinaryTree {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(7);
        binarySearchTree.add(5);
        binarySearchTree.add(30);
        binarySearchTree.add(2);
        binarySearchTree.add(9);

        int height = findHeight(binarySearchTree);
        System.out.println(height);
    }

    private static int findHeight(BinarySearchTree binarySearchTree) {
        return findHeight(binarySearchTree.root);
    }

    private static int findHeight(Node node) {
        if (node == null || node.left == null && node.right == null) {
            return 0;
        }
        return 1 + Math.max(findHeight(node.left), findHeight(node.right));
    }
}
