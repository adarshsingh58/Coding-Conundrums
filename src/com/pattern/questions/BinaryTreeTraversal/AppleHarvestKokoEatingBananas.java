package com.pattern.questions.BinaryTreeTraversal;
/**
 * DESCRIPTION (credit https://leetcode.com/problems/koko-eating-bananas)
 *
 * Bobby has an orchard of apple trees, and each tree has a certain number of apples on it.
 *
 * Bobby wants to collect all the apples by the end of the day by collecting a fixed number of apples per hour. He can only harvest apples from one tree per hour - if he finishes collecting apples from a tree before the hour is up, he must wait until the next hour to move to the next tree.
 *
 *     For example, if there are 3 apples on a tree and Bobby collects 1 apple per hour, it will take him 3 hours to finish collecting the apples on that tree.
 *     If he harvests 2 apples per hour, it will take him 2 hours to finish collecting all the apples on that tree (he waits until the hour is up even though he finishes early).
 *
 * Write a function to determine the slowest rate of apples Bobby can harvest per hour to finish the job in at most 'h' hours. The input to the function is an array of integers representing the number of apples on each tree and an integer 'h' representing the number of hours Bobby has to finish the job within.
 * EXAMPLES
 *
 * Example 1:
 *
 * Input:
 *
 * apples = [3, 6, 7], h = 8
 *
 * Output: 3
 *
 * Explanation:
 *
 *     1 apple per hour: 3 hours for first tree, 6 hours the second tree, and 7 hours for third tree. This totals 16 hours, which is more than the 8 hours he has to finish the job. NOT VALID.
 *     2 apples per hour: 2 + 3 + 4 = 9 hours, which is more than the 8 hours he has to finish the job. NOT VALID.
 *     3 apples per hour: 1 + 2 + 3 = 6 hours, which is less than the 8 hours he has to finish the job. VALID.
 *     4 apples per hour: 1 + 2 + 2 = 5 hours, which is less than the 8 hours he has to finish the job. VALID.
 *     5 apples per hour: 1 + 2 + 2 = 5 hours, which is less than the 8 hours he has to finish the job. VALID.
 *
 * Therefore, the minimum number of apples Bobby must harvest per hour to finish the job in 8 hours or less is 3.
 *
 * Example 2:
 *
 * Input:
 *
 * apples = [25, 9, 23, 8, 3], h = 5
 *
 * Output: 25 (Bobby must harvest 25 apples per hour to finish in 5 hours or less)
 *
 * https://leetcode.com/problems/koko-eating-bananas/
 * https://www.youtube.com/watch?v=qyfekrNni90
 * */
public class AppleHarvestKokoEatingBananas {
    public static void main(String[] args) {
        int[] inp={30,11,23,4,20};
    new AppleHarvestKokoEatingBananas().minEatingSpeed(inp,5);
    }

    public int minEatingSpeed(int[] piles, int h) {

        int start = 1, end = 1;
        for (int i = 0; i < piles.length; i++) {
            end = Math.max(end, piles[i]);
        }

        while (start < end) {
            int mid = (start + end) / 2;
            int hours = findHoursWithGivenK(piles, mid);

            if (hours <= h) {
                end = mid; // Try smaller k
            } else {
                start = mid + 1; // Need larger k
            }
        }

        return start;
    }

    public int findHoursWithGivenK(int[] piles, int k) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours = hours + (int)Math.ceil((double)piles[i]/k);
        }
        return hours;
    }
}
