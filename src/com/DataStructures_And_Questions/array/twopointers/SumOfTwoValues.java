package com.DataStructures_And_Questions.array.twopointers;

import java.util.*;

/**
 * Given an array of integers and a value, determine if there are any two
 * integers in the array which sum equal to the given value e.g.
 * inputArr=5, 7, 1, 2, 8, 4, 3
 * targetSum=10
 * O/P: 7,3 and 2,8
 */
public class SumOfTwoValues {

    public static void main(String[] args) {
        int[] inputArr = new int[]{5, 7, 1, 2, 8, 4, 3};
        int targetNumber = 10;

        printSum(inputArr, targetNumber);
    }

    /**
     * The idea is very simple but powerful.
     * If you have a number x and a target number z, then to see if a third number y exist
     * so that x+y=z then you only need to look for number (z-x).
     * >Here, we store all integers in a set.
     * >We know the target.
     * >we now traverse the inputArr and for each number, we see if (target-number) exist or not.
     * If yes, then we found 2 number adding up to target number else not.
     * >>We also need to remove the found number from the set so that they do not show up twice
     * >>Also we need to keep a check that same number do not show up as found number,
     * i.e. if we do set.contains(10-5) and set will contain 5 as a number then result will be true
     * but in reality 5 is the number we are trying to find a match against.
     *
     * @TimeComplexity O(n + n) -> O(n)
     * @SpaceComplexity O(n), since a set of size of inputArr is used as an auxiliary storage
     */
    private static void printSum(int[] inputArr, int targetNumber) {
        Set<Integer> set = createInputSet(inputArr);
        for (int number : inputArr) {
            if (set.contains(targetNumber - number)) {
                if (number != targetNumber - number) {// this will prevent same number as 'number' from the set to be
                    // printed
                    System.out.println(number + " and " + (targetNumber - number));
                    set.remove(number);
                    set.remove(targetNumber - number);// so that (a and b) doest show up again as (b and a)
                }
            }
        }
    }

    /**
     * This method sets up a hashset with data from inputArr
     *
     * @param inputArr
     * @return
     */
    private static Set<Integer> createInputSet(int[] inputArr) {
        Set<Integer> set = new HashSet<>();
        for (int i : inputArr) {
            set.add(i);
        }
        return set;
    }
}
