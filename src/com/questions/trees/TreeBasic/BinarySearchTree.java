package com.questions.trees.TreeBasic;


public class BinarySearchTree {
    public Node root;

    //1->STARTS    MAIN ACTIONS FOR A BST STARTS HERE

    /*
     * We have 6 main operation performed on a BST:
     *  >add: This method will take in the data we want to add in thee BST. While adding we must remember that the property of BST must not be
     *        violated after adding the data i.e. left child (subtree)less than current node data and right child (subtree) greater than current node data.
     *  >delete: This method will take in the data we want to delete in thee BST. While deleting we must remember that the property of BST must not be
     *         violated after adding the data i.e. left child (subtree)less than current node data and right child (subtree) greater than current node data.
     *  >search: This method will search the entire BST for the data passed as parameter. The return will be the node of found.
     *  >inOrdertraversal: This method when invoked upon a BST will print the nodes of BST in inOrder fashion i.e. LEFT-ROOT-RIGHT.
     *  >preOrdertraversal: This method when invoked upon a BST will print the nodes of BST in inOrder fashion i.e. ROOT-LEFT-RIGHT.
     *  >postOrdertraversal: This method when invoked upon a BST will print the nodes of BST in inOrder fashion i.e. LEFT-RIGHT-ROOT.
     *
     * All of them are implemented using recursive calls, hence they call their recursive counterpart augmenting any additional parameter if required.
     * */
    public void add(int data) {
        add(root, data);
    }

    public void delete(int data) {
        Node nodeToBeDeleted = search(data);
        delete(nodeToBeDeleted);
    }

