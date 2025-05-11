package com.DataStructures_And_Questions.linkedList;

import com.DS.LinkedList.LinkedList;

import com.DS.LinkedList.LinkedList.Node;

/**
 * Given a singly linked list, reverse nodes at even indices.
 * inputList: 7,14,28,21,9,32
 * o/p: 7,32,28,21,9,14
 */
public class ReverseEvenNodes {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(4);
        linkedList.add(8);
        linkedList.add(15);
        linkedList.add(19);
        linkedList.add(21);
        linkedList.add(33);
        reverseEvenNodes(linkedList);
    }

    private static void reverseEvenNodes(LinkedList<Integer> linkedList) {
        LinkedList<Integer> linkedListEven = new LinkedList<>();
        int length = linkedList.length;
        Node currOdd = linkedList.head;
        int i = 1;//started at 1 coz we can get even index easily by %2
        while (i <= length) {
            if (i % 2 == 0) {
                linkedListEven.addFirst((int) currOdd.data);
                linkedList.delete((int) currOdd.data);
            }
            currOdd = currOdd.next;
        }
        //after this we have 2 lists, original with all the odd data and new onw with all even data
        //We can take first element out of new List which will be reversed as we were doing add first
        //and add into new one.
        LinkedList<Integer> outputList = new LinkedList<>();
        currOdd = linkedList.head;
        Node currEven = linkedListEven.head;

        while (currOdd != null && currEven != null) {
            outputList.add((int) currOdd.data);
            outputList.add((int) currEven.data);
            currOdd = currOdd.next;
            currEven = currEven.next;
        }

        if (currOdd != null) {
        }
    }
}
