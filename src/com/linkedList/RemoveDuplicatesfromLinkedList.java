package com.linkedList;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.Helper;


/**
 * Remove duplicate nodes from linked list of integers while keeping only the
 * first occurrence of duplicates.
 * 
 */
public class RemoveDuplicatesfromLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(7);
		list.add(14);
		list.add(21);
		list.add(28);
		list.add(14);
		list.add(18);
		list.add(11);
		list.add(5);
		list.add(5);
		list.add(7);

		/*
		 * A naive approach will be to traverse entire list per element to see for duplicates and remove
		 * That will be O(n SQUARE) compleaxity.
		 * Below is a better solution 
		 */
		
		removeDuplicate(list);
	}

	/**
	 * Here, we are adding elements from list to the set.
	 * If element already exist in set, then we are removing it from the list else not.
	 * By the end of the loop, we have list with unique elements.
	 * 
	 *  @TimeComplexity O(n). The list is traversed only once
	 *  @SpaceComplexity O(n). We needed additional storage for set. Also, a new o/p list was used
	 *  because, we cannot modify linkedlist while traversing it dur to concurrent modification limitation.
	 */
	private static void removeDuplicate(LinkedList<Integer> list) {
		Set<Integer> set=new HashSet<>();
		LinkedList outputList=new LinkedList(list);
		for(Integer data:list) {
			if(set.contains(data)){
				outputList.remove(data);
			}else {
				set.add(data);
			}
		}
		Helper.printLinkedList(outputList);
	}
}
