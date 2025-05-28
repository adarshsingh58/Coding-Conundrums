package com.DataStructures_And_Questions.linkedList;


import com.DS.DoublyListNode;
import com.DS.LinkedList.DoublyLinkedList;

import java.util.HashSet;
import java.util.Set;
/**
 *Given the head of a linked list, return the DoublyListNode where the cycle begins. If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some DoublyListNode in the list that can be reached again by
 * continuously following the next pointer. Internally, pos is used to denote the index of the DoublyListNode that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 *
 * Do not modify the linked list.
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to DoublyListNode index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second DoublyListNode.
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to DoublyListNode index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first DoublyListNode.
 *
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * */
public class DetectAndRemoveLoopLinkedList {

    public static void main(String[] args) {
        DoublyLinkedList l=new DoublyLinkedList();
        l.add("2");
        l.add("3");
        l.add("4");
        l.add("5");


//        new DetectAndRemoveLoopLinkedList().detectCycle();
    }

    /*
    * Here we are adding the noes in a set and checking if its already present.
    * If yes then we found a first DoublyListNode in the loop and return that.
    * Time Comp: O(n)
    * Space Comp: O(n)
    * */
    public DoublyListNode detectCycle(DoublyListNode head) {
        Set<DoublyListNode> map=new HashSet<>();
        DoublyListNode curr=head;
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
     * If yes then we found a first DoublyListNode in the loop and return that.
     * Time Comp: O(n)
     * Space Comp: O(1)
     * */
    public DoublyListNode detectCycle_Better(DoublyListNode head) {
          DoublyListNode slow=head;
            DoublyListNode fast=head;

            while(fast!=null && fast.next!=null){

            }

        return null;
    }
}
