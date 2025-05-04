package com.pattern.questions.inplaceManipulation;

import com.DS.ListNode;

/**
 * Given the head of a singly linked list, reverse the linked list and return its updated head.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode ln1 = new ListNode(4);
        ListNode ln2 = new ListNode(3, ln1);
        ListNode ln3 = new ListNode(2, ln2);
        ListNode ln4 = new ListNode(1, ln3);



        ListNode head=new ReverseLinkedList().reorderList(ln4);;
        while(head!=null) {
            System.out.println(head.val);
            head=head.next;
        }
    }

    public ListNode reorderList(ListNode head) {
        return reorderList(null, head);
    }

    public ListNode reorderList(ListNode currN, ListNode nextN) {
        if (nextN == null) return currN;
        ListNode op = reorderList(nextN, nextN.next);
        nextN.next = currN;
        return op;
    }
}
