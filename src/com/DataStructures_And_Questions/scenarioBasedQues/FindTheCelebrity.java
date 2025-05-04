package com.DataStructures_And_Questions.scenarioBasedQues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
 * <p>
 * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 * <p>
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n). There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: graph = [
 * [1,1,0],
 * [0,1,0],
 * [1,1,1]
 * ]
 * Output: 1
 * Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j, otherwise graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.
 * <p>
 * Example 2:
 * <p>
 * Input: graph = [
 * [1,0,1],
 * [1,1,0],
 * [0,1,1]
 * ]
 * Output: -1
 * Explanation: There is no celebrity.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * The directed graph is represented as an adjacency matrix, which is an n x n matrix where a[i][j] = 1 means person i knows person j while a[i][j] = 0 means the contrary.
 * Remember that you won't have direct access to the adjacency matrix.
 * <p>
 * https://leetcode.com/explore/interview/card/microsoft/48/others/194/
 */
public class FindTheCelebrity {

    public static void main(String[] args) {
//        findCelebrity(3);


        int[][][] matrices = {
                { // matrix 1
                        {0, 1, 1, 0},
                        {1, 0, 1, 1},
                        {0, 0, 0, 0},
                        {0, 1, 1, 0}
                },
                { // matrix 2
                        {0, 1, 1, 0},
                        {1, 0, 1, 1},
                        {0, 0, 0, 1},
                        {0, 1, 1, 0}
                },
                { // matrix 3
                        {0, 0, 0, 0},
                        {1, 0, 0, 1},
                        {1, 0, 0, 1},
                        {1, 1, 1, 0}
                },
                { // matrix 4
                        {0, 1, 0, 0},
                        {0, 0, 0, 0},
                        {0, 1, 0, 0},
                        {0, 1, 0, 0}
                },
                { // matrix 5
                        {0, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0}
                }
        };

        int[] n = {4, 4, 4, 4, 5};

        for (int i = 0; i < 5; ++i) {
            System.out.print((i + 1) + ".\tInput matrix: [");
            for (int[] row : matrices[i]) {
                System.out.print(" [");
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.print("]");
            }
            System.out.println("]");

            System.out.println("\tCelebrity: " + findCelebrity1(matrices[i], n[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }


    static boolean knows(int a, int b) {
        boolean x = true;
        return x;
    }

    public static int findCelebrity(int n) {
        Map<Integer, Integer> personKnowMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            personKnowMap.put(i, 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (knows(i, j)) {
                    personKnowMap.put(i, personKnowMap.get(i) + 1);
                } else {
                    personKnowMap.put(j, personKnowMap.get(j) - 1);
                }
            }
        }

        for (Map.Entry<Integer, Integer> e : personKnowMap.entrySet()) {
            if (e.getValue() == 1) return e.getKey();
        }

        return -1;
    }


    public static int findCelebrity1(int[][] matrix, int n) {
        boolean skipI = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == i) continue;
                if (matrix[i][j] != 0 || matrix[j][i] != 1) {
                    skipI = true;
                    break;
                }
            }
            if (!skipI)
                return i;
            else
                skipI = false;
        }
        // Replace this placeholder return statement with your code
        return -1;
    }


    /*USING STACK*/

    public static boolean knows(int[][]  matrix, int x, int y) {
        // Returns true if x knows y, else returns false
        return matrix[x][y] == 1;
    }
/*Before we delve into the solution, it’s crucial to consider the minimum and maximum number of celebrities that can exist within the given matrix.

To explore the possibility of having more than one celebrity, consider two individuals, XX and YY, both purported to be celebrities. Following the celebrity criteria:

    XX, being a celebrity, should not know YY, implying matrix[X][Y]=0matrix[X][Y]=0. Consequently, YY should know XX, or matrix[Y][X]=1matrix[Y][X]=1.
    Conversely, for YY to be a celebrity, YY should not know XX, implying matrix[Y][X]=0matrix[Y][X]=0, while XX must know YY, or matrix[X][Y]=1matrix[X][Y]=1.

These conditions contradict each other, as they suggest that XX should both know and not know YY simultaneously, which is impossible. Thus, the assumption of having more than one celebrity contradicts the definition of a celebrity in this context. Therefore, the maximum number of celebrities possible in a matrix is 11.

Now, let’s dive deep into the solution. To identify a celebrity at a party, this solution employs an approach utilizing a stack data structure and a binary matrix representation of individuals at the party.

Let’s walk through the steps of the solution:

    We create a stack to hold the indexes of all attendees, treating everyone as a potential celebrity initially.

    We populate the stack with every attendee’s index, starting from 00 up to (N−1N−1).

    We determine potential celebrities by repeatedly popping two indexes from the stack to compare two individuals at a time.

        For the popped individuals, we check whether one knows the other by referencing the binary matrix, where a value of 11 at (i,j)(i,j) indicates that person ii knows person jj.
            If individual xx knows individual yy, xx cannot be a celebrity; yy is considered a potential celebrity and is pushed back into the stack.
            Otherwise, xx does not know person yy, yy is eliminated from consideration, and xx is pushed back into the stack for further comparison.

        Continue the process until only one index(individual) remains in the stack. This index represents the tentative celebrity.

    Next, to verify the celebrity status, we ensure that the tentative celebrity does not know any of the other attendees (no outgoing acquaintance) while every other attendee knows them (incoming acquaintance from all).
        We check the binary matrix for the following conditions for the tentative celebrity index:
            The row corresponding to the tentative celebrity should have all zeros (except for the diagonal element), indicating they know no one. We do not need to check the diagonal element here.
            The column corresponding to the tentative celebrity should have all ones (except for the diagonal element), indicating everyone knows them. We do not need to check the diagonal element here.

    Finally, if the tentative celebrity meets the verification criteria, their index is returned as the confirmed celebrity. Otherwise, we return −1−1, signifying the absence of a celebrity.

This solution efficiently narrows down the list of potential celebrities and validates the final candidate to ensure they meet the strict criteria of being known by everyone without knowing anyone at the party.*/
    public static int findCelebrity(int[][] matrix, int n) {
        Stack<Integer> stack = new Stack<>();
        int celebrity = -1;

        for (int i = 0; i < n; ++i) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int x = stack.pop();

            if (stack.isEmpty()) {
                celebrity = x;
                break;
            }

            int y = stack.pop();

            if (knows(matrix, x, y)) {
                // x knows y, discard x and push y back in stack
                stack.push(y);
            } else {
                // y is discarded, x is pushed back
                stack.push(x);
            }
        }

        // Verify the potential celebrity
        for (int j = 0; j < n; ++j) {
            // A celebrity knows no one, and everyone knows the celebrity
            if (celebrity != j && (knows(matrix, celebrity, j) || !knows(matrix, j, celebrity))) {
                return -1;
            }
        }

        return celebrity;
    }
}
