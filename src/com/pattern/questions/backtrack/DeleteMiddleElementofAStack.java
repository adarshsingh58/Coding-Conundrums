package com.pattern.questions.backtrack;

import java.util.Arrays;
import java.util.Stack;

/**
 * * Remove Kth (Middle, in this case) Element From Stack
 */
public class DeleteMiddleElementofAStack {

    public void remove(Stack<Integer> stack, int k) {
        if (stack.isEmpty()) return; //Edge Case.
        if (k == 1) {     //Base Case.-> This means that we've found out the element that needs to be deleted.
            stack.pop();
            return;
        }
        int top = stack.pop();
        remove(stack, k - 1);
        stack.push(top);
    }

    public void attempt(Stack<Integer> stack, int indexToRemove) {


    }


    public static void main(String[] args) {
        DeleteMiddleElementofAStack solution = new DeleteMiddleElementofAStack();

        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(5, 4, 3, 8, 1));

        int mid = stack.size() / 2 + 1;

//        solution.remove(stack, mid);
        solution.attempt(stack, mid);

        solution.print(stack);
    }

    public void print(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int item = stack.pop();
        print(stack);
        System.out.print(item + " ");
        stack.push(item);
    }
}
