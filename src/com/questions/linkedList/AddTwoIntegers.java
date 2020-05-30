package com.questions.linkedList;

import com.questions.linkedList.linkedListBase.LinkedList;
import com.questions.linkedList.linkedListBase.LinkedList.Node;

/**
 * Given head pointers of two linked lists where each linked list represents an
 * integer number (each node is a digit), add them and return the resulting
 * linked list. Here, the first node in a list represents the least significant
 * digit.
 * eg: list1= 1 0 9 9
 * list2= 7 3 2
 * coz first node is the Least sig digit, numbers are 9901 and 237 we the addition is 10138
 * which in list form with Least Sig Digit as first node will be :
 * O/P list: 8 3 1 0 1
 */

public class AddTwoIntegers {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.add(2);
        linkedList1.add(4);
        linkedList1.add(3);
//        linkedList1.add(9);
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.add(5);
        linkedList2.add(6);
        linkedList2.add(4);

        LinkedList<Integer> opList = add(linkedList1, linkedList2);
        System.out.println(opList);
    }

    /**
     * Idea here is that, we have tracked carry forward in a var named carry.
     * For 2 numbers, carry can never be >1, it is either 0 or 1. As max 2 numbers in addition
     * can be 9 and 9 added to 18 where 8 is the sum and 1 is the carry.
     * <p>
     * >We added data from both list along with carry and the resultant is moded by 10 to give Least Sig digit
     * >When one list fall shorter i.e. MSB is not available, we simply add digit from other list with carry and mod
     * >At the very end, we must see if, the carry forward is 0 or 1, if 1 then that will be the MSB of result
     * and must be added to the opList
     *
     * @TimeComplexity O(m + n)
     * @SpaceComplexity O(n) New List is used. (here n>m)
     */
    private static LinkedList<Integer> add(LinkedList<Integer> linkedList1, LinkedList<Integer> linkedList2) {
        LinkedList<Integer> opList = new LinkedList<>();
        int carry = 0;
        Node curr1 = linkedList1.head;
        Node curr2 = linkedList2.head;

        while (curr1 != null || curr2 != null) {
            if (curr1 != null && curr2 != null) {
                opList.add(((int) curr1.data + (int) curr2.data + carry) % 10);
                carry = (int) curr1.data + (int) curr2.data > 9 ? 1 : 0;
                curr1 = curr1.next;
                curr2 = curr2.next;
            } else if (curr1 != null) {
                opList.add(((int) curr1.data + carry) % 10);
                carry = (int) curr1.data + carry > 9 ? 1 : 0;
                curr1 = curr1.next;
            } else if (curr2 != null) {
                opList.add(((int) curr2.data + carry) % 10);
                carry = (int) curr2.data + carry > 9 ? 1 : 0;
                curr2 = curr2.next;
            }
        }
        if (carry != 0) {
            opList.add(carry);
        }
        return opList;
    }

}
