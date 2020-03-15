package com.datastructures.BST;

public class Main {
    /*                            50
                             /         \
    *                     30              70
    *                  /     \         /      \
    *                20       40     60        80
    *                        /         \       /  \
    *                      32           65    75     85
    *                        \
    *                         34
    *                           \
    *                            36
    *
    *
    * */
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(50);
        binarySearchTree.add(30);
        binarySearchTree.add(70);
        binarySearchTree.add(20);
        binarySearchTree.add(40);
        binarySearchTree.add(60);
        binarySearchTree.add(80);
        binarySearchTree.add(32);
        binarySearchTree.add(65);
        binarySearchTree.add(75);
        binarySearchTree.add(85);
        binarySearchTree.add(34);
        binarySearchTree.add(36);

        binarySearchTree.delete(30);
        binarySearchTree.inOrderTraversal();// Inorder traversal of BST gives you sorted order.
    }

    private static void printNode(BinarySearchTree binarySearchTree) {
        System.out.println(binarySearchTree.root.data);
    }

}