package com;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((v1, v2) -> {return (v2 - v1);});
    }
}
