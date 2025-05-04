The Sliding Window pattern is used to find a subarray or substring that satisfies a specific condition, optimizing the time complexity by maintaining a window of elements.

Use this pattern when dealing with problems involving contiguous subarrays or substrings.
Sample Problem:

Find the maximum sum of a subarray of size k.

Example:

    Input: nums = [2, 1, 5, 1, 3, 2], k = 3

    Output: 9

Explanation:

    Start with the sum of the first k elements.

    Slide the window one element at a time, subtracting the element that goes out of the window and adding the new element.

    Keep track of the maximum sum encountered.