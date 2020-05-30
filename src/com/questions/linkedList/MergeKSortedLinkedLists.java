package com.questions.linkedList;

import com.questions.linkedList.linkedListBase.LinkedList;

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
 */
public class MergeKSortedLinkedLists {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(4);
        ListNode ln3 = new ListNode(2);

        ln1.next = new ListNode(1);
        ln1.next.next = new ListNode(7);
        ln1.next.next.next = new ListNode(31);

        ln2.next = new ListNode(17);
        ln2.next.next = new ListNode(21);
        ln2.next.next.next = new ListNode(47);

        ln3.next = new ListNode(14);
        ln3.next.next = new ListNode(76);

        lists[0] = ln1;
        lists[1] = ln2;
        lists[2] = ln3;

        ListNode op = mergeKListsByDivideAndConquer(lists);

        while (op != null) {
            System.out.println(op.val);
            op = op.next;
        }
    }

    private static LinkedList<Integer> mergeListsBySort(LinkedList<Integer>[] lists) {

        return null;
    }

    /*
    We have divided the problem into sub problem of 2 from first and last list of the array and
    stored the result in first i.e. ith index of array
    when half of the indexes are done we started back from 0 to last where last is not middle way.

    This way we divided the problem into problem of 2 and conquered its way to main solution
    * */
    public static ListNode mergeKListsByDivideAndConquer(ListNode[] lists) {
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


    private static ListNode mergeTwoLists(ListNode i, ListNode j) {

        if (i == null && j != null) return j;
        if (j == null && i != null) return i;
        if (i == null && j == null) return null;
        ListNode l1 = new ListNode();
        ListNode l2 = l1;

        while (i != null && j != null) {
            l1.next = new ListNode();
            l1 = l1.next;
            if (i.val == j.val) {
                l1.val = i.val;
                l1.next = new ListNode();
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

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
