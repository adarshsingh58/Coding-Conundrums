package com.questions.bitwise;

/**
 * Given 2 integers, they are gray if they differ by 1 bit
 * eg: 00 and 01 i.e. 0 and 1 -> true
 * 01 and 10 i.e. 1 and 2 -> false. they differ by 2 bits
 * 
 * 
 */
public class GrayNumber {
	
	public static void main(String[] args) {
		int input=5;
		boolean b=isGrayNumber(input);
	}

	/**
	 * We can loop through each bit of both number
	 * and get last bit of each number and compare them:
	 * > if different, increment int var diff by 1.
	 * > if var diff becomes more than 1 break and return false
	 * 
	 * This approach requires O(n), where n is the number of bits in number
	 * 
	 * A better approach is:
	 * > if numbers are x and y, we XOR -> x^y
	 * > this will result in a number, which, if x and y
	 *   differs by 1 bit, will have only 1 bit set. else >1 bit set.
	 * > if XORed value has only 1 bit set, numbers are gray else not
	 * 
	 * e.g 100110 and 100010 -> XOR -> 000100. coz 3rd bit from left differs.
	 * 
	 * This process of XOR takes O(1) time but reading set bit may require to 
	 * traverse the XORed value. hence total:
	 * @TimeComplexity O(n),  where n is the number of bits in number
	 * 
	 */
	private static boolean isGrayNumber(int input) {
		
		return false;
	}

}
