package com.pattern.questions.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, nums, find all possible subsets of nums, including the empty set.
 * <p>
 * Note: The solution set must not contain duplicate subsets. You can return the solution in any order.
 */
public class Subset {

    /**
     * Problems such as this one, where we need to find all possible subsets of a given set, can be efficiently solved
     * using the subsets pattern. This pattern involves generating all possible subsets of a given set by using binary
     * representations of indices to represent which elements should be included in each subset. This approach allows us
     * to solve a wide
     * <p>
     * range of problems that involve generating all possible subsets of a set. Solution
     * <p>
     * Generating all possible subsets of a given set inherently involves exploring different combinations of elements,
     * which aligns well with the subset technique. First, the total number of potential subsets is calculated using:
     * pow(2,nums.length) This determines the total number of possible combinations, where each combination represents a
     * potential subset formed by either including or excluding each element from the input list. Next, we iterate
     * through all potential possible combinations of subsets starting from 0 and iterating up to the total number of
     * subsets calculated earlier. A new subset is generated within each iteration by interpreting the current iteration
     * number in binary format. Each bit of the binary representation corresponds to whether the element at that
     * position in the input list should be included in the subset. We use bitwise operations to check each bit of the
     * binary representation. If the bit is set to 1, the corresponding element from the input list is included in the
     * subset. Otherwise, it is excluded. This approach ensures that every possible combination of elements is
     * considered, generating all subsets without duplicates.
     * <p>
     * <p>
     * Time complexity
     * <p>
     * The time complexity of this solution is exponential, specifically O(2n⋅n)O(2n⋅n), where nn represents the number
     * of integers in the given array. Space complexity
     * <p>
     * The space complexity of this solution is O(n)O(n), where nn represents the number of integers in the given array.
     * This analysis excludes the space utilized by the output array, setsList, and only considers the space used by the
     * subset set.
     */
    static List<List<Integer>> findAllSubsets(int[] nums) {
        List<List<Integer>> setsList = new ArrayList<>();
        if (nums.length != 0) {

            // finds number of subsets by taking power of length of input array
            int subsetsCount = (int) (Math.pow(2, nums.length));

            System.out.println("   Total subsets: " + subsetsCount);
        } else {
            System.out.println("   Total subsets: 1");
            List<Integer> subset = new ArrayList<>();
            setsList.add(subset);
        }
        return setsList;
    }

    public static void main(String[] args) {
        int[][] inputSets = {
                {},
                {2, 5, 7},
                {1, 2},
                {1, 2, 3, 4},
                {7, 3, 1, 5}
        };

        for (int i = 0; i < inputSets.length; i++) {
            int[] set = inputSets[i];
            System.out.println((i + 1) + ". Set: " + Arrays.toString(set));
            List<List<Integer>> subsets = findAllSubsets(set);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
