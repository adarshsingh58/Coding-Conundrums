package com.DataStructures_And_Questions.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Rearrange an array such that arr[i] = i Given an array of elements of length
 * N, ranging from 1 to N. All elements may not be present in the array. If
 * element is not present then there will be -1 present in the array. Rearrange
 * the array such that arr[i] = i and if i is not present, display -1 at that
 * place.
 * <p>
 * Examples:
 * <p>
 * Input : arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1}
 * Output : [-1, 1, 2, 3, 4,-1, 6, -1, -1, 9]
 * <p>
 * Input : arr = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4}
 * Output : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
 */
public class ArrangeArray_i_at_arrOfi {

    public static void main(String[] args) {
        List<int[]> inp=new ArrayList<>();
        inp.add(new int[]{-1, -1, 6, 2, 9, 3, 1, -1, 4, -1});
        inp.add(new int[]{19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4});

        inp.forEach(i ->{
            int[] op=new ArrangeArray_i_at_arrOfi().attempt(i);
            System.out.println("Output:");
            for (int i1 : op) {
                System.out.print(" "+i1+" ");
            }
        });

    }

    /*
    * One thing we can do is to use extra space and put (0 to arr.length-1) value in a Set.
    * Now traverse over arr and remove items when a match happens.
    * Now For left items in set we mark op array as -1 and for all else as its index value.
    *
    * Here space of O(n) is used.
    *
    * */
    private int[] attempt(int[] inp) {
        Set<Integer> set=new HashSet<>();
        //initialize Set from 0 to arr.length-1
        for (int i = 0; i < inp.length; i++)
            set.add(i);

        for (int i : inp)
            if(set.contains(i))
                set.remove(i);

        for (int i = 0; i < inp.length; i++) {
            if (set.contains(i))
                inp[i] = -1;
            else
                inp[i] = i;
        }
        return inp;
    }

    /**
     * @Pseudo Traverse through the array.
     * If inputArr[i] is not -1 Proceed
     * Else 	1>swap inputArr[i] to the inputArr[inputArr[i]]
     *
     * 2>Here if the existing value at index inputArr[i] i.e. inputArr[inputArr[i]] is not -1
     * we will need to put it to its right place instead of placing it at inputArr[i], because in next iteration i will become
     * i++ and if this value we just swapped to inputArr[i] is wrongly set, the control will never come back here to fix this.
     *
     * 3>So, we also check that if inputArr[inputArr[i]] != -1, we arrange this value too by decresing i by one
     * hence when loop starts i is same as previous and hence the index is revisited again for the rearrangemnet
     * @Analysis one for loop for all numbers is used, occasionally repeating certain indexes where step 3 is implied, but overall time comp is O(n)
     * Since no new array is utilized , space complexity is O(1)
     */
    private int[] method1(int[] inputArr) {

        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] != -1) {
                int temp = inputArr[inputArr[i]];
                inputArr[inputArr[i]] = inputArr[i];// step 1
                inputArr[i] = temp;// step 2
                if (temp != -1 && i != temp) {// step 3
                    i--;
                }
            }
        }
        return inputArr;
    }

}
