package com.DataStructures_And_Questions.trees;

import com.DS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 */
public class RIghtSideViewBTree {


    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> mainQ = new LinkedList<>();
        Queue<TreeNode> tempQ = new LinkedList<>();
        List<Integer> op = new ArrayList<>();
        if (root == null) return op;
        mainQ.add(root);

        while (!mainQ.isEmpty() || !tempQ.isEmpty()) {
            if (!mainQ.isEmpty()) {

                if (mainQ.size() == 1)
                    op.add(mainQ.peek().val);

                TreeNode n = mainQ.poll();
                if (n.left != null)
                    tempQ.add(n.left);
                if (n.right != null)
                    tempQ.add(n.right);
            } else if (!tempQ.isEmpty()) {
                mainQ = tempQ;
                tempQ = new LinkedList<>();
            }
        }
        return op;
    }
}
