package com.questions.QueuesStack;

import java.util.Stack;

/**
 * Implement a queue using Stacks.
 */
public class QueueUsingStacks {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue("1 Person");
        queue.enqueue("2 Person");
        queue.enqueue("3 Person");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue("4 Person");
        System.out.println(queue.dequeue());
        queue.enqueue("5 Person");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

}

/**
 * In this approach, we use 2 stack. stack1 and stack2.
 * >stack1 will be used for enqueuing data. For each enqueue we do stack1.push.
 * >stack2 will be used for dequeuing. We check if stack2 is empty,
 * -if it is we pop data from stack1 and push to stack2. This will essentially reverse the order
 * in which data was stored in stack1.
 * -now we pop from stack2. This is the dequeued data.
 */
class Queue {
    Stack<String> stack1 = new Stack<>();
    Stack<String> stack2 = new Stack<>();
    int size = 0;

    public void enqueue(String data) {
        stack1.push(data);
        size++;
    }

    public String dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return "No Elements to Dequeue";
            } else {
                while (!stack1.isEmpty())
                    stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
