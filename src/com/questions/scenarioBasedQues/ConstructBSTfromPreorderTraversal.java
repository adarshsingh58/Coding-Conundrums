package com.questions.scenarioBasedQues;

/*
* Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

        8
       / \
      5   10
    /  \    \
   1    7    12

*/
public class ConstructBSTfromPreorderTraversal {
    public static void main(String[] args) {
        int[] preorder = new int[]{8, 5, 1, 7, 10, 12};
        new ConstructBSTfromPreorderTraversal().bstFromPreorder(preorder);

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return new TreeNode();
        TreeNode rootNode = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            findPosition(rootNode, preorder[i]);
        }
        return rootNode;
    }

    /*
     * Basic idea used here. Solution CAN be made more efficient.
     * First elemnt will be root being Preorder. For every nexyt element  start from root and
     * Find its position based on rules of BST, left< root and right > root.
     * Keep adding the number accordingly and return root node.
     *
     * */
    private void findPosition(TreeNode rootNode, int number) {
        TreeNode currentNode = rootNode;
        while (currentNode != null) {
            if (number <= currentNode.val) {
                if (currentNode.left == null) {
                    currentNode.left = new TreeNode(number);
                    return;
                }
                currentNode = currentNode.left;
            } else {
                if (currentNode.right == null) {
                    currentNode.right = new TreeNode(number);
                    return;
                }
                currentNode = currentNode.right;
            }
        }
    }

    public class TreeNode {
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