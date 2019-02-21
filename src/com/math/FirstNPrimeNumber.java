package com.math;

public class FirstNPrimeNumber {

	public static void main(String[] args) {
		int n = 5;
		printNPrimeNumber(n);
	}

	/**
	 * All prime number are of form 6n+1 OR 6n-1 But all number who are of form 6n+1
	 * OR 6n-1 are not prime numbers. We will leverage this property
	 * 
	 */
	private static void printNPrimeNumber(int n) {

		if (n == 1) {
			System.out.println(2);
		} else if (n == 2) {
			System.out.println(2 + "\n" + 3);
		} else {
			System.out.println(2 + "\n" + 3);
			int count = 2;
			int i = 1;
			int firstNumber = 0;
			int secondNumber = 0;

			while (count != n) {
				firstNumber = (6 * i) - 1;
				secondNumber = (6 * i) + 1;
				if (IsPrimeNumber.isPrime(firstNumber)) {
					System.out.println(firstNumber);
					count++;
				}
				if (IsPrimeNumber.isPrime(secondNumber) && count < n) {
					System.out.println(secondNumber);
					count++;
				}
				i++;
			}
		}
	}
}
