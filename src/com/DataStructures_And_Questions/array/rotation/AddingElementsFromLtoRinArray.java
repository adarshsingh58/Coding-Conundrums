package com.DataStructures_And_Questions.array.rotation;

/**
 * l r : Print the sum of all integers in the subarray a[l,r] (l and r inclusive), X number of times
 * arr[] = { 1, 2, 3, 4, 5 }
 * input { 0, 2 }, {3,4}, {2,3}
 * output 4, 9, 7
 */
public class AddingElementsFromLtoRinArray {

    public static void main(String[] args) {
        int[] inputArr = {12, 22, 13, 6, 4};
        System.out.println(printSumFromLtoR(inputArr, 1, 4));
    }

    private static int attempt(int[] inputArr, int l, int r) {
    return 0;
    }

    /**
     * @Pseudo >Here we are creating an array intermediateSumArray[], where its ith elemenet will contain sum of inputArr[0] till inputArr[i]
     * > This is one time process
     * > For any subsequential request for addition, instead of adding numbers everytime from inputArr[l] to inputArr[r],
     * We subtract  intermediateSumArray[l-1] from intermediateSumArray[r]
     * @Analysis First step is one time process of O(n) in time and second is constant process O(1), so total time complexity O(n)
     * Since we are maintaining a similar array of size n, space complexity is O(n).
     */
    private static int printSumFromLtoR(int[] inputArr, int l, int r) {
        int[] intermediateSumArray = new int[inputArr.length];
        int sum = 0;
        for (int i = 0; i < inputArr.length; i++) {
            intermediateSumArray[i] = sum + inputArr[i];
            sum = sum + inputArr[i];
        }
        if (l == 0) {
            return intermediateSumArray[r];// because if only execute else part (l-1) will throw exception for this case
        } else {
            return intermediateSumArray[r] - intermediateSumArray[l - 1];
        }
    }

}
