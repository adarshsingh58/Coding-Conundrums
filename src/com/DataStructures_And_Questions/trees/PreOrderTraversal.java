package com.DataStructures_And_Questions.trees;

import com.DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,null,2,3]
 * <p>
 * Output: [1,2,3]
 * <p>
 * Explanation:
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
 * <p>
 * Output: [1,2,4,5,6,7,3,8,9]
 * <p>
 * Explanation:
 * <p>
 * Example 3:
 * <p>
 * Input: root = []
 * <p>
 * Output: []
 * <p>
 * Example 4:
 * <p>
 * Input: root = [1]
 * <p>
 * Output: [1]
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 */
public class PreOrderTraversal {

    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        preorderTraversal(root,result);
        return result;
    }

    public void preorderTraversal(TreeNode root, List<Integer> result) {
        if(root==null) return;
        result.add(root.val);
        preorderTraversal(root.left,result);
        preorderTraversal(root.right,result);
    }
}
