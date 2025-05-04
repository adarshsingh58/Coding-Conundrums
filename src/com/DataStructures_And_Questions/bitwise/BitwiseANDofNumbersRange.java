package com.DataStructures_And_Questions.bitwise;

/*
* Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4

Example 2:

Input: [0,1]
Output: 0

Fails for 0,2147483647
*/
public class BitwiseANDofNumbersRange {
    public static void main(String[] args) {
        System.out.println(bitwiseAndOfRangeOptimised(0, 21));
    }

    //    Not the right solution some test cases failing
    public static int bitwiseAndOfRangeNaive(int m, int n) {
        if (m == n) System.out.println(m & m);
        int bAnd = m & (++m);
        while (m < n) {
            bAnd = bAnd & (++m);
        }
        return bAnd;
    }
/*
* Here, Idea is that, for a given range doing and, we will always get 0 even if any one no is 0
* and 1 only if all no in that column are 1.
*
* We do right shift by 1 until m and n are equal and count the no of steps here i.
* Now we  do left shift by i and have our answer.
* */
    public static int bitwiseAndOfRangeOptimised(int m, int n) {
        int i = 0;
        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            i++;
        }
        m = m << i;

        return m;
    }
}
