package com.DataStructures_And_Questions.sorting;

import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arrayToSort = new int[10];
        setArrayData(arrayToSort);
        bubbleSort(arrayToSort);
        printArray(arrayToSort);
    }

    private static void setArrayData(int[] arrayToSort) {
        System.out.println("Enter" + arrayToSort.length + " Array data");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = sc.nextInt();
        }
    }

    /*
     * The concept of bubble sorting is that it every 2 ADJACENT elements are a bubble
     * A bubble starts from (0th & 1st){coz a bubble is a pair of 2 adjacent elements} index and goes till end (n-1 & n) of the array
     * A bubble has the tendency to sort the only 2 elements inside it in either ascending or descending order, depnding on implemntation
     * A bubble iterate the array n times from (0th & 1st) index to (n-1 & n) index where n is the length of the array
     *
     * Because, 1 iteration is having upto n traversal {from 0th & 1st) index to (n-1 & n) index} and there are
     * total n iterations, therefore Time complexity is O(n*n) i.e. O(n^2)
     *
     * We are not using any n dependent storage here, only a temp variable hence Space/Auxilary complexity is O(1)
     *
     */
    private static void bubbleSort(int[] arrayToSort) {
        for (int i = 0; i < arrayToSort.length; i++) {
            for (int j = 0; j < arrayToSort.length - 1; j++) {
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    int temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = temp;
                }
            }
            printArray(arrayToSort);
            System.out.println("");
        }
    }

    private static void printArray(int[] arrayToSort) {
        for (int data : arrayToSort) {
            System.out.print(data + " ");
        }
    }
}