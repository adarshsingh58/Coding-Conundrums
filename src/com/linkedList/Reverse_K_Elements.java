package com.linkedList;

import java.util.Queue;
import java.util.Stack;

import com.linkedList.linkedListBase.LinkedList;
import com.linkedList.linkedListBase.LinkedList.Node;

/**
 * Given a singly linked list and an integer 'k', reverse every 'k' elements. 
 * If k <= 1, then input list is unchanged. 
 * If k >= n (n is the length of linked list), then reverse the whole linked list.
 * e.g.
 * InputList= 1,2,3,4,5,6
 * k=4
 * OutputList= 4,3,2,1,6,5
 *
 */
public class Reverse_K_Elements {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.add(6);
		int k=4;
//		reverseKElements(linkedList,k);
		reverseEveryKElements(linkedList,k);
		
	}

	/**
	 * A very simple technique of queue is used here.
	 * >We add the elments inside queue from linkedList till kth element.
	 * >This we start dequeuing(polling) elements and adding them to head of the linkedlist.
	 * >We will get a linkedlist with k elmeents reversed.
	 * 
	 * @TimeComplexity O(k), at max we will traverse entire linkedlist n and then traversing entire queue n i.e. O(2k)
	 * which asymptotically is O(k) if k reaches nit will become O(n)
	 * 
	 * @SpaceComplexity O(n), we used a queue of size n
	 */
	private static void reverseKElements(LinkedList<Integer> linkedList, int k) {
		if (k <= 1) {
			return;// changes needed
		} else if (k > linkedList.length) {
			k = linkedList.length;
		}
		Node current = linkedList.head;
		Queue<Integer> queue = new java.util.LinkedList<>();
		for (int i = 0; i < k; i++) {
			queue.add((int) current.data);
			int currentdata=(int) current.data;
			current = current.next;
			linkedList.delete(currentdata);
		}
		for (int i = 0; i < k; i++) {
			Integer polled = queue.poll();
			linkedList.addFirst(polled);
		}
	}
	

	/**
	 * In this case, we are not reversing first k elements but EVERY k elements in the list.
	 * >For first k elements push the data inside stack
	 * >Now pop the data from stack and append them at Last of the linkedlist
	 * >Now repear the same steps for every next k elements untill the end of linked list
	 * 
	 * We have to take care of scenario where number of elements left are
	 * less than k, they should be reversed too > (j == linkedListLen && i < k) < condition
	 * took care of that
	 * 
	 * @TimeComplexity O(nk) where n is the length of linked list and k length of k.
	 * 
	 * @SpaceComplexity O(k) we used a stack of size k
	 */
	private static void reverseEveryKElements(LinkedList<Integer> linkedList, int k) {
		Stack<Integer> stack = new Stack<>();

		int i = 0, j = 0;
		int linkedListLen = linkedList.length;
		while (i < k && j < linkedListLen) {
			stack.push(linkedList.getFirst());
			linkedList.delete(linkedList.getFirst());
			i++;
			j++;
			if (i == k || (j == linkedListLen && i < k)) {
				while (!stack.isEmpty()) {
					linkedList.addLast(stack.pop());
				}
				if (j != linkedList.length)
					i = 0;
			}
		}
	}
	
	
	
}
