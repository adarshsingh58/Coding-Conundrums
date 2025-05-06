package com.DataStructures_And_Questions.array;

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
 * [4,13,22,0,0,0]
 * [1,7,43]
 *
 *
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        new MergeSortedArray().merge(nums1, 3,nums2,3);
        for (int i : nums1) {
            System.out.println(i);
        }

    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        m--;
        n--;

        for (; m>-1 && n>-1 && i >= 0; i--) {
            if (nums2[n] > nums1[m]) {
                nums1[i] = nums2[n];
                n--;
            }else{
                nums1[i] = nums1[m ];
                m--;
            }
        }

        while(n>0 && m==0){
            nums1[i]=nums2[n];
            n--;
            i--;
        }
        while(m>0 && n==0){
            nums1[i]=nums1[n];
            n--;
            i--;
        }

    }
    private void attempt(int[] arr1, int[] arr2) {


    }

    /*
    * Here "WE HAVE TO WORK ON "2 TYPES" OF VALUES IN 2 ARRAY. SO IN THESE SITUATIONS WE CAN TRY TWO POINTER APPROACH"
    *
    * Here, we can take a new Array and 2 pointers i=0,j=0 on arr1 and arr2.
    * Using i, j we compare values on sorted arr1 and arr2 to see which is smaller
    * and add that value to new array and increase the i or j, whicever had smaller value
    * untill the end of either array. Then which ever array is left with values we append to
    * op array. Here we have time compl as O(n) but space of O(n) is also used for op array.
    *
    * To make inplace, we start from last index values from both arr1 and arr2 : i,j.
    * and use k to mark last index of arr1 from where the values are to be placed.
    *
    * Now which ever amoing i and j is larger we place on k and decrement either of (i or j) and k.
    * continue until either array is over. If j is over then we have final sorted array, if i is over
    * then we pre-append all left elements from arr2 to arr1.
    * This will have time as O(n) but with space as O(1).
    *
    * */
    public void merge(int[] arr1, int[] arr2) {
        int i = arr1.length - arr2.length - 1,
                j = arr2.length - 1,
                k = arr1.length - 1;
        while(i>-1 && j>-1 && k>-1) {
            if (arr1[i] > arr2[j]) {
                arr1[k] = arr1[i];
                i--;
            }
            else {
                arr1[k] = arr2[j];
                j--;
            }
            k--;
        }

        if(i<0 && j>-1){
            while(j>-1) {
                arr1[j] = arr2[j];
                j--;
            }
        }
    }

}
