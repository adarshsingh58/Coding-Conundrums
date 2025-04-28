package com.DataStructures_And_Questions.Queue;

import com.DataStructures_And_Questions.Queue.Queue.Queue;
import com.DataStructures_And_Questions.Stack.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a queue and a number k, reverse the order of the first k elements in queue.
 * If k is less than 00, if k exceeds queue size, or if queue is empty, return NULL. Otherwise, return the modified queue.
 * <p>
 * Constraints:
 * <p>
 * 0≤0≤ queue.length ≤103≤103
 * 10−3≤10−3≤ queue[i] ≤103≤103
 * 10−3≤10−3≤ k ≤103≤103
 *
 *
 */
public class ReverseKElementsInaQueue {

    public static void main(String[] args) throws Exception {
        Queue q=new Queue(6);
        q.enqueue(-15);
        q.enqueue(7);
        q.enqueue(-9);
        q.enqueue(16);
        q.enqueue(-2);
        q.enqueue(10);
        reverseK(q,3);
    }

    public static Queue reverseK(Queue queue, int k) throws Exception {

        // Replace this placeholder return statement with your code
        Stack stack=new Stack(queue.size);
        List<Integer> list=new ArrayList<>();
        if(queue.size==0 || k<=0 || k>queue.size ) return null;

        for(int counter=0; counter<k;counter++){
            stack.push(queue.dequeue());
            System.out.println("x-> "+stack.peek());
        }

        for(int counter=k-1; counter>=queue.rear;counter--){
            list.add(queue.dequeue());
        }

        for(Integer data:list){
            System.out.println("y-> "+data);
        }


        while(!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }
        for(Integer data:list){
            queue.enqueue(data);
        }
        return queue;
    }
}
