package com.DataStructures_And_Questions.trees;

import com.DataStructures_And_Questions.trees.TreeBasic.BinarySearchTree;
import com.DataStructures_And_Questions.trees.TreeBasic.Node;

/**
 * Given the root node of a binary search tree (BST), find and return the minimum value present in the BST.
 */
public class MinInABST {

    public static void main(String[] args) {
        Integer[][] inputs = {
                {18, 15, 13, 19, 5, 14},
                {1, 2, 3, 4, 5, 6},
                {100, 200, 50, 40, 30, 80, 90},
                {10},
                {1, 2},
                {-10, -20, -30, -40, -50, -60, -70}
        };

        for (int i = 0; i < inputs.length; i++) {
            BinarySearchTree inputTree = new BinarySearchTree();
            findMin(inputTree.root);
        }
    }

    /*
    * The time complexity of this solution is O(h)O(h), where hh represents the height of the binary search tree.

    In a balanced BST, the height is log⁡nlogn, where nn is the number of nodes in the tree. Therefore, the time complexity in this case becomes O(log⁡n)O(logn).

    In the worst case scenario, when the BST is left-skewed, the height becomes equal to the number of nodes in the tree. Therefore, the time complexity in this case becomes O(n)O(n).

    Space complexity

    The space complexity of this solution is O(1)O(1) because constant extra memory is used.
    * */
    public static int findMin(Node root) {
        // Replace this placeholder return statement with your code
        while (root.left != null) {
            root = root.left;
        }

        return root.data;
    }

}
