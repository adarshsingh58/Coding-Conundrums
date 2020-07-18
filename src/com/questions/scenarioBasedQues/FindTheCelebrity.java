package com.questions.scenarioBasedQues;

import java.util.HashMap;
import java.util.Map;

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
        findCelebrity(3);
    }

    static boolean knows(int a, int b) {
        boolean x=true;
        return x;
    }

    public static int findCelebrity(int n) {
        Map<Integer, Integer> personKnowMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            personKnowMap.put(i, 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                if( i == j) continue;
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

}
