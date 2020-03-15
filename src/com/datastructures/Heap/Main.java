package com.datastructures.Heap;

public class Main {

    public static void main(String[] args) {
        Heap heap=new Heap(10);
        heap.add(1);
        heap.add(9);
        heap.add(22);
        heap.add(17);
        heap.add(11);
        heap.add(27);
        heap.add(21);

        System.out.println(heap.getMax());
        heap.add(54);
        System.out.println(heap.getMax());
        heap.delete(11);
        System.out.println(heap.getMax());
        heap.delete(54);
        System.out.println(heap.getMax());
        heap.delete(27);
        System.out.println(heap.getMax());
    }
}