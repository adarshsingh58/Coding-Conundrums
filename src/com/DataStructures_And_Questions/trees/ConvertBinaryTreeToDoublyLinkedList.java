package com.DataStructures_And_Questions.trees;

/**
 * Given a binary tree, convert it to a doubly linked list such that the order
 * of doubly linked list is the same as in-order traversal of the binary tree.
 * After conversion the left pointer of the node should be pointing to the
 * previous node in the doubly linked list and the right pointer should be
 * pointing to the next node in the doubly linked list.
 * <p>
 * <p>
 * One simple way of solving this problem is to start with an empty doubly
 * linked list. While doing the in-order traversal of the binary tree, keep
 * inserting each element output into the doubly linked list. But if we look at
 * the question carefully, the interviewer wants us to convert the binary tree
 * to a doubly linked list in-place i.e. we should not create new nodes for the
 * doubly linked list.
 */
public class ConvertBinaryTreeToDoublyLinkedList {

}
