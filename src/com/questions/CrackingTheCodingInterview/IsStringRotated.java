package com.questions.CrackingTheCodingInterview;

/**
 * Given a string s1 and a string s2, write a snippet to say whether s2 is a
 * rotation of s1 using isSubstring/contains method.
 * eg:
 * input1=waterbottle
 * input2=erbottlewat
 * 
 * O/P
 * input2 is rotated version of input1
 */
public class IsStringRotated {
	public static void main(String[] args) {
		String input1 = "waterbottle";
		String input2 = "erbottlewat";
		boolean isRot = isRotated(input1, input2);
		System.out.println(isRot);
	}

	/**
	 * Here, we appended originalString to itself.
	 * Now we see that if the second string is a part of original string or not.
	 * If yes, second string is rotated form of original string.
	 */
	private static boolean isRotated(String input1, String input2) {
		String concatStr = input1.concat(input1);
		if (concatStr.contains(input2))
			return true;
		else
			return false;
	}
}
