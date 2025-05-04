package com.DataStructures_And_Questions.trees;

import com.DataStructures_And_Questions.trees.BST.BinarySearchTree;

public class CheckIfTreeIsBalanced {

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(7);
        binarySearchTree.add(5);
        binarySearchTree.add(30);
        binarySearchTree.add(2);
        binarySearchTree.add(9);

        boolean isBalanced = isBalanced(binarySearchTree);
        System.out.println(isBalanced);
    }

    private static boolean isBalanced(BinarySearchTree binarySearchTree) {

        return false;
    }


}
