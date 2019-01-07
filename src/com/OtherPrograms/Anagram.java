package com.OtherPrograms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Check if two strings are angaram
 * 
 */
public class Anagram {

	public static void main(String[] args) {
		String a = "listen", b = "silent";
		boolean isAnagram_sort = ifAnagram_sort(a, b);
		boolean isAnagram_Set = ifAnagram_Set(a, b);
		System.out.println(isAnagram_sort);
		System.out.println(isAnagram_Set);
	}

	/**
	 * @TimeComplexity O(nlogn)
	 * @SpaceComplexity O(1). No new DS used (char arrays are not counted here)
	 */
	private static boolean ifAnagram_sort(String a, String b) {
		if (a.length() == b.length()) {
			char[] ac = a.toCharArray(), bc = b.toCharArray();
			Arrays.sort(ac);
			Arrays.sort(bc);
			if (new String(ac).equals(new String(bc))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @TimeComplexity O(n)
	 * @SpaceComplexity O(n). set of size of strings used
	 */
	private static boolean ifAnagram_Set(String a, String b) {
		if (a.length() == b.length()) {
			Set<Character> set = new HashSet<>();
			for (int i = 0; i < a.length(); i++) {
				set.add(a.charAt(i));
			}

			for (int i = 0; i < b.length(); i++) {
				set.remove(b.charAt(i));
			}

			if (set.isEmpty()) {
				return true;
			}
		}
		return false;
	}
}
