package com.datastructures.Stack;


/*
 * First question before designing, what are the attributes/characterstics of the class Stack.
 * Here, its the
 *  >array which makes up the stack,
 *  >top pointer, current size,
 *  >MAX size the stack can accomodate
 *
 *  Now, add all these attributes and then write behavious or methods required and while implementing them
 *  make sure to update all the necessary attributes if required.
 *
 *  A stack is a DS which only adds data to the top most available position. This operation is called Push.
 *  Removing is also done only from top, this operation is called pop.
 *  When Pushing data if the top, the pointer which reference the current top node, reaches max, any push
 *  will case Overflow exception.
 *  While popping if, top pointer <0, any poppoing while cause underflow exception as this indicates that
 *  there are no elemnets/data left in the stack to pop.
 *
 *  top is kept -1 to indicate there are no elments in the stack
 *
 */
public class Stack {

    public int[] stackArray;
    public int top;
    public final int MAX;

    public Stack(int size) {
        MAX = size;
        stackArray = new int[size];
        top = -1;
    }

    /*
     * Time complexity is O(1)
     * Space complexity is O(1)
     */
    public void push(int data) {
        if (top == MAX - 1) {//top is 0 index based while MAX is size based, hence -1
            System.out.println("Stack overflow!!! Can't Push");
        } else {
            stackArray[++top] = data;//incremented top and then added data at that index
        }
    }

    /*
     * unlike array where we can delete data from any index, which lead us to shift
     * elemnts from right by one making Time complexity O(n), here we only delete from end of array aka top,
     * hence
     * Time complexity is O(1)
     * Space complexity is O(1)
     */
    public int pop() {
        if (top == -1) {
            System.out.println("Stack underflow!!! Can't Pop");
        } else {
            return stackArray[top--];//We first return the top data and then reduce the size
        }
        return 0;
    }

    public boolean isEmpty() {
        if (top == -1)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if (top == MAX - 1)
            return true;
        else
            return false;
    }

}