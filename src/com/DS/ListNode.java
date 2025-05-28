package com.DS;

public class ListNode<E> {
    public E val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(E val) {
        this.val = val;
    }

    public ListNode(E val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

