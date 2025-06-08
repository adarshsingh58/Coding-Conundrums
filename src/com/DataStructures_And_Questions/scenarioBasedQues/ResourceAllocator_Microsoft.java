package com.DataStructures_And_Questions.scenarioBasedQues;

/*
* This problem is a variation of the Partition Array into n Subarrays to Minimize the Maximum Subarray Sum,
* with the added constraint that each resource (server) must get a contiguous segment of tasks.

⸻

Problem Recap
	•	You have m tasks with burst times: burstTime[0...m-1]
	•	You have n servers.
	•	Each server must process a contiguous segment of tasks.
	•	Your goal: Minimize the maximum load time among all servers after distributing the tasks.
Example

For n = 3 and burstTime = [4, 3, 2, 2, 2, 6], an optimal partition is:
	•	[4,3] → sum = 7
	•	[2,2,2] → sum = 6
	•	[6] → sum = 6
=> Max load = 7

⸻

Algorithm: Binary Search + Greedy Partitioning

We use binary search to find the minimum possible value of the maximum load.

Steps:
	1.	Search Space:
	•	low = max(burstTime)
	•	high = sum(burstTime)
	2.	Binary Search:
	•	For a mid value (possible max load), check if it’s possible to divide the array into at most n contiguous segments, each with a sum ≤ mid.
	3.	Greedy Check:
	•	Keep accumulating sums until it exceeds mid. When it does, start a new segment.
	•	Count how many segments are formed.

* */
public class ResourceAllocator_Microsoft {

    public static long getMinMaxLoadTime(int n, int[] burstTime) {
        long low = 0;
        long high = 0;

        for (int time : burstTime) {
            low = Math.max(low, time); // min possible max load is the max burst time
            high += time;              // max possible load is total of all burst times
        }

        long result = high;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (canPartition(burstTime, n, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private static boolean canPartition(int[] burstTime, int n, long maxLoad) {
        int count = 1;
        long currentSum = 0;

        for (int time : burstTime) {
            if (currentSum + time <= maxLoad) {
                currentSum += time;
            } else {
                count++;
                currentSum = time;
                if (count > n) {
                    return false;
                }
            }
        }

        return true;
    }

    // For testing
    public static void main(String[] args) {
        int n = 3;
        int[] burstTime = {4, 3, 2, 2, 2, 6};
        System.out.println(getMinMaxLoadTime(n, burstTime)); // Output: 7
    }
}
