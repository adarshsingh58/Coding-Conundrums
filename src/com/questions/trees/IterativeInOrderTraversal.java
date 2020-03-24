package com.questions.trees;

import com.questions.trees.TreeBasic.BinarySearchTree;
import com.questions.trees.TreeBasic.Node;

import java.util.Stack;

/**
 * Given a binary tree, write an iterative algorithm to traverse the tree
 * inorder
 */
public class IterativeInOrderTraversal {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(7);
        binarySearchTree.add(5);
        binarySearchTree.add(30);
        binarySearchTree.add(2);
        binarySearchTree.add(9);

        binarySearchTree.inOrderTraversal();

        iterativeInorderTraversal(binarySearchTree);
    }

    private static void iterativeInorderTraversal(BinarySearchTree binarySearchTree) {
        Stack<Node> stack = new Stack<>();

        Node curr = binarySearchTree.root;
        while (!stack.isEmpty() || curr != null) {

            if (curr != null) {// adding all the left nodes to stack
                stack.push(curr);
                curr = curr.left;
                continue;
            }
            // when curr is null, we have left most element in stack, we print it and if it
            // has a right node, we push it to stack
            System.out.println(stack.peek().data);
            curr = stack.pop();
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = null;
            }

        }

    }

}
