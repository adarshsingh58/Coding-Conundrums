package com.CrackingTheCodingInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, 
 * 1: Find if a palindrome of among its permutation exist or not. 
 * 2: If yes, we need to print all possible palindromes that can be
 * generated using letters of that string. 
 * Input: str = "aabcb" 
 * Output: abcba bacab
 */
public class PalindromePermutation {
	public static void main(String[] args) {
		String input = "tactcoa";
		System.out.println(permutationPalindromeExist(input));
		if (permutationPalindromeExist(input)) {
			printAllPermutationPalindrome(input);
		}
	}

	private static void printAllPermutationPalindrome(String input) {
		
	}

	/**
	 * A palindrome is a word which spells same if read backwards.
	 * e.g. rivir, baddab
	 * As we see there are 2 types of palindromes, even and odd, depending on no of chars they have.
	 * >For odd palindromes, there would be one char which is in odd number like v in river and
	 * 	it is always in middle
	 * >For even palindromes, all chars must be in even numbers and there is no middle char.
	 * 
	 * Here, we traverse through the string:
	 *  > We add each char in map the every odd time ie when countMap.get(char) is null
	 *  > We remove the char every even time, ie. if char is found in map remove it
	 *  > Simple saying, if char found in map, remove it else add it.
	 *  > If there are even num of one char say 'i' in rivir, then eventually map will not
	 *    contain it as it will be removed upon even call.
	 *  > If there are odd num of one char say 'v' in river, that will stay in the map as 
	 *    there is no even 'v' to remve it
	 *  > Hence, at the end the size of the map must be 0(for even palindromes) or 1(for odd palindromes)
	 *  > If it is> 1 then there are >1 char with odd value and hence palindrome can never be formed.
	 *  
	 */
	private static boolean permutationPalindromeExist(String input) {
		Map<Character, Integer> countMap=new HashMap<>();
		for(char c:input.toCharArray()) {
			if(countMap.get(c)!=null) {
				countMap.remove(c);
			}else {
				countMap.put(c, 1);
			}
		}
		return countMap.size()<=1?true:false;
	}
	
	
}
