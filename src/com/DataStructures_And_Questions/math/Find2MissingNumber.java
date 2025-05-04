package com.DataStructures_And_Questions.math;

public class Find2MissingNumber {

    public static void main(String[] args) {

    }


    /*
     * Common Solution: Using Set with Extra Space
     *
     * time O(n) Space O(n)
     * */
    public int[] get2MissingNumbers() {
        int[] op = new int[2];


        return op;
    }


    /*
    * The idea is based on this popular solution for finding one missing number.
    * We extend the solution so that two missing elements are printed.
        Let’s find out the sum of 2 missing numbers:

        arrSum => Sum of all elements in the array
        sum (Sum of 2 missing numbers) = (Sum of integers from 1 to n) - arrSum
                                       = ((n)*(n+1))/2 – arrSum

        avg (Average of 2 missing numbers) = sum / 2;

            One of the numbers will be less than or equal to avg while the other one will be strictly greater than avg.
            Two numbers can never be equal since all the given numbers are distinct.
            We can find the first missing number as a sum of natural numbers from 1 to avg,
            i.e., avg*(avg+1)/2 minus the sum of array elements smaller than avg
            We can find the second missing number by subtracting the first missing number from the sum of missing numbers

        Time O(n) Space O(1)
    * */

    public int[] get2MissingNumbers_better() {
        int[] op = new int[2];


        return op;
    }
}
