package com.DataStructures_And_Questions.array.conundrums;
/**
 *
 * You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
 *
 * You should return the array of nums such that the the array follows the given conditions:
 *
 *     Every consecutive pair of integers have opposite signs.
 *     For all integers with the same sign, the order in which they were present in nums is preserved.
 *     The rearranged array begins with a positive integer.
 *
 * Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1,-2,-5,2,-4]
 * Output: [3,-2,1,-5,2,-4]
 * Explanation:
 * The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
 * The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
 * Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.
 *
 * Example 2:
 *
 * Input: nums = [-1,1]
 * Output: [1,-1]
 * Explanation:
 * 1 is the only positive integer and -1 the only negative integer in nums.
 * So nums is rearranged to [1,-1].
 *
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/
 * */
public class RearrangeAltElementsinpositiveNegative {

    public static void main(String[] args) {
        int[] nums=new int[]{28,-41,22,-8,-37,46,35,-9,18,-6,19,-26,-37,-10,-9,15,14,31};
        rearrangeArray(nums);
    }

    //This can be done using 2 pointers, one at positive number other at negative number
    //keep increasing them to next +ve/-ve # and extracting values to output array.
    public static int[] rearrangeArray(int[] nums) {
        int[] op=new int[nums.length];
        int i=0;
        int p=0,n=0;
        for(;p<nums.length && n<nums.length && i< nums.length;){
            while(p < nums.length && nums[p]<0 )  p++;
            while(n < nums.length && nums[n]>0) n++;
            if(i%2==0){
                op[i]=nums[p];
                i++; p++;
            }
            else{
                op[i]=nums[n];
                i++; n++;
            }
        }
        if(n<nums.length){
            op[i]=nums[n];
        }
        return op;
    }



}
