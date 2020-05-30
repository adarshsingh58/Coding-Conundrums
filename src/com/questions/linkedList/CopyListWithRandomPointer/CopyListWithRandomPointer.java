package com.questions.linkedList.CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 * <p>
 * The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 * <p>
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <p>
 * Example 2:
 * <p>
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 * <p>
 * Example 3:
 * <p>
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 * <p>
 * Example 4:
 * <p>
 * Input: head = []
 * Output: []
 * Explanation: Given linked list is empty (null pointer), so return null.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -10000 <= Node.val <= 10000
 * Node.random is null or pointing to a node in the linked list.
 * Number of Nodes will not exceed 1000.
 */
public class CopyListWithRandomPointer {

    public static void main(String[] args) {
        Node head = new Node(7);
        Node head1 = new Node(13);
        Node head2 = new Node(11);
        Node head3 = new Node(10);
        Node head4 = new Node(1);
        Node head5 = head;

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        head1.random = head;
        head2.random = head3;
        head3.random = head1;
        head4.random = head;

        CopyListWithRandomPointer.copyRandomList(head);
    }

    /*
     * Here, we have to make a deep clone of oroginal list with   random pointer.
     * If we start creating a full clone i.e. new node with correct next and random pointers, then that would be depth first.
     * Since, random pointer points to a node then its random pointer will also point to another node and so  on.
     * So, for setting random pointer for a node, we either create random nodes on the fly in DFS manner,
     * OR, we first create all the list w/o the random pointer. Now, we have all the new cloned nodes  with us.
     * Now we start to add random pointer to each node one by one.
     *
     * So, for that, we use 2 maps,
     * originalToCopyMap -> this map consist track of original node against which new node was created and
     * copyToOriginalMap -> this map consist  track of new node against which original node was created.
     *
     * The reason we need 2 maps is because, for a given new node, to find its random pointer node,
     * we must find the original random node to its original corrosponding node.
     * So, we get the original corrosponding node for the current cloned node using copyToOriginalMap.
     * and then for this original node we find the random original pointer node and for this poiunter
     * we find the cloned node using originalToCopyMap.
     *
     * There is additional space complexity here, but time complexity is O(n).
     *
     * To make it space efficient consider the list as a graph with 2 childs  next and random and do a DFS.
     * */
    public static Node copyRandomList(Node originalNodeHead) {

        Map<Node, Node> originalToCopyMap = new HashMap<>();
        Map<Node, Node> copyToOriginalMap = new HashMap<>();
        Node copyNodeHead = new Node(0);

        Node copyNodeCurr = copyNodeHead;
        Node originalNodeCurr = originalNodeHead;

        //first create clone list without random reference
        while (originalNodeCurr != null) {
            copyNodeCurr.next = new Node(originalNodeCurr.val);
            originalToCopyMap.put(originalNodeCurr, copyNodeCurr.next);
            copyToOriginalMap.put(copyNodeCurr.next, originalNodeCurr);
            copyNodeCurr = copyNodeCurr.next;
            originalNodeCurr = originalNodeCurr.next;
        }
        copyNodeCurr = copyNodeHead.next;
        originalNodeCurr = originalNodeHead;
        //put random reference now since all the nodes are created
        while (originalNodeCurr != null) {
            copyNodeCurr.random = originalToCopyMap.get(copyToOriginalMap.get(copyNodeCurr).random);
            originalNodeCurr = originalNodeCurr.next;
            copyNodeCurr = copyNodeCurr.next;
        }

        return copyNodeHead.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
