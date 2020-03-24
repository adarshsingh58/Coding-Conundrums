package com.questions.trees;

import com.questions.trees.TreeBasic.BinarySearchTree;
import com.questions.trees.TreeBasic.Node;

/**
 * Given a tree like:
 * <p>
 * 1
 * /		\
 * 2		     9
 * /   \		/
 * 4   5       7
 * /     \     /
 * 9 	 8	  10
 * <p>
 * OR
 * 1
 * /		 \
 * 2		      3
 * /   \		 /
 * 4   5        7
 * /     \     /  \
 * 9 	 8	   11  10
 * <p>
 * OR
 * <p>
 * 1
 * /		\
 * 2		     3
 * /   \		  \
 * 4   5          7
 * /     \        /
 * 9 	 8	    10
 * <p>
 * Print its top view. In top view all edge elements will br printed.
 * O/P -> 1 2 4 9 3 7 10
 * <p>
 * If the tree were like:
 * <p>
 * 1
 * /		 \
 * 2		      3
 * /   \		 /
 * 4   5        7
 * /     \     /  \
 * 9 	 8	   11  10
 */
public class PrintTopViewOfTree {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(50);
        binarySearchTree.add(200);
        binarySearchTree.add(25);
        binarySearchTree.add(75);
        binarySearchTree.add(350);

        printTopView(binarySearchTree.root);
    }

    /**
     * If we were to print top view strictly, then only all the left and the right elements will be printed.
     * That way we call simply print all the root.left recursively and root.right recursively, where root is the main root.
     * But here, we want all the edge nodes in top view.
     */
    private static void printTopView(Node root) {
        if (root != null) {
            System.out.println(root.data);
        }

        printTopViewLeft(root.left);
        printTopViewRight(root.right);
    }

    private static void printTopViewLeft(Node left) {
        if (left != null) {
            System.out.println(left.data);
        }
        if (left.left != null) {
            printTopViewLeft(left.left);
        } else if (left.right != null) {
            printTopViewLeft(left.right);
        }
    }

    private static void printTopViewRight(Node right) {

        if (right != null) {
            System.out.println(right.data);
        }
        if (right.right != null) {
            printTopViewRight(right.right);
        } else if (right.left != null) {
            printTopViewLeft(right.left);
        }
    }

}
