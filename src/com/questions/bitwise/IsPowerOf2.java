package com.questions.bitwise;

public class IsPowerOf2 {

	public static void main(String[] args) {
		int n=32;
		boolean isPowOf2= isPowOf2(n);
		System.out.println(isPowOf2);
	}

	/**
	 * Any number which is a power of 2 will always have only 1 set bit in its 
	 * binary representation.
	 */
	private static boolean isPowOf2(int n) {
		int countofSetBits=CountSetBitsInAnInteger.countSetBits(n);
		if(countofSetBits==1) {
			return true;
		}
		return false;
	}
}
