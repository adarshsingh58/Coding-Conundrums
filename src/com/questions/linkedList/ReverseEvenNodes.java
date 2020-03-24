package com.questions.linkedList;

import com.questions.linkedList.linkedListBase.LinkedList;
import com.questions.linkedList.linkedListBase.LinkedList.Node;

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
        Node curr = linkedList.head;
        int i = 1;//started at 1 coz we can get even index easily by %2
        while (i <= length) {
            if (i % 2 == 0) {
                linkedListEven.addFirst((int) curr.data);
                linkedList.delete((int) curr.data);
            }
            curr = curr.next;
        }
        //after this we have 2 lists, original with all the odd data and new onw with all even data
        //We can take first element out of new List which will be reversed as we were doing add first
        //and add into new one.
        LinkedList<Integer> outputList = new LinkedList<>();
        curr = linkedList.head;
        Node curr2 = linkedListEven.head;

        while (curr != null && curr2 != null) {
            outputList.add((int) curr.data);
            outputList.add((int) curr2.data);
            curr = curr.next;
            curr2 = curr2.next;
        }

        if (curr != null) {
        }
    }
}
