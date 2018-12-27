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

	/**
	 * With the naive approach, we can simple keep adding the divisor to itself 
	 * untill it is equal to or greater than divident.
	 * If equal then return the resultant divisor, if greater
	 * than return (resultant divisor-1), as this will be the quotient.
	 * 
	 * @TimeComplexity it can be O(divident) in worst case if
	 * expression is (1000000/1), which is a lot
	 */
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

	/**
	 * A better approach will be the recursive one.
	 * Idea:Quotient*divisor is always going to be less than or equal to divident
	 * 
	 * >we start off by setting quotient as 1
	 * >we take a temp var whose initial value is set to divisor.
	 * >We take base cases as given below to come out of recursion.
	 * >Now the idea is to keep multiplying quotient and temp(initialized with divisor)
	 *  by 2, untill temp is >= divident. So temp basically holds value which is obtained
	 *  after (divisor*quotient). And we *2(<<1) both divisor(temp) and quotient.
	 * >If temp==divident, then we return the quotient
	 * >If temp>divident, we go back a point where temp was just less than divident, by dividing 
	 * temp and quotient by 2 (>>1). Now temp is < divident 
	 * 	o Now we call recursivly this method, where divident is (divident-temp) and divisor remain same.
	 * > output will be sum of all quotient received from recursive calls.
	 * 
	 * @TimeComplexity O(logn) coz we are multiplying by 2 every time, essentially halving the effort
	 * @SpaceComplexity O(logn). Recursive call
	 */
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
