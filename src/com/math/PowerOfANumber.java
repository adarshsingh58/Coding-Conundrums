package com.math;

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
