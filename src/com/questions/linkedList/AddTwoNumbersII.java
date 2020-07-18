package com.questions.linkedList;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

    }

    public ListNode addTwoNumbers() {//7243 + 564 = 7807
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode newNode = new ListNode();

        int l1L = findLength(l1);
        int l2L = findLength(l2);
        if (l2L > l1L) {
            ListNode tempHead = l1;
            l1 = l2;
            l2 = tempHead;
            l1L = findLength(l1);
            l2L = findLength(l2);
        }
        if (l1L >= l2L) {
            ListNode tempHead = l1;
            int diff = l1L - l2L;
            if (newNode.next == null)
                newNode.next = new ListNode();
            int carry = add(tempHead, l2, newNode.next, diff);
            if (carry != 0) {
                newNode.val = carry;
                return newNode;
            } else {
                return newNode.next;
            }
        }

        return newNode;
    }

    private int findLength(ListNode l1) {
        int len = 0;
        while (l1 != null) {
            len++;
            l1 = l1.next;
        }
        return len;
    }


    private int add(ListNode n, ListNode m, ListNode newNode, int diff) {
        int carry = 0;

        if (diff > 0) {
            if (newNode.next == null)
                newNode.next = new ListNode();
            carry = add(n.next, m, newNode.next, --diff);
            int value = (n.val + carry) > 9 ? (n.val + carry) % 10 : n.val + carry;
            carry = (n.val + carry) > 9 ? 1 : 0;
            newNode.val = value;
            return carry;

        } else if (n.next != null && m.next != null) {
            if (newNode.next == null)
                newNode.next = new ListNode();
            carry = add(n.next, m.next, newNode.next, diff);
        } else if (n.next == null && m.next != null) {
            if (newNode.next == null)
                newNode.next = new ListNode();
            carry = add(n, m.next, newNode.next, diff);
        } else if (n.next != null && m.next == null) {
            if (newNode.next == null)
                newNode.next = new ListNode();
            carry = add(n.next, m, newNode.next, diff);
        } else if (n.next == null && m.next == null) {
            int value = (n.val + m.val + carry) > 9 ? (n.val + m.val + carry) % 10 : n.val + m.val + carry;
            carry = (n.val + m.val + carry) > 9 ? 1 : 0;
            newNode.val = value;
            return carry;
        }
        int value = (n.val + m.val + carry) > 9 ? (n.val + m.val + carry) % 10 : n.val + m.val + carry;
        carry = (n.val + m.val + carry) > 9 ? 1 : 0;

        newNode.val = value;
        return carry;
    }


}

