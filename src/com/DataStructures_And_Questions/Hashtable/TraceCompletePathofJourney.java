package com.DataStructures_And_Questions.Hashtable;

import java.util.*;

/**
 * Given an array paths, where paths i contains a pair of strings [source,destination]
 * representing there exists a direct path from source to destination.
 * Return the correct sequence of the whole journey from the first city to the last.
 * <p>
 * Note: It is guaranteed that a journey always exists.
 * <p>
 * Constraints:
 * <p>
 * 1≤1≤ paths.length ≤102≤102
 * paths[i].length ==2==2
 * 1≤1≤ source.length , destination.length ≤10≤10
 * sourcei !=!= destinationi
 */
public class TraceCompletePathofJourney {
  /*
  We can first convert the input array into a dictionary structure, mapping each source city to its destination.
  Then, we create a reverse dictionary to map destinations back to their sources. Next, we identify the starting point
    of the itinerary by finding the source city without a corresponding destination. Finally, we trace the complete path
    by iteratively following destinations until reaching the end, appending each source-destination pair to the result array.*/

    public static List<List<String>> tracePath(List<List<String>> paths) {
        Map<String, String> dictionary = new HashMap<>();

        // Convert the array into a map
        for (List<String> path : paths)
            dictionary.put(path.get(0), path.get(1));

        Map<String, String> reverseDict = new HashMap<>();

        // To fill reverseDict, iterate through the given map
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            reverseDict.put(entry.getValue(), entry.getKey());
        }

        String start = null;

        // Find the starting point of itinerary
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            if (!reverseDict.containsKey(entry.getKey())) {
                start = entry.getKey();
                break;
            }
        }

        List<List<String>> result = new ArrayList<>();

        // Trace complete path
        String dest = dictionary.get(start);
        while (dest != null && !dest.isEmpty()) {
            List<String> path = new ArrayList<>();
            path.add(start);
            path.add(dest);
            result.add(path);
            start = dest;
            dest = dictionary.get(start);
        }

        return result;
    }

    public static List<List<String>> convertTo2DList(String[][] inputMaps) {
        List<List<String>> resultList = new ArrayList<>();

        for (String[] pair : inputMaps) {
            List<String> innerList = new ArrayList<>();
            innerList.add(pair[0]);
            innerList.add(pair[1]);
            resultList.add(innerList);
        }

        return resultList;
    }

    public static void main(String[] args) {
        String[][][] inputMaps = {
                {{"NewYork", "Chicago"}, {"Boston", "Texas"}, {"Missouri", "NewYork"}, {"Texas", "Missouri"}},
                {{"Sydney", "Dubai"}, {"LosAngeles", "Cairo"}, {"Paris", "Rome"}, {"Cairo", "Paris"}, {"Rome", "Tokyo"}, {"Tokyo", "Sydney"}},
                {{"Vienna", "Athens"}, {"London", "Berlin"}, {"Madrid", "Rome"}, {"Paris", "Vienna"}, {"Rome", "Paris"}, {"Athens", "Moscow"}, {"Berlin", "Madrid"}},
                {{"Singapore", "Sydney"}},
                {{"HongKong", "Taipei"}, {"Osaka", "Seoul"}, {"Taipei", "Singapore"}, {"Tokyo", "Osaka"}, {"Beijing", "Shanghai"}, {"Seoul", "Beijing"}, {"Singapore", "KualaLumpur"}, {"Shanghai", "HongKong"}}
        };

        for (int i=0;i<inputMaps.length;i++) {

            List<List<String>> result = convertTo2DList(inputMaps[i]);
            List<List<String>> actual_output = tracePath(result);

            System.out.println(Integer.toString(i+1)+". \tInput: " + Arrays.deepToString(inputMaps[i]));
            System.out.println("\tOutput: " + actual_output);
            System.out.println(new String(new char[100]).replace('\0', '-'));
            System.out.println();
        }
    }

}
