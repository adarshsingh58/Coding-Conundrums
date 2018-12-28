package com.math;

/**
 * Given any number, write a function to calculate its square root. 
 * Square root of 2.25 is 1.5 :  for 1<n, sqrt(n)<n
 * 
 * Square root of .81 is .9 : for 0<n<1, sqrt(n)>n
 */
public class CalculateSquareRoot_Double {
	
	private static final double EPSILON = 0.001;
	
	public static void main(String[] args) {
		double number=99;
		double sqrt=findSqrt(number);
		System.out.println(sqrt);
	}

	/**
	 * First Change var to double.
	 * Take care of epsilon
	 * 
	 */
	private static double findSqrt(double number) {
		double upperLimit = 1 + (number / 2);
		return binarySearch(0, upperLimit, number);
	}

	/**
	 * Changes -> Math.abs(mid*mid-number)<=Math.abs(EPSILON)
	 */
	private static double binarySearch(double lowerLimit, double upperLimit, double number) {
		double mid=(lowerLimit+upperLimit)/2;
		if(Math.abs(mid*mid-number)<=Math.abs(EPSILON)) {
			return mid;
		}else if(mid*mid<number) {
			return binarySearch(mid+1, upperLimit, number);
		}else {
			return binarySearch(lowerLimit, mid-1, number);
		}
	}
}
