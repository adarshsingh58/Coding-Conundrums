package com.questions.OtherPrograms.NStackProblem;

public class NStackSingleArray {

	public static void main(String[] args) {

		NStack ns = new NStackSingleArray().new NStack(3);
		ns.push(0, 5);
		ns.push(1, 1);
		ns.push(1, 3);
		ns.push(0, 6);
		ns.push(0, 7);
		ns.push(0, 9);
		
		System.out.println(ns.pop(0));
		System.out.println(ns.pop(1));
		System.out.println(ns.pop(1));
	}

	class NStack {

		private final int TOTAL_NUMBER_OF_STACK;
		private final int MAX_ARR_SIZE = 6;

		private int[] stackArray;
		private int[] top_of_stack_Array;
		private int[] next_free_slot;
		private int free;

		public NStack(int n) {
			TOTAL_NUMBER_OF_STACK = n;

			stackArray = new int[MAX_ARR_SIZE];
			next_free_slot = new int[MAX_ARR_SIZE];
			top_of_stack_Array = new int[TOTAL_NUMBER_OF_STACK];

			for (int i = 0; i < TOTAL_NUMBER_OF_STACK; i++) {
				top_of_stack_Array[i] = -1;
			}
			for (int i = 0; i < next_free_slot.length - 1; i++) {
				next_free_slot[i] = i + 1;
			}
			next_free_slot[next_free_slot.length - 1] = -1;

			free = 0;
		}

		
		
		/**
		 * We have 4 main vars here, 
		 * 	>stackArray
		 * 	>top_of_stack_Array
		 * 	>next_free_slot
		 * 	>free
		 * First we need to make sure that while writing logic we need to update all 
		 * 4 of them.
		 * 
		 * Explantion:
		 *  >TOTAL_NUMBER_OF_STACK: Number of stacks we want to implement in our array
		 *  >MAX_ARR_SIZE: This is the MAX size of our stackArray, which will hold all the data
		 *  
		 * 	>stackArray:  This is the actual array which will store the data we are trying to save in stack
		 * 	>top_of_stack_Array: This is an array of size=TOTAL_NUMBER_OF_STACK. This will store the top index for each
		 * 			stack. Its ith index will store top of ith stack, where i can be from 0 to TOTAL_NUMBER_OF_STACK-1.
		 * 
		 * 	>next_free_slot: This is the array which makes storage of multiple stacks in a single array possible.
		 * 					This array will be of size MAX_ARR_SIZE.
		 * 					The idea here is that, this array will be initialized value from 1 to MAX_ARR_SIZE-1.
		 * 					next_free_slot[i]=i+1, where i is from 0 to MAX_ARR_SIZE-2. We are doing MAX_ARR_SIZE-2
		 * 					because, on last slot in this array we will store -1.
		 * 	>free: This is a var which at any given point will tell which slot in stackArray is free for data to store.
		 * 			It is initialized to 0, to state that 0th index is free at the very beginning.
		 * 
		 * 
		 * 
		 */
		public void push(int stackNumber, int data) {
			if (free == -1) {
				System.out.println("Over Flow");
				return;
			}
			
			int i = free;
			free = next_free_slot[i];
			next_free_slot[i] = top_of_stack_Array[stackNumber];
			top_of_stack_Array[stackNumber] = i;
			stackArray[i] = data;
		}

		public int pop(int stackNumber) {
			
			if (free == 0|| top_of_stack_Array[stackNumber]==-1) {
				System.out.println("Underflow");
				return -1;
			}
			
			int i=top_of_stack_Array[stackNumber];
			top_of_stack_Array[stackNumber]=next_free_slot[i];
			next_free_slot[i]=free;
			free=i;

			return stackArray[i];
		}

	}
}
