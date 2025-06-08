package com.DataStructures_And_Questions.trees;

import com.DS.TreeNode;

import java.util.HashSet;
import java.util.Set;
/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 * */
public class LowestCommonAncestorofaBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = root;
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        TreeNode p = root1.left;
        TreeNode q = root1.left.right.right;

//        new LowestCommonAncestorofaBST().lowestCommonAncestor(root, p, q);
        new LowestCommonAncestorofaBinaryTree().lowestCommonAncestorBetter(root, p, q);

    }

    public TreeNode lowestCommonAncestorBetter(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root == q){
            return root;
        }

        TreeNode left=lowestCommonAncestorBetter(root.left,p,q);
        TreeNode right=lowestCommonAncestorBetter(root.right,p,q);

        if(left==null)
            return right;
        if(right==null)
            return left;
        if(right!=null && left!=null)
            return root;
        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        Set<TreeNode> parentSet = new HashSet<>();
        TreeNode curr = root;
        TreeNode lca = null;
        parentSet.add(curr);
        while (curr != p) {
            if (p.val < curr.val) {
                curr = curr.left;
                parentSet.add(curr);
            } else if (p.val > curr.val) {
                curr = curr.right;
                parentSet.add(curr);
            }
            if (curr == p) {
                parentSet.add(curr);
            }
        }
        curr = root;
        if (curr == q && parentSet.contains(curr)) {
            lca = curr;
        }
        while (curr != q) {
            if (parentSet.contains(curr)) {
                lca = curr;
            }
            if (q.val < curr.val ) {
                curr = curr.left;

            } else if (q.val > curr.val) {
                curr = curr.right;
            }
            if (curr == q && parentSet.contains(curr)) {
                lca = curr;
            }
        }

        return lca;
    }

}
