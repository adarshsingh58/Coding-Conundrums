package com.DataStructures_And_Questions.trees;

import com.DataStructures_And_Questions.trees.TreeBasic.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root node of a binary search tree and an integer value k, return the kth maximum value in the tree.
 */
public class FindKthMaxInBST {
    public static void main(String[] args) {

    }
/*The time complexity of this solution is O(n)O(n), where nn represents the number of nodes in the binary tree.*/
    public static int findKthMax(Node root, int k) {

        // Replace this placeholder return statement with your code
        List<Integer> pre = new ArrayList<>();
        prefi(root, pre);//preorder gives ascending sorted order for a BST

        return pre.get(pre.size()-k);

    }

    public static void prefi(Node root, List<Integer> pre) {
        if (root == null) return;
        prefi(root.left, pre);
        pre.add(root.data);
        prefi(root.right, pre);
    }

}
