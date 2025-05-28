package com.DS.LinkedList;


import com.DS.DoublyListNode;

/**
 * Always remeber that a class var are like attributes of the object, the class represents We should always think of
 * updating all the attributes when an object's behaviour is called. If you see this object orieted way, u will never
 * mistake updating a var
 * <p>
 * For Add:  This is a modification behaviour so, we need to update the attributes also if required For Delete: This is
 * a modification behaviour so, we need to update the attributes also if required For Search: This is not a modification
 * behavior so we need not be worried about updating the attributes of the object
 * <p>
 * For LinkedList we cab identify following as its attribute: >head : points to head of the linked list >tail : points
 * to tail of the linked list >length : contains the active length of the LinkedList
 * <p>
 * For behaviour, following are the behaviour: > add - add an element to linked list > delete - delete element from
 * linked list > traverse - return a string with traversed elements > getFirst - return the first node's (head) data in
 * the Linked List > getLast - return the last node's (tail) data in the Linked List
 * <p>
 * We have made LinkedList Generic by introducing <E>
 */
public class DoublyLinkedList<E> {
    public DoublyListNode<E> head;
    public DoublyListNode<E> tail;
    public int length;

    public DoublyLinkedList() {
    }

    /*
     *Add functionality adds an element or data at the end of the linkedlist
     *
     * Since only adding at end is happening and we already have the tail reference,
     * Time complexity for this is O(1)
     * Space complexity is also O(1), as no n dependent variable is introduced
     */
    public void add(E data) {
        if (head == null) {
            head = new DoublyListNode<E>(data);
            tail = head;
            length++;
        } else if (tail != null) {
            tail.next = new DoublyListNode<E>(data);
            tail.next.prev = tail;
            tail = tail.next;
            length++;
        }
    }


    /*
     */
    public void addFirst(E data) {
        if (head == null) {
            add(data);
        } else {
            DoublyListNode<E> newHead = new DoublyListNode<>(data);
            newHead.next = head;
            head = newHead;
            length++;
        }
    }

    /*
     * Deleting a data requires removing all the reference of the to be deleted node and altering refences of nodes next to and prev to it
     * For Search -> We are calling a search method here , which has Time complexity of O(n) and one temporary node, so space complexity of O(1)
     * For delete -> We are not calling any for loop or using recursion, therefore no n dependent operations are performed
     * Time complexity is O(n)
     * space complexity is O(1)
     */
    public void delete(E data) {
        DoublyListNode<E> nodeToBeDeleted = search(data);
        if (nodeToBeDeleted.equals(head)) {
            if (head == tail) {
                //this will be automatically collected by GC
            } else {
                head = nodeToBeDeleted.next;
                nodeToBeDeleted.next.prev = null;
                nodeToBeDeleted.next = null;
            }
        } else if (nodeToBeDeleted.equals(tail)) {
            tail = nodeToBeDeleted.prev;
            nodeToBeDeleted.prev.next = null;
            nodeToBeDeleted.prev = null;
        } else {
            nodeToBeDeleted.prev.next = nodeToBeDeleted.next;
            nodeToBeDeleted.next.prev = nodeToBeDeleted.prev;
            nodeToBeDeleted.prev = null;
            nodeToBeDeleted.next = null;
        }
        length--;
    }

    /*
     * Searching an element qill require us to traverse each node in linked list starting from head.
     * So worst case is going through all the nodes.
     * Time complexity is O(n)
     * Space complexity is O(1)
     *
     */
    public DoublyListNode<E> search(E data) {
        DoublyListNode<E> temp = head;
        while (temp.next != null) {
            if (temp.data == data) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /*
     * This method returns a traversed linked list in form of string, with space seperated elements
     */
    public String traverse() {
        return toString();
    }

    /*
     * Returns data inside last node of linked list i.e. tail
     */
    public E getLast() {
        return tail.data;
    }

    /*
     * Returns data inside fist node of linked list i.e. head
     */
    public E getFirst() {
        return head.data;
    }

    @Override
    public String toString() {
        DoublyListNode<E> temp = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (temp != null) {
            stringBuilder.append(temp.data).append(" ");
            temp = temp.next;
        }
        return stringBuilder.toString();
    }

    public void addLast(E data) {
        if (tail != null) {
            tail.next = new DoublyListNode<>(data);
            tail = tail.next;
            length++;
        } else {
            tail = new DoublyListNode<>(data);
            head = tail;
            length++;
        }
    }
}