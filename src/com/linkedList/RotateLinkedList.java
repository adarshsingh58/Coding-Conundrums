package com.linkedList;

import com.linkedList.linkedListBase.LinkedList;
import com.linkedList.linkedListBase.LinkedList.Node;

/**
 * Given head node of a singly linked list and an integer 'n', rotate linked list by 'n'.
 * e.g.
 * InputList = 1,2,3,4,5
 * n = 2
 * OutputLIst = 4,5,1,2,3
 * 
 */
public class RotateLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		int n = 1;
		rotateList(linkedList,n);
		
	}

	/**
	 * Here, we are using two pointers i and j which are n distance apart.
	 * We traverse them untill j reaches the tail.
	 * At this point, i will point at the Node right before the node from where the rotation will occur
	 * So, we point next of i to null and next of j to head. 
	 * While also making i's next as head now.
	 * 
	 * @TimeComplexity O(n), the list is traversed n times
	 * @SpaceComplexity O(1), no new storage was used.
	 *  
	 */
	private static void rotateList(LinkedList<Integer> linkedList, int n) {
		//Making sure that rotation size is within the limits of the list.
		//If not mod it
		if (n > linkedList.length) {
			n = n % linkedList.length;
		}
		
		Node i = linkedList.head;
		Node j = i;
		for (int k = 0; k < n; k++) {
			j = j.next;
		}

		while (j.next != null) {
			i = i.next;
			j = j.next;
		}
		Node tempHead = i.next;
		i.next = null;
		j.next = linkedList.head;
		linkedList.head = tempHead;
	}
}
