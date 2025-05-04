package com.DataStructures_And_Questions.algorithms.concepts.Memoization;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static void main(String[] args) throws InterruptedException {
        long n1 = new Date().getTime();
        System.out.println(fibo(35));
//        System.out.println(fibo_memo(35));
        long n2 = (new Date().getTime());
        System.out.println("Time took for execution:" + (n2 - n1) + "ms");
        //The time it took for normal fibonacci is close to 200ms while for memoized fibonacci was 1ms. This is almost 200% faster.
    }

    /*
     *  This is a normal recursive method for calculating fibonacci of a given number.
     *  Here, we recursively call fact(int n) method and calculate the result of sub problem untill breaking condition
     *  occurs.
     *
     *  The problem here is that we, sometimes, are performing same calculation more than once which can be a huge
     *  waste of resource and time.
     *  e.g. for fibonacci of 5:
     *      1> we do : fact(4) + fact(3)
     *      2> Now fact(4) will be calculated first like : fact(3) + fact(2)
     *      3> So, we see that fact(3) is already calculated as a part of fact(4) and when fact(4) is completed, our code is gonna compute
     *          fact(3) again as per step 1.
     *  This affects the performace very badly
     *
     */
    public static Long fibo(int n) {
        if (n <= 1)
            return 1L;
        else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    static Map<Integer, Long> lookUp = new HashMap<>();

    /*
     *  With memoization, we tend to memorize the data which has already been computed. Here, we used a map/cache, where we are storing the
     *  fact(x) first time it is computed.
     *  Now, next time when a call for fact(x) happens we first check if it is available in the map or not, if yes we use that value and skip the
     *  calculation.
     *
     *  This saves HUGE amount of time.
     */
    public static Long fibo_memo(int n) {
        if (n <= 1)
            return 1L;
        else if (lookUp.containsKey(n)) {
            return lookUp.get(n);
        } else {
            long x = fibo_memo(n - 1) + fibo_memo(n - 2);
            lookUp.put(n, x);
            return x;
        }
    }

}