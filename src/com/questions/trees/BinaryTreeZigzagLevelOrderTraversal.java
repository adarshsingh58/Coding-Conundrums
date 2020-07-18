package com.questions.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]

*/
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new BinaryTreeZigzagLevelOrderTraversal().new TreeNode(1);
        TreeNode root1=root;
        root1.left=new BinaryTreeZigzagLevelOrderTraversal().new TreeNode(2);
        root1.left.left=new BinaryTreeZigzagLevelOrderTraversal().new TreeNode(4);
        root1.right=new BinaryTreeZigzagLevelOrderTraversal().new TreeNode(3);
        root1.right.right=new BinaryTreeZigzagLevelOrderTraversal().new TreeNode(5);

        new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean l2r = true;
        if (root == null) return new ArrayList<>();
        List<List<Integer>> lots = new ArrayList<>();
        List<Integer> lot = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<TreeNode> levelQueue = new LinkedList<>();
        nodeQueue.add(root);
        lot.add(root.val);
        lots.add(lot);
        lot = new ArrayList<>();
        while (true) {
            if (!nodeQueue.isEmpty()) {
                if (!l2r) {
                    TreeNode currNode = ((LinkedList<TreeNode>) nodeQueue).pollLast();
                    if (currNode.left != null) levelQueue.add(currNode.left);
                    if (currNode.right != null) levelQueue.add(currNode.right);

                } else {
                    TreeNode currNode = ((LinkedList<TreeNode>) nodeQueue).pollLast();
                    if (currNode.right != null) levelQueue.add(currNode.right);
                    if (currNode.left != null) levelQueue.add(currNode.left);
                }
                continue;
            }
            if (l2r) l2r = false;
            else l2r = true;
            for (TreeNode node : levelQueue) {
                lot.add(node.val);
            }
            nodeQueue.addAll(levelQueue);
            if (nodeQueue.isEmpty() && levelQueue.isEmpty()) break;
            lots.add(lot);
            levelQueue = new LinkedList<>();
            lot = new ArrayList<>();

        }


        return lots;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
