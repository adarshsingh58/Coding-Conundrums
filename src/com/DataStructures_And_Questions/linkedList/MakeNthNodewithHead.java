package com.DataStructures_And_Questions.linkedList;

import com.DS.LinkedList.DoublyLinkedList;
import com.DS.DoublyListNode;


/**
 * Given the head of a singly linked list and 'N', swap the head with Nth node.
 * Return the head of the new linked list.
 * inputList: 7,14,21,35,28,42
 * N=4
 * O/P List: 35,14,21,7,28,42
 */
public class MakeNthNodewithHead {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        int n = 4;

        swapData(linkedList, n);
    }

    /**
     * We simple traverse till N-1 th Node and swap references of next of Nth and head node
     *
     * @TimeComplexity O(n)
     * @SpaceComplexity O(1)
     */
    private static void swapData(DoublyLinkedList<Integer> linkedList, int n) {
        DoublyListNode curr = linkedList.head;
        for (int i = 0; i < n - 2; i++) {//n-2 because we need to go to prev node from the one to be replaced
            curr = curr.next;
        }
        DoublyListNode temp2 = curr.next;
        DoublyListNode temp = linkedList.head.next;
        linkedList.head.next = curr.next.next;
        curr.next.next = temp;
        curr.next = linkedList.head;
        linkedList.head = temp2;


    }

}