    public Node search(int data) {
        return search(root, data);
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    //1->ENDS  UPTILL HERE ALL THE MAIN ACTIONS ARE PRESENT


    //  2->STARTS  FOR RECURSIVE CALLS FOLLOWING METHODS ARE RECURSIVE REPLICA OF MAIN ACTIONS ON BST
    /*
     *  While adding a data to the BST, we need to ensure the position at which the data is added follows the property that
     *  for all Nodes, their left child are always less than it and right child always greater than it.
     *  CASE 1: ROOT of the BST is null. This means the BST itself is null for now and any Node we are about to add will be the root node.
     *          So, we assign the new node to the root. Parent of this node is by default is null, so no need to set.
     *  CASE 2: If there is only one Node in entire BST. In this case the only Node has to be the Root node. In this case,
     *          we will check if the data Node to add has smaller value than root node or not. For former case, add node to left of the root node,
     *          for later case add as right child of root node.
     *          Make sure to add the references of parent and isLeftChild to the new node. Parent will be the root node and isLeftChild will be
     *          true or false depending upon where are we adding it.
     *  CASE 3: The currentNodeInFocus has no left child and only right child subtree and data Node to add is less than currentNodeInFocus.
     *          In this case, data Node will be added as left child of currentNodeInFocus. It's parent will be currentNodeInFocus and isLeftNode will
     *          be true.
     *  CASE 4: The currentNodeInFocus has no right child and only left child subtree and data Node to add is greater than currentNodeInFocus.
     *          In this case, data Node will be added as right child of currentNodeInFocus. It's parent will be currentNodeInFocus and isLeftNode will
     *          be false.
     *  CASE 5: The currentNodeInFocus has right child subtree and data Node to add is greater than currentNodeInFocus.
     *          The new Node needs to be on right of currentNodeInFocus, but because there is a right subtree present, we need to
     *          figure out the proper position of new node in right subtree. So, we will recursively call add() where currentNodeInFocus will be the
     *          currentNodeInFocus.right now.
     *          The currentNodeInFocus left child subtree and data Node to add is less than currentNodeInFocus.
     *          The new Node needs to be on left of currentNodeInFocus, but because there is a left subtree present, we need to
     *          figure out the proper position of new node in left subtree. So, we will recursively call add() where currentNodeInFocus will be the
     *          currentNodeInFocus.left now.
     *
     */
    private void add(Node currentNodeInFocus, int data) {
        if (currentNodeInFocus == null) {//Case 1: No Node in BST
            this.root = new Node(data);
        } else if (currentNodeInFocus.isLeafNode()) {//Case 2: Only 1 node in BST, i.e. the Root node
            if (data < currentNodeInFocus.data) {
                Node node = new Node(data);
                node.parent = currentNodeInFocus;
                node.isLeftNode = true;
                currentNodeInFocus.left = node;
            } else {
                Node node = new Node(data);
                node.parent = currentNodeInFocus;
                node.isLeftNode = false;
                currentNodeInFocus.right = node;
            }
        } else if (currentNodeInFocus.left == null && data < currentNodeInFocus.data) {//Case 3: No Left Child and data to add is < current Data
            Node node = new Node(data);
            node.parent = currentNodeInFocus;
            node.isLeftNode = true;
            currentNodeInFocus.left = node;
        } else if (currentNodeInFocus.right == null && data > currentNodeInFocus.data) {//Case 4: No Right Child and data to add is > current Data
            Node node = new Node(data);
            node.parent = currentNodeInFocus;
            node.isLeftNode = false;
            currentNodeInFocus.right = node;
        } else {                                    //Case 5: Either or both left and right child are there
            if (data < currentNodeInFocus.data) {
                add(currentNodeInFocus.left, data);
            } else {
                add(currentNodeInFocus.right, data);
            }
        }
    }

    /*
     *  Deleting a node is relatively tricky. This is the case which require the node to have the parent reference and isLeftNode field.
     *  As obvious, whenever a node is deleted from anywhere in the BST, we must ensure that the node is replaced in a way that the innate property
     *  of BST remains intact. When a node is deleted we must make sure to update
     *  >its parent reference
     *  >its left and right child references
     *
     *  Lets see different cases in deletion:
     *
     *  CASE 1: When the node to be deleted is a Leaf node. In this case, we will simply point its parent reference to null.
     *          We must know if the node to be deleted is a left or right child of its parent, coz accordingly its child reference will be updated.
     *  CASE 2: When node to be deleted has only one child tree: Only Right Child Tree and Left child tree is null. In this case we can simply
     *          point the parent of nodeToBeDeleted to right child of nodeToBeDeleted and also mark nodeToBeDeleted.right as null, making it free
     *          for garbage collection. Again, we must know the orientation of nodeToBeDeleted i.e. if left or right child it was, accordingly parent
     *          reference can be updated.
     *  CASE 3: When node to be deleted has only one child tree: Only Left Child Tree and Right child tree is null. In this case we can simply
     *          point the parent of nodeToBeDeleted to left child of nodeToBeDeleted and also mark nodeToBeDeleted.left as null, making it free
     *          for garbage collection. Again, we must know the orientation of nodeToBeDeleted i.e. if left or right child it was, accordingly parent
     *          reference can be updated.
     *  CASE 4: When nodeToBeDeleted has both child. This one is trickier. For this
     *          >we first need to swap nodeToBeDeleted with a leaf node and change all the parent and child references
     *          >then delete the leaf node, changing the parent reference
     *          But to which leaf node should nodeToBeDeleted be swapped with. We go for LEFMOST NODE IN RIGHT SUBTREE OF nodeToBeDeleted. This node
     *          will be the node on right of nodeToBeDeleted, hence (A) larger than nodeToBeDeleted and then left most means (B) it will be smaller than any other node
     *          on right on nodeToBeDeleted. Hence, from (A) we can conclude that this node we picked will be greater than all nodes on left of
     *          nodeToBeDeleted and from (B) we know it will be smaller than all the nodes on right of nodeToBeDeleted. Hence, on swap this element
     *          will maintain the BST property. THIS CASE IS TAKEN CARE IN Case 4.2.
     *
     *          There is a special case covered below as Case 4.1. It is for sure that leftMostNodeOfRightSubTree will have no left child
     *          as it itself is the leftmost node but it still have a right child or right subtree for that matter. In this case we will not delete the
     *          nodeToBeDeleted as in case 4.2, but will recursively call the delete() method passing nodeToBeDeleted, and this then will be deleted
     *          as per CASE 2 mentioned above.
     *
     */
    private void delete(Node nodeToBeDeleted) {
        if (nodeToBeDeleted.isLeafNode()) {//Case 1: when node to be deleted is a leaf node
            if (nodeToBeDeleted.isLeftNode) nodeToBeDeleted.parent.left = null;
            else nodeToBeDeleted.parent.right = null;
        } else if (nodeToBeDeleted.left == null) {//Case 2: when node to be deleted has only one child tree: Only Right Child Tree
            if (nodeToBeDeleted.isLeftNode) {
                nodeToBeDeleted.parent.left = nodeToBeDeleted.right;
                nodeToBeDeleted.right = null;
            } else {
                nodeToBeDeleted.parent.right = nodeToBeDeleted.right;
                nodeToBeDeleted.right = null;
            }
        } else if (nodeToBeDeleted.right == null) {//Case 3: when node to be deleted has only one child tree: Only Left Child Tree
            if (nodeToBeDeleted.isLeftNode) {
                nodeToBeDeleted.parent.left = nodeToBeDeleted.left;
                nodeToBeDeleted.left = null;
            } else {
                nodeToBeDeleted.parent.right = nodeToBeDeleted.left;
                nodeToBeDeleted.left = null;
            }
        } else if (nodeToBeDeleted.isCompleteNode()) {//Case 4: when node to be deleted has both child
            Node leftMostNodeOfRightSubTree = leftMostNode(nodeToBeDeleted.right);
            swap(nodeToBeDeleted, leftMostNodeOfRightSubTree);
            //The nodes are swapped now, hence nodeToBeDeleted is a leaf node now, about to be deleted.
            if (nodeToBeDeleted.right != null) {//Case 4.1: when left most node in right sub tree is not empty
                delete(nodeToBeDeleted);
            } else {
                if (nodeToBeDeleted.isLeftNode)//Case 4.2: when left most node in right sub tree is not empty
                    nodeToBeDeleted.parent.left = null;
                else
                    nodeToBeDeleted.parent.right = null;
            }
        }
    }

    /*
     *  We utilize the property of BST that any node  will have all smaller nodes than it as its left child and all greater or equal nodes
     *  than it as the right child.
     *
     *  If the data is not found we return null.
     */
    private Node search(Node currentNodeInFocus, int data) {
        if (data == currentNodeInFocus.data) return currentNodeInFocus;
        else if (data < currentNodeInFocus.data) return search(currentNodeInFocus.left, data);
        else if (data > currentNodeInFocus.data) return search(currentNodeInFocus.right, data);
        return null;
    }

    /*
     *  This will be the recursive method, where the breaking condition is that the currentNodeInFocus is null. This is when the recursive
     *  call will be broken.
     *  We traverse all left node first recursively calling inOrderTraversal() for each left node
     *  then, print the left nodes and then root node
     *  then traverse all right node first recursively calling inOrderTraversal() for each right node
     */
    public void inOrderTraversal(Node currentNodeInFocus) {
        if (currentNodeInFocus != null) {
            inOrderTraversal(currentNodeInFocus.left);
            System.out.println(currentNodeInFocus.data);
            inOrderTraversal(currentNodeInFocus.right);
        }
    }

    public void preOrderTraversal(Node root) {
        System.out.println(root);
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(Node root) {
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
        System.out.println(root);
    }


    //  2->ENDS


    //3->STARTS HELPER METHODS FOR BST STARTS

    /*
     *
     */
    private void swap(Node nodeToBeDeleted, Node leftMostNodeInRightSubTree) {
        /*BELOW WAS EASIER OPTION WHERE JUST DATA IS SWAPPED AND THUS ALL REFERENCES OF BOTH NODES REMAIN UNAFFECTED.
        THE PROBLEM WAS THAT IT WAS HARD TO UDNERSTAIND THIS WITH THE NAMING CONVENTION FOLLOWED IN DELETE LOGIC
        tempData = nodeToBeDeleted.data;
        nodeToBeDeleted.data = leftMostNodeInRightSubTree.data;
        leftMostNodeInRightSubTree.data = tempData;
        */

        //Associate left/right child reference of parent of nodeToBeDeleted with leftMostNodeInRightSubTree
        if (nodeToBeDeleted.isLeftNode) {
            nodeToBeDeleted.parent.left = leftMostNodeInRightSubTree;
        } else {
            nodeToBeDeleted.parent.right = leftMostNodeInRightSubTree;
        }
        Node tempNode = new Node(leftMostNodeInRightSubTree.data);
        tempNode.parent = leftMostNodeInRightSubTree.parent;
        leftMostNodeInRightSubTree.isLeftNode = leftMostNodeInRightSubTree.isLeftNode;
        tempNode.right = leftMostNodeInRightSubTree.right;

//associate left and right nodes of nodeToBeDeleted with leftMostNodeInRightSubTree
        leftMostNodeInRightSubTree.right = nodeToBeDeleted.right;
        leftMostNodeInRightSubTree.left = nodeToBeDeleted.left;
//replace parent reference of both child of nodeToBeDeleted with leftMostNodeInRightSubTree
        nodeToBeDeleted.right.parent = leftMostNodeInRightSubTree;
        nodeToBeDeleted.left.parent = leftMostNodeInRightSubTree;
//Null all child reference of nodeToBeDeleted, as it will be a leaf node now
        nodeToBeDeleted.left = null;
        /*leftMostNodeInRightSubTree must have an empty left child as it is the leftmost child, but it can have a right child or right subtree
         *So we must associate it accordingly CASE 4.1 of delete case
         */
        nodeToBeDeleted.right = tempNode.right;
//        replace parent field of nodeToBeDeleted with parent of leftMostNodeInRightSubTree
        nodeToBeDeleted.parent = tempNode.parent;
//replace left child reference of leftMostNodeInRightSubTree'parent with nodeToBeDeleted
        tempNode.parent.left = nodeToBeDeleted;

    }

    private Node leftMostNode(Node leftMostNodeInRightTree) {
        while (leftMostNodeInRightTree.left != null)
            leftMostNodeInRightTree = leftMostNodeInRightTree.left;
        return leftMostNodeInRightTree;
    }

    //3->ENDS HELPER METHODS FOR BST ENDS


}