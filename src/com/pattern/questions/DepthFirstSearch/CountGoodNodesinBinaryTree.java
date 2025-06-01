package com.pattern.questions.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/*
*
* Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.



Example 1:

Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.

Example 2:

Input: root = [3,3,null,4,2]
Output: 3
Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.

Example 3:

Input: root = [1]
Output: 1
Explanation: Root is considered as good.
*
* https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
 */
public class CountGoodNodesinBinaryTree {
    public static void main(String[] args) {

    }

    public int goodNodes(TreeNode root) {
        List<Integer> op=new ArrayList<>();
        goodNodes(root,root.val,op);
        return op.size();
    }
    public void goodNodes(TreeNode currNode, int currMax, List<Integer> gNodes) {
        if(currNode==null) return ;
        if(currNode.val>=currMax)
        {
            gNodes.add(currNode.val);
            currMax=currNode.val;
        }
        goodNodes(currNode.left,currMax,gNodes);
        goodNodes(currNode.right,currMax,gNodes);

    }

     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
