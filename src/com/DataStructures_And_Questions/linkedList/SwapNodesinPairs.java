package com.DataStructures_And_Questions.linkedList;

import com.DS.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying
 * the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4]
 * <p>
 * Output: [2,1,4,3]
 * <p>
 * Explanation:
 * <p>
 * Example 2:
 * <p>
 * Input: head = []
 * <p>
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1]
 * <p>
 * Output: [1]
 * <p>
 * Example 4:
 * <p>
 * Input: head = [1,2,3]
 * <p>
 * Output: [2,1,3] https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesinPairs {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        if (prev == null) {
            ListNode temp = next.next;
            next.next = curr;
            curr.next = temp;
            head = next;
            if (curr.next == null) return head;
            prev = curr;
            curr = curr.next;
            next = curr.next;

        }

        while (next != null) {
            ListNode temp = next.next;
            next.next = curr;
            curr.next = temp;
            prev.next = next;
            if (curr.next == null) break;
            prev = curr;
            curr = curr.next;
            next = curr.next;
        }
        return head;
    }
}
