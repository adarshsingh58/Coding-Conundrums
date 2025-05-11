package com.pattern.questions.twopointers;

import com.DS.ListNode;

/**
 * Given a singly linked list, remove the nth node from the end of the list and return its head.
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodefromEndOfList {

    public static void main(String[] args) {

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=head;
        ListNode fast=head;
        for(int i=0;i<n;i++)
            fast=fast.next;
        if(fast==null){
            head=slow.next;
            slow.next=null;
            return head;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        fast=slow.next;
        slow.next=slow.next.next;
        fast.next=null;

        return head;
    }
}
