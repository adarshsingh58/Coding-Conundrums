package com.scenarioBasedQues;

import java.util.List;

import com.math.PermuteString;

/**
 * Arrange the characters of the input string in various combinations and find
 * out the number of occurrences of the substring. 
 * Sample Input: ATSC CAT 
 * Sample Output: 2
 * 
 * There are 4! permutation possible for ATSC and out of them
 * only CATS and SCAT contains CAT as a sub string. 
 */
public class FindSubStrInAllPermutation {
	
	public static void main(String[] args) {
		String inputString="ATSC";
		String keyWord="CAT";
		
		int x=findSubstrInAllPerm(inputString,keyWord);
		System.out.println(x);
		
	}

	private static int findSubstrInAllPerm(String inputString, String keyWord) {
		List<String> list=PermuteString.printAllPermutation(inputString);
		int count=0;
		for(String s:list) {
			if(s.contains(keyWord)) {
				count++;
				System.out.println(keyWord+" found in "+s);
			}
		}
		return count;
	}

}
