package com.DataStructures_And_Questions.bitwise;

/**
 * Given an array of positive numbers from 1 to n, such that all numbers from 1
 * to n are present except one. Find the missing number.
 */
public class FindMissingNumber_bit {
    public static void main(String[] args) {
        int[] inputArr = new int[]{5, 2, 9, 7, 4, 3, 6, 1};
        int size = inputArr.length + 1;
        int missingNumber_cor = findMissingNum_bitwise(inputArr, size);
        System.out.println(missingNumber_cor);
    }


    /**
     * So we Xor all the values from 1 to n.
     * Now, to this xor, we also Xor all the values inside inputArr.
     * <p>
     * Because a ^ a is always 0, coz we are missing only 1 number i.e.
     * all other numbers are present. So xoring of all but missing number willl be 0.
     * And in the end 0^missingNumber will be missing number.
     */
    private static int findMissingNum_bitwise(int[] inputArr, int size) {
        int xor = 1;
        for (int i = 2; i <= size; i++) {
            xor = xor ^ i;
        }
        for (int i = 0; i < inputArr.length; i++) {
            xor = xor ^ inputArr[i];
        }
        return xor;
    }
}
