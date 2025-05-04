package com.pattern.questions.inplaceManipulation;

import com.DS.ListNode;

/**
 * Given the head of a singly linked list, reorder the list as if it were folded on itself. For example, if the list is
 * represented as follows:
 * <p>
 * L0 → L1L1​ → L2L2​ → … → Ln−2Ln−2​ → Ln−1Ln−1​ → LnLn​ ​
 * <p>
 * This is how you’ll reorder it:
 * <p>
 * L0L0​ → LnLn​ → L1L1​ → Ln−1Ln−1​ → L2L2​ → Ln−2Ln−2​ → …
 * <p>
 * You don’t need to modify the values in the list’s nodes; only the links between nodes need to be changed.
 * <p>
 * 9 -> 2 -> 0 -> 8 op: 9->8 -> 2->0
 * <p>
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode ln6 = new ListNode(6);
        ListNode ln5 = new ListNode(5, ln6);
        ListNode ln4 = new ListNode(4, ln5);
        ListNode ln3 = new ListNode(3, ln4);
        ListNode ln2 = new ListNode(2, ln3);
        ListNode ln1 = new ListNode(1, ln2);

        new ReorderList().reorderList(ln1);
    }

    /*
     * The essence of this approach lies in reorganizing a linked list in three main steps. It begins by using two
     * pointers at different speeds to locate the middle of the list: one moves step by step, and the other two steps at
     * a time. The faster one reaches the end, the slower one is right in the middle. Then, after reaching the middle,
     * the second half of the list is reversed. This means each node of the list now points back to the one before it,
     * effectively flipping the order of this half. The final step merges the two halves together. Starting with the
     * heads of each half, the nodes from the reversed second half are linked and alternated with those from the first
     * half. This is done by adjusting the next pointers: each node in the first half now points to a node from the
     * second half, and similarly, each node from the second half is linked to the subsequent node from the first half.
     * The algorithm performed all steps without using extra space.We can use two pointers, first and second, to point
     * to the heads of the two halves of the linked list. We’ll traverse both halves in lockstep to merge the two linked
     * lists, interleaving the nodes from the second half into the first half.
     */
    public void reorderList(ListNode head) {
        ListNode middle = findMiddle(head);
        middle.next = reverseList(middle.next, middle.next.next);
        System.out.println(head);
    }

    public ListNode findMiddle(ListNode head) {
        ListNode h1 = head, h2 = head;
        while (h2.next != null && h2.next.next != null) {
            h1 = h1.next;
            h2 = h2.next.next;
        }
        return h1;
    }

    public ListNode reverseList(ListNode curr, ListNode next) {
        if (next == null) {
            return curr;
        }
        ListNode op = reverseList(next, next.next);
        next.next = curr;
        curr.next=null;
        return op;
    }

}


