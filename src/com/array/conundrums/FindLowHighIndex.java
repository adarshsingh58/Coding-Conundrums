package com.array.conundrums;

/**
 * Given a sorted array of integers, return the low and high index of the given
 * key. Return -1 if not found. The array length can be in millions with lots of
 * duplicates.
 * e.g.
 * inputArr: 1,2,5,5,5,5,5,5,5,5,20
 * key: 5
 * o/p: low index-> 2 high index -> 9
 * key: 20
 * o/p: low index-> 10 high index -> 10
 * 
 */
public class FindLowHighIndex {
	
	public static void main(String[] args) {
		int[] inputArr = new int[] { 1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 20 };
		String indexes = findLowHighIndex(inputArr);
		System.out.println("low index:" + indexes.charAt(0) + "\n high index:" + indexes.charAt(2));
	}

	private static String findLowHighIndex(int[] inputArr) {
		StringBuffer buffer=new StringBuffer();
		
		
		return null;
	}

}
