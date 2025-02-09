package com.pattern.questions.customDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Implement a data structure that can store multiple values of the same key at different timestamps and retrieve the
 * key’s value at a certain timestamp.
 * <p>
 * You’ll need to implement the TimeBasedKeyValueStore class. This class has the following functions:
 * <p>
 * Init(): This function initializes the values dictionary and timestamp dictionary.
 * <p>
 * Set Value(key, value, timestamp): This function stores the key and value at any given timestamp.
 * <p>
 * Get Value(key, timestamp): This function returns the value set for this key at the specified timestamp.
 * <p>
 * Note: When a query requests the value of a key at a timestamp that isn’t recorded, return the value corresponding to
 * the most recent timestamp before the query’s timestamp. If there are no timestamps before the query’s timestamp,
 * return an empty string.
 */
public class TimeBasedKeyValueStore {

    /**
     * Solution
     * <p>
     * So far, you have probably brainstormed some approaches and have an idea of how to solve this problem. Let’s
     * explore some of these approaches and figure out which to follow based on considerations such as time complexity
     * and implementation constraints. Naive approach
     * <p>
     * The naive approach uses three individual lists to store the key, value, and timestamp, each in a separate list.
     * To set a value, we’ll simply append key, value, and timestamp in their respective lists. To get a value, we’ll
     * perform a linear search and search for a specific value for the given timestamp and key throughout the list.
     * <p>
     * The time complexity to set a value is O(1)O(1), whereas to get a value is O(n)O(n), where nn represents the total
     * number of values in a list. However, the space complexity of the naive approach is O(n)O(n). Optimized approach
     * using binary search
     * <p>
     * The key idea is to minimize the time complexity by using the binary search instead of linear search. We can use
     * the binary search to implement our logic and can decrease the time complexity to a great extent.
     * <p>
     * We will use the two dictionaries. The first dictionary, valuesDict, stores the values against a specific key. The
     * second dictionary, timestampDict, stores the timestamps corresponding to the same key to keep track of the values
     * stored at a specific timestamp.
     * <p>
     * Set Value(key, value, timestamp): This function adds the key with the value for the given timestamp. For this, we
     * check if the key already exists in the valuesDict dictionary.
     * <p>
     * If the key exists and the provided value is not equal to the last value stored in the valuesDict for this key, we
     * append the value and timestamp to the lists associated with that key in the valuesDict and timestampDict,
     * respectively. If the key does not exist in the valuesDict dictionary, it creates a new entry in both the
     * valuesDict and timestampDict dictionaries.
     * <p>
     * Get Value(key, timestamp): This function returns the value set previously, with the highest timestamp for the
     * respective key. This function uses the searchIndex function, which uses the binary search in its implementation.
     * To implement this function, we initialize the left and right variables as starting and ending positions of the
     * timestampDict dictionary. We then find the middle position and move these pointers to get the required value. If
     * the required value is less than the middle value, we increment the right pointer. Otherwise, we increment the
     * left pointer.
     * <p>
     * We check the following conditions to get the required value:
     * <p>
     * We first verify whether or not the required key exists. If it does not exist, then return the empty string.
     * <p>
     * If the key exists, we check the following conditions: If the given timestamp does not exist but is greater than
     * the timestamp that was set previously, it returns the value associated with the nearest smaller timestamp. If the
     * given timestamp exists, it returns the value associated with the given key and timestamp.
     */

    HashMap<String, List<String>> valuesDict;
    HashMap<String, List<Integer>> timestampDict;

    public TimeBasedKeyValueStore() {
        valuesDict = new HashMap<String, List<String>>();
        timestampDict = new HashMap<String, List<Integer>>();
    }

    // Set TimeBasedKeyValueStore data variables
    public void setValue(String key, String value, int timestamp) {
        if (valuesDict.containsKey(key)) {
            if (value != valuesDict.get(key).get(valuesDict.get(key).size() - 1)) {
                valuesDict.get(key).add(value);
                timestampDict.get(key).add(timestamp);
            }
        } else {
            valuesDict.put(key, new ArrayList<>());
            valuesDict.get(key).add(value);
            timestampDict.put(key, new ArrayList<Integer>());
            timestampDict.get(key).add(timestamp);
        }
    }

    // Find the index of right most occurrence of the given timestamp using binary search
    public int searchIndex(int n, String key, int timeStamp) {

        int left = 0;
        int right = n;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (!(timestampDict.get(key).get(mid) > timeStamp)) left = mid + 1;
            else right = mid;
        }
        return left - 1;
    }

    // Get the value for the given key and timestamp
    public String getValue(String key, int timeStamp) {
        int index = 0;
        if (!valuesDict.containsKey(key)) {
            return "";
        } else {
            index = searchIndex(timestampDict.get(key).size(), key, timeStamp);
        }

        if (index > -1) {
            return valuesDict.get(key).get(index);
        }
        return "";
    }

    // Driver code
    public static void main(String args[]) {
        TimeBasedKeyValueStore ts = new TimeBasedKeyValueStore();
        int num = 1;
        List<Triplet> input = Arrays.asList(new Triplet("course", "OOP", 3), new Triplet("course", "PF", 5), new Triplet("course", "OS", 7), new Triplet("course", "ALGO", 9), new Triplet("course", "DB", 10));
        for (int i = 0; i < input.size(); i++) {
            System.out.println(num + ".\tAdd value: (" + '"' + input.get(i).course + '"' + ", " + '"' + input.get(i).cName + '"' + ", " + input.get(i).id + ")");
            ts.setValue(input.get(i).course, input.get(i).cName, input.get(i).id);
            int randomInt = (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);
            System.out.println("\n\tGet value for:");
            System.out.println("\t\tKey = course  \n\t\tTimestamp = " + randomInt);
            System.out.println("\n\tReturned value = " + '"' + ts.getValue("course", randomInt) + '"');
            num += 1;
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    static class Triplet {
        public String course;
        public String cName;
        public int id;

        public Triplet(String course, String cName, int id) {
            this.course = course;
            this.cName = cName;
            this.id = id;
        }
    }
}
