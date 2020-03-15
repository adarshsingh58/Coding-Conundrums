package com.datastructures.Heap;

/*
 * A heap stores in array where 0th index will always have maximum of all data. This is called Max Heap.
 * It is a binary tree structure where root node always have value greater than both child node and the tree is always
 * complete i.e. all levels are filled before a new level starts.
 *
 * For any node at ith index, its left node index in array which the heap is represented as, is given by [(i*2)+1]
 * and right node is given by, [(i*2)+2]
 *
 * Parent node is given by (i-1)/2
 */
public class Heap {
    private int[] heapArray;
    private int currentSizeOfHeap;

    public Heap(int size) {
        heapArray = new int[size];
        currentSizeOfHeap = 0;
    }

    /*
     * While add, the new data is always added on the last index in a HEAP.
     * After adding, the entire heap is adjusted to make sure its property of current node greater than child nodes is met.
     * For that we have a method reHeapAfterAdd().
     * */
    public void add(int data) {
        heapArray[currentSizeOfHeap] = data;
        currentSizeOfHeap++;
        reHeapAfterAdd();
    }

    /*
    To delete a data from heap,
    >we swap it with the last data in heap/array and then delete it.
    >Now since the heap might be imbalanced of swap we re structure it using method reHeapAfterDelete()
     */
    public void delete(int data) {
        int dataIndex = indexOf(data);
        swap(dataIndex, currentSizeOfHeap - 1);
        heapArray[currentSizeOfHeap - 1] = 0;//step 1 in (equivalent to) deletinig the last element
        currentSizeOfHeap--;//step 2 in (equivalent to) deletinig the last element
        reHeapAfterDelete(dataIndex);
    }

    private int indexOf(int data) {
        for (int i = 0; i < currentSizeOfHeap; i++) {
            if (heapArray[i] == data)
                return i;
        }
        throw new RuntimeException("Data Doesn't Exist");
    }

    /*
    Max in a max heap is always at the 0th index
     */
    public int getMax() {
        return heapArray[0];
    }

    /**
     * Here we will re structure the heap after an element is added on the last index.
     * >We compare the added data from the parent data,
     * >if added data is greater -> we swap
     * else
     * -> break, because this mean that current node's parent is greater than all the child nodes and that is our objective
     */
    private void reHeapAfterAdd() {
        int i = currentSizeOfHeap - 1;
        while (i >= 0) {
            if (heapArray[i] > heapArray[parentNode(i)]) {
                swap(i, parentNode(i));
            } else {
                break;
            }
            i = parentNode(i);
        }
    }

    private void swap(int i, int j) {
        int temp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = temp;
    }

    /*
    Now we will check,
    >> If the data at dataIndex is greater than parent node
            -> HeapUP()
    >>Else,
            -> HeapDown()
   */
    private void reHeapAfterDelete(int dataIndex) {
        heapUp(dataIndex);
        heapDown(dataIndex);
    }

    /*
    Compare the dataIndex data with BOTH its child
        >If left child is greater than dataIndex data and also the right child, swap
        >If right child is greater than dataIndex data and also the left child, swap
        >continue until end of the level
     */
    private void heapDown(int dataIndex) {
        int leftChildIndex = leftNode(dataIndex);
        int rightChildIndex = rightNode(dataIndex);
        int i = dataIndex;
        while (i < currentSizeOfHeap) {
            if (leftChildIndex > currentSizeOfHeap && rightChildIndex > currentSizeOfHeap) {
                return;//no left or right child exist
            } else if (leftChildIndex > currentSizeOfHeap || rightChildIndex > currentSizeOfHeap) {
                if (leftChildIndex > currentSizeOfHeap) {//no left child
                    if (heapArray[i] >= heapArray[rightChildIndex])
                        return;
                    else {
                        swap(rightChildIndex, i);
                        i = rightChildIndex;
                    }
                } else {//no right child
                    if (heapArray[i] >= heapArray[leftChildIndex])
                        return;
                    else {
                        swap(leftChildIndex, i);
                        i = leftChildIndex;
                    }
                }
            }
            if (heapArray[i] > heapArray[leftChildIndex] && heapArray[i] > heapArray[rightChildIndex]) {//if current replaced dataIndex data is greatest, no action required
                return;
            } else if (heapArray[leftChildIndex] > heapArray[i] && heapArray[leftChildIndex] > heapArray[rightChildIndex]) {
                //leftChildIndex is greatest, replace replaced dataIndex with leftChild
                swap(leftChildIndex, i);
                i = leftChildIndex;
            } else if (heapArray[rightChildIndex] > heapArray[i] && heapArray[rightChildIndex] > heapArray[leftChildIndex]) {
                //rightChildIndex is greatest, replace replaced dataIndex with rightChildIndex
                swap(rightChildIndex, i);
                i = rightChildIndex;
            }
            leftChildIndex = leftNode(i);
            rightChildIndex = rightNode(i);
        }
    }

    /*
    swap the parent data from current data and continue until root or until parent is greater than current
     */
    private void heapUp(int dataIndex) {
        int i = dataIndex;
        while (i >= 0) {
            if (heapArray[i] > heapArray[parentNode(i)]) {
                swap(i, parentNode(i));
            } else {
                break;
            }
            i = parentNode(i);
        }
    }

    /*
    For any node at ith index, its left node index is given by [(i*2)+1]
     */
    private int leftNode(int indexOfCurrentNode) {
        return (indexOfCurrentNode * 2) + 1;
    }

    /*
    right node index is given by [(i*2)+2]
     */
    private int rightNode(int indexOfCurrentNode) {
        return (indexOfCurrentNode * 2) + 2;
    }

    /*
    Parent node is given by (i-1)/2
     */
    private int parentNode(int indexOfCurrentNode) {
        return (indexOfCurrentNode - 1) / 2;
    }


}
