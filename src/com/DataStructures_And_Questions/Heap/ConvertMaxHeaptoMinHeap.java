package com.DataStructures_And_Questions.Heap;

/**
 * Given an array representing a max heap, convert this into a min heap.
 */
public class ConvertMaxHeaptoMinHeap {


    /*In this solution, we convert a given maxHeap into a min heap.
    We achieve this by adjusting the positions of elements within the heap to meet the criteria of a min heap,
    where each parent node is smaller than its child nodes. This process starts from the halfway point of the heap,
    typically where the last non-leaf node is found, and iteratively applies the min heap criteria up to the root node.

    The adjustment involves comparing each node with its children to identify the smallest among them.
    We determine the left and right children of a node using the following formulas:

    left=index∗2+1left=index∗2+1

    right=index∗2+2right=index∗2+2

    Here are the steps for the comparison:

    Check whether the node does not have the smallest value among its children.
        If the value of the left child is smaller, then swap the node with the left child.
        Otherwise, swap the node with the right child.

    Apply the above step recursively to ensure the entire subtree rooted at the swapped node satisfies the min heap property.

    Continue this process until all the nodes, from the last nonleaf node up to the root,
    have been checked and adjusted to meet the criteria of a min heap. */
}
