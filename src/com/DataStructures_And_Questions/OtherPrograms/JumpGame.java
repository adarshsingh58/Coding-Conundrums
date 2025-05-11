package com.DataStructures_And_Questions.OtherPrograms;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the
 * array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [3,2,1,0,4] Output: false Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * <p>
 * https://leetcode.com/problems/jump-game/description/
 */
public class JumpGame {
    public static void main(String[] args) {

    }

    /*
     * O(n) solution. we are starting from last maintaining the leastPossibleIndex from which target i.e. last index can be reached.
     * leastPossibleIndex is updated to currIndex if currIndex has jump >= target OR >= the last least index from which jump to target was possible.
     * */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        int target = nums.length - 1;
        int leastPossibleIndex = target;
        for (int i = target - 1; i > -1; i--) {
            int jump = (nums[i] + i);
            if (jump >= target || jump >= leastPossibleIndex) {
                leastPossibleIndex = i;
            }
        }
        //   list.forEach(System.out::println);
        return leastPossibleIndex == 0 ? true : false;
    }
}
