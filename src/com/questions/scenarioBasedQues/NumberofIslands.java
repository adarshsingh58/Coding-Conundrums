package com.questions.scenarioBasedQues;

import java.util.ArrayList;
import java.util.List;

/*
* Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
* An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3

* */

public class NumberofIslands {
//[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","1"]]
    public static void main(String[] args) {

//        System.out.println(numIslands(grid));
    }

    /*
     * Here, the idea is to track all connected 1 from a given 1. This approach is similar to that of finding adjacent siblings in a tree.
     * > First we add all coordinates  with 1 in a list listOfAll1s. Now we know all the places  which are 1 i.e. land.
     * > Now since island is surrounded only vertically and horizontally, we will have to check from a given point only in 4 directions, x-1, x+1, y-1, y+1
     * > We pick one coordinate from listOfAll1s and check if (x-1, x+1, y-1, y+1) from that cordinate is presnet in listOfAll1s. coz then we confirm a connections of island.
     * > Add all found connections from listOfAll1s to a queue connectedIslandQueue while removing them from listOfAll1s.
     * > we repeat this process for all coordinates in connectedIslandQueue. This way we will find all cordinates reachable from any connected island.
     * > Once a cordinate is traversed from connectedIslandQueue, we remove it from queue.
     * > At the end all rechable coordinates will be in connectedIslandQueue and then removed since all were traversed, leaving listOfAll1s with other set of island.
     * > Every time we empty connectedIslandQueue, we increase the count as we have found all connections of an island.
     * > the purpose of having a queue here is to track connection of all connected island points.
     *
     * */
    public static int numIslands(char[][] grid) {

        int count = 0;
        List<String> listOfAll1s = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    listOfAll1s.add(i + "" + j);
            }
        }
        if (listOfAll1s.isEmpty()) {
            return 0;
        }
        List<String> connectedIslandQueue = new ArrayList<>();

        while (!listOfAll1s.isEmpty()) {
            String firstRandomElement = listOfAll1s.get(0);
            connectedIslandQueue.add(firstRandomElement);
            listOfAll1s.remove(firstRandomElement);
            List<String> tempListOfDeletion = new ArrayList<>();
            for (int i = 0; i < connectedIslandQueue.size(); i++) {

                int x = Character.getNumericValue(connectedIslandQueue.get(i).charAt(0));
                int y = Character.getNumericValue(connectedIslandQueue.get(i).charAt(1));
                final String XplusOne = (x + 1) + "" + y;
                final String XminusOne = (x - 1) + "" + y;
                final String YPlusOne = x + "" + (y + 1);
                final String YminusOne = x + "" + (y - 1);

                if (listOfAll1s.contains(XplusOne)) {
                    connectedIslandQueue.add(XplusOne);
                    listOfAll1s.remove(XplusOne);
                }
                if (listOfAll1s.contains(XminusOne)) {
                    connectedIslandQueue.add(XminusOne);
                    listOfAll1s.remove(XminusOne);
                }
                if (listOfAll1s.contains(YPlusOne)) {
                    connectedIslandQueue.add(YPlusOne);
                    listOfAll1s.remove(YPlusOne);
                }
                if (listOfAll1s.contains(YminusOne)) {
                    connectedIslandQueue.add(YminusOne);
                    listOfAll1s.remove(YminusOne);
                }
                tempListOfDeletion.add(connectedIslandQueue.get(i));
            }
            connectedIslandQueue.removeAll(tempListOfDeletion);
            if (connectedIslandQueue.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}
