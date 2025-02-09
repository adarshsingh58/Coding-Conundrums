package com.pattern.questions.Recursion.Factorial;


public class FactorialTest {
  public static void main(String[] args) {

    // should be 720
    System.out.println(Factorial.factorial(6, Factorial.TYPE.RECURSIVE));

    // should be 720
    System.out.println(Factorial.factorial(6, Factorial.TYPE.MEMOIZATION));

    // should be 5040 (should take less time as 6! is already calculated)
    System.out.println(Factorial.factorial(7, Factorial.TYPE.MEMOIZATION));
  }
}
