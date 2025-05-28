package com.DS;

public class DoublyListNode<E> {
    public E data;
    public DoublyListNode<E> prev;
    public DoublyListNode<E> next;

    public DoublyListNode(E data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
