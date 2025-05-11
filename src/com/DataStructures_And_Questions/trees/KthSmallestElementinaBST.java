package com.DataStructures_And_Questions.trees;

import com.DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values
 * of the nodes in the tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,1,4,null,2], k = 1 Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3 Output: 3
 * <p>
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */
public class KthSmallestElementinaBST {

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1,null,new TreeNode(2,null,null));
        System.out.println(new KthSmallestElementinaBST().kthSmallest(root,1));
    }


    //One way is to create a inorder of BST and since order is sorted get the k-1th value.
    // This is O(n) complexity since List traversal till k would linear when k reaches n, then its O(n)
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.val;
        List<Integer> result =new ArrayList<>();
        kthSmallest(root,result);
        result.forEach(System.out::println);
        return result.get(k-1);
    }

    public void kthSmallest(TreeNode root, List<Integer> result) {
        if(root==null) return;
        kthSmallest(root.left,result);
        result.add(root.val);
        kthSmallest(root.right,result);
    }
}
