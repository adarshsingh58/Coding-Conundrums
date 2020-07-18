package com.questions.trees;

import com.questions.trees.TreeBasic.BinarySearchTree;
import com.questions.trees.TreeBasic.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given root of a binary tree, display node values at each level. Node values
 * for all levels should be displayed on separate lines.
 * <p>
 * BSTree:
 * 100
 * /   \
 * 50 	200
 * / \	  \
 * 25  75     350
 * <p>
 * Level order traversal for this tree should look like:
 * 100
 * 50, 200
 * 25, 75, 350
 */
public class LevelOrderTraversal {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(50);
        binarySearchTree.add(200);
        binarySearchTree.add(25);
        binarySearchTree.add(75);
        binarySearchTree.add(350);

        printLevelOrder(binarySearchTree.root);
        returnLevelOrder(binarySearchTree.root);

    }

    private static void printLevelOrder(Node root) {
        Queue<Node> mainQ = new LinkedList<>();
        Queue<Node> levelDataQ = new LinkedList<>();

        if (root != null) {
            levelDataQ.add(root);
        }

        while (!levelDataQ.isEmpty() || !mainQ.isEmpty()) {
            if (!levelDataQ.isEmpty()) {
                Node curr = levelDataQ.poll();
                if (curr.left != null)
                    mainQ.add(curr.left);
                if (curr.right != null)
                    mainQ.add(curr.right);
                System.out.print(curr.data + " ");
            } else {
                System.out.println();
                levelDataQ.addAll(mainQ);
                mainQ = new LinkedList<>();
            }
        }

    }

    private static List<List<Integer>> returnLevelOrder(Node root) {
        if (root == null) return null;
        List<List<Integer>> lots = new ArrayList<>();
        List<Integer> lot = new ArrayList<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        List<Node> levelQueue = new ArrayList<>();
        nodeQueue.add(root);
        lot.add(root.data);
        lots.add(lot);
        lot = new ArrayList<>();
        while (true) {
            if (!nodeQueue.isEmpty()) {
                Node currNode = nodeQueue.poll();

                if (currNode.left != null) levelQueue.add(currNode.left);
                if (currNode.right != null) levelQueue.add(currNode.right);
                continue;
            }
            for (Node node : levelQueue) {
                lot.add(node.data);
            }
            nodeQueue.addAll(levelQueue);
            if (nodeQueue.isEmpty() && levelQueue.isEmpty()) break;
            lots.add(lot);
            levelQueue = new ArrayList<>();
            lot = new ArrayList<>();

        }


        return lots;
    }
}