package com.pattern.questions.heap;

/**
 The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
 So the median is the mean of the two middle values.

 For examples, if arr = [2,3,4], the median is 3.
 For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.

 You are given an integer array nums and an integer k. There is a sliding window of size k
 which is moving from the very left of the array to the very right.
 You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 Return the median array for each window in the original array. Answers within 10-5 of the actual value will be accepted.

 Example 1:

 Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
 Explanation:
 Window position                Median
 ---------------                -----
 [1  3  -1] -3  5  3  6  7        1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7        3
 1  3  -1  -3 [5  3  6] 7        5
 1  3  -1  -3  5 [3  6  7]       6

 Median is always of ordered/sorted data. So when we have window of [1 3 -1], the median is 1 because
 values are perceived as [-1 1 3] in their sorted nature.

 Example 2:

 Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
 Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]

 https://leetcode.com/problems/sliding-window-median/description/
 */
public class SlidingWindowMedian {
    public static void main(String[] args) {
        int[] inp={1,3,-1,-3,5,3,6,7};
        int windowSize=3;
        double[] op=medianSlidingWindow(inp,windowSize);
        for (double v : op) {
            System.out.println(v);
        }
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] op= new double[nums.length+1-k];
        for (int i = 0; i + k < nums.length; i++) {

        }

        return op;
    }

}
