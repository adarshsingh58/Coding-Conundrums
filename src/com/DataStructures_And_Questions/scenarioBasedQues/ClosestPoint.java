package com.DataStructures_And_Questions.scenarioBasedQues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
*
https://www.geeksforgeeks.org/best-meeting-point-2d-binary-array/
*/
public class ClosestPoint {

    int numOfPoints = 0;

    // Driver code
    public static void main(String[] args) {
        int grid[][] = {{1, 0, 0, 0, 1},
                   {0, 0, 0, 0, 0},
                   {0, 0, 1, 0, 0}};
        ClosestPoint closestPoint=new ClosestPoint();
        System.out.println(closestPoint.minTotalDistance(grid, grid.length, grid[0].length)+" "+closestPoint.numOfPoints);
    }

    public int minTotalDistance(int grid[][], int ROW, int COL) {
        if (ROW == 0 || COL == 0)
            return 0;

        List<Integer> vertical = new ArrayList<>();
        List<Integer> horizontal = new ArrayList<>();

        // Find all members home's position
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 1) {
                    vertical.add(i);
                    horizontal.add(j);
                }
            }
        }

        Collections.sort(vertical);
        Collections.sort(horizontal);

        int x = vertical.get(vertical.size() / 2);
        int y = horizontal.get(horizontal.size()/2);

        // Find total distance from best meeting point (x,y) using Manhattan Distance formula
        int distance = 0;
        for (int i = 0; i < ROW; i++)
            for (int j = 0; j < COL; j++)
                if (grid[i][j] == 1) {
                    distance += Math.abs(x - i) +
                            Math.abs(y - j);
                    numOfPoints++;
                }

        return distance;
    }

}
