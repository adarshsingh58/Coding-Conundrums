package com.pattern.questions.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value,
 and the median is the mean of the two middle values.

 For example, for arr = [2,3,4], the median is 3.
 For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.

 Implement the MedianFinder class:

 MedianFinder() initializes the MedianFinder object.
 void addNum(int num) adds the integer num from the data stream to the data structure.
 double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.



 Example 1:

 Input
 ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 [[], [1], [2], [], [3], []]
 Output
 [null, null, null, 1.5, null, 2.0]

 Explanation
 MedianFinder medianFinder = new MedianFinder();
 medianFinder.addNum(1);    // arr = [1]
 medianFinder.addNum(2);    // arr = [1, 2]
 medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 medianFinder.addNum(3);    // arr[1, 2, 3]
 medianFinder.findMedian(); // return 2.0



 Constraints:

 -105 <= num <= 105
 There will be at least one element in the data structure before calling findMedian.
 At most 5 * 104 calls will be made to addNum and findMedian.



 Follow up:

 If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?

 https://leetcode.com/problems/find-median-from-data-stream/

 */
public class FindMedianfromDataStream {

    public static void main(String[] args) {
        FindMedianfromDataStream obj = new FindMedianfromDataStream();

        obj.addNum(2);
        System.out.println("Median now: " + obj.findMedian());
        obj.addNum(3);
        obj.addNum(1);
        System.out.println("Median now: " + obj.findMedian());
        obj.addNum(7);
        obj.addNum(9);
        obj.addNum(4);
        System.out.println("Median now: " + obj.findMedian());
        obj.addNum(12);
        System.out.println("Median now: " + obj.findMedian());
    }

    /*
    * Straight up brute force approach would be to add all the incoming data to a TreeSet or Sorted ArrayList which will maintain the order.
    * When findMedian is called, we traverse to n/2 and return value.
    * Here on add(), the data structure will be sorted everytime, so for each add O(n logn), then for findMedian O(n)
    *
    * Better Approach would be to use 2 Heaps/PriorityQueue.
    * - maxHeap_from_leftValues: This will contain first/left half of the Sorted data and since its a MaxHeap, we get rightmost/larger element in O(1)
    * - minHeap_from_rightValues: This will contain second/right half of the Sorted data and since its a minHeap, we get leftmost/smaller element in O(1)
    * With these two peeks we can get median since we have the middle elements of the sorted array.
    * For odd elements we return only maxHeap_from_leftValues's peek
    * For even elements we return (maxHeap_from_leftValues's peek + minHeap_from_rightValues) /2
    * For this while adding we ensure, maxHeap_from_leftValues always has equalTo or +1 elements from minHeap_from_rightValues.
    *
    * For add:
    * - we first add data to min or max heap based on if its greater or smaller then top of minHeap.
    * - Then we adjust the heaps to make sure minHeap_from_rightValues.size >= minHeap_from_rightValues with diff not more than 1
    *
    * here findMedian is O(1)
    * add is adding to 2 heaps O(logn)+O(logn) then for adjusting we are polling which is O(1) and again adding which is O(logn)
    * so total for add its O(logn)
    * */


    PriorityQueue<Double> maxHeap_from_leftValues = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Double> minHeap_from_rightValues = new PriorityQueue<>();

    public void addNum(int numInt) {
        Double num = Double.valueOf(numInt);
        if (maxHeap_from_leftValues.isEmpty()) //we start with adding elements in leftSide of sorted array first
            maxHeap_from_leftValues.add(num);
        else {
            if (num <= maxHeap_from_leftValues.peek())
                maxHeap_from_leftValues.add(num);
            else
                minHeap_from_rightValues.add(num);

            if (maxHeap_from_leftValues.size() - minHeap_from_rightValues.size() > 1) {
                int elementDifference = maxHeap_from_leftValues.size() - minHeap_from_rightValues.size();
                while (elementDifference != 1) {
                    minHeap_from_rightValues.add(maxHeap_from_leftValues.poll());
                    elementDifference--;
                }
            } else if (minHeap_from_rightValues.size() - maxHeap_from_leftValues.size() > 0) {
                int elementDifference = minHeap_from_rightValues.size() - maxHeap_from_leftValues.size();
                while (elementDifference != 0) {
                    maxHeap_from_leftValues.add(minHeap_from_rightValues.poll());
                    elementDifference--;
                }
            }
        }

    }

    public double findMedian() {
        double median;
        if (maxHeap_from_leftValues.size() == minHeap_from_rightValues.size())
            median = (double) (maxHeap_from_leftValues.peek() + minHeap_from_rightValues.peek()) / 2;
        else
            median = maxHeap_from_leftValues.peek();
        return median;
    }


}
