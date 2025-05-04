package com.DataStructures_And_Questions.trees;

import com.DataStructures_And_Questions.trees.ConnectAllSiblings.BinarySearchTree;
import com.DataStructures_And_Questions.trees.ConnectAllSiblings.Node;

/**
 * Given the root node of a binary tree, swap the 'left' and 'right' children
 * for each node.
 */
public class MirrorBinaryTreeNodes {
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
        mirrorBTree(bst1.root);
    }

    private static void mirrorBTree(Node root) {
        if (root.isLeafNode()) {
            return;
        }
        if (root.left != null) {
            mirrorBTree(root.left);
        }
        if (root.right != null) {
            mirrorBTree(root.right);
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

    }
}
