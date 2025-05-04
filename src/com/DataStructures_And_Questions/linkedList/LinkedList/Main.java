package com.DataStructures_And_Questions.linkedList.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(10);
        linkedList.add(87);
        linkedList.add(7);
        linkedList.add(41);

        System.out.println(linkedList.length);
        linkedList.delete(87);
        System.out.println(linkedList.length);

    }
}