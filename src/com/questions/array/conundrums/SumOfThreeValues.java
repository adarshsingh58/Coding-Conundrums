package com.questions.array.conundrums;

import com.questions.array.ArraySearchRotated;
import com.questions.array.ArraySort;

/**
 * Given an array of integers and a value, determine if there are any three
 * integers in the array that sum equal to the given value.
 * eg: inputArr= 3,7,1,2,8,4,5
 * target=20 -> possible 5+7+8
 * target=21 -> not possible. No 3 values sum upto 21
 */
public class SumOfThreeValues {
	public static void main(String[] args) {
		int[] inputArr= new int[] {3,7,1,2,8,4,5};
		int target=20;
		//as a naive method we can have 3 for loop and find 3 sum in O(n^3) time but lets use a better approach
//		boolean flag=is3valueSumPossible_binarySearch(inputArr,target);
//		System.out.println(flag);
		
		boolean flag1=is3valueSumPossible_QuadraticApproach(inputArr, target);
		System.out.println(flag1);
		
	}

	/**
	 * Finding 3 sum is a little tricky than 2 sum. As a naive approach 3 for loop can be used but we have used a more refined way.
	 * >First we sort the data using QuickSort. TimeCimplexity O(log n)
	 * >Then using 2 loops, we get 2 input from index i and j from the array. Now we have 2 pair of digit and a target.Complexity (n^2)
	 * >We now use binary search to find (target-dataAt_i-dataAt_j), as this is the third digit. Complexity O(log n)
	 * >We omit data at ith and jth index if found during binary search as these digits have already been taken.
	 * 
	 * @TimeComplexity O(n^2 logn). Quicksort was sequential but binary search was inside 2 loops, hence (n^2 log n).
	 * @SpaceComplexity O(1)
	 */
	private static boolean is3valueSumPossible_binarySearch(int[] inputArr, int target) {
		ArraySort arraySort=new ArraySort();
		inputArr=arraySort.quickSort(inputArr);
		inputArr=new int[] {1,2,3,4,5,7,8};//coz quickSort is not implemented manually putting sorted data
		for (int i = 0; i < inputArr.length; i++) {
			for (int j = i + 1; j < inputArr.length; j++) {
				int remainingSum = target - inputArr[i] - inputArr[j];
				int indexFound = new ArraySearchRotated().binarySearch(inputArr, 0, inputArr.length-1, remainingSum);
				if (indexFound != -1 && indexFound != i && indexFound != j) {
					System.out.println("Numbers Found:" + inputArr[i] + " " + inputArr[j] + " " + inputArr[indexFound]);
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Here we have further reduced the time complexity to O(n^2).
	 * We are leveraging the idea that we sort the input first.
	 * >We sort the input using quicksort. O(logn)
	 * >Now for each digit in inputArr, i, we find two pairs which sum upto(target-ith element).O(n)
	 * >We find these pairs in linear time, by leveraging that input is sorted.
	 *  we start from i=0 and j=length-1, and add them to see if the pair is found.
	 *  If not and sum of i and j is > (target-ith element), then we reduce jth index as j points to higher value
	 *  end in the sorted array. If sum of i and j is < (target-ith element), then we increase ith index as i points
	 *  to lower value end of the sorted array. Hence we find the pair.
	 *  
	 * @TimeComplexity O(n^2), as finding Pair is used inside fist for loop.
	 * @SpaceComlexity O(1), no new storage is used.
	 * 
	 */
	private static boolean is3valueSumPossible_QuadraticApproach(int[] inputArr, int target) {
		ArraySort arraySort=new ArraySort();
		inputArr=arraySort.quickSort(inputArr);
		inputArr=new int[] {1,2,3,4,5,7,8};//coz quickSort is not implemented manually putting sorted data
		
		for(int i=0;i<inputArr.length;i++) {
			int remainingSum=target-inputArr[i];
			boolean found=findPairWithRemainingSum(inputArr,remainingSum,inputArr[i]);
			if(found) {
				return true;
			}
		}
		return false;
	}

	private static boolean findPairWithRemainingSum(int[] inputArr, int remainingSum, int firstDigit) {
		for(int i=0, j=inputArr.length-1;i<inputArr.length&& i<j;) {
			if(inputArr[i]==firstDigit) {
				i++;
			}else if(inputArr[j]==firstDigit) {
				j--;
			}else if(inputArr[i]+inputArr[j]==remainingSum) {
				System.out.println("Numbers Found: "+firstDigit+" "+inputArr[i]+" "+inputArr[j]);
				return true;
			}else if(inputArr[i]+inputArr[j]>remainingSum) {
				j--;
			}else {
				i++;
			}
			
		}
		return false;
	}
}
