package com.pattern.questions.Recursion.Fibonacci;


public class FibonacciTest {
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
}
