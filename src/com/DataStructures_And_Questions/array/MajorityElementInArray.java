package com.DataStructures_And_Questions.array;

import java.util.*;

/**
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element
 * always exists in the array.
 * <p>
 * Example 1: Input: nums = [3,2,3] Output: 3
 * <p>
 * Example 2: Input: nums = [2,2,1,1,1,2,2] Output: 2
 * <p>
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 * <p>
 * https://leetcode.com/problems/majority-element/ Boyer-Moore Majority Vote Algorithm
 * http://www.cs.utexas.edu/~moore/best-ideas/mjrty/
 */
public class MajorityElementInArray {


    public static void main(String[] args) {
        List<Integer[]> inp = new ArrayList<>();
        inp.add(new Integer[]{2, 2, 1, 1, 1, 2, 2});
        inp.add(new Integer[]{2, 3, 3, 3, 4});

        inp.forEach(i -> {
            System.out.println(majEleOn(i));
        });

      /*  int sol=0,majorityElement=-1;
        if(sol==0)
            majorityElement= majEle_ExtraSpace(nums);
        else
            majorityElement= majEleOn(nums);*/
    }

    /**
     * Here we have to work on #of a certain elements i.e. frequency. So sorting is one way and using HashMap is
     * another.
     * <p>
     * With Sorting, we sort the data and check if for each value i, next value i+1 is same or not, if so we increase
     * the frequency counter and cpntinue until we get counter> length/2. Here we have time as nlogn and space as 1
     * <p>
     * With Map we can store freq for each element and then traverse the map to find the element where freq>length/2.
     * Here Time is O(n) but space is O(n)
     */
    private static int attempt(Integer[] nums) {
        Arrays.sort(nums);
        int counter = 1, i = 0;
        while (i < nums.length - 1) {
            if (nums[i] == nums[i + 1]) {
                counter++;
            } else {
                if (counter > (nums.length / 2))
                    break;
                else
                    counter = 1;
            }
            i++;
        }

        if (counter > (nums.length / 2))
            return nums[i];

        return -1;
    }

    private static int majEle_ExtraSpace(int[] nums) {

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(nums[i])) {
                mp.put(nums[i], mp.get(nums[i]) + 1);
            } else {
                mp.put(nums[i], 1);
            }
        }
        int res = 0;
        Integer threshold = Math.round((nums.length) / 2);


        for (Map.Entry<Integer, Integer> entry : mp.entrySet())
            if (entry.getValue() > threshold && entry.getValue() > res)
                res = entry.getKey();
        return res;
    }

    /*
     * When any element is > half of entire array that means, if we start incrementing
     * a counter everytime similar char is found and decrementing when different char is found
     * then at the end only dominant char will be left.
     * This would only work when there is absolutely a dominant/major element in an array.
     * */
    private static int majEleOn(Integer[] num) {
        int major = num[0];
        int count = 1;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) {
                count++;
            } else count--;

        }
        return major;
    }
}
