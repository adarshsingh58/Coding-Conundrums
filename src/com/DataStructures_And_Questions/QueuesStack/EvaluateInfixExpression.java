package com.DataStructures_And_Questions.QueuesStack;

import java.util.Stack;

/**
 * Given an arithmetic expression, evaluate it i.e. calculate its result. Let's
 * assume that there are no parentheses in the expression and only binary
 * operations ( +, -, *, / ) are allowed.
 * e.g. 6+4/2*2=10
 */
public class EvaluateInfixExpression {
    public static void main(String[] args) {
        String expression = "6+4/2*2";
        String output = evaluateExpression(expression);
        System.out.println(output);
    }

    private static String evaluateExpression(String expression) {
        String postfixNotation = InfixToPostfix.getPostFixNotation(expression);
        Stack<String> operandStack = new Stack();
        for (char c : postfixNotation.toCharArray()) {
            if (Character.isDigit(c)) {
                operandStack.push(Character.toString(c));
            } else {
                String op = evaluate_2_Operands(operandStack.pop(), operandStack.pop(), c);
                operandStack.push(op);
            }
        }

        return (String) operandStack.pop();
    }

    /**
     * order of operand matters in operators like /.
     * So, the first popped operand will actually be second while evaluating the expression
     */
    private static String evaluate_2_Operands(String secondOperand, String firstOperand, char c) {
        switch (c) {
            case '+':
                return String.valueOf(Integer.parseInt(firstOperand) + Integer.parseInt(secondOperand));
            case '-':
                return String.valueOf(Integer.parseInt(firstOperand) - Integer.parseInt(secondOperand));
            case '*':
                return String.valueOf(Integer.parseInt(firstOperand) * Integer.parseInt(secondOperand));
            case '/':
                return String.valueOf(Integer.parseInt(firstOperand) / Integer.parseInt(secondOperand));
        }
        return null;
    }
}
