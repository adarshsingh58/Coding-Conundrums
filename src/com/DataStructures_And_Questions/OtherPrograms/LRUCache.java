package com.DataStructures_And_Questions.OtherPrograms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Implement LRU (Least Recently Used) Cache.
 *
 *
 *
 *
 * ["LRUCache","put","put","get","get","put","get","get","get"]
 * [[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]
 *
 *
 * https://leetcode.com/problems/lru-cache/submissions/1630580514/
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lrucache = new LRUCache();

        System.out.println("Value:" + lrucache.get(1) + " Cache Size:" + lrucache.cache.size() + " lru List size:"
                + lrucache.accessList.size() + " accessList:" + lrucache.accessList);
        System.out.println("Value:" + lrucache.get(2) + " Cache Size:" + lrucache.cache.size() + " lru List size:"
                + lrucache.accessList.size() + " accessList:" + lrucache.accessList);
        System.out.println("Value:" + lrucache.get(3) + " Cache Size:" + lrucache.cache.size() + " lru List size:"
                + lrucache.accessList.size() + " accessList:" + lrucache.accessList);
        System.out.println("Value:" + lrucache.get(4) + " Cache Size:" + lrucache.cache.size() + " lru List size:"
                + lrucache.accessList.size() + " accessList:" + lrucache.accessList);
        System.out.println("Value:" + lrucache.get(3) + " Cache Size:" + lrucache.cache.size() + " lru List size:"
                + lrucache.accessList.size() + " accessList:" + lrucache.accessList);
        System.out.println("Value:" + lrucache.get(5) + " Cache Size:" + lrucache.cache.size() + " lru List size:"
                + lrucache.accessList.size() + " accessList:" + lrucache.accessList);
        System.out.println("Value:" + lrucache.get(6) + " Cache Size:" + lrucache.cache.size() + " lru List size:"
                + lrucache.accessList.size() + " accessList:" + lrucache.accessList);
        System.out.println("Value:" + lrucache.get(3) + " Cache Size:" + lrucache.cache.size() + " lru List size:"
                + lrucache.accessList.size() + " accessList:" + lrucache.accessList);
        System.out.println("Value:" + lrucache.get(4) + " Cache Size:" + lrucache.cache.size() + " lru List size:"
                + lrucache.accessList.size() + " accessList:" + lrucache.accessList);
        System.out.println("Value:" + lrucache.get(2) + " Cache Size:" + lrucache.cache.size() + " lru List size:"
                + lrucache.accessList.size() + " accessList:" + lrucache.accessList);
    }

    private LinkedList<Integer> accessList = new LinkedList<>();
    private Map<Integer, String> cache = new HashMap<>();
    private final int CACHE_SIZE = 5;

    /**
     * Here, we are using a hashmap as a cache for storing data and a linkedlist to keep track of which key was
     * accessed most recently.
     * >We check if cache contains the key or not.
     * >If it does contain, then we will return the value from the cache map for this key, but first we need to
     * update our accessList to make sure our firstNode or head has the most recently used key and tail as least recently used.
     * so, we remove the key from accessList and then add it as the first/head node.
     * >If it does not contains, then we get the value for the key from the DB and add it to the cache.
     * we also, will have to add this key entry into the accesslist as the first Node since this is the most recently
     * used key now.
     * >One more thing to take care here, is that when there is a miss and we fetch the data from DB, before addin to the cache,
     * we check if the maximum cache size allocated is not reached. If yes, then as per LRU, we remove the least recently
     * used key from cache and the list and this new one. So we remove the last entry from accessList as this is the LRU key
     * and also we remove the corrosponding entry from cache. Now the new entry which came from DB can be added.
     */
    private String get(Integer key) {
        if (cache.containsKey(key)) {
            accessList.remove(key);
            accessList.addFirst(key);
            return cache.get(key);
        } else {
            if (cache.size() >= CACHE_SIZE) {
                cache.remove(accessList.getLast());
                accessList.removeLast();
            }
            String value = getValueFromDBAgainstKey(key);
            cache.put(key, value);
            accessList.addFirst(key);
            return value;
        }
    }

    public String getValueFromDBAgainstKey(int key) {
        switch (key) {
            case 1: {
                return "Adarsh";
            }
            case 2: {
                return "Aditi";
            }
            case 3: {
                return "Magan";
            }
            case 4: {
                return "Jagan";
            }
            case 5: {
                return "Chinka";
            }
            case 6: {
                return "Lukha";
            }
            default: {
                return null;
            }
        }
    }
}
