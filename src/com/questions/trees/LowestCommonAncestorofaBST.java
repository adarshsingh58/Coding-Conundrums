package com.questions.trees;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorofaBST {

    public static void main(String[] args) {
        TreeNode root = new LowestCommonAncestorofaBST().new TreeNode(2);
        TreeNode root1 = root;
        root1.left = new LowestCommonAncestorofaBST().new TreeNode(1);
        TreeNode p = root;
        TreeNode q = root.left;

        new LowestCommonAncestorofaBST().lowestCommonAncestor(root, p, q);

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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
