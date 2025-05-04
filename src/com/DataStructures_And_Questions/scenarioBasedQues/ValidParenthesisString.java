package com.DataStructures_And_Questions.scenarioBasedQues;

import java.util.Stack;

/*
*  Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

    Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    Any right parenthesis ')' must have a corresponding left parenthesis '('.
    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
    An empty string is also valid.

Example 1:

Input: "()"
Output: True

Example 2:

Input: "(*)"
Output: True

Example 3:

Input: "(*))"
Output: True

Input: "(*))*)"
Output: True

Input: "(*))*("
Output: False

Input: "(*))*)"
Output: True

Input: "(*)))*"
Output: False

Input: "**((*"
Output: False

"(*())(()*((*(((()*())*()())(((((()*)()(((((()()))*)()))((())((((())))**(())()()()())((())(*())()*)()"


*/
public class ValidParenthesisString {

    public static void main(String[] args) {
        System.out.println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
    }

    public static boolean checkValidString(String s) {
        char[] ca = s.toCharArray();
        Stack<CharWithCount> s1 = new Stack();
        if (ca.length == 0) return true;
        if (ca[0] == ')' || ca[ca.length - 1] == '(') {
            return false;
        }
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] == '(') {
                if (!s1.empty() && s1.peek().getC() == '(')
                    s1.peek().setI(s1.peek().getI() + 1);
                else
                    s1.push(new CharWithCount('(', 1));
            } else if (ca[i] == '*') {
                if (!s1.empty() && s1.peek().getC() == '*')
                    s1.peek().setI(s1.peek().getI() + 1);
                else
                    s1.push(new CharWithCount('*', 1));
            } else if (ca[i] == ')') {
                if (s1.empty()) {
                    return false;
                }
                if (!s1.empty() && s1.peek().getC() == '(') {
                    if (s1.peek().getI() == 1) s1.pop();
                    else s1.peek().setI(s1.peek().getI() - 1);
                } else {
                    if (s1.size() == 1) {
                        if (!s1.empty() && s1.peek().getI() == 1) s1.pop();
                        else s1.peek().setI(s1.peek().getI() - 1);
                    } else {
                        CharWithCount temp = s1.pop();
                        if (!s1.empty() && s1.peek().getI() == 1) {
                            s1.pop();
                            if (!s1.empty())
                                s1.peek().setI(s1.peek().getI() + temp.getI());
                            else
                                s1.push(temp);
                        } else {
                            s1.peek().setI(s1.peek().getI() - 1);
                            s1.push(temp);
                        }
                    }
                }
            }
        }
        if (!s1.empty() && s1.peek().getC() == '(') return false;

        else {
            while (!s1.empty()) {
                if (s1.size() == 1 && s1.peek().getC() == '*') return true;

                CharWithCount asstriek = s1.pop();
                CharWithCount openingBracket = s1.pop();
                if (asstriek.getI() < openingBracket.getI()) {
                    return false;
                } else {
                    if (s1.empty()) return true;
                    s1.peek().setI(s1.peek().getI() + asstriek.getI());
                }
            }
        }
        return true;
    }


    private static class CharWithCount {
        char c;
        int i;

        public CharWithCount(char c, int i) {
            this.c = c;
            this.i = i;
        }

        public char getC() {
            return c;
        }

        public void setC(char c) {
            this.c = c;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }
}
