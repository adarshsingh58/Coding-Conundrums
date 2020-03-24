package com.questions.bitwise;

import java.util.Stack;

/**
 * Find Binary Representation of a number
 * Input : 7 Output : 111
 * <p>
 * Input : 10 Output : 1010
 * <p>
 * Input: 33 Output: 100001
 */
public class BinaryOfANumber {

    public static void main(String[] args) {
        int n = 7;
//		binaryOf_naive(n);
        binaryOf(n);
    }

    /**
     * We add n%2 to stack, as we need to print data in reverse order for binary
     * representation. This will be either 0 or 1.
     * We also keep doing dividing n by 2 and saving it to n.
     * Continue till n>0
     * <p>
     * Now we pop and print int from stack
     */
    private static void binaryOf_naive(int n) {
        Stack<Integer> binaryBits = new Stack<>();
        while (n > 0) {
            binaryBits.push(n % 2);
            n = n / 2;
        }
        while (!binaryBits.isEmpty()) {
            System.out.print(binaryBits.pop());
        }
    }

    /**
     * Here, we do a bitwise AND & on (n and 1). This will give us 1 only when
     * rightmost bit of n is 1 else 0. We push this data in stack and shift n by 1 to right.
     * <p>
     * Continue until n>0
     * <p>
     * Now pop and print data from Stack
     */
    private static void binaryOf(int n) {
        Stack<Integer> binaryBits = new Stack<>();
        while (n > 0) {
            binaryBits.push(n & 1);
            n = n >> 1;
        }
        while (!binaryBits.isEmpty()) {
            System.out.print(binaryBits.pop());
        }
    }
}
