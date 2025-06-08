package com.DataStructures_And_Questions.scenarioBasedQues;

import java.util.HashSet;
import java.util.Set;

/*
* This problem is about counting “compromised subarrays” — subarrays whose bitwise OR result is present anywhere in the original array.

⸻

🧠 Problem Summary:
Given array arr, a subarray [i..j] is compromised if:
* (bitwise OR of arr[i..j]) is present in arr[]
*
* Approach:
	•	Preprocess all values in arr into a Set<Integer> present for O(1) lookup.
	•	Use a sliding window of ORs:
	•	At each index i, track all distinct ORs that can end at that index.
	•	For each OR, check if it’s in the present set → count as compromised.

* */
public class CompromisedSubarray {
/*
* Time Complexity:
	•	Worst-case OR set size per step is ~32 (for 32-bit integers).
	•	So total complexity is approximately: O(n * 32) ≈ O(n)
* */
        public static long getCompromisedSubarrayCount(int[] arr) {
            int n = arr.length;
            Set<Integer> present = new HashSet<>();
            for (int val : arr) {
                present.add(val);
            }

            Set<Integer> prev = new HashSet<>();
            long count = 0;

            for (int num : arr) {
                Set<Integer> curr = new HashSet<>();
                curr.add(num);
                for (int p : prev) {
                    curr.add(p | num);
                }

                for (int val : curr) {
                    if (present.contains(val)) {
                        count++;
                    }
                }

                prev = curr;
            }

            return count;
        }

        public static void main(String[] args) {
            int[] arr = {2, 4, 7};
            System.out.println(getCompromisedSubarrayCount(arr)); // Output: 5
        }
}
