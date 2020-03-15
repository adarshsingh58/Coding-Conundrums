package com.questions.QueuesStack;

import java.util.Stack;

/**
 * Given a stack, sort it.
 * 
 * Input:  -3  <--- Top
        14 
        18 
        -5 
        30 

	Output: 30  <--- Top
        18 
        14 
        -3 
        -5 
 */
public class SortStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(12);
		stack.push(-2);
		stack.push(41);
		stack.push(63);
		stack.push(-7);

		stack = sortStack_Recursion(stack);
		System.out.println(stack);
	}

	private static Stack<Integer> sortStack_Recursion(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			int temp=stack.pop();
			sortStack_Recursion(stack);
			insertSortedData(stack,temp);
		}
		return stack;
	}

	private static void insertSortedData(Stack<Integer> stack, int temp) {
		if(stack.isEmpty() || stack.peek()<=temp) {
			stack.push(temp);
		}else {
			int pop=stack.pop();
			insertSortedData(stack, temp);
			stack.push(pop);
		}
	}
}
