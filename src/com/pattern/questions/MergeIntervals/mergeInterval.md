The Overlapping Intervals pattern is used to merge or handle overlapping intervals in an array.

In an interval array sorted by start time, two intervals [a, b] and [c, d] overlap if b >= c (i.e., the end time of the first interval is greater than or equal to the start time of the second interval).
Sample Problem:

Problem Statement: Merge all overlapping intervals.

Example:

    Input: intervals = [[1, 3], [2, 6], [8, 10], [15, 18]]

    Output: [[1, 6], [8, 10], [15, 18]]

Explanation:

    Sort the intervals by their start time.

    Create an empty list called merged to store the merged intervals.

    Iterate through the intervals and check if it overlaps with the last interval in the merged list.

    If it overlaps, merge the intervals by updating the end time of the last interval in merged.

    If it does not overlap, simply add the current interval to the merged list.