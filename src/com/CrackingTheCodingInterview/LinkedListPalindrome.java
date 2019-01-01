package com.CrackingTheCodingInterview;

import com.linkedList.linkedListBase.LinkedList;

/**
 * Identify if a linkedlist of characters is palindrome or not
 */
public class LinkedListPalindrome {
	public static void main(String[] args) {
		LinkedList<Character> linkedList1 = new LinkedList<>();
		linkedList1.add('a');
		linkedList1.add('b');
		linkedList1.add('b');
		linkedList1.add('a');
		System.out.println(isPalindrome_stack(linkedList1));
		System.out.println(isPalindrome_recursion(linkedList1));
	}

	private static boolean isPalindrome_recursion(LinkedList<Character> linkedList1) {
		// TODO Auto-generated method stub
		return true;
	}

	private static boolean isPalindrome_stack(LinkedList<Character> linkedList1) {
		
		return true;
	}
}
