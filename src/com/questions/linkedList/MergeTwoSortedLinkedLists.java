package com.questions.linkedList;

import com.questions.linkedList.linkedListBase.LinkedList;
import com.questions.linkedList.linkedListBase.LinkedList.Node;

/**
 * Given two sorted linked lists, merge them such that the resulting linked list
 * is also sorted.
 * list1: 4,8,15,19
 * list2: 9,10,18,19
 * <p>
 * O/P: 4,8,9,10,18,19,19
 */
public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.add(4);
        linkedList1.add(8);
        linkedList1.add(15);
        linkedList1.add(19);
        linkedList1.add(21);
        linkedList1.add(33);
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.add(9);
        linkedList2.add(10);
        linkedList2.add(18);
        linkedList2.add(19);

        mergeList(linkedList1, linkedList2);

    }

    /**
     * Simple idea is used here. We utilize the fact here that both the lists are sorted.
     * A curr Node start from head for both lists. We check if data at curr is less in list1 or list2.
     * We take the smaller value and add it to a new list and move the curr pointer of the list from which
     * the smaller data has been taken.
     * We do this untill one of the list is over.
     * <p>
     * If other list has still elements left we simple append the end of output list to the curr of
     * list which has elements left.
     *
     * @TimeComplexity O(n + m), where n is the size of one list and m of other.
     * @SpaceComplexity O(n), considering n>m.
     * <p>
     * We can improve on Space Complexity by using one of the existing list for merger.
     */
    private static void mergeList(LinkedList<Integer> linkedList1, LinkedList<Integer> linkedList2) {
        Node curr1 = linkedList1.head;
        Node curr2 = linkedList2.head;
        LinkedList<Integer> opList = new LinkedList<>();
        while (curr1 != null && curr2 != null) {
            if ((int) curr1.data < (int) curr2.data) {
                opList.add((int) curr1.data);
                curr1 = curr1.next;
            } else {
                opList.add((int) curr2.data);
                curr2 = curr2.next;
            }
        }
        if (curr1 != null) {
            opList.tail.next = curr1;
        }
        if (curr2 != null) {
            opList.tail.next = curr2;
        }

    }
}
