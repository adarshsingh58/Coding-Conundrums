package com.pattern.questions.recursionbasics;

import com.DataStructures_And_Questions.trees.BST.BinarySearchTree;

/**
 *  Basically "https://leetcode.com/problems/house-robber-iii/" but you want to find entire max sum and not worry about skipping houses.
 * */
public class HoubseRobber0 {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree=new BinarySearchTree();
        binarySearchTree.add(3);
        binarySearchTree.add(2);
        binarySearchTree.add(3);
        binarySearchTree.add(3);
        binarySearchTree.add(1);

        System.out.println(rob(binarySearchTree.root));

    }

    public static int rob(BinarySearchTree.Node root) {
        return robRec(root,0,0);
    }
    public static int robRec(BinarySearchTree.Node root, int currLoot, int maxLoot) {
        if(root==null){
            if(currLoot>maxLoot)
                maxLoot=currLoot;
            return maxLoot;
        }
        maxLoot=Math.max(maxLoot,robRec(root.left,currLoot+root.data,maxLoot));
        maxLoot=Math.max(maxLoot,robRec(root.right,currLoot+root.data,maxLoot));
        return maxLoot;
    }
}
