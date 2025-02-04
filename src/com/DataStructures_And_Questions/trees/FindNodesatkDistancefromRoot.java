package com.DataStructures_And_Questions.trees;

import com.DataStructures_And_Questions.trees.TreeBasic.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root node of a binary tree and an integer value k, find all the nodes at a distance of k from the root node.
 */
public class FindNodesatkDistancefromRoot {

    public static void main(String args[]) {

        /*Integer[][] inputs = {
                {2, 1, 4, 3, 5, 6, 7},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {45, 32, 23, 21, 18, 1},
                {8, 5, 9, 4, 6, null, 10},
                {10, 6, 9, 3, null, 8, null, 3},
        };
        Integer[] k = {0, 1, 2, 1, 3};

        for (int i = 0; i < inputs.length; i++) {
            BinaryTree<Integer> inputTree = new BinaryTree<Integer>(inputs[i]);
            System.out.println((i + 1) + ".\tInput Tree:");
            Print.displayTree(inputTree.root);
            System.out.println("\n\tk: " + k[i]);
            List<Integer> result = findKNodes(inputTree.root, k[i]);
            System.out.println("\n\tResult: " + Arrays.toString(result.toArray()));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }*/

    }

    /**
     * The solution uses depth first search (DFS) to recursively traverse the binary tree and collect the nodes at a distance k from the root.
     * At each node, the distance k is decremented, and both left and right subtrees are explored. When the distance reaches 0,
     * the node is added to the result. This process continues until all the nodes at distance k are explored.
     * Time complexity
     * <p>
     * The time complexity of this solution is O(n)O(n), where nn is the number of nodes in the binary tree. In the worst case,
     * when k is the maximum depth of the tree, the solution explores all nodes of the binary tree, resulting in the time complexity of O(n)O(n).
     * <p>
     * Space complexity
     * <p>
     * The space complexity is O(h)O(h), where hh is the height of the binary tree. At each level of recursion,
     * there is a call stack maintained to keep track of the function calls. Because the depth of the recursion can reach
     * up to the height of the tree in the worst case, the resulting space complexity is O(h)O(h).
     */
    public static List<Integer> findKNodes(Node root, int k) {

        // Replace this placeholder return statement with your code
        List<Integer> result = new ArrayList<>();
        findN(root, k, 0, result);
        return result;
    }

    public static void findN(Node currnode, int k, int curr, List<Integer> result) {
        if (currnode == null) return;
        if (curr == k) {
            result.add(currnode.data);
            return;
        }
        findN(currnode.left, k, curr + 1, result);
        findN(currnode.right, k, curr + 1, result);
    }
}
