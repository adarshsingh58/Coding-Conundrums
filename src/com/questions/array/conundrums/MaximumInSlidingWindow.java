package com.questions.array.conundrums;

import com.heap.Heap;

/**
 * Given a large array of integers and a window of size 'w', find the current
 * maximum in the window as the window slides through the entire array.
 * 
 * Consider the array below and let's try to find all maximum with window size = 3.
 * -4,2,-5,3,6
 * <p> 
 *  1st window of 3 elements max = 2
 *  2nd window of 3 elements max = 3
 *  3rd window of 3 elements max = 6
 * </p>
 */
public class MaximumInSlidingWindow {

	public static void main(String[] args) {
		int[] inputArray=new int[]{5,7,-5,8,9,-1};
		int slidingWindowSize=3;
		System.out.println("Printing Max values in window size"+slidingWindowSize);
		maxInSlidingWindow_NaiveApproach(inputArray,slidingWindowSize);
		
		maxInSlidingWindow_HeapApproach(inputArray, slidingWindowSize);
		
	}

	/**
	 * In this Naive approach, we are traversing the array and in each traversal, we
	 * are finding the maximum in the window w. If i is the current index we are on
	 * in the inputArray, we are checking for the maximum element till (i+w-1)th
	 * index, which is the window of size w.
	 * 
	 * @TimeComplexity We are using 2 nested foor loops, one running for (n-w) times other for w time.
	 * Therefore timecomplexity will be O((n-w)w) which can be written as O(nw).
	 * This is a quadratic complexity if w approaches n.
	 * 
	 * @SpaceComplexity All the operations are performed on inputArray and only one max variable is used
	 * as an additional var. This is not depenedent on n, therefore spaceC is O(1).
	 * 
	 */
	private static void maxInSlidingWindow_NaiveApproach(int[] inputArray, int w) {
		for (int i = 0; i <= inputArray.length - w; i++) {
			int max = 0;
			for (int j = i; j < i + w; j++) {
				if (inputArray[j] > max) {
					max = inputArray[j];
				}
			}
			System.out.println("Max in window " + (i + 1) + " is : " + max);
		}
	}

	/**
	 * This is a more refined approach which uses Heap. We know that in a Heap DS,
	 * we always have the maximum value at the top of the heap and doing getMax() is
	 * an O(1) operation. Adding a new element is O(logn) and so is the delete
	 * operation.
	 * 
	 * Steps: 
	 * 1. Have a heap of window size, this will keep the elements from the
	 * 	window and doing getMax() will get the maximum value in the window. 
	 * 2.Initially populate the heap with w elements and print the max. 
	 * 3.Delete the first element of the window from heap as the window is sliding by 1 element
	 * 	now. 
	 * 4.Loop in the inputArray from wth elment till end(because 0 to w have
	 * 	already been taken in heap during step 2) 
	 * 5.Inside the loop follow same steps from 2 to 3.
	 * 
	 * We keep adding one next element and deleting starting element inside the
	 * window to get the max.
	 * 
	 * @TimeComplexity Initializing for loop takes O(w logw). Second for loop we are
	 *                 adding and deleting from heap hence, O((n-w) log w)+O((n-w)
	 *                 log w) for heap of size w looped n times. Therefore total
	 *                 time complexity will be O(nlog w)
	 * 
	 * @SpaceComplexity We are using a heap of size w, which internally is an array of size w. Hence, 
	 * 	O(w)
	 */
	private static void maxInSlidingWindow_HeapApproach(int[] inputArray, int w) {
		Heap heap = new Heap(w);

		for (int i = 0; i < w; i++) {
			heap.add(inputArray[i]);
		}
		
		System.out.println("Max in window is " + heap.getMax());
		heap.delete(inputArray[0]);

		for (int i = w; i < inputArray.length; i++) {
			heap.add(inputArray[i]);
			System.out.println("Max in window is " + heap.getMax());
			heap.delete(inputArray[i - w + 1]);
		}
	}
	
}
