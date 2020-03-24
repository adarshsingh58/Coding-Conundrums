package com.questions.trees;

import com.questions.trees.TreeBasic.BinarySearchTree;
import com.questions.trees.TreeBasic.Node;

/**
 * Given root of a binary tree, delete any subtrees whose nodes sum up to zero.
 * <p>
 * 7
 * /   \
 * 5		6
 * / \
 * -3   -2
 * <p>
 * O/P
 * <p>
 * 7
 * \
 * 6
 */
public class DeleteZeroSumSubtrees {
    public static void main(String[] args) {
        BinarySearchTree bst1 = new BinarySearchTree();
        bst1.add(8);
        bst1.add(-2);
        bst1.add(10);
        bst1.add(-5);
        bst1.add(7);

        deleteZeroSubTree(bst1.root);
    }

    static int sum = 0;

    private static int deleteZeroSubTree(Node root) {
        if (root == null) {
            return 0;
        }

        if (deleteZeroSubTree(root.left) == 0) {
            root.left = null;
        }
        if (deleteZeroSubTree(root.right) == 0) {
            root.right = null;
        }

        if (root.left != null && root.right != null) {
            sum = root.data + root.left.data + root.right.data;
        } else if (root.left != null) {
            sum = root.data + root.left.data;
        } else if (root.right != null) {
            sum = root.data + root.right.data;
        } else {
            sum = root.data;
        }
        return sum;
    }
}
