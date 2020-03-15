package com.questions.linkedList;

import com.questions.linkedList.linkedListBase.LinkedList.Node;

/**
 * Write a function findFirstLoopNode() that checks whether a given Linked List
 * contains loop. If loop is present then it returns point to first node of
 * loop. Else it returns NULL.
 * 
 */
public class FindLoopNodeInLoopLinkedList {

	public static void main(String[] args) {

	}

	/**
	 * 
	 * 
	 * Step1: Proceed in the usual way, you will use to find the loop, i.e. Have two
	 * pointers, increment one in single step and other in two steps, If they both
	 * meet in sometime, there is a loop.
	 * 
	 * Step2: Freeze one pointer where it was and increment the other pointer in one
	 * step counting the steps you make and when they both meet again, the count
	 * will give you the length of the loop (this is same as counting the number of
	 * elements in a circular link list).
	 * 
	 * Step3: Reset both pointers to the start of the link list, increment one
	 * pointer to the length of loop times and then start the second pointer.
	 * increment both pointers in one step and when they meet again, it will be the
	 * start of the loop (this is same as finding the nth element from the end of
	 * the link list).
	 * 
	 */
	public Node findFirstLoopNode_usingLoopLength() {
		return null;
	}

	/**
	 * 1. If a loop is found, initialize slow pointer to head, let fast pointer be
	 * at its position. 
	 * 2. Move both slow and fast pointers one node at a time. 
	 * 3. The point at which they meet is the start of the loop.
	 * 
	 * REF: https://www.geeksforgeeks.org/find-first-node-of-loop-in-a-linked-list/
	 * 
	 */
	public Node findFirstLoopNode_usingBetterAlgo() {
		return null;
	}

}
