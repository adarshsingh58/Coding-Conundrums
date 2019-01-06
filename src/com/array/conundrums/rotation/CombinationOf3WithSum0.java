package com.array.conundrums.rotation;

/**
 * Given an array containing positive and negative numbers. Find the
 * combinations of elements in array so that the sum of 3 elements is 0. eg:
 * Array = [-1, 5, -3, -2, 6, 2] Output: [5, -2, -3], [-2, 2, 0]
 * 
 * @author Adarshs
 */
public class CombinationOf3WithSum0 {

	/**
	 * 1. Sort all element of array 
	 * 2. Run loop from i=0 to n-2. Initialize two index variables l=i+1 and r=n-1 
	 * 4. while (l < r) Check sum of arr[i], arr[l], arr[r] is zero or not if sum is zero then print the triplet and do l++ and r--. 
	 * 5. If sum is less than zero then l++ 6. If sum is greater than zero then r-- 
	 * 7. If not exist in array then print not found.
	 * 
	 * (Sorting : O(n2))
	 * @param args
	 */
	public static void main(String[] args) {
		
//		int[] A ={0, -1, 2, -3, 1};
//		SORT ARRAY
		
		int[] A = new int[] { -1, -3, 0, 1, 2 };

		for (int i = 0; i < A.length - 2; i++) {
			int l = i + 1, r = A.length - 1;
			while (l < r) {
				if (A[i] + A[l] + A[r] == 0) {
					System.out.println(A[i] + ":" + A[l] + ":" + A[r]);
					break;
				} else if (A[i] + A[l] + A[r] < 0) {
					l++;
				} else {
					r--;
				}
			}
		}
	}

}
