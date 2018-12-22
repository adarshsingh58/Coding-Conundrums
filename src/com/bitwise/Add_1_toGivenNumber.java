package com.bitwise;

/**
 * Add one to a given number. The use of operators like ‘+’, ‘-‘, ‘*’, ‘/’,
 * ‘++’, ‘–‘ …etc are not allowed.
 * Input: 12 
 * Output: 13
 */
public class Add_1_toGivenNumber {
	public static void main(String[] args) {
		int n=5;
		int output=addOne(n);
		System.out.println(output);
	}

	/**
	 * We know that the negative number is represented in 2’s complement form on
	 * most of the architectures. We have the following lemma hold for 2’s
	 * complement representation of signed numbers.
	 * 
	 * 
	 * Say, x is numerical value of a number, then
	 * 
	 * ~x = -(x+1) [ ~ is for bitwise complement ]
	 * 
	 * (x + 1) is due to addition of 1 in 2’s complement conversion
	 * 
	 * To get (x + 1) apply negation once again. So, the final expression becomes
	 * (-(~x)).
	 */
	private static int addOne(int n) {
		return -(~n);
	}
}
