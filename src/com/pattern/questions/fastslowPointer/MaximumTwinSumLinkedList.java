package com.pattern.questions.fastslowPointer;

/**
 * In a linked list of even length nn, the node at position ii (0-based indexing) is
 * considered the twin of the node at position (n−1−i) for all 0≤i<n/2. For example,
 * if n=4, node 0 and node 3 are twins, and node 1 and node 2 are twins. These pairs are the only twins in a linked list of size 4.
 * <p>
 * The twin sum is defined as the sum of a node’s value and its twin’s value.
 * <p>
 * Given the head of a linked list with an even number of nodes, return the maximum twin sum of the linked list.
 * <p>
 * Constraints:
 */
public class MaximumTwinSumLinkedList {

/*The main idea behind finding the maximum twin sum in a linked list is to reverse the second half of the list and sum the corresponding values from both halves. The algorithm first locates the middle node using fast and slow pointers to achieve this. Then, it reverses the second half of the linked list, starting from the middle node. After that, it calculates the twin sums by adding the values of the nodes from the start of the list and the reversed second half while keeping track of the maximum sum found so far. Finally, it returns the maximum sum encountered during the traversal.*/
    public static void main(String[] args) {

    }
}
