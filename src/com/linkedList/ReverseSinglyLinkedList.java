package com.linkedList;

import com.linkedList.linkedListBase.LinkedList;
import com.linkedList.linkedListBase.LinkedList.Node;

/**
 * Given the pointer/reference to the head of a singly linked list, reverse it
 * and return the pointer/reference to the head of reversed linked list.
 * e.g:
 * inputList:  7 > 14 > 21 > 28 > null
 * outputList: 28 > 21 > 14 > 7 > null
 * 
 */
public class ReverseSinglyLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> list=new LinkedList<>();
		list.add(7);
		list.add(14);
		list.add(21);
		list.add(28);
		reverse(list);
		
		System.out.println(list);
	}

	/**
	 * Here, we are doing the reversal in a single pass.
	 * Idea is to have two pointer, i and j. i will become head of new list 
	 * while j keep traversing the original list.
	 * 
	 * >i is head and j is head.next
	 * >we do i.next=null, marking it as a new list where tail is i.
	 * >we keep a temp var for j while moving j to j.next
	 * >temp var now points to i and i now points to temp.
	 * 
	 * @TimeComplexity O(n). Reversal happened in single pass
	 * @SpaceComplexity O(1). No new list used, only references of existing nodes changed
	 * 
	 */
	private static void reverse(LinkedList<Integer> list) {
		Node i=list.head;
		Node j=list.head.next;
		i.next=null;
		while(j!=null) {
			Node temp=j;
			j=j.next;
			temp.next=i;
			i=temp;
		}
		list.head=i;
	}
	
	
}
