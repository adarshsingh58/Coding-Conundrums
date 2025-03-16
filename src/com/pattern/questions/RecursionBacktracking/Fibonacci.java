package com.pattern.questions.RecursionBacktracking;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static void main(String[] args) {

        // should be 55
        System.out.println(Fibonacci.TYPE.RECURSION + " -> " + Fibonacci.fibo(10, Fibonacci.TYPE.RECURSION));

        // should be 55
        System.out.println(Fibonacci.TYPE.MEMOIZATION + " -> " + Fibonacci.fibo(10, Fibonacci.TYPE.MEMOIZATION));

        // should be 55
        System.out.println(Fibonacci.TYPE.ITERATION + " -> " + Fibonacci.fibo(10, Fibonacci.TYPE.ITERATION));
        System.out.println();

        // should be 1
        System.out.println(Fibonacci.TYPE.RECURSION + " -> " + Fibonacci.fibo(1, Fibonacci.TYPE.RECURSION));

        // should be 1
        System.out.println(Fibonacci.TYPE.MEMOIZATION + " -> " + Fibonacci.fibo(1, Fibonacci.TYPE.MEMOIZATION));

        // should be 1
        System.out.println(Fibonacci.TYPE.ITERATION + " -> " + Fibonacci.fibo(1, Fibonacci.TYPE.ITERATION));
        System.out.println();

        // should be 28657
        System.out.println(Fibonacci.TYPE.RECURSION + " -> " + Fibonacci.fibo(23, Fibonacci.TYPE.RECURSION));

        // should be 28657
        System.out.println(Fibonacci.TYPE.MEMOIZATION + " -> " + Fibonacci.fibo(23, Fibonacci.TYPE.MEMOIZATION));

        // should be 28657
        System.out.println(Fibonacci.TYPE.ITERATION + " -> " + Fibonacci.fibo(23, Fibonacci.TYPE.ITERATION));
        System.out.println();
    }

    private static Map<Integer, Integer> map = new HashMap<>();

    public static enum TYPE {
        RECURSION,
        MEMOIZATION,
        ITERATION,
    }

    public static int fibo(int n, TYPE type) {
        switch (type) {
            case RECURSION:
                return fibonacciByRecursion(n);

            case MEMOIZATION:
                return fibonacciByMemoization(n);

            case ITERATION:
                return fibonacciByIteration(n);

            default:
                System.err.println("Invalid type");
                return -1;
        }
    }

    private static int fibonacciByRecursion(int n) {

        // * Base Case
        if (n <= 1) return n;

        return fibonacciByRecursion(n - 1) + fibonacciByRecursion(n - 2);
    }

    private static int fibonacciByMemoization(int n) {

        // * Base Case
        if (n <= 1) return n;

        if (!map.containsKey(n))
            map.put(n, fibonacciByMemoization(n - 1) + fibonacciByMemoization(n - 2));

        return map.get(n);
    }

    private static int fibonacciByIteration(int n) {

        if (n <= 2) return 1;

        int n1 = 0, n2 = 1, sum = 0;

        for (int i = 2; i <= n; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }

        return sum;
    }
}
