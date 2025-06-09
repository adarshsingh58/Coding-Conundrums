package com.pattern.questions.BinaryTreeTraversal;

import java.util.*;

/**
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values
 * of all nodes that have a distance k from the target node.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2 Output: [7,4,1] Explanation: The nodes that are a
 * distance 2 from the target node (with value 5) have values 7, 4, and 1.
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1], target = 1, k = 3 Output: [] https://www.youtube.com/watch?v=i9ORlEy6EsI
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 */
public class AllNodesDistanceKinBinaryTree {

    public static void main(String[] args) {
        /*
              3
             / \
            5   1
           / \  / \
          6  2 0  8
            / \
           7   4
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        AllNodesDistanceKinBinaryTree sol = new AllNodesDistanceKinBinaryTree();
        List<Integer> result = sol.distanceK(root, root.left, 2);  // Target = node 5

        System.out.println("Nodes at distance 2 from target:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> nodeToParent = new HashMap<>();
        Queue<TreeNode> bfsQ = new LinkedList<>();
        bfsQ.offer(root);
        while (!bfsQ.isEmpty()) {
            TreeNode curr = bfsQ.poll();
            if (curr!=null && curr.left != null) {
                nodeToParent.put(curr.left, curr);
                bfsQ.offer(curr.left);
            }
            if (curr!=null && curr.right != null) {
                nodeToParent.put(curr.right, curr);
                bfsQ.offer(curr.right);
            }
        }
        List<Integer> op=new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> radialBFSQ = new LinkedList<>();

        radialBFSQ.add(target);
        int currentLevelSize=radialBFSQ.size();
        visited.add(target);
        while (k >0 && !radialBFSQ.isEmpty()) {
            TreeNode curr = radialBFSQ.poll();
            if (curr.left != null && !visited.contains(curr.left)) {
                visited.add(curr.left);
                radialBFSQ.offer(curr.left);
            }

            if (curr.right != null && !visited.contains(curr.right)) {
                visited.add(curr.right);
                radialBFSQ.offer(curr.right);
            }

            TreeNode parent = nodeToParent.get(curr);
            if (nodeToParent.containsKey(curr) && !visited.contains(parent)) {
                visited.add(parent);
                radialBFSQ.offer(parent);
            }
            currentLevelSize--;
            if(currentLevelSize==0) {
                k--;
                currentLevelSize= radialBFSQ.size();
            }
        }
        while(!radialBFSQ.isEmpty()){
            op.add(radialBFSQ.poll().val);
        }
        return op;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
