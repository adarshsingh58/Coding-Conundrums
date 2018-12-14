package com.array.conundrums.rotation;

import com.array.arrayRotation.ArrayRotate;
import com.array.arraySort.ArraySort;
import com.array.utilites.Helper;

/**
 * 
 * Quickly find multiple left rotations of an array | Set 1
 * 
 * Given an array of size n and multiple values around which we need to left
 * rotate the array. How to quickly find multiple left rotations?
 * 
 * Input : arr[] = {1, 3, 5, 7, 9}
 * k1 = 1 k2 = 3 k3 = 4 k4 = 6 
 * Output : 
 * 3 5 7 9 1
 * 7 9 1 3 5
 * 9 1 3 5 7
 * 3 5 7 9 1
 */
public class FindMultipleRotation {

	public static void main(String[] args) {
		 int[] inputArr = {1, 3, 5, 7, 9};
		 int[] kArr={1,3,4,6};
		FindMultipleRotation findMultipleRotation=new FindMultipleRotation(); 
		findMultipleRotation.subsequentRotationMethod(inputArr,kArr);
	}
	
	/**
	 * @Pseudo
	 * Instead of doing kArr[i] rotation operation everytime on inputArr,
	 * We do kArr[i]-kArr[i-1] operation on ROTATED ARRAY from operation kArr[i-1]-kArr[i-2]
	 * @PreRequisite
	 * kArr should be sorted in ascending order. Duplicates can be handled by this algo
	 * @Analysis
	 * Sorting of kArr will take best case O(log n) if we use best algorithim
	 * Since we are performing rotation of n items, m times where n is no of elemnts in inputArr and m is no of elements in kArr
	 * Time complexity is O(mn)
	 * This is not a very efficient approach but better then rotating inputArr individually kArr[i] times 
	 * as here we have reduce rotation operations 
	 */
	public void subsequentRotationMethod(int[] inputArr, int[] kArr) {
		ArraySort arraySort = new ArraySort();
		// arraySort.sort(kArr);
		ArrayRotate arrayRotate = new ArrayRotate();
		for (int i = 0; i < kArr.length; i++) {
			if (i > 0)
				inputArr = arrayRotate.rotateMethod1(inputArr, kArr[i] - kArr[i - 1]);
			else
				inputArr = arrayRotate.rotateMethod1(inputArr, kArr[i]);
			System.out.print("\n");
		}
	}
	
}