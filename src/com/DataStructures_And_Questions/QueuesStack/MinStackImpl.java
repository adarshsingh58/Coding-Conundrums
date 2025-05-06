package com.DataStructures_And_Questions.QueuesStack;

import java.util.ArrayList;
import java.util.List;

public class MinStackImpl {
    /*
    *
    * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

        push(x) -- Push element x onto stack.
        pop() -- Removes the element on top of the stack.
        top() -- Get the top element.
        getMin() -- Retrieve the minimum element in the stack.
    */
    public static void main(String[] args) throws Exception {
        MinStack stackMin = new MinStack();
        stackMin.push(3);
        stackMin.push(-1);
        stackMin.push(4);
        stackMin.push(-4);
        stackMin.push(-3);
        stackMin.push(12);
        stackMin.push(90);
        stackMin.push(-9);

        System.out.println(stackMin.top() + " , " + stackMin.getMin());
        stackMin.pop();
        System.out.println(stackMin.top() + " , " + stackMin.getMin());
        stackMin.pop();
        System.out.println(stackMin.top() + " , " + stackMin.getMin());
        stackMin.pop();
        System.out.println(stackMin.top() + " , " + stackMin.getMin());

    }


}

class MinStack {
    private List<Integer> data;
    private List<Integer> minStack;

    public MinStack() {
        data = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int val) {
        data.add(val);
        if (minStack.isEmpty() || val <= minStack.get(minStack.size() - 1)) {
            minStack.add(val);
        } else {
            minStack.add(minStack.get(minStack.size() - 1));
        }
    }

    public void pop() throws Exception {
        if (data.isEmpty()) throw new Exception();
        data.remove(data.size() - 1);
        minStack.remove(minStack.size() - 1);
    }

    public int top() throws Exception {
        if (data.isEmpty()) throw new Exception();
        return data.get(data.size() - 1);
    }

    public int getMin() throws Exception {
        if (minStack.isEmpty()) throw new Exception();
        return minStack.get(minStack.size() - 1);
    }
}