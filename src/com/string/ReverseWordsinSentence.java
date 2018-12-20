package com.string;

/**
 * Reverse the order of words in a given sentence. Here are a few examples: 
 * e.g:
 * "The quick brown fox jumped over the lazy dog." -> 
 * "dog. lazy the over jumped fox brown quick The"
 * 
 */
public class ReverseWordsinSentence {
	
	public static void main(String[] args) {
		String input="The quick brown fox jumped over the lazy dog.";
		String output=reverseOrder_split(input);
		System.out.println(output);
	}

	/**
	 * In this example we have utilized the split method of Java and split the String
	 * based on space. Now we simply reverse the array by one of the classic array resersal method.
	 * We swap first and last element, second and second last element and so on...
	 * 
	 * At the end we have an array with reversed words order.
	 * But because this method used split function we cant be sure of its complexity untill we
	 * know the complexity of split function.
	 * So we can implement an algo from scratch which do not use existing functions.
	 */
	private static String reverseOrder_split(String input) {
		String[] ca=input.split(" ");
		int len=ca.length;
		for(int i=0;i<len-i-1;i++) {
			String temp=ca[i];
			ca[i]=ca[len-i-1];
			ca[len-i-1]=temp;
		}
		
		StringBuffer sb=new StringBuffer();
		for(String s:ca) {
			sb.append(s+" ");
		}
		return sb.toString();
	}
	
	
	/**
	 * We can reverse the whole String inside a char array
	 * and then we can reverse individual words by checking if space has been encountered or not
	 */
	private String reverse_algo(String input) {
		
		return null;
	}
}
