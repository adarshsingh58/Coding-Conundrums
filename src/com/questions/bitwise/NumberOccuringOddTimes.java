package com.questions.bitwise;

/**
 * Given an array of positive integers. All numbers occur even number of times
 * except one number which occurs odd number of times
 * 
 * Input : arr = {5, 7, 2, 7, 5, 2, 5}
 * Output : 5
 */
public class NumberOccuringOddTimes {
	public static void main(String[] args) {
		int[] inputArr=new int[] {5, 7, 2, 7, 5, 2, 5};
		int output=findOddOccuringNumber(inputArr);
		System.out.println(output);
	}

	/**
	 * Here, the property of XOR is used. 
	 * XOR of 2 same numbers ( i.e. even occurence) is always 0
	 * And XOR of 0 and any other number x (i.e. odd occurence), is always x.
	 * 
	 * Hence, here we XOR all number and numbers with even occurence will be cancelled.
	 */
	private static int findOddOccuringNumber(int[] inputArr) {
		int a = inputArr[0];
		for (int i = 1; i < inputArr.length; i++) {
			a = a ^ inputArr[i];
		}
		return a;
	}
}
