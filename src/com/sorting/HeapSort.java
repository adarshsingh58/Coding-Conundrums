package com.sorting;

import com.heap.Heap;

import java.util.Scanner;

/*
 * Heap sort utilizes the idiosyncrasy of Heap that they always have the maximum element on top of heap i.e. at 0th index
 * So, all we have to do is to take out the top element and let the rest of the heap heapify itself again w/o the just
 * removed element recursively.
 *
 * Steps:
 * 1> Form a heap containing all the input elements
 * 2> Because max of all will be at top,
 *      - swap the top element with last element, then (print and delete) last element and then call Heapify
 *      OR
 *      - (print and delete) the top element (this will automatically call heapify and will structure the heap to have max element at top again)
 * 3> Repeat step 2 untill no elements left in heap
 *
 * Time complexity: Considering Heap contains all the data (i.e. not including cost of copying array to heap)
 *                  We are essentially doing 2 things: getMax(), which takes O(1) and delete(data) which takes O(log n) in a heap.
 *                  So total complexity is O(1)+O(logn) -> O(log n)
 *                  This whole operation is performed on a data set of size n, hence that will be O(n)
 *                  Therefore total Time complexity -> O(n)*O(log n) {multiplied coz O(log n) code is inside a for loop of O(n)}
 *                      -> O(nLog n)
 *
 * Space complexity: If we follow approach 1 from below to directly add data to heap from console then no additional storage is used aside from
 *                  actual storing data, hence Space complexity will be O(1)
 *
 *                  If we follow approach 2 from below to have an input array and then copy data into the array, as we have done here, then
 *                  since heap DS is an additional DS for storing data of array n, Space complexity will be O(n)
 *
 *                  With approach 3 from below also, since heap array will only be referencing to input array no additional space is used,
 *                  hence Space complexity will be O(1)
 *
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arrayToSort = setUpArray();
        heapSort(arrayToSort);
    }

    private static void heapSort(int[] arrayToSort) {

        /*
         * We prepare heap here. Heap internally uses array, so we can either
         * 1> directly add input to heap, or
         * 2> like we did here, add input to array and then copy to heap one by one, or
         * 3> point the Heap.ARRAYitUSESinternally to the arrayToSort.
         *
         * 1 is the best option but our sort method will then restrict to have a Heap input parameter instead of Array
         *   which is not very feasible from API standpoint,
         * 2 is good in terms of input param is an array, but there is an additional O(n) cost for adding all
         *   data into heap one by one. As an end result, we will have a proper heap.
         * 3 is also one of the best option, but API should have exposed the internal array through a getter method, in
         *   this case the getter method is not exposed to we are taking the 2nd approach. As an end result,
         *   we will not have a proper heap as user is adding data from console and this will not be in heap form. So,
         *   a heapify() operation will be required.
         *
         * The actual complexity of the heap sort will be tested considering that data is already present in the HEAP
         * and will not include the addition of data into heap from input array.
         *
         */
        Heap heap = prepareHeap(arrayToSort);

        System.out.println("Sorted List");
        for (int i = 0; i < arrayToSort.length; i++) {
            System.out.println(heap.getMax());
            heap.delete(heap.getMax());
        }

    }

    private static Heap prepareHeap(int[] arrayToSort) {
        Heap heap = new Heap(arrayToSort.length);
        for (int i = 0; i < arrayToSort.length; i++) {
            heap.add(arrayToSort[i]);
        }
        return heap;
    }

    private static int[] setUpArray() {
        System.out.println("Enter Array of size 10");
        int[] array = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }
}