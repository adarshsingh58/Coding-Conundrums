package com.DataStructures_And_Questions.Hashtable;

import com.DataStructures_And_Questions.linkedList.LinkedList.LinkedList.Node;

import java.util.Set;
import java.util.TreeSet;

/**
 * Given two linked lists as inputs containing integer values, implement the union and intersection functions for the linked lists.
 * The order of elements in the output lists doesn’t matter.
 * <p>
 * Here’s how to implement the functions:
 * <p>
 * Union: This function will take two linked lists as input and return a new linked list containing all the unique elements.
 * <p>
 * Intersection: This function will take two linked lists as input and return all the common elements between them as a new linked list.
 */
public class UnionandIntersectionLinkedListsHashing {
    public static void main(String[] args) {
        Integer[][] unionList = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 1, 2, 2, 3, 3, 4, 4, 5},
                {-45, 34, -54, 45, -65, 54},
                {12},
                {0, 1, 2}
        };

        Integer[][] intersectionList = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 1, 2},
                {1, 1, 2, 2, 3, 3, 4, 4, 5},
                {-45, 34, -54, 45, -65, 54},
                {12}
        };

        Integer[][] inputList2 = {
                {7, 8, 9, 10, 11, 12, 13, 14},
                {1, 3, 4, 1},
                {1, 2, 3, 4, 5, 6},
                {3, 2, 1},
                {12}
        };

        for (int i = 0; i < unionList.length; i++) {
           /* LinkedList<Integer> inputLinkedList1 = new LinkedList<>();
            LinkedList<Integer> inputLinkedList2 = new LinkedList<>();
            PrintList<Integer> printLinkedList = new PrintList<Integer>();

            inputLinkedList1.createLinkedList(unionList[i]);
            inputLinkedList2.createLinkedList(inputList2[i]);

            System.out.print((i + 1) + ".\tInput linked list 1: ");
            printLinkedList.printListWithForwardArrow(inputLinkedList1.head);

            System.out.print("\n\tInput linked list 2: ");
            printLinkedList.printListWithForwardArrow(inputLinkedList2.head);

            System.out.print("\n\n\tUnion: ");
            printLinkedList.printListWithForwardArrow(union(inputLinkedList1.head, inputLinkedList2.head));

            System.out.print("\n\tIntersection: ");
            printLinkedList.printListWithForwardArrow(intersection(inputLinkedList1.head, inputLinkedList2.head));
            System.out.println("\n"+ new String(new char[75]).replace('\0', '-') + "\n");*/
        }
    }
    /*public static Node findUnion(Node head, Node head2) {
        // Add your code here.
        Set<Integer> set=new TreeSet<>();
        if(head==null ) return head2;
        if(head2==null ) return head;
        while(head!=null){
            set.add(head.data);
            head=head.next;
        }

        while(head2!=null){
            set.add(head2.data);
            head2=head2.next;
        }

        Node headop=new Node(0);
        Node curr=headop;
        for(Integer s:set){
            curr.next=new Node(s);
            curr=curr.next;
        }

        return headop.next;
    }*/
}
