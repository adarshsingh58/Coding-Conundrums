package com.pattern.questions.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 You may return the answer in any order.

 Example 1:
 Input: n = 4, k = 2
 Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]

 Explanation: There are 4 choose 2 = 6 total combinations.
 Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

 Example 2:
 Input: n = 1, k = 1
 Output: [[1]]
 Explanation: There is 1 choose 1 = 1 total combination.

 https://leetcode.com/problems/combinations/description/
 */
public class Combinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        List<List<Integer>> op = findComb(n, k);
        op.forEach(v -> {
            v.forEach(System.out::print);
        });
        System.out.println();
    }

    private static List<List<Integer>> findComb(int n, int k) {
        List<List<Integer>> opMain = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        findCombRec(n, k, op, 1, opMain);
        return opMain;
    }

    // 1234 -> 123, 134, 234
    private static void findCombRec(int n, int k, List<Integer> op, int index, List<List<Integer>> opMain) {
        if (op.size() == k) {
            opMain.add(new ArrayList<>(op));
            return;
        }
        if (index > n)
            return;
        op.add(index);
        for (int i = index + 1; i <= n; i++) {
            findCombRec(n, k, op, i, opMain);
            op.remove(op.size()-1);
        }
    }
}
