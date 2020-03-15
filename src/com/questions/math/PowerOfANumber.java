package com.questions.math;

/**
 * Given a double 'x' and an integer 'n'. Write a function to calculate 'x'
 * raised to the power 'n'.
 * 
 */
public class PowerOfANumber {

	public static void main(String[] args) {
		int x = 2;
		int y = 9;
		int output = pow(x, y);
		System.out.println(output);
	}

	/**
	 * For x^y
	 * In divide step we keep dividing y by 2 recursively until we reach the base
	 * case i.e. y == 1.
	 * In combine step we get result 'r' of the sub-problem and
	 * compute result of the current problem using below two rules:
	 * 
	 * if y is even, then result is r * r (where r is the result of sub-problem) 
	 * if y is odd, then result is x * r * r (where r is the result of sub-problem)
	 * 
	 */
	private static int pow(int x, int y) {
		if (y == 1) {
			return x;
		}
		int temp = pow(x, y / 2);
		if (y % 2 == 0) {
			return temp * temp;
		} else {
			return x * temp * temp;
		}
	}
}
