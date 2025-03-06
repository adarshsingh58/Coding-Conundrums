package com.pattern.questions.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 You are given a positive integer num. You may swap any two digits of num that have the same parity
 (i.e. both odd digits or both even digits).

 Return the largest possible value of num after any number of swaps.


 Example 1:

 Input: num = 1234
 Output: 3412
 Explanation: Swap the digit 3 with the digit 1, this results in the number 3214.
 Swap the digit 2 with the digit 4, this results in the number 3412.
 Note that there may be other sequences of swaps but it can be shown that 3412 is the largest possible number.
 Also note that we may not swap the digit 4 with the digit 1 since they are of different parities.

 Example 2:

 Input: num = 65875
 Output: 87655
 Explanation: Swap the digit 8 with the digit 6, this results in the number 85675.
 Swap the first digit 5 with the digit 7, this results in the number 87655.
 Note that there may be other sequences of swaps but it can be shown that 87655 is the largest possible number.

 https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/
 */
public class LargestNumberAfterDigitSwapsbyParity {


    public static void main(String[] args) {
        int inp = 65875;
        System.out.println("for Inp:" + inp + " Output :" + new LargestNumberAfterDigitSwapsbyParity().largestInteger(inp));
    }


    /*
    * So idea here is that:
    * - We get each digit from input number and add it to Even or Odd minHeap, based on if its even or odd
    * - Now we recreate the number by traversing each digit from Last in original number
    * - If the digit is even we pick the min digit from EvenMinHeap in O(1) time and use this min value as the new digit.
    * - Similary if the digit is odd we pick the min digit from OddMinHeap in O(1) time and use this min value as the new digit.
    * - This way the new number will have from last, min digits from entire set of odd/even digits making the largest number(since first
    * number now will have largest digit. Remember we start to add min digit from last so start will get the largest digit)
    * */
    public int largestInteger(int num) {
        PriorityQueue<Integer> oddMinHeap = new PriorityQueue<>();
        PriorityQueue<Integer> evenMinHeap = new PriorityQueue<>();
        int number = num;
        while (num > 0) {
            int lastDigit = num % 10;
            if (lastDigit % 2 == 0)
                evenMinHeap.add(lastDigit);
            else
                oddMinHeap.add(lastDigit);
            num = num / 10;
        }
        num=number;
        StringBuilder op = new StringBuilder();

        while (num > 0) {
            int currDigit = num % 10;

            if (currDigit % 2 == 0){
                    op.append(evenMinHeap.poll());
            }else{
                    op.append(oddMinHeap.poll());
            }
            num = num / 10;
        }

        return Integer.parseInt(op.reverse().toString());
    }

}
