package com.questions.array;

import com.questions.array.utilites.Helper;

public class ArrayReverse {


    public static void main(String[] args) {
        int[] inputArr = new int[]{1, 2, 31, 1, 4, 5, 6, 7};
        new ArrayReverse().method2(inputArr);

    }

    /**
     * @param inputArr
     * @Pseudo Input array arr[] size n, indexed i. Output array outputArr[n];
     * for(i=0 till n-1)
     * outputArr[i] = inputArr[n-1]
     * @Analysis outputArr of same size as of input is used, hence space complexity is O(n)
     * All the numbers are traversed once in the array hence time complexity is O(n)
     */
    public void method1(int[] inputArr) {
        int n = inputArr.length;
        int[] outputArr = new int[n];
        for (int i = 0; i < inputArr.length; i++, n--) {
            outputArr[i] = inputArr[n - 1];
        }
        Helper.printArray(outputArr);
    }

    /**
     * @Pseudo We will traverse till n/2 where n is the size of the input array
     * swap(arr[i], arr[n-1-i]) till i<n/2
     * @Analysis No Extra array is used, only one variable n is used, which is also optional, hence space complexity = O(1)
     * f(n) = 3c*n/2; where 3c is the constant time for execution of swap function and that is executed n/2 times.
     * Hence, complexity = O(n/2) = O(n)
     */
    public void method2(int[] inputArr) {
        int n = inputArr.length;

        for (int i = 0; i < n / 2; i++) {
            Helper.swap(inputArr, i, n - i - 1);
        }
        Helper.printArray(inputArr);

    }


}
