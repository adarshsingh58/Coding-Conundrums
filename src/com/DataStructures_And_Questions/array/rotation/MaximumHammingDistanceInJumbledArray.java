package com.DataStructures_And_Questions.array.rotation;

import java.util.Map;

/**
 * Find maximum hamming distance from a jumbled array
 * <p>
 * Given an array of n elements, create a new array which is a jumbled of given
 * array and hamming distance between both the arrays is maximum.
 * Hamming distance between two arrays or strings of equal length is the number of
 * positions at which the corresponding character(elements) are different.
 * <p>
 * Note: There can be more than one output for the given input.
 * <p>
 * Input : 1 4 1 Output : 2
 * Explanation: Maximum hamming distance = 2.
 * We get this hamming distance with 4 1 1 or 1 1 4
 * <p>
 * input : N = 4
 * 2 4 8 0 output : 4
 * Explanation: Maximum hamming distance = 4
 * We get this hamming distance with 4 8 0 2. All the places can be occupied by
 * another digit. Other solutions can be 8 0 2 4, 4 0 2 8 etc.
 */
public class MaximumHammingDistanceInJumbledArray {

    public static void main(String[] args) {
        MaximumHammingDistanceInJumbledArray distance = new MaximumHammingDistanceInJumbledArray();
        int[] inputArr = {2, 1, 2, 3, 2, 4};
        int hammingDis = distance.findMaxhamming(inputArr);
        System.out.println("Max Hamming Distance = " + hammingDis);
    }

    /**
     * @Pseudo >The idea is that if the similar item count is less than dissimilar items, they can be moved to those dissimilar places
     * >If similar item count is greater than the dissimilar items then no matter how many position change we do, we wil alawys have atleast
     * inputSize-(numberOfSimilarElements-numberOfDissimilarELemnets) items in same place
     * @Analysis findDuplicate_ViaMap() takes O(n) time  and findSimilarElements() takes O(n) times which combinly is O(n) space complexity
     * Since inside findSimilarElements() we have a map which contains items from the array, in worst case scenatio when no
     * items are similar, a map of size n will be formed, hence space complexty = O(n)
     */
    private int findMaxhamming(int[] inputArr) {
        int inputSize = inputArr.length;
        int numberOfSimilarElements = findSimilarElements(inputArr);
        int numberOfDissimilarELemnets = inputSize - numberOfSimilarElements;
        if (numberOfSimilarElements <= numberOfDissimilarELemnets) {
            return inputSize;
        } else {
            return inputSize - (numberOfSimilarElements - numberOfDissimilarELemnets);
        }
    }

    /**
     * This methods returns the count of of maximum occurence of a number
     */
    private int findSimilarElements(int[] inputArr) {
        int numberOfSimELements = 0;
        Map<Integer, Integer> map = null; /*FindingDuplicateElements.findDuplicate_ViaMap(inputArr)*/
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (numberOfSimELements < entry.getValue()) {
                numberOfSimELements = entry.getValue();
            }
        }
        return numberOfSimELements;
    }
}
