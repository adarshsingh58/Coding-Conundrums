package com.DataStructures_And_Questions.trees;

import com.DataStructures_And_Questions.trees.TreeBasic.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root node of a binary search tree (BST) and an integer value k, find all the ancestors of the node whose value is k.
 * <p>
 * An ancestor of a node in a tree is any node on the path from the root to that node.
 */
public class FindAncestorsofNodeBST {

    public static void main(String[] args) {

    }
/*

Search the node k from root and keep adding the intermediate nodes in the result

Time complexity
The time complexity is O(n) if the tree is skewed and O(logn) if it is a balanced binary search tree (BST), where nn is the number of nodes.

Space complexity
In the worst-case scenario with a leaf node target, the algorithm requires O(h) space, where hh is the tree’s height,
as it needs to store ancestors up to the root node.
*/

    public static List<Integer> findAncestors(Node root, int k) {
        List<Integer> res = new ArrayList<>();

        while (root != null && root.data != k) {
            res.add(root.data);
            if (k > root.data)
                root = root.right;
            else
                root = root.left;
        }
        return res;
    }
}
