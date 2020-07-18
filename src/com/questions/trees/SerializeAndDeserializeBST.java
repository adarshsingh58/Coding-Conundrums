package com.questions.trees;

import java.util.Arrays;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * The encoded string should be as compact as possible.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeAndDeserializeBST {
    public static void main(String[] args) {
        TreeNode root = new SerializeAndDeserializeBST().new TreeNode(2);
        TreeNode root1 = root;
        root1.left = new SerializeAndDeserializeBST().new TreeNode(1);
        TreeNode p = root;
        TreeNode q = root.left;

        String treeStr = new SerializeAndDeserializeBST().serialize(root);
        TreeNode rootD = new SerializeAndDeserializeBST().deserialize(treeStr);
    }

    // Encodes a tree to a single string.
    /*
    * we can inhance this by just passing preorder. inorder is just sorted form of preorder in case of BST
    * So, on deserialization side we can simply sort the preorder to get inorder.
    * This will save memory in terms of data sent over network.
    * */
    public String serialize(TreeNode root) {
         if(root==null ) return "";
        StringBuilder pre = new StringBuilder();
        preorderString(root, pre);
        StringBuilder in = new StringBuilder();
        inorderString(root, in);
        return pre.toString() + "," +in.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         if(data==null || data == "") return null;

        String[] stA = data.split(",");
        String preorderStr = stA[0];
        String inorderStr = stA[1];

        int[] preorder = new int[preorderStr.length()];
        int[] inorder = new int[inorderStr.length()];
        buildIntArrFromStr(preorder, preorderStr);
        buildIntArrFromStr(inorder, inorderStr);
        return buildTree(preorder, inorder);
    }

    void buildIntArrFromStr(int[] arr, String str) {
        char[] chA = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            arr[i] = chA[i]- 48;
        }
    }

    void preorderString(TreeNode root, StringBuilder pre) {
        if (root == null) return;
        pre.append(root.val);
        preorderString(root.left, pre);
        preorderString(root.right, pre);
    }

    void inorderString(TreeNode root, StringBuilder in) {
        if (root == null) return;
        inorderString(root.left, in);
        in.append(root.val);
        inorderString(root.right, in);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode x = build(preorder, inorder, 0, inorder.length - 1);

        return x;
    }

    int preorderCurr = 0;

    public TreeNode build(int[] preorder, int[] inorder, int inorderLow, int inorderHi) {
        if (inorderHi < inorderLow) return null;
        if (inorderHi < 0 || inorderHi >= inorder.length) return null;
        if (inorderLow < 0 || inorderLow >= inorder.length) return null;
        int index = firstMatch(preorder, inorder, inorderLow, inorderHi);
        TreeNode root = new TreeNode(inorder[index]);
        root.left = build(preorder, inorder, inorderLow, index - 1);
        root.right = build(preorder, inorder, index + 1, inorderHi);
        return root;
    }

    public int firstMatch(int[] preorder, int[] inorder, int inorderLow, int inorderLength) {
        for (int i = preorderCurr; i < preorder.length; i++)
            for (int j = inorderLow; j <= inorderLength; j++)
                if (preorder[i] == inorder[j]) {
                    preorderCurr = i + 1;
                    return j;
                }
        return 0;
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
