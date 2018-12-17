package com.array.conundrums;

/**
 * Given three integer arrays sorted in ascending order, have to find the
 * smallest number that is common in all three arrays
 * 
 * InputArr1 6,8,14,22,38,55
 * InputArr2 1,2,4,22,33,15
 * InputArr3 4,22,29,41
 *
 * Output -> 22
 * 
 */
public class FindSmallestCommonNumber {

	public static void main(String[] args) {
		
		int[] inputArr1=new int[] {6,7,10,25,30,63,64};
		int[] inputArr2=new int[] {-1,4,5,6,7,8,50};
		int[] inputArr3=new int[] {1,6,10,14};
		
//		int[] inputArr1=new int[] {6,8,14,22,38,55};
//		int[] inputArr2=new int[] {1,2,4,22,33,15};
//		int[] inputArr3=new int[] {4,22,29,41};
		int commonNumber=findCommonNumber(inputArr1,inputArr2,inputArr3);
		
		System.out.println(commonNumber);
		
	}

	/**
	 * In this approach we keep 3 pointers i,j,k , one for each array. We will take advantage of the fact that
	 * the arrays are sorted.
	 * If value at these pointers match we return.
	 * coz the arrays are sorted, This means that if one of them is greater than other two, other two need to have a
	 * increased value, hence index++.
	 * If two of them are equals and other is greater, then other two needs to be increased, This case will be taken care by previous case itself.
	 * If two of them are equals and other is less, then this less one needs to be increamented.
	 *  
	 * @TimeComplexity  We are traversing loop for the longest array with size n. But indexes of 
	 * other arrays may increment while of longest array remains the same. so complexity is O(n+m+o), where n,m,o are respective lenght of arrays
	 * Asymptotically its O(n), where n is the size of the largest array
	 * 
	 * @SpaceComplexity Since we are not using any new array for storage its O(1)
	 */
	private static int findCommonNumber(int[] inputArr1, int[] inputArr2, int[] inputArr3) {
		int i = 0, j = 0, k = 0;

		while (i < inputArr1.length) {//inputArr1 must be the longest array
			if (inputArr1[i] == inputArr2[j] && inputArr2[j] == inputArr3[k]) {
				return inputArr1[i];
			} else {
				if (inputArr1[i] > inputArr2[j] && inputArr1[i] > inputArr3[k]) {
					j++;
					k++;
				} else if (inputArr2[j] > inputArr1[i] && inputArr2[j] > inputArr3[k]) {
					i++;
					k++;
				} else if (inputArr3[k] > inputArr2[j] && inputArr3[k] > inputArr1[i]) {
					i++;
					j++;
				} else if (inputArr1[i] == inputArr2[j] && inputArr1[i] > inputArr3[k]) {
					k++;
				} else if (inputArr1[i] == inputArr3[k] && inputArr1[i] > inputArr2[j]) {
					j++;
				} else if (inputArr3[k] == inputArr2[j] && inputArr2[j] > inputArr1[i]) {
					i++;
				}
			}
		}

		return -1;
	}
	
}
