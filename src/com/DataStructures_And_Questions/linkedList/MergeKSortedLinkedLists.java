package com.DataStructures_And_Questions.linkedList;

import com.DS.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLinkedLists {
    public static void main(String[] args) {
        ListNode<Integer>[] lists = new ListNode[3];
        ListNode<Integer> ln1 = new ListNode<Integer>(1);
        ListNode<Integer> ln2 = new ListNode<Integer>(4);
        ListNode<Integer> ln3 = new ListNode<Integer>(2);

        ln1.next = new ListNode<Integer>(1);
        ln1.next.next = new ListNode<Integer>(7);
        ln1.next.next.next = new ListNode<Integer>(31);

        ln2.next = new ListNode<Integer>(17);
        ln2.next.next = new ListNode<Integer>(21);
        ln2.next.next.next = new ListNode<Integer>(47);

        ln3.next = new ListNode<Integer>(14);
        ln3.next.next = new ListNode<Integer>(76);

        lists[0] = ln1;
        lists[1] = ln2;
        lists[2] = ln3;

        ListNode<Integer> op = mergeKListsByDivideAndConquer(lists);

        while (op != null) {
            System.out.println(op.val);
            op = op.next;
        }
    }

    /*
    We have divided the problem into sub problem of 2 from first and last list of the array and
    stored the result in first i.e. ith index of array
    when half of the indexes are done we started back from 0 to last where last is not middle way.

    This way we divided the problem into problem of 2 and conquered its way to main solution
    * */
    public static ListNode<Integer> mergeKListsByDivideAndConquer(ListNode<Integer>[] lists) {
        if (lists.length == 0) return null;
        int last = lists.length - 1;

        while (last > 0) {
            int i = 0, j = last;

            while (i < j) {
                lists[i] = mergeTwoLists(lists[i], lists[j]);
                i++;
                j--;
            }
            last = j;
        }

        return lists[0];
    }


    private static ListNode<Integer> mergeTwoLists(ListNode<Integer> i, ListNode<Integer> j) {

        if (i == null && j != null) return j;
        if (j == null && i != null) return i;
        if (i == null && j == null) return null;
        ListNode<Integer> l1 = new ListNode<Integer>();
        ListNode<Integer> l2 = l1;

        while (i != null && j != null) {
            l1.next = new ListNode<Integer>();
            l1 = l1.next;
            if (i.val == j.val) {
                l1.val = i.val;
                l1.next = new ListNode<Integer>();
                l1 = l1.next;
                i = i.next;

                l1.val = j.val;
                j = j.next;

            } else if (i.val > j.val) {
                l1.val = j.val;
                j = j.next;

            } else {
                l1.val = i.val;
                i = i.next;
            }
        }

        if (i == null && j != null) {
            l1.next = j;
        } else if (i != null && j == null) {
            l1.next = i;
        }

        return l2.next;
    }
}

