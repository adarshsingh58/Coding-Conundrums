package com.pattern.questions.inplaceManipulation;

import com.DataStructures_And_Questions.linkedList.linkedListBase.LinkedList;

/**
 * Given the head of a sorted linked list, remove all duplicates such that each element appears only once, and return the list in sorted order.
 */
public class RemoveDuplicatesfromSortedList {

    public static void main(String[] args) {

    }

    /*here we are using outer loop to with if condition to find first occurence of duplicate
    * and then when its found we are using inner loop to find last occurent of the duplicate.
    * post which first occurrence node is connewcted to last occurence node. next.
    * This is played untill curr is null or curr.next is null
    *
    *
    * */
    public static LinkedList.Node removeDuplicates(LinkedList.Node head) {

        // Replace this placeholder return statement with your code
        LinkedList.Node curr=head;
        while(curr!=null && curr.next!=null){
            if(curr.data == curr.next.data){
                LinkedList.Node first=curr;
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
