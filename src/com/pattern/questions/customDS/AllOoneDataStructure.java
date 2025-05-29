package com.pattern.questions.customDS;

import java.util.*;
/*
*Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.

Implement the AllOne class:

    AllOne() Initializes the object of the data structure.
    inc(String key) Increments the count of the string key by 1. If key does not exist in the data structure, insert it with count 1.
    dec(String key) Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it from the data structure. It is guaranteed that key exists in the data structure before the decrement.
    getMaxKey() Returns one of the keys with the maximal count. If no element exists, return an empty string "".
    getMinKey() Returns one of the keys with the minimum count. If no element exists, return an empty string "".

Note that each function must run in O(1) average time complexity.



Example 1:

Input
["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
Output
[null, null, null, "hello", "hello", null, "hello", "leet"]

Explanation
AllOne allOne = new AllOne();
allOne.inc("hello");
allOne.inc("hello");
allOne.getMaxKey(); // return "hello"
allOne.getMinKey(); // return "hello"
allOne.inc("leet");
allOne.getMaxKey(); // return "hello"
allOne.getMinKey(); // return "leet"

*
* All O`one Data Structure
https://leetcode.com/problems/all-oone-data-structure/description/
 * */
public class AllOoneDataStructure {

    public static void main(String[] args) {
        AllOoneDataStructure sol=new AllOoneDataStructure();
        sol.inc("hello");
        sol.inc("hello");
        System.out.println(sol.getMaxKey());
        System.out.println(sol.getMinKey());
        sol.dec("leet");
        System.out.println(sol.getMaxKey());
        System.out.println(sol.getMinKey());

    }


    class Node {
        int freq;
        Set<String> keys;
        Node prev, next;

        Node(int freq) {
            this.freq = freq;
            this.keys = new LinkedHashSet<>();
        }
    }

    private Map<String, Node> keyToNode = new HashMap<>();
    private Node head = new Node(0); // dummy head
    private Node tail = new Node(0); // dummy tail

    public AllOoneDataStructure() {
        head.next = tail;
        tail.prev = head;
    }

    // Insert new node after prevNode
    private void insertNodeAfter(Node prevNode, Node newNode) {
        newNode.prev = prevNode;
        newNode.next = prevNode.next;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
    }

    // Remove node from list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void inc(String key) {
        Node curr = keyToNode.getOrDefault(key, head);
        Node next = curr.next;

        int newFreq = curr.freq + 1;

        if (next == tail || next.freq != newFreq) {
            Node newNode = new Node(newFreq);
            insertNodeAfter(curr, newNode);
            next = newNode;
        }

        next.keys.add(key);
        keyToNode.put(key, next);

        if (curr != head) {
            curr.keys.remove(key);
            if (curr.keys.isEmpty()) removeNode(curr);
        }
    }

    public void dec(String key) {
        Node curr = keyToNode.get(key);
        if (curr == null) return;

        curr.keys.remove(key);

        if (curr.freq == 1) {
            keyToNode.remove(key);
        } else {
            Node prev = curr.prev;
            if (prev == head || prev.freq != curr.freq - 1) {
                Node newNode = new Node(curr.freq - 1);
                insertNodeAfter(prev, newNode);
                prev = newNode;
            }
            prev.keys.add(key);
            keyToNode.put(key, prev);
        }

        if (curr.keys.isEmpty()) removeNode(curr);
    }

    public String getMaxKey() {
        return tail.prev != head && !tail.prev.keys.isEmpty()
                ? tail.prev.keys.iterator().next()
                : "";
    }

    public String getMinKey() {
        return head.next != tail && !head.next.keys.isEmpty()
                ? head.next.keys.iterator().next()
                : "";
    }
}
