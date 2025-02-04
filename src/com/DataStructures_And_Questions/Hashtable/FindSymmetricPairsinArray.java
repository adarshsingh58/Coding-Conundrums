package com.DataStructures_And_Questions.Hashtable;

import java.util.*;

/*Given an array of pairs, nums, find all the symmetric pairs from it. If no symmetric pair is found, return an empty array.*/
public class FindSymmetricPairsinArray {
    public static void main(String[] args) {
        int[][][] testCases = {
                {{1, 2}, {4, 6}, {4, 3}, {6, 4}, {5, 9}, {3, 4}, {9, 5}},
                {{1, 2}, {2, 1}, {3, 4}, {5, 5}, {6, 7}},
                {{1, 9}, {9, 1}},
                {{1, 2}, {3, 4}, {5, 6}},
                {{-8, -4}, {7, 7}, {1, 1}, {2, 2}, {-4, -8}}
        };

        int i = 1;
        for (int[][] testCase : testCases) {
            System.out.println(i + ".\tInput Array: " + Arrays.deepToString(testCase));
            List<List<Integer>> symmetric = findSymmetric(testCase);
            System.out.println("\n\tSymmetric pairs: " + symmetric);
            System.out.println(new String(new char[100]).replace('\0', '-'));
            i++;
        }
    }
    public static List<List<Integer>> findSymmetric(int[][] arr) {
        List<List<Integer>> op=new ArrayList<>();
        Set<String> s=new HashSet<>();
        for(int[] a:arr){
            if(s.contains(a[1]+","+a[0])){
                op.add(Arrays.asList(a[0],a[1]));
                op.add(Arrays.asList(a[1],a[0]));
            }
            else
                s.add(a[0]+","+a[1]);
        }
        return op;
    }
}
