package com.DataStructures_And_Questions.linkedList;

import com.DataStructures_And_Questions.linkedList.LinkedList.LinkedList;

import com.DataStructures_And_Questions.linkedList.LinkedList.LinkedList.Node;

/**
 * Given head nodes of two linked lists that may or may not intersect, find out
 * if they intersect and return the point of intersection; return null
 * otherwise. e.g. inputList1= 29,23,89,11,12,27 inputList2= 13,4,1,12,27
 * <p>
 * o/p: 12
 */
public class IntersectionPointofTwoLists {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.add(29);
        linkedList1.add(23);
        linkedList1.add(89);
        linkedList1.add(11);
        linkedList1.add(12);
        linkedList1.add(27);

        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.add(13);
        linkedList2.add(4);
        linkedList2.add(1);
        linkedList2.add(12);
        linkedList2.add(27);

        int intersectionData = findIntersection(linkedList1, linkedList2);
        System.out.println(intersectionData);
    }

    /**
     * In this case, we must first understand the idea.
     * When 2 list have and intersection point, they will have the same data
     * and same number of data post the intersection point.
     * Hence, only the size of the list before the intersection point will differ.
     * if we can subtract the size of 2 list, and increment the head of bigger list
     * by this diff, we will essentially make the 2 list equal in size.
     * Now, keep incrementing the size of both by 1 and see where the data is equal.
     * <p>
     * Because the lists are equal and at a point intersection will happen, it
     * is bound that intersection will happen at same index and hence both are
     * incremnted by 1.
     *
     * @TimeComplexity O(n) where n is the size of bigger list.
     * @SpaceComplexity O(1) no new data structure is used.
     */
    private static int findIntersection(LinkedList<Integer> linkedList1, LinkedList<Integer> linkedList2) {
        int lenDiff = linkedList1.length - linkedList2.length;
        Node curr1 = linkedList1.head;
        Node curr2 = linkedList2.head;
        if (lenDiff < 0) {
            while (lenDiff != 0) {
                curr2 = curr2.next;
                lenDiff++;
            }
        } else if (lenDiff > 0) {
            while (lenDiff != 0) {
                curr1 = curr1.next;
                lenDiff--;
            }
        }
        while (curr2!=null && curr1!=null) {
            /* If intersection point is goverened by value we use this but if  its by Node, then we do
                if (curr1 == curr2)
               comparing if nodes are equal. i.e. there might be a case where node value are same but thats not
               the intersection, intersection may be by Object type of Node and not value type.
            * */
            if (curr1.data == curr2.data) {
                return (int) curr1.data;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return -1;
    }
}
