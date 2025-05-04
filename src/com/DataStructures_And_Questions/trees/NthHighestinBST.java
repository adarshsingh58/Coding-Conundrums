package com.DataStructures_And_Questions.trees;

import com.DataStructures_And_Questions.trees.ConnectAllSiblings.BinarySearchTree;
import com.DataStructures_And_Questions.trees.ConnectAllSiblings.Node;

/**
 * We are given a Binary Search Tree(BST) and a node number n. We have to find
 * the node with nth highest value.
 */
public class NthHighestinBST {
    public static void main(String[] args) {
        BinarySearchTree bst1 = new ConnectAllSiblings().new BinarySearchTree();
        bst1.add(50);
        bst1.add(30);
        bst1.add(70);
        bst1.add(20);
        bst1.add(40);
        bst1.add(60);
        bst1.add(80);
        bst1.add(32);
        bst1.add(65);
        bst1.add(75);
        bst1.add(85);
        bst1.add(34);
        bst1.add(36);

        int n = 4;
        getNthHighest(bst1.root, n);
    }

    private static void getNthHighest(Node root, int n) {
//        reverseInorder(root, n);
    }
}
