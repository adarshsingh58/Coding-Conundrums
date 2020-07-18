package com.questions.trees;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorofaBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new LowestCommonAncestorofaBinaryTree().new TreeNode(2);
        root.left = new LowestCommonAncestorofaBinaryTree().new TreeNode(1);
        root.left.left = new LowestCommonAncestorofaBinaryTree().new TreeNode(7);
        root.right = new LowestCommonAncestorofaBinaryTree().new TreeNode(3);
        root.right.left = new LowestCommonAncestorofaBinaryTree().new TreeNode(33);
        root.right.right = new LowestCommonAncestorofaBinaryTree().new TreeNode(8);

        TreeNode p = root.right.right;
        TreeNode q = root.right.left;

        new LowestCommonAncestorofaBinaryTree().lowestCommonAncestor(root, p, q);

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == null && q != null) return q;
        if (q == null && p != null) return p;
        TreeNode curr = root;
        TreeNode lca = null;
        Set<TreeNode> parentSet = new HashSet<>();
        Set<TreeNode> parentSetq = new HashSet<>();

        if (!findNode(curr, p, parentSet)) {
            System.out.println("P not found");
        }

        findNode(curr, q, parentSetq);


        return lca;
    }

    public boolean findNode(TreeNode curr, TreeNode p, Set<TreeNode> parentSet) {
        if (curr == null) return false;
        if (curr == p) {
            parentSet.add(curr);
            return true;
        }
        if (findNode(curr.left, p, parentSet)) {
            parentSet.add(curr);
            return true;
        }
        if (findNode(curr.right, p, parentSet)) {
            parentSet.add(curr);
            return true;
        }
        return false;
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
