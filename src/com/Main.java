package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Main {
    static Map<String, Product> cache = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {

        cache.put("1", new Product("1", 3));
        cache.put("2", new Product("2", 13));
        cache.put("3", new Product("3", 42));
        cache.put("4", new Product("4", 9));


        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<Boolean>> listOfActions = new ArrayList();
        listOfActions.add(() -> hello("1", 1));
        listOfActions.add(() -> hello("1", 2));
        listOfActions.add(() -> hello("1", 3));

        List<Future<Boolean>> response = executorService.invokeAll(listOfActions);
/*
        response.forEach(ft -> {
                    try {
                        System.out.println(ft.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
        );*/

        executorService.invokeAll(listOfActions);
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        executorService.shutdown();
    }

    private static Boolean hello(String s, int reqQty) {
        if (cache.get(s).qty > reqQty) {
            cache.get(s).onHold = reqQty;
            cache.get(s).qty = cache.get(s).qty - reqQty;
            System.out.println(cache.get(s));
            return true;
        }
        return false;
    }


}

class Product {
    String desc;
    int qty;
    int onHold;

    public Product(String desc, int qty) {
        this.desc = desc;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return desc + "-" + qty + "-" + onHold;
    }
}