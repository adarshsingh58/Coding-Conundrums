package com.DataStructures_And_Questions.linkedList;

import com.DS.LinkedList.LinkedList;

import com.DS.LinkedList.LinkedList.Node;

/**
 * Given a singly linked list, delete middle of the linked list. For example, if
 * given linked list is 1->2->3->4->5 then linked list should be modified to
 * 1->2->4->5
 */
public class DeleteMiddleNode {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        deleteMiddle(linkedList);
    }

    /**
     * Slow and Fast pointer concept is used when we need to hop in linked list by a certain amount.
     * Here, we need to find the middle node in linkedlist. So, w move slow pointer normally by 1 node
     * at a time while, fast pointer moves 2 nodes at a time, so that by the time fast pointer reaches
     * the end of linkedlist, slow pointer will be in middle of linked list as slowpointer is moving
     * at half the rate of fast pointer.
     * <p>
     * Afte identifying middle element we delete it.
     *
     * @TimeComplexity O(n)
     */
    private static void deleteMiddle(LinkedList<Integer> linkedList) {
        Node slowPointer = linkedList.head;
        Node fastPointer = linkedList.head;
        Node slowPoint_prev = null;
        while (fastPointer != null && fastPointer.next != null) {
            slowPoint_prev = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        slowPoint_prev.next = slowPointer.next;
        slowPointer.next = null;

    }
}
