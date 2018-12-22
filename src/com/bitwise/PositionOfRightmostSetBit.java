package com.bitwise;

/**
 * Write a one line function to return position of first 1 from right to left,
 * in binary representation of an Integer.
 * 
 * I/P 18, 
 * Binary Representation 010010 
 * O/P 2
 * 
 * I/P 19, 
 * Binary Representation 010011 
 * O/P 1
 */
public class PositionOfRightmostSetBit {
	public static void main(String[] args) {
		int n=18;
		int position=positionOfRightmostSetBit(n);
		System.out.println(position);
	}

	/**
	 * We do n&1. This will give 1 if rightmost bit of n is 1 else will give 0.
	 * We keep on looping n while doing n=n>>1, i.e. right shifting
	 * untill we find n&1 as true i.e. 1 found on right most bit.
	 * We will keep counting the number of time rightshift has happened
	 * and when 1 found we will return i, else -1.
	 */
	private static int positionOfRightmostSetBit(int n) {
		int i = 1;
		while (n > 0) {
			if ((n & 1) == 1) {
				return i;
			}
			i++;
			n = n >> 1;
		}
		return -1;
	}
}
