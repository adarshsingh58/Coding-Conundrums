package com.DataStructures_And_Questions.QueuesStack.QueueBaseImpl;

public class Queue {
    int[] queue;
    int front;
    int rear;
    public int size = 0;

    /*
     * Initializing the queue with -1, which will represent empty slot
     */
    public Queue(int sizeOfQueue) {
        queue = new int[sizeOfQueue];
        for (int i = 0; i < sizeOfQueue; i++) {
            queue[i] = -1;
        }
        rear = -1;
        front = -1;
    }

    /*
     * Enqueuing is the process of adding the element to the queue. Since we are
     * implementing the circular array, there are certain cases we need to take care
     * of:
     *
     * Case 1: When Queue is empty. Then, we need to set the front from -1 to last
     * index of the array, which is front of the queue. And then add the element to
     * front index. We also set rear to front index as with one element front and
     * rear are same. Case 3: When rear index is full i.e. rear element is at 0th
     * index. Unlike normal Queue, where we would have stopped enqueuing when this
     * situation arises, here we have a circular queue which means if there is a
     * space available at the front of the queue also, we will enqueue there to
     * utilize space. This beget 2 scenarios,
     *
     * Case 3.1: If queue itself is not full, i.e. front is not at last elemnt of
     * the array, i.e. atmost ahead of queue. Then, because rear end is full and
     * there is space on front end, we set rear index to (Array'slength-1) and
     * insert the data there. Case 3.2: If queue is full i.e. front is at the atmost
     * ahead index of array i.e. (Array'slength-1), we say queue is full Case 2: If
     * rear end is not full, i.e. rear index is > 0. Here also, 2 scenarios are
     * created:
     *
     * Case 2.1: If Queue is not full, i.e. front index of queue is not (rear
     * index-1), remember this can happen as we are dealing with circular array and
     * rear index can get ahead of the front index. Then we simply, reduce the rear
     * index and then enqueue the data there. Case 2.2: If front index of queue is
     * equal to (rear index-1), then essentially queue is full and hence enqueue is
     * not possible
     *
     */
    public void enqueue(int data) {
        if (rear == -1 && front == -1) { // Case 1: There is no data in the array
            front = queue.length - 1;
            queue[front] = data;
            rear = queue.length - 1;
            size++;
        } else if (rear - 1 >= 0) { // Case 2: If rear end is not full i.e. index is > 0 and space is left at the
            // rear end
            if (rear - 1 != front) {// Case 2.1: Queue is not full i.e. front is not just behind rear
                queue[--rear] = data;
                size++;
            } else {
                System.out.println("Queue Full");
            }
        } else if (rear - 1 < 0) { // Case 3: Rear end is full i.e. rear is at index 0
            if (queue.length - 1 != front) {// Case 3.1: If Queue is not full
                rear = queue.length - 1;
                queue[rear] = data;
                size++;
            } else {// Case 3.2: If Queue is full
                System.out.println("Queue Full");
            }
        }
    }

    /*
     * Dequeue is the case when nwe want remove an element from the queue. Dequeue
     * always happens at the front end of the queue.
     *
     * Case 1: When Queue is empty. Then we can't remove any element and print
     * message saying queue is empty. Case 2: When front index is ahead of the rear
     * index and not at the rear end, i.e. front index != 0. Case 2.1: There are >1
     * record. In this case, we simply return the data at front index and replace it
     * with -1 to show no data and decrease the front index by 1. Case 2.2: If there
     * is only one record i.e. front==rear, then we need to return it and mark both
     * front and rear to -1. Case 3: When front index is behind rear index and at
     * the rear end i.e. front index ==0 Case 3.1: There are >1 record. In this
     * case, we simply return the data at front index and replace it with -1 to show
     * no data and make front index equal to array's length-1, to put it back to
     * endmost of array, as this is a circular queue. Case 3.2: If there is only one
     * record i.e. front==rear, then we need to return it and mark both front and
     * rear to -1.
     */
    public int dequeue() throws Exception {
        if (rear == -1 && front == -1) {// Case 1: Queue Empty
            throw new Exception("Queue Empty");
        } else if (front - 1 >= 0) { // Case 2: front is not at the rear end
            size--;
            if (front != rear)// Case 2.1 : There is > than one record
            {
                int data = queue[front];
                queue[front] = -1;
                front--;
                return data;
            } else { // Case 2.2: There is only one record
                int dataToReturn = queue[front];
                front = -1;
                rear = -1;
                return dataToReturn;
            }
        } else {// Case 3: front index is at the rear end
            size--;
            if (front != rear) {// Case 3.1
                int dataToReturn = queue[front];
                queue[front] = -1;
                front = queue.length - 1;
                return dataToReturn;
            } else {// Case 3.2
                int dataToReturn = queue[front];
                front = -1;
                rear = -1;
                return dataToReturn;
            }

        }
    }

    public String traverse() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int dataInQ : queue) {
            stringBuffer.append(dataInQ + " ");
        }
        stringBuffer.append("\n");
        if (front != -1 && rear != -1)
            stringBuffer.append("Front : " + queue[front] + " \nRear : " + queue[rear]);
        stringBuffer.append("\n size:" + size);
        return stringBuffer.toString();
    }

    @Override
    public String toString() {
        return traverse();
    }
}