package com.DataStructures_And_Questions.Hashtable;

/**
 * Given the head of a linked list, check whether or not a cycle is present in the linked list.
 * A cycle is present in a linked list if at least one node can be reached again by traversing the next pointer.
 * If a cycle exists, return TRUE, otherwise return FALSE.
 */
public class LinkedListCycleHashing {
    public static void main(String[] args) {

    }

    //WORKING SOL
    /*The algorithm uses a set to track visited nodes while traversing the linked list,
     returning true if a repeated node is encountered (indicating a cycle)
     and false otherwise.*/

/*    public static boolean detectCycle(LinkedListNode<Integer> head) {
        Set<LinkedListNode> set=new HashSet<>();
        LinkedListNode<Integer> curr=head;
        while(curr!=null){
            if(set.contains(curr.next)){
                return true;
            }
            set.add(curr);
            curr=curr.next;
        }

        return false;
    }*/
}
