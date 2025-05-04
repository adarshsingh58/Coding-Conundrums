package com.DataStructures_And_Questions.scenarioBasedQues.SkyLine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).
 * Buildings Skyline Contour
 * <p>
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * <p>
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * <p>
 * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 * <p>
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 * <p>
 * Notes:
 * <p>
 * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * The input list is already sorted in ascending order by the left x position Li.
 * The output list must be sorted by the x position.
 * There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 * <p>
 * Input: [[1,2,1],[1,2,2],[1,2,3]]
 * Output: [[1,3],[2,0]]
 * <p>
 * Input: [[3,7,8],[3,8,7],[3,9,6],[3,10,5],[3,11,4],[3,12,3],[3,13,2],[3,14,1]]
 * Output: [[3,8],[7,7],[8,6],[9,5],[10,4],[11,3],[12,2],[13,1],[14,0]]
 */
public class TheSkylineProblem {

    /*
     * > 2 Adjacent buildings of same height can be merged into 1.
     * > A Building entirely submerged by other or sets of buildings can be removed.
     * >
     *   List<List<Integer>> op;

        for(building b: buildings){

            if(no building on left and right of b){
                op.add(b.left,b.height) and (b.right,0)
            }
            else if(no building on left of b){
                if( building on right of b has same left){
                     op.add(b.left,MAX(b.height,b.nextBuilding.height))
                }else{
                    op.add(b.left,b.height)
                }
            }else if(no building on right of b){
                op.add(b.left,b.height) and (b.right,0)
            } else {
                //if b height > prev heigt: b.left and b.height
                //if b height = prev heigt: skip
                //if b height < prev heigt:
                    //b.left is after prev.right:  b.left and b.height
                    //b.left is before or = prev.right:  prev.right and b.height


                //cases: b is submerged entirely : skip
                //b is submerged but height is taller then prev: b.left and b.height
                //only left of b is submerged but height is taller
                //only left of b is submerged and height also
                //only right of b is submerged but height is taller
                //only right of b is submerged and height also
                //only left and right of b are submerged but middle part is open
                //not submerged at all
            }
        }
     * */
    public static void main(String[] args) {
        /*int[][] arr = new int[][]{
                {1, 2, 1}, {1, 2, 2}, {1, 2, 3}
        };*/
        /*int[][] arr = new int[][]{
                {2,4,7},{2,4,5},{2,4,6}
        };
        */
        /*int[][] arr = new int[][]{
                {0, 3, 3}, {1, 5, 3}, {2, 4, 3}, {3, 7, 3}
        };*/
        /*int[][] arr = new int[][]{
                {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}
        };
        */
        int[][] arr = new int[][]{
                {3, 7, 8}, {3, 8, 7}, {3, 9, 6}, {3, 10, 5}, {3, 11, 4}, {3, 12, 3}, {3, 13, 2}, {3, 14, 1}
        };
        getSkyline(arr);
    }

    public static int[][] combineConsecutiveSubmergedBuilding(int[][] buildings) {
        int[][] opBuild = new int[buildings.length][3];
        opBuild[0] = buildings[0];
        int j = 0;
        for (int i = 1; i < buildings.length; i++) {
            if (!(opBuild[j][0] <= buildings[i][0] && opBuild[j][1] >= buildings[i][1] && opBuild[j][2] >= buildings[i][2])) {
                opBuild[++j] = buildings[i];
            }
        }
        int[][] opBuild1 = new int[++j][3];
        for (int i = 0; i < j; i++) {
            opBuild1[i] = opBuild[i];
        }
        return opBuild1;
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings.length == 0) return new ArrayList<>();
        buildings = combineConsecutiveSubmergedBuilding(buildings);
        List<List<Integer>> op = new LinkedList<>();
        for (int i = 0; i <= buildings.length; i++) {//<= for marking the rightmost point
            List<Integer> leftHeight = new LinkedList<>();

            if (buildings.length == i) {//last building
                leftHeight.add(buildings[i - 1][1]);
                leftHeight.add(0);
                op.add(leftHeight);
            } else if (buildings[i][0] == 0 && buildings[i][1] == 0 && buildings[i][2] == 0) {
                continue;
            } else if (1 == buildings.length) {// if only building
                leftHeight.add(buildings[i][0]);//b.left,b.height) and (b.right,0)
                leftHeight.add(buildings[i][2]);
                op.add(leftHeight);
            } else if (i == 0) {//first building
                leftHeight.add(buildings[i][0]);
                leftHeight.add(buildings[i][2]);
                op.add(leftHeight);
            } else {
                if (buildings[i][0] > buildings[i - 1][1]) {// if current building is after prev building, ground marking to be done.
                    leftHeight.add(buildings[i - 1][1]);
                    leftHeight.add(0);
                    op.add(leftHeight);
                    leftHeight = new ArrayList<>();
                }
                if (buildings[i][0] == buildings[i - 1][0]) {
                    if (buildings[i][2] > buildings[i - 1][2]) {
                        ((LinkedList<List<Integer>>) op).removeLast();
                        leftHeight.add(buildings[i][0]);
                        leftHeight.add(buildings[i][2]);
                    }
                } else
                    //if b height > prev heigt: b.left and b.height
                    //if b height = prev heigt: skip
                    //if b height < prev heigt:
                    //b.left is > prev.right:  b.left and b.height
                    //b.left is < or = prev.right:  prev.right and b.height
                    if (buildings[i][2] > buildings[i - 1][2]) {
                        leftHeight.add(buildings[i][0]);
                        leftHeight.add(buildings[i][2]);
                    } else if (buildings[i][2] == buildings[i - 1][2]) {
                        continue;
                    } else {
                        if (buildings[i][0] > buildings[i - 1][1]) {
                            leftHeight.add(buildings[i][0]);
                            leftHeight.add(buildings[i][2]);
                        } else {
                            leftHeight.add(buildings[i - 1][1]);
                            leftHeight.add(buildings[i][2]);
                        }
                    }
                op.add(leftHeight);
            }
        }
        op = op.stream().filter(integers -> !integers.isEmpty()).collect(Collectors.toList());
        return op;
    }
}
