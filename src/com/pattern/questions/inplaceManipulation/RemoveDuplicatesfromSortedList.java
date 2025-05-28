package com.pattern.questions.inplaceManipulation;

import com.DS.DoublyListNode;

/**
 * Given the head of a sorted linked list, remove all duplicates such that each element appears only once, and return the list in sorted order.
 */
public class RemoveDuplicatesfromSortedList {

    public static void main(String[] args) {

    }

    /*here we are using outer loop to with if condition to find first occurence of duplicate
    * and then when its found we are using inner loop to find last occurent of the duplicate.
    * post which first occurrence DoublyListNode is connewcted to last occurence DoublyListNode. next.
    * This is played untill curr is null or curr.next is null
    *
    *
    * */
    public static DoublyListNode removeDuplicates(DoublyListNode head) {

        // Replace this placeholder return statement with your code
        DoublyListNode curr=head;
        while(curr!=null && curr.next!=null){
            if(curr.data == curr.next.data){
                DoublyListNode first=curr;
                while(curr.next!=null && curr.next.data==curr.data){
                    curr=curr.next;
                }
                first.next=curr.next;
                curr.next=null;
                curr=first.next;
            }else{
                curr=curr.next;
            }
        }
        return head;
    }

}
