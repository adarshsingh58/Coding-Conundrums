About the pattern

The top k elements pattern is an important technique in coding that helps us efficiently find a specific number of elements, known as kk, from a set of data. This is particularly useful when we’re tasked with identifying the largest, smallest, or most/least frequent elements within an unsorted collection.

To solve tasks like these, one might think to sort the entire collection first, which takes O(nlog⁡(n))O(nlog(n)) time, and then select the top k elements, taking additional O(k)O(k) time. However, the top k elements pattern bypasses the need for full sorting, reducing the time complexity to O(nlog⁡k)O(nlogk) by managing which elements we compare and keep track of.

Which data structure can we use to solve such problems? A heap is the best data structure to keep track of the smallest or largest kk elements. With this pattern, we either use a max heap or a min heap to find the smallest or largest kk elements, respectively, because they allow us to efficiently maintain a collection of elements ordered in a way that gives us quick access to the smallest (min heap) or largest (max heap) element.

For example, let’s look at how this pattern operates to solve the problem of finding the top kk largest elements (by using min heap) or top kk smallest elements (by using max heap):

    Insert the first kk elements from the given set of elements into a heap. If we’re looking for the largest elements, use a min heap to keep the smallest of the large elements at the top. Conversely, for the smallest elements, use a max heap to keep the largest of the small elements at the top.

    Iterate through the remaining elements of the given set.
        For a min heap, if we find an element larger than the top, remove the top element (the smallest of the large elements) and insert the new, larger element. This ensures the heap always contains the largest elements seen so far.
        For a max heap, if we find an element smaller than the top, remove the top element (the largest of the small elements) and insert the new, smaller element, keeping the heap filled with the smallest elements seen so far.

The efficiency of this pattern comes from the ability of the heap to insert and remove elements in O(log⁡k)O(logk) time. Because we only maintain kk elements in the heap, these operations are quick, and we can process all nn elements in the given set in O(nlog⁡k)O(nlogk) time.

    It’s important to note that while accessing the top element of the heap can be done in O(1)O(1) time, retrieving all k elements, if necessary, involves removing them one by one. This process takes O(klog⁡k)O(klogk) time because each removal necessitates reorganizing the heap.
The following examples illustrate some problems that can be solved with this approach:

    Sort characters by frequency: Sort a string in increasing order based on the frequency of its characters.
    Connect nn ropes with minimum cost: Connect nn ropes into one rope with minimum cost, such that the cost to connect two ropes is equal to the sum of their lengths.

Does your problem match this pattern?

    Yes, if both of these conditions are fulfilled:

        Unsorted list analysis: We need to extract a specific subset of elements based on their size (largest or smallest), frequency (most or least frequent), or other similar criteria from an unsorted list. This may be the requirement of the final buildingBridges, or it may be necessary as an intermediate step toward the final buildingBridges.

        Identifying a specific subset: The goal is to identify a subset rather than just a single extreme value. When phrases like top k, kth largest/smallest, k most frequent, k closest, or k highest/lowest describe our task, it suggests the top k elements pattern is ideal for efficiently identifying a specific subset.

    No, if any of these conditions is fulfilled:
        Presorted input: The input data is already sorted according to the criteria relevant to solving the problem.
        Single extreme value: If only 11 extreme value (either the maximum or minimum) is required, that is, k=1k=1, as that problem can be solved in O(n)O(n) with a simple linear scan through the input data.

Real-world problems

Many problems in the real world use the top K elements pattern. Let’s look at some examples.

    Location-based services in ride-sharing apps like Uber: For a user requesting a ride, the app needs to find the nearest available drivers to ensure a quick pickup. However, it’s not efficient or necessary to consider every driver in the city. Using the top k elements pattern, the app can efficiently determine the nn closest drivers to the user’s location. This involves sorting drivers based on their distance from the user but in a way that prioritizes computational efficiency, especially when nn is much smaller than the total number of drivers.

    Performance analysis in financial markets: We can analyze broker performance by identifying those with the highest transaction volumes or other metrics of success. Given a dataset with broker IDs and their transaction volumes, the top K elements pattern can help sift through the data to highlight the brokers leading the market based on the frequency of their transactions or other relevant performance indicators.

    Social media trend analysis: Identifying the most popular or trending topics by analyzing hashtags or keywords. The top K elements pattern can help filter out the top topics based on their frequency over a certain time frame.


The Top 'K' Elements pattern finds the top k largest or smallest elements in an array or stream of data using heaps or sorting.
Sample Problem:

Find the k-th largest element in an unsorted array.

Example:

    Input: nums = [3, 2, 1, 5, 6, 4], k = 2

    Output: 5

Explanation:

    Use a min-heap of size k to keep track of the k largest elements.

    Iterate through the array, adding elements to the heap.

    If the heap size exceeds k, remove the smallest element from the heap.

    The root of the heap will be the k-th largest element.