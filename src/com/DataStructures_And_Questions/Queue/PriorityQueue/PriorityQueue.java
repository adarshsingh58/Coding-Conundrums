package com.DataStructures_And_Questions.Queue.PriorityQueue;

/**
 * A priority queue is a type of queue that arranges elements based on their priority values. Elements with higher priority values are typically retrieved or removed before elements with lower priority values. Each element has a priority value associated with it. When we add an item, it is inserted in a position based on its priority value.
 * <p>
 * There are several ways to implement a priority queue, including using an array, linked list, heap, or binary search tree, binary heap being the most common method to implement. The reason for using Binary Heap is simple, in binary heaps, we have easy access to the min (in min heap) or max (in max heap) and binary heap being a complete binary tree are easily implemented using arrays. Since we use arrays, we have cache friendliness advantage also.
 * <p>
 * Priority queues are often used in real-time systems, where the order in which elements are processed is not simply based on the fact who came first (or inserted first), but based on priority. Priority Queue is used in algorithms such as Dijkstra’s algorithm, Prim’s algorithm, Kruskal’s algorithm and Huffnam Coding.
 * Properties of Priority Queue
 * <p>
 * So, a priority Queue is an extension of the queue with the following properties.
 * <p>
 * Every item has a priority associated with it.
 * An element with high priority is dequeued before an element with low priority.
 * If two elements have the same priority, they are served according to their order in the queue.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Binary Heap is generally preferred for priority queue implementation because heaps provide better performance compared to arrays or LinkedList.
 * Considering the properties of a heap, The entry with the largest key is on the top and can be removed immediately.
 * It will, however, take time O(log n) to restore the heap property for the remaining keys.
 * However if another entry is to be inserted immediately, then some of this time may be combined with the O(log n) time needed to insert the new entry.
 * Thus the representation of a priority queue as a heap proves advantageous for large n, since it is represented efficiently in contiguous storage
 * and is guaranteed to require only logarithmic time for both insertions and deletions. Operations on Binary Heap are as follows:
 * <p>
 * insert(p): Inserts a new element with priority p.
 * extractMax(): Extracts an element with maximum priority.
 * remove(i): Removes an element pointed by an iterator i.
 * getMax(): Returns an element with maximum priority.
 * changePriority(i, p): Changes the priority of an element pointed by i to p.
 * <p>
 * <p>
 * insert() O(log n)
 * remove() O(log n)
 * peek() O(1)
 */
public class PriorityQueue<E> {

    /*When a new element is inserted in a priority queue, it moves to the empty slot from top to bottom and left to right.
    However, if the element is not in the correct place then it will be compared with the parent node.
    If the element is not in the correct order, the elements are swapped.
    The swapping process continues until all the elements are placed in the correct position.*/
    public void insert() {

    }

    /*As you know that in a max heap, the maximum element is the root node.
    And it will remove the element which has maximum priority first.
    Thus, you remove the root node from the queue.
    This removal creates an empty slot, which will be further filled with new insertion.
    Then, it compares the newly inserted element with all the elements inside the queue to maintain the heap invariant.*/
    public void delete() {

    }

    /*This operation helps to return the maximum element from Max Heap or the minimum element
    from Min Heap without deleting the node from the priority queue.*/
    public E peek() {

        return null;
    }
}
