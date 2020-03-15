package com.questions.linkedList.linkedListBase;

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
    public void addFirst(E data) {
    	if (head == null) {
    		head = new Node(data);
    		tail = head;
    		length++;
    	} else{
    		Node dataNode = new Node(data);
    		dataNode.next=head;
    		head.previous=dataNode;
    		head=dataNode;
    		length++;
    	}
    }
    public void addLast(E data) {
    	if (head == null) {
    		head = new Node(data);
    		tail = head;
    		length++;
    	} else{
    		Node dataNode = new Node(data);
    		tail.next=dataNode;
    		dataNode.previous=tail;
    		tail=dataNode;
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
            	head=null;
            	tail=null;
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
        if(temp.data==data)
        {
        	return temp;
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
