package com.DataStructures_And_Questions.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(2);
        stack.push(42);
        stack.push(21);
        stack.push(58);
        stack.push(87);

        System.out.println(stack.top);
        System.out.println(stack.isFull());

        stack.push(5);

        System.out.println("Popped Data " + stack.pop());
    }
}