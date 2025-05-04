package com.DataStructures_And_Questions.scenarioBasedQues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* Closest Point

You are given a 2D grid of values 0 or 1. Find a point in the grid from which the sum of the distances of each 1 is the minimum. The distance between two points (p1, p2) is calculated using the formula

|p2.x - p1.x| +  |p2.y - p1.y|

where |x| is the absolute value of x
Input

First line contains an integer T which is the number of test cases. Each case consists of N which signifies the number of 1s in the grid for that particular case followed by N space separated integers x,y which are the coordinates of the point in the grid whose value is 1.
Output

For each test case, print the value of minimum distance and number of points with minimum distance space separated.
Constraints

1 <= T <= 100
1 <= N <= 50
0 <= x,y <= 50

Sample Input

1
3
0 0
0 4
2 2

Sample Output

6 1

Explanation

The grid formed from the input is as shown below.

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

The point (0,2) is the ideal point since the distance between (0,2) and all the 1s is 2 + 2 + 2 = 6 and there’s only one such point.
INPUT:
21
3
0 0
0 4
2 2
2
0 0
1 1
1
3 3
2
0 0
10 0
3
0 0
5 0
10 0
9
0 3
0 5
1 2
1 3
2 2
3 0
3 4
4 1
5 5
5
1 4
1 5
2 5
3 2
5 0
3
0 2
2 2
3 0
6
0 5
1 3
3 3
4 0
4 1
4 5
1
3 1
2
0 4
5 4
10
0 3
0 4
1 0
1 4
2 2
2 5
3 0
4 0
4 2
5 5
1
2 0
5
0 2
1 4
2 4
2 5
3 1
7
0 2
1 4
1 5
2 5
3 1
5 0
5 5
4
0 0
0 2
1 0
1 2
2
1 1
1 3
6
0 0
0 2
1 1
1 3
2 0
2 2
11
0 0
0 1
0 2
0 3
1 0
1 1
1 3
2 0
2 1
2 2
2 3
12
0 0
0 1
0 2
0 3
1 0
1 1
1 2
1 3
2 0
2 1
2 2
2 3
9
0 0
0 1
0 2
1 0
1 1
1 2
2 0
2 1
2 2


OUTPUT:
6 1
2 4
0 1
10 11
10 1
25 1
14 1
5 1
17 2
0 1
5 6
31 2
0 1
10 1
23 1
6 6
2 3
10 2
19 1
20 2
12 1*/
public class ClosestPoint_2 {

    int noOfPoints = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testCases = 1;

        for (int i = 0; i < testCases; i++) {
            List<Integer> vertical = new ArrayList<>();
            List<Integer> horizontal = new ArrayList<>();

            vertical.add(0);
            vertical.add(1);
            horizontal.add(0);
            horizontal.add(1);
            ClosestPoint_2 closestPoint = new ClosestPoint_2();
            if(closestPoint.noOfPoints==0)closestPoint.noOfPoints=1;
            System.out.println(closestPoint.minTotalDistance(vertical, horizontal) + " " + closestPoint.noOfPoints);

        }
    }

    public int minTotalDistance(List<Integer> vertical, List<Integer> horizontal) {

        Collections.sort(vertical);
        Collections.sort(horizontal);
        int x = vertical.get(vertical.size() / 2);
        int y = horizontal.get(horizontal.size() / 2);
        int distance = findDistance(vertical, horizontal, x, y);

        int row = vertical.get(vertical.size() - 1);
        int col = vertical.get(horizontal.size() - 1);
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                int disTemp = findDistance(vertical, horizontal, i, j);
                if (disTemp == distance)
                    noOfPoints++;
            }
        }

        return distance;
    }

    private int findDistance(List<Integer> vertical, List<Integer> horizontal, int x, int y) {
        int distance = 0;
        for (int i = 0, k = 0; i < vertical.size() && k < horizontal.size(); i++, k++) {
            distance += Math.abs(x - vertical.get(i)) + Math.abs(y - horizontal.get(k));
        }
        return distance;
    }

}
