package com.pattern.questions.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * There are N people standing in a circle waiting to be executed. The counting out begins at some point in the circle
 * and proceeds around the circle in a fixed direction. In each step, a certain number of people are skipped and the
 * next person is executed. The elimination proceeds around the circle (which is becoming smaller and smaller as the
 * executed people are removed), until only the last person remains, who is given freedom.
 * <p>
 * Given the total number of persons N and a number k which indicates that k-1 persons are skipped and the kth person is
 * killed in a circle. The task is to choose the person in the initial circle that survives.
 * <p>
 * Examples:
 * <p>
 * Input: N = 5 and k = 2 Output: 3 Explanation: Firstly, the person at position 2 is killed, then the person at
 * position 4 is killed, then the person at position 1 is killed. Finally, the person at position 5 is killed. So the
 * person at position 3 survives.
 * <p>
 * Input: N = 7 and k = 3 Output: 4 Explanations: The persons at positions 3, 6, 2, 7, 5, and 1 are killed in order, and
 * the person at position 4 survives.
 * <p>
 * Input: N = 6 and k = 2 Output: 5 Explanation: The persons at positions 2, 4, 6, 3, and 1 are killed in order, and the
 * person at position 5 survives.
 * <p>
 * https://www.geeksforgeeks.org/josephus-problem/
 */
public class JosephusProblem {
    public static void main(String[] args) {
        System.out.println(new JosephusProblem().solveJosephusProblem(14, 2));
    }

    public int solveJosephusProblem(int n, int k) {
        List<Integer> soldiers = new ArrayList<>();
        for (int idx = 1; idx <= n; idx++) soldiers.add(idx);
        return solveJosephusProblem(soldiers, k - 1, 0);
    }

    private int solveJosephusProblem(List<Integer> soldiers, int k, int index) {
        if (soldiers.size() == 1) return soldiers.get(0); // Base Case.
        int killIdx = (index + k) % soldiers.size();
        soldiers.remove(killIdx);
        return solveJosephusProblem(soldiers, k, killIdx);
    }

}
