package com.questions.array.conundrums;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * <p>
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 * <p>
 * <p>
 * [4,5,6,0,0,0]
 * 3
 * [1,2,3]
 * 3
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        new MergeSortedArray().merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.println(i);
        }
        
    }

    /*
     *
     * */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = nums1.length - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0 && end >= m) {
            if (nums2[n] > nums1[m]) {
                nums1[end] = nums2[n];
                n--;
                end--;
            } else {
                nums1[end] = nums1[m];
                m--;
                end--;
            }
        }

        while (n >= 0) {
            nums1[n] = nums2[n];
            n--;
        }
    }

}
