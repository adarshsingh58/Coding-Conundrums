package com.DataStructures_And_Questions.Queue;

import com.DataStructures_And_Questions.Queue.Queue.Queue;

/**
 * Given a number n, generate a list of binary numbers from 1 to n in the form of a string using a queue.
 * <p>
 * Constraints:
 * <p>
 * 1≤ n ≤1000
 * <p>
 * Eg: n = 5
 * Output: [1, 10, 11, 101, 111]
 */
public class GenerateBinaryNumbers {

    public static void main(String[] args) {
        String[] op = generateBin(5);
        for (String data : op)
            System.out.println(data);
    }

    /*
     * The algorithm for generating binary numbers up to a specified count using a queue is straightforward.
     * It begins by placing the binary number "1" in the queue and creating an empty list to hold the generated binary numbers. I
     * n each iteration of the algorithm, a number is removed from the queue, added to the result list, and then two variations
     * of that number are placed back into the queue by appending "0" and "1". This process is repeated until the desired number of
     * binary numbers has been generated.
     * <p>
     * Below are the detailed steps of the algorithm:
     * <p>
     * Initialize an empty list result to store the binary numbers, and create an empty queue named queue.
     * <p>
     * Enqueue the integer 1 into the queue.
     * <p>
     * Start a loop that iterates n times, where n is the desired count of binary numbers. Inside the loop, perform the following steps:
     * <p>
     * Dequeue an element from the queue, convert it to a string, and append it to the result list.
     * <p>
     * Create two new strings, s1 and s2, by appending "0" and "1" respectively, to the dequeued string.
     * <p>
     * Enqueue s1 and s2 back into the queue.
     * <p>
     * After the loop completes, return the result list containing the generated binary numbers.
     */
    public static String[] generateBin(int n) {
            String[] result = new String[n];
            /*Queue<String> queue = new Queue() <String>();

            // Start with '1' in the queue
            queue.enqueue("1");

            // Loop to generate binary numbers up to 'n'
            for (int i = 0; i < n; i++) {
                // Dequeue the front element of the queue
                result[i] = queue.dequeue();

                // Generate new binary numbers by appending '0' and '1' to the dequeued number
                String s1 = result[i] + "0";
                String s2 = result[i] + "1";

                // Enqueue the new binary numbers back into the queue
                queue.enqueue(s1);
                queue.enqueue(s2);
            }*/

        return result;
    }
}
