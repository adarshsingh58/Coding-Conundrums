package com.DataStructures_And_Questions.Queue.Queue;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Queue queue = new Queue(4);
        int i = 1;
        while (i != 0) {
            System.out.println("1->Enqueue 2->Dequeue 0->Exit");
            Scanner sc = new Scanner(System.in);
            i = sc.nextInt();
            switch (i) {
                case 1: {
                    System.out.println("Enter data to enqueue");
                    queue.enqueue(sc.nextInt());
                    break;
                }
                case 2: {
                    System.out.println("Dequeued Element :" + queue.dequeue());
                    break;
                }
                default: {
                    System.out.println("Enter Valid response");
                }
            }
            System.out.println(queue);
        }
    }
}