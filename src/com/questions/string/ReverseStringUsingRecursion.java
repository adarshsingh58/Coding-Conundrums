package com.questions.string;

public class ReverseStringUsingRecursion {

	public static void main(String[] args) {
		String input="My name is Adarsh";
		input=reverse(input.toCharArray(),0,input.length()-1);
		System.out.println(input);
	}

	private static String reverse(char[] input, int i, int j) {
		if(i<j) {
			char temp=input[i];
			input[i]=input[j];
			input[j]=temp;
			return reverse(input, ++i, --j);
		}else {
			return new String(input);
		}
		
	}
}
