package com.pattern.questions.BinaryTreeTraversal;

import com.DS.TreeNode;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 *     The left
 *
 *     of a node contains only nodes with keys less than the node's key.
 *     The right subtree of a node contains only nodes with keys greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [2,1,3]
 * Output: true
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 * */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode n1=new TreeNode(2);
        n1.left=new TreeNode(1);
        n1.right=new TreeNode(3);
        System.out.println(new ValidateBinarySearchTree().isValidBST(n1));
    }

    public boolean isValidBST(TreeNode root) {
        if(root.left==null && root.right==null) return true;
        return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, int min, int max) {
        if(root == null) return true;
        if(root.val<min && root.val>max){
            return false;
        }
        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);

    }
}
