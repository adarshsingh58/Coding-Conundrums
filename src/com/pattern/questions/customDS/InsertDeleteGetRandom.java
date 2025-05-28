package com.pattern.questions.customDS;

import java.util.*;

/**
 * Implement the RandomizedSet class:
 * <p>
 * RandomizedSet() Initializes the RandomizedSet object. bool insert(int val) Inserts an item val into the set if not
 * present. Returns true if the item was not present, false otherwise. bool remove(int val) Removes an item val from the
 * set if present. Returns true if the item was present, false otherwise. int getRandom() Returns a random element from
 * the current set of elements (it's guaranteed that at least one element exists when this method is called). Each
 * element must have the same probability of being returned.
 * <p>
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"] [[], [1], [2],
 * [2], [], [1], [2], []] Output [null, true, false, true, 2, true, false, 2]
 * <p>
 * Explanation RandomizedSet randomizedSet = new RandomizedSet(); randomizedSet.insert(1); // Inserts 1 to the set.
 * Returns true as 1 was inserted successfully. randomizedSet.remove(2); // Returns false as 2 does not exist in the
 * set. randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly. randomizedSet.remove(1); // Removes 1
 * from the set, returns true. Set now contains [2]. randomizedSet.insert(2); // 2 was already in the set, so return
 * false. randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return
 * <p>
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 */
public class InsertDeleteGetRandom {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> index = new ArrayList<>();

    public static void main(String[] args) {
        InsertDeleteGetRandom sol = new InsertDeleteGetRandom();
        System.out.println(sol.insert(0));
        System.out.println(sol.insert(1));
        System.out.println(sol.remove(0));
        System.out.println(sol.insert(2));
        System.out.println(sol.remove(1));
        System.out.println(sol.getRandom());
    }


    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, index.size());
        index.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        map.put(index.get(index.size() - 1), map.get(val));
        index.set(map.get(val), index.get(index.size() - 1));

        index.remove(index.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(index.size());
        return index.get(randomNumber);
    }
}
