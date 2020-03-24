package com.questions.QueuesStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a Stack using a Queue
 */
public class StackUsingQueue {

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push("adarsh");
        stack.push("brian");
        stack.push("john");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}

/**
 * Stack Class implemented Using 2 queues
 * >queue1 will be used to save/push data
 * >queue2 will be used as a temp array
 * <p>
 * >Logic here is that, we push all data into queue1. We will be enqueuing here.
 * >When pop is required, we dequeue queue1 into queue2 untill last element
 * >Now we dequeue queue1, which contains only one elmeent i.e. the rear
 * element of queue which is the last element pushed into stack
 * >Now since, queue2 contains all elements we swap references of queue2 and queue1
 */
class Stack {
    private Queue<String> queue1 = new LinkedList<>();
    private Queue<String> queue2 = new LinkedList<>();
    int size = 0;
    final int MAX;

    public Stack(int max) {
        this.MAX = max;
    }

    public void push(String a) {
        if (size <= MAX) {
            queue1.add(a);
            size++;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    public String pop() {
        if (size > 0) {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
        } else {
            return "Stack Underflow";
        }
        size--;
        String data = queue1.poll();

        Queue<String> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return data;
    }

}
