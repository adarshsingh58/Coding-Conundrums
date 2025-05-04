package com.DataStructures_And_Questions.QueuesStack;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        // Using 2 stack
        // Using recursion and no extra DS
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        stack = reverse(stack);
        System.out.println(stack);
    }

    private static java.util.Stack<Integer> reverse(java.util.Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }
        int temp = stack.pop();
        reverse(stack);
        return insertAtbottom(stack, temp);
    }

    private static Stack<Integer> insertAtbottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return stack;
        }
        int temp = stack.pop();
        insertAtbottom(stack, data);
        stack.push(temp);
        return stack;
    }
}
