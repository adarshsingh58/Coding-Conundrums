package com.DataStructures_And_Questions.linkedList;

import com.DS.DoublyListNode;
import com.DS.LinkedList.DoublyLinkedList;

/**
 * Given head DoublyListNode of a singly linked list and an integer 'n', rotate linked list by 'n'.
 * e.g.
 * InputList = 1,2,3,4,5
 * n = 2
 * OutputLIst = 4,5,1,2,3
 */
public class RotateLinkedList {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        int n = 1;
        rotateList(linkedList, n);

    }

    /**
     * Here, we are using two pointers i and j which are n distance apart.
     * We traverse them untill j reaches the tail.
     * At this point, i will point at the DoublyListNode right before the DoublyListNode from where the rotation will occur
     * So, we point next of i to null and next of j to head.
     * While also making i's next as head now.
     *
     * @TimeComplexity O(n), the list is traversed n times
     * @SpaceComplexity O(1), no new storage was used.
     */
    private static void rotateList(DoublyLinkedList<Integer> linkedList, int n) {
        //Making sure that rotation size is within the limits of the list.
        //If not mod it
        if (n > linkedList.length) {
            n = n % linkedList.length;
        }

        DoublyListNode i = linkedList.head;
        DoublyListNode j = i;
        for (int k = 0; k < n; k++) {
            j = j.next;
        }

        while (j.next != null) {
            i = i.next;
            j = j.next;
        }
        DoublyListNode tempHead = i.next;
        i.next = null;
        j.next = linkedList.head;
        linkedList.head = tempHead;
    }
}
