package com.DataStructures_And_Questions.array;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int newCount = new RemoveDuplicatesFromSortedArray().removeDuplicates(nums);
        System.out.println(newCount);
    }

    /*
     * This is in place solution but additional space is needed. Better solution must not have extra space for in place solution
     * here, we create a List which will keep data in order since we need to make op array sported the way it is.
     * We find all the unique elements from original array and save them in List in order.
     *
     * Now, we set them back in original array from 0 to maxLength-1 and return maxLength.
     *
     * space O(n)
     * Time O(n)
     *  */
    public int removeDuplicates(int[] nums) {
        List<Integer> listOfUniqueElements = new ArrayList<>();
        for (int i = 0, j = i + 1; i < nums.length; i++, j++) {
            if (j == nums.length) {
                listOfUniqueElements.add(nums[i]);
                break;
            }
            if (nums[i] != nums[j])
                listOfUniqueElements.add(nums[i]);
        }

        for (int i = 0; i < listOfUniqueElements.size(); i++) {
            nums[i] = listOfUniqueElements.get(i);
        }
        return listOfUniqueElements.size();

    }

    /**
     * Since the array is already sorted, we can keep two pointers i and j, where i is the slow-runner while j
     * is the fast-runner. As long as nums[i]=nums[j], we increment j to skip the duplicate.
     * <p>
     * When we encounter nums[j]≠nums[i], the duplicate run has ended so we must copy its value to nums[i+1].
     * i is then incremented and we repeat the same process again until j reaches the end of array.
     *
     * Space O(1)
     * Time O(n)
     */
    public int removeDuplicates_BetterSolution(int[] nums) {

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                //swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        return i + 1;
    }


}
