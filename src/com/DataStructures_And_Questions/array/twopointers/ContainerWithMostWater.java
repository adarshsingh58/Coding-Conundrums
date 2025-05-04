package com.DataStructures_And_Questions.array.twopointers;

/**
 * Statement
 * <p>
 * You’re given an integer array height of length n, and there are n vertical lines drawn such that
 * the two endpoints of the ith line are (i,0) and (i, height[i]).
 * <p>
 * Find two lines from the input array that, together with the x-axis, form a container that holds as much water as possible.
 * Return the maximum amount of water a container can store.
 * <p>
 * Note: You may not slant the container.
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea_attempt(height));
    }


    public static int maxArea_attempt(int[] height) {


        return 0;
    }

    /*
    The idea is to use 2 pointers from each and to m=find max height and keep updating
    the lower height pointer to ++ for i OR -- for j until they overlap.
    First Q: What if we find 2 largest values and calculate their distance?
             This will not work because 2 largest ones may be just 1 unit away while smaller ones may b n-1 units away
             In which case max area will be between smaller ones which are the farthest.
    Prefix Sum? : No wont work, we cant save prefix sum of ith index from 0. Since we need min(ith and jth).
    Two Pointer? This might work.
    */
    public static int maxArea(int[] height) {
        int max = 0;

        for (int i = 0, j = height.length - 1; i <= j; ) {
            int area = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, area);
            if (height[i] < height[j]) i++;
            else j--;
        }

        return max;
    }
}
