package com.DataStructures_And_Questions.QueuesStack;

import java.util.Stack;

/*
*You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

    The valid operators are '+', '-', '*', and '/'.
    Each operand may be an integer or another expression.
    The division between two integers always truncates toward zero.
    There will not be any division by zero.
    The input represents a valid arithmetic expression in a reverse polish notation.
    The answer and all the intermediate calculations can be represented in a 32-bit integer.



Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22


* https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] arg={"2","1","+","3","*"};
    new EvaluateReversePolishNotation().evalRPN(arg);
    }

    public int evalRPN(String[] tokens) {
        java.util.Stack<Integer> operandStack = new Stack<>();

        for (String s : tokens) {
            if (s == "+") {
                int
                f = operandStack.pop();
                int second = operandStack.pop();
                operandStack.push(second + f);
            } else if (s == "-") {
                int f = operandStack.pop();
                int second = operandStack.pop();
                operandStack.push(second - f);
            } else if (s == "*") {
                int f = operandStack.pop();
                int second = operandStack.pop();
                operandStack.push(second * f);
            } else if (s == "/") {
                int f = operandStack.pop();
                int second = operandStack.pop();
                operandStack.push(second / f);
            } else {
                operandStack.push(Integer.parseInt(s));
            }
        }
        return operandStack.pop();
    }
}
