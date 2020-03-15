package com.questions.trees.TreeBasic;

/*
 *This is the Node class which holds the preliminary structure of a Node.
 * In general, a node must have following 3 fields:
 *   >data- This field contains the data which the node contains
 *   >left- This field reperesents the Node which is theoritically on the left of the current Node.
 *   >right- This field reperesents the Node which is theoritically on the right of the current Node.
 *
 *  Just using these fields will be sufficient for operations like add, search and traversals.
 *
 *  BUT FOR DELETE OPERATION WE NEED SOME MORE INFORMATION ABOUT A NODE LIKE ITS PARENT AND WHETHER IT IS A LEFT CHILD OR RIGHT.
 *  HENCE, OTHER FIELDS WILL BE:
 *  >parent- This field will represent the parent Node of the current node. This will be NULL in case the current node is the parent node.
 *  >isLeftNode- This field is a boolean value which will be true when current Node is a left node i.e. is the left child of its parent. False, if right.
 *
 *  Three helper methods will be:
 *  isLeafNode() -> checking if current node is a leaf node i.e. current node has no left and right child
 *  isCompleteNode() -> checking current node has both left and right child
 *  isRoot() -> returns true if current node is a root node i.e. parent child is null
 */
public class Node {
	public int data;
    public Node left;
    public Node right;
    public Node parent;//needed for delete case 3
    public boolean isLeftNode;//needed for delete cases

    public Node(int data) {
        this.data = data;
    }

    public boolean isLeafNode() {
        if (this.left == null && this.right == null) return true;
        else return false;
    }

    public boolean isCompleteNode() {
        if (this.left != null && this.right != null) return true;
        else return false;
    }

    public boolean isRoot() {
        if (parent == null)
            return true;
        return false;
    }
}