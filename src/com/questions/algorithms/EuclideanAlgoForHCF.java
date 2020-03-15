package com.questions.algorithms;

/**
 * Given 2 numbers, find GCD/HCF of them. 
 * e.g 36 and 60 
 * HCF = 12
 */
public class EuclideanAlgoForHCF {
	public static void main(String[] args) {
		int x = 36, y = 60;
		int hcf = findHCF(x, y);
		System.out.println(hcf);
		int lcm=findLCM(x,y);
		System.out.println(lcm);
	}



	/**
	 * Euclidean algo says that hcf of 2 numbers x and y will
	 * be same as hcf of (x-y and y) where x>y.
	 * > we keep calling findHCF with differenceOfTwoNumbers and smallerNumber
	 * > Until one of the numbers divide other number
	 * >This number is our HCF 
	 */
	private static int findHCF(int x, int y) {
		if (x % y == 0) {
			return y;
		} else if (y % x == 0) {
			return x;
		} else {
			if (x > y)
				return findHCF(x - y, y);
			else
				return findHCF(y - x, x);
		}
	}
	
	/**
	 * Now using HCF we can find LCM as :
	 * x*y=lcm*hcf
	 */
	private static int findLCM(int x, int y) {
		int hcf=findHCF(x, y);
		int lcm=(x*y)/hcf;
		return lcm;
	}
}
