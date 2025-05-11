package com.DataStructures_And_Questions.linkedList;


import com.DS.LinkedList.LinkedList;
import com.DS.LinkedList.LinkedList.Node;

import java.util.HashSet;
import java.util.Set;
/**
 *Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by
 * continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 *
 * Do not modify the linked list.
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * */
public class DetectAndRemoveLoopLinkedList {

    public static void main(String[] args) {
        LinkedList l=new LinkedList();
        l.add("2");
        l.add("3");
        l.add("4");
        l.add("5");


//        new DetectAndRemoveLoopLinkedList().detectCycle();
    }

    /*
    * Here we are adding the noes in a set and checking if its already present.
    * If yes then we found a first node in the loop and return that.
    * Time Comp: O(n)
    * Space Comp: O(n)
    * */
    public Node detectCycle(Node head) {
        Set<Node> map=new HashSet<>();
        Node curr=head;
        int i=0;
        while(curr!=null){
            if(map.contains(curr)){
                return curr;
            }
            map.add(curr);
            curr=curr.next;
        }

        return null;
    }

    /*
     * Here we are adding the noes in a set and checking if its already present.
     * If yes then we found a first node in the loop and return that.
     * Time Comp: O(n)
     * Space Comp: O(1)
     * */
    public Node detectCycle_Better(Node head) {
          Node slow=head;
            Node fast=head;

            while(fast!=null && fast.next!=null){

            }

        return null;
    }
}
