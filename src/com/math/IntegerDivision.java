package com.math;

/**
 * Given two integers: x and y; return x ÷ y without using '/' (division) or '*'
 * (multiplication) operators.
 * 
 */
public class IntegerDivision {

	public static void main(String[] args) {
		int divident = 40;
		int divisor = 4;
		/*
		 * int output=divide_naive(divident,divisor); System.out.println(output);
		 */
		int output = divide_bitwise(divident, divisor);
		System.out.println(output);

	}

	private static int divide_naive(int divident, int divisor) {
		int i = 0;
		int tempSum = 0;
		while (tempSum < divident) {
			tempSum = tempSum + divisor;
			i++;
		}
		if (tempSum == divident) {
			return i;
		} else if (tempSum > divident) {
			return i - 1;
		}
		return 0;
	}

	private static int divide_bitwise(int divident, int divisor) {
		int quotient = 1;
		int temp = divisor;

		// Base Case
		if (divisor == 1) {
			return divident;
		} else if (divident == 0) {
			return 0;
		} else if (divident < divisor) {
			return 0;
		} else if (divisor == divident) {
			return 1;
		}
		while (temp <= divident) {
			quotient = quotient << 1;
			temp = temp << 1;
		}
		if (temp == divident) {
			return quotient;
		} else {// temp > divident
			quotient = quotient >> 1;
			temp = temp >> 1;
			return quotient + divide_bitwise(divident - temp, divisor);
		}
	}
}
