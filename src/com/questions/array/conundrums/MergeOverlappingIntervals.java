package com.questions.array.conundrums;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array (list) of intervals as input where each interval has a start
 * and end timestamps. Input array is sorted by starting timestamps. You are
 * required to merge overlapping intervals and return output array (list).
 * <p>
 * Consider below input array.
 * inputArr = (1, 5), (3, 7), (4, 6), (6, 8), (10, 12) and (12, 15)
 * <p>
 * Intervals (1, 5), (3, 7), (4, 6), (6, 8) are
 * overlapping so should be merged to one big interval (1, 8).
 * Similarly intervals (10, 12) and (12, 15) are also overlapping intervals and should be
 * merged to (10, 15).
 * O/P =  (1, 8), (10,15)
 */
public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        List<String> inputArr = new ArrayList<>();
        inputArr.add("1,5");
        inputArr.add("3,7");
        inputArr.add("4,6");
        inputArr.add("6,8");
        inputArr.add("10,12");
        inputArr.add("12,15");

        List<String> mergedList = getMergedList(inputArr);
        System.out.println(mergedList);
    }

    /**
     *
     */
    private static List<String> getMergedList(List<String> inputArr) {
        List<String> outputArr = new ArrayList<>();
        int globalX = Integer.parseInt(inputArr.get(0).split(",")[0]);
        int globalY = Integer.parseInt(inputArr.get(0).split(",")[1]);
        for (int i = 0; i < inputArr.size(); i++) {
            String tuple = inputArr.get(i);
            int tupleX = Integer.parseInt(tuple.split(",")[0]);
            int tupleY = Integer.parseInt(tuple.split(",")[1]);
            if (tupleX <= globalY) {
                globalY = tupleY;
                continue;
            } else {
                outputArr.add(globalX + "," + globalY);
                globalX = tupleX;
                globalY = tupleY;
            }
        }
        outputArr.add(globalX + "," + globalY);
        return outputArr;
    }
}
