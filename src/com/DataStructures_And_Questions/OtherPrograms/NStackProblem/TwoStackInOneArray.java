package com.DataStructures_And_Questions.OtherPrograms.NStackProblem;

/**
 * 2 stacks from both ends
 * <p>
 * Design a data structure TwoStacks, that represents two stacks using a single array, where both stacks share the same array for storing elements.
 * <p>
 * The following operations must be supported:
 * <p>
 * push1(value): Takes an integer value and inserts it into the first stack.
 * <p>
 * push2(value): Takes an integer value and inserts it into the second stack.
 * <p>
 * pop1(): Removes the top element from the first stack and returns it.
 * <p>
 * pop2(): Removes the top element from the second stack and returns it.
 * <p>
 * Note: Perform all operations in-place without resizing the underlying list, maintaining a fixed size throughout.
 */
public class TwoStackInOneArray {

    public static void main(String[] args) {

    }

    private int arraySize;
    private int[] array;
    private int stack1Top;
    private int stack2Top;

    @SuppressWarnings("unchecked")
    public TwoStackInOneArray(int arraySize) {
        this.arraySize = arraySize;
        array = new int[arraySize]; //type casting Object[] to V[]
        stack1Top=-1;
        stack2Top=arraySize;
    }

    //insert at top of first stack
    public void push1(int value) {
        if(stack1Top<arraySize && stack1Top<stack2Top)
            array[++stack1Top]=value;
        else
            return;
    }

    //insert at top of second stack
    public void push2(int value) {
        if(stack2Top>-1 && stack1Top<stack2Top)
            array[--stack2Top]=value;
        else
            return;
    }

    //remove and return value from top of first stack
    public int pop1() {
        if(stack1Top>-1 && stack1Top<arraySize)
            return array[stack1Top--];
        else
            return -1;
    }

    //remove and return value from top of second stack
    public int pop2() {
        if(stack2Top>-1 && stack2Top<arraySize)
            return array[stack2Top++];
        else
            return -1;
    }
}
