package com.DS.LinkedList;


/**
 * Always remeber that a class var are like attributes of the object, the class represents
 * We should always think of updating all the attributes when an object's behaviour is called.
 * If you see this object orieted way, u will never mistake updating a var
 * <p>
 * For Add:  This is a modification behaviour so, we need to update the attributes also if required
 * For Delete: This is a modification behaviour so, we need to update the attributes also if required
 * For Search: This is not a modification behavior so we need not be worried about updating the attributes of the object
 * <p>
 * For LinkedList we cab identify following as its attribute:
 * >head : points to head of the linked list
 * >tail : points to tail of the linked list
 * >length : contains the active length of the LinkedList
 * <p>
 * For behaviour, following are the behaviour:
 * > add - add an element to linked list
 * > delete - delete element from linked list
 * > traverse - return a string with traversed elements
 * > getFirst - return the first node's (head) data in the Linked List
 * > getLast - return the last node's (tail) data in the Linked List
 * <p>
 * We have made LinkedList Generic by introducing <E>
 */
public class LinkedList<E> {
    public Node head;
    public Node tail;
    public int length;

    public LinkedList() {
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
            head = new Node(data);
            tail = head;
            length++;
        } else if (tail != null) {
            tail.next = new Node(data);
            tail.next.previous = tail;
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
            Node newHead = new Node(data);
            newHead.next=head;
            head=newHead;
            length++;
        }
    }

    /*
     * Deleting a data requires removing all the reference of the to be deleted node and altering refences of nodes next to and previous to it
     * For Search -> We are calling a search method here , which has Time complexity of O(n) and one temporary node, so space complexity of O(1)
     * For delete -> We are not calling any for loop or using recursion, therefore no n dependent operations are performed
     * Time complexity is O(n)
     * space complexity is O(1)
     */
    public void delete(E data) {
        Node nodeToBeDeleted = search(data);
        if (nodeToBeDeleted.equals(head)) {
            if (head == tail) {
                //this will be automatically collected by GC
            } else {
                head = nodeToBeDeleted.next;
                nodeToBeDeleted.next.previous = null;
                nodeToBeDeleted.next = null;
            }
        } else if (nodeToBeDeleted.equals(tail)) {
            tail = nodeToBeDeleted.previous;
            nodeToBeDeleted.previous.next = null;
            nodeToBeDeleted.previous = null;
        } else {
            nodeToBeDeleted.previous.next = nodeToBeDeleted.next;
            nodeToBeDeleted.next.previous = nodeToBeDeleted.previous;
            nodeToBeDeleted.previous = null;
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
    public Node search(E data) {
        Node temp = head;
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
        Node temp = head;
        StringBuffer stringBuffer = new StringBuffer();
        while (temp != null) {
            stringBuffer.append(temp.data + " ");
            temp = temp.next;
        }
        return stringBuffer.toString();
    }

    public void addLast(E data) {
        if (tail != null) {
            tail.next = new Node(data);
            tail = tail.next;
            length++;
        } else {
            tail = new Node(data);
            head = tail;
            length++;
        }
    }

    /*
     * Node class for holding data and references of next and previous node in a Linked List
     */
    public class Node {
        public E data;
        public Node next;
        public Node previous;

        public Node(E data) {
            this.data = data;
        }

    }
}