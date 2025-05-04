package com.DataStructures_And_Questions.math;

public class IsPrimeNumber {

    public static void main(String[] args) {
        int n = 41;
        boolean isPrime = isPrime(n);
        System.out.println(isPrime);
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
