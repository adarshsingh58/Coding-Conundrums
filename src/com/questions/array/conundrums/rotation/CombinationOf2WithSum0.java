package com.questions.array.conundrums.rotation;

/**
 * Given an array A[] and a number X, check for pair in A[] with sum as X
 * 
 * eg: A=[1,1,3,-2,4,-1] and X=0 O/P: (1,-1)
 * 
 * @author Adarshs
 */
public class CombinationOf2WithSum0 {

	public static void main(String[] args) {
		// int[] A=new int[]{1,1,3,-2,4,-1};
		// sortArray(A);
		int[] A = new int[] { -8, 1, 4, 6, 8, 45};
		int indexTillWhichNumbersAreNegative = 3;

		for (int i = 0, j = indexTillWhichNumbersAreNegative; i < indexTillWhichNumbersAreNegative && j < A.length;) {
			if(Math.abs(A[i])==A[j]){
				System.out.println(A[i]+":"+A[j]);
				i++;j++;
				break;
			}else if(Math.abs(A[i])<A[j]){
				i++;
			}else if(Math.abs(A[i])>A[j]){
				j++;
			}
		}

	}

	private static void sortArray(int[] a) {
	}
}
