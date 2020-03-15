package com.questions.CrackingTheCodingInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement an algo to determine if a string has all unique char
 * with and without using addition DS
 * e.g: 
 * London -> Not unique. 'n' and 'o' repeated 
 * Sitapur -> unique
 */
public class IsUnique {
	public static void main(String[] args) {
		String input = "London";
		System.out.println(isUnique_withDS(input));
		System.out.println(isUnique_withoutDS(input));
	}

	private static boolean isUnique_withDS(String input) {
		Map<Character, Integer> count = new HashMap<>();
		for (char c : input.toCharArray()) {
			if (count.get(c) != null) {
				return false;
			} else {
				count.put(c, 1);
			}
		}
		return true;
	}
	
	/**
	 * In this approach we sort the string and check for any same adjacent chars.
	 * If found, duplicate exist else not
	 * 
	 * @TimeComplexity O(n + nlogn) i.e. sorting + travesing -> O(nlogn)
	 */
	private static boolean isUnique_withoutDS(String input) {
		char[] charInput=input.toCharArray();
		charInput=sortArray(charInput);
		for(int i=0;i<charInput.length;i++) {
			if(i==i+1) {
				return false;
			}
		}
		return true;
	}

	private static char[] sortArray(char[] charInput) {
		return null;
	}
}
