package com.DataStructures_And_Questions.trees;

import com.DataStructures_And_Questions.trees.BST.BinarySearchTree;
import com.DataStructures_And_Questions.trees.BST.BinarySearchTree.Node;

public class CheckIdenticalBTree {
    public static void main(String[] args) {
        BinarySearchTree bst1 = new BinarySearchTree();
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
        BinarySearchTree bst2 = new BinarySearchTree();
        bst2.add(50);
        bst2.add(35);
        bst2.add(70);
        bst2.add(20);
        bst2.add(40);
        bst2.add(60);
        bst2.add(80);
        bst2.add(32);
        bst2.add(65);
        bst2.add(75);
        bst2.add(85);
        bst2.add(34);
        bst2.add(36);
        boolean isIdentical = isIdentical(bst2, bst1);
        System.out.println(isIdentical);
    }

    private static boolean isIdentical(BinarySearchTree bst1, BinarySearchTree bst2) {
        return inOrderCheck(bst1.root, bst2.root);
    }

    private static boolean inOrderCheck(Node root1, Node root2) {
        if (root2 == null && root1 == null) {
            return true;
        } else if (root2 == null || root1 == null) {
            return false;
        }

        boolean a = inOrderCheck(root1.left, root2.left);
        if (root1.data != root2.data) {
            return false;
        }
        boolean b = inOrderCheck(root1.right, root2.right);

        if (a && b)
            return true;
        else
            return false;
    }

}
