package com.pattern.questions.customDS;

/**
 * In this challenge, you have to implement a Snapshot Array with the following properties:
 * <p>
 * Constructor (length): This is the constructor and it initializes the data structure to hold the specified number of
 * indexes.
 * <p>
 * Set Value (idx, val): This property sets the value at a given index idx to value val.
 * <p>
 * Snapshot(): This method takes no parameters and returns the Snap ID. Snap ID is the number of times that the snapshot
 * function was called, less 1, as we start the count at 0. The first time this function is called, it saves a
 * snapshot and returns 0. The nth time it is called, after saving the snapshot, it returns n−1.
 * <p>
 * Get Value (idx, Snap ID) method returns the value at the index in the snapshot with the given Snap ID.
 * <p>
 * Suppose that we have three nodes whose values we wish to track in the snapshot array. Initially, the value of all the
 * nodes will be 0. After calling the Set Value (1, 4) function, the value of node 1 will change to 4. If we take a
 * snapshot at this point, the current values of all the nodes will be saved with Snap ID 0. Now, if we call Set Value
 * (1, 7), the current value for node 1 will change to 7. Now, if we call the Get Value (1, 0) function, we will get
 * the value of node 1 from snapshot 0, that is, 4.
 */
public class SnapshotArray {


}
