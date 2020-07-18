package com.questions.algorithms;

public class KadaneAlgoForMaxSumSubArray {

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
    }

    /*
     * The simplest approach here would be to do a BRUTE FORCE where we find sum of every sub array in the array \
     * and keep track of max sum. This would take O(n*n) time complexity.
     *
     * With Kadane's algo, this could be done in O(n) time.
     *
     * The idea is that, at a given index the maximum sub array will ALWAYS be maximum of
     * (MaxSubArrayBeforeCurrentIndex+valueAtCurrentIndex OR valueAtCurrentIndex). This is because we are talking about
     * contiguous sub array.
     *
     * In a = {-2, -3, 4, -1, -2, 1, 5, -3}; at index say 2, maximum sub array would be
     * (maxumum sub array till index 1 + value at index 2 OR value at index 2)
     * (-2 + 4 OR 4) Hence 4.
     *
     * So,  we take a variable max_ending_here and make it 0 as soon as its value become <0. The reason is that
     * max_ending_here being negative can NEVER create maximum sub array upon adding to value at current index.
     *
     */
    static int maxSubArraySum(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
}
