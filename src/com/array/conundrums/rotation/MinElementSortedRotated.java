package com.array.conundrums.rotation;

/**
 * 
 * Find the minimum element in a sorted and rotated array
 * 
 * A sorted array is rotated at some unknown point, find the minimum element in
 * it.
 * 
 * Following solution assumes that all elements are distinct.
 * 
 * Examples
 * 
 * Input: {5, 6, 1, 2, 3, 4} Output: 1
 * 
 * Input: {1, 2, 3, 4} Output: 1
 * 
 * Input: {2, 1} Output: 1
 *
 */
public class MinElementSortedRotated {
	
	public static void main(String[] i){
		int[] inputArr={10, 1, 2, 3, 4,5, 6,7,8,9};
		MinElementSortedRotated elementSortedRotated=new MinElementSortedRotated();
		elementSortedRotated.method1(inputArr);
	}
	
	/**
	 * @Pseudo
	 * start = 0 and end = n
	 * while start!=end
	 * >find currIndex=(start+end)/2.
	 * >if(inputArr[currIndex]<inputArr[currIndex-1] && inputArr[currIndex] <inputArr[currIndex+1])
	 * 		print <MIN NUMBER FOUND>
	 * >else if(inputArr[currIndex]>inputArr[currIndex-1] && inputArr[currIndex] < inputArr[currIndex+1])
	 * 		start=0 and end = currIndex
	 * 		currIndex=start+currIndex/2;
	 * >else if(inputArr[currIndex]>inputArr[currIndex-1] && inputArr[currIndex] > inputArr[currIndex+1])
	 * 		print <MIN NUMBER at inputARR[currIndex+1]>
	 * 
	 * @Analysis
	 * Since we are divinding the inputs to work on by 2 evreytime. Timc complexity is O(log n)
	 * and space complexity is O(1)
	 */
	public int method1(int[] inputArr) {
		int start = 0, end = inputArr.length - 1;
		int min = inputArr[0];
		int currIndex = (start + end) / 2;
		while (start != end) {
			if (inputArr[currIndex] < inputArr[currIndex - 1] && inputArr[currIndex] < inputArr[currIndex + 1]) {
				System.out.println("number found " + inputArr[currIndex]);
				return currIndex;
			} else if (inputArr[currIndex] > min) {
				start = currIndex + 1;
				currIndex = (start + end) / 2;
			} else {
				min = inputArr[currIndex];
				end = currIndex;
				currIndex = (start + end) / 2;
			}
		}
		return -1;
	}

/*	
 * Same method can be use for Question: Find the Rotation Count in Rotated Sorted array 
 */
}
