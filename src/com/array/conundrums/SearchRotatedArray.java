package com.array.conundrums;

/**
 * Search a given number in a sorted array that has been rotated by some
 * arbitrary number. Return -1 if the number does not exist.
 * 
 * InputArray: 1 10 20 47 59 63 75 88 99 107 120 133 155 162 176 188 199 200 210 222
 * InputRotatedArray 6 times: 176 188 199 200 210 222 1 10 20 47 59 63 75 88 99 107 120 133 155 162
 * 
 * NumberToFind=75.
 * 
 * O/P index -> 12
 *
 */
public class SearchRotatedArray {

	public static void main(String[] args) {
		int[] inputArr = new int[] { 176, 188, 199, 200, 210, 222, 1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133,
				155, 162 };
		int numberToFind=75;
		//Naive Approach would be to do a linear search from 0th index to nth index making O(n) time complexity
		
		//But we can utilize the fact that the array is actually sorted, though rotated.
		int indexOutput=searchNumber_ModifiedBinarySearch(inputArr,numberToFind,0 , inputArr.length-1);
		System.out.println("Number found at "+indexOutput);
	}

	/**
	 * In this algo we will utilize the property of the inputArr after finding the
	 * mid point of the array, we know that atleast one half of the array is sorted.
	 * 
	 * IF -> numberToFind > inputArr[midIndex] && numberToFind > inputArr[endIndex]
	 * : We are in unsorted half, now move to sorted half and continue binary search
	 * 
	 * IF -> numberToFind > inputArr[midIndex] && numberToFind < inputArr[endIndex]
	 * : We are in sorted half, continue binary search
	 * 
	 * @BreakingCondition when numberToFind matches value at mid
	 * @TimeComplexity Since this is a binary search , O(log n)
	 * @SpaceComplexity The operation is performed on same array hence, O(1)
	 * 
	 */
	private static int searchNumber_ModifiedBinarySearch(int[] inputArr, int numberToFind, int startIndex,
			int endIndex) {

		int midIndex = (startIndex + endIndex) / 2;
		if (numberToFind == inputArr[midIndex]) {
			return midIndex;
		} else if ((numberToFind > inputArr[midIndex] && numberToFind > inputArr[endIndex])
				|| numberToFind < inputArr[midIndex]) {
			return searchNumber_ModifiedBinarySearch(inputArr, numberToFind, startIndex, midIndex - 1);
		} else if (numberToFind > inputArr[midIndex] && numberToFind < inputArr[endIndex]) {
			return searchNumber_ModifiedBinarySearch(inputArr, numberToFind, midIndex + 1, endIndex);
		}
		return -1;
	}
	
	
}
