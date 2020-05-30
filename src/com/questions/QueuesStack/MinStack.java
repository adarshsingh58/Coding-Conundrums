package com.questions.QueuesStack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    /*
    *
    * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

        push(x) -- Push element x onto stack.
        pop() -- Removes the element on top of the stack.
        top() -- Get the top element.
        getMin() -- Retrieve the minimum element in the stack.
    */
    public static void main(String[] args) throws Exception {
        StackMin stackMin = new MinStack.StackMin();
        stackMin.push(3);
        stackMin.push(-1);
        stackMin.push(4);
        stackMin.push(-4);

        System.out.println(stackMin.top() + " , " + stackMin.getMin());
        stackMin.pop();
        System.out.println(stackMin.top() + " , " + stackMin.getMin());
        stackMin.pop();
        System.out.println(stackMin.top() + " , " + stackMin.getMin());
        stackMin.pop();
        System.out.println(stackMin.top() + " , " + stackMin.getMin());

    }

    static class StackMin {
        List<Integer> data;
        List<Integer> minStack;
        int top = -1;

        public StackMin() {
            data = new ArrayList<>();
            minStack = new ArrayList<>();
//            MAX = size;
        }

        public void push(int x) throws Exception {
            /*if (top == MAX - 1) {
                System.out.println("Overflow");
                throw new Exception("Overflow");
            }*/
            top++;
            data.add(top, x);
            if (top == 0) {
                minStack.add(top, x);
            } else if (minStack.get(top - 1) < x) {
                minStack.add(top, minStack.get(top - 1));
            } else {
                minStack.add(top, x);
            }
        }

        public int pop() throws Exception {
            if (top == -1) {
                System.out.println("Underflow");
                throw new Exception("Underflow");
            }
            int x = data.get(top);
            top--;
            return x;
        }

        public int top() throws Exception {
            if (top == -1) {
                System.out.println("No Data In Stack");
                throw new Exception("No Data In Stack");
            }
            return data.get(top);
        }

        public int getMin() {
            return minStack.get(top);
        }
    }
}
