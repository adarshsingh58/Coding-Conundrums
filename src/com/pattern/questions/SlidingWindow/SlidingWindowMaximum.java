package com.pattern.questions.SlidingWindow;

/**
 * Given an integer list, nums, find the maximum values in all the contiguous subarrays (windows) of size w. eg: -4 2 -5
 * 3 6 window size=3 op: 2 3 6
 * <p>
 * eg : 1 2 3 4 5 6 window size=6 op: 6
 * <p>
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] inp = {7, 2, 4};
        new SlidingWindowMaximum().maxSlidingWindow(inp, 2);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;
        int startWin = 0, endWin = nums.length - 1 < k - 1 ? nums.length - 1 : k - 1;
        int[] op = new int[nums.length - k + 1];
        int j = 0;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        while (endWin < nums.length) {
            if (maxIndex == startWin - 1) {
                max = Integer.MIN_VALUE;
                for (int i = startWin; i <= endWin; i++) {
                    if (nums[i] > max) {
                        max = nums[i];
                        maxIndex = i;
                    }
                }
            } else if (nums[endWin] > max) {
                max = nums[endWin];
                maxIndex = endWin;
            }
            op[j] = max;
            j++;
            startWin++;
            endWin++;
        }

        return op;
    }
}
