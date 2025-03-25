package com.pattern.questions.backtrack;

/**
 * Statement
 * <p>
 * We are given the following values as input to begin with:
 * <p>
 * The coordinates of a source cell, i.e., sr and sc.
 * <p>
 * A target value, target.
 * <p>
 * An (m×n) grid.
 * <p>
 * Our task is to perform flood fill by updating the values of the four directionally connected cells, which have the
 * same value as the source cell with the target value.
 * <p>
 * How to perform flood fill:
 * <p>
 * Suppose that a (4×4) grid has a source value of 11 at coordinates [1,1]. We perform flood fill on its neighboring
 * cells only if they have the same source value as this cell. Once all adjacent cells are updated, return the new grid
 * after performing flood fill.
 * <p>
 * If no neighboring cell has a value equal to the source cell, only update the source cell with the target value and
 * return the updated grid.
 * <p>
 * https://leetcode.com/problems/flood-fill/
 */
public class FloodFill {

    public static void main(String[] args) {
        int[][] image1 = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int color1 = 2,sr1=1,sc1=1;

        int[][] image2 = {
                {0, 0, 0},
                {0, 0, 0}
        };
        int color2 = 0,sr2=0,sc2=0;

        int[][] imageOP = floodFill(image2, sr1, sc2, color2);

        for (int i = 0; i < image2.length; i++) {
            for (int i1 = 0; i1 < image2[0].length; i1++) {
                System.out.print(image2[i][i1] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
//        int[][] imageOP=new int[image.length][image[0].length];
        floodFillRec(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private static void floodFillRec(int[][] image, int sr, int sc, int currColor, int colorToFill) {
        if (sr < 0 || sr == image.length || sc < 0 || sc == image[0].length || image[sr][sc] != currColor || currColor==colorToFill) return;
        if (image[sr][sc] == currColor)
            image[sr][sc] = colorToFill;
        floodFillRec(image, sr - 1, sc, currColor, colorToFill);
        floodFillRec(image, sr, sc - 1, currColor, colorToFill);
        floodFillRec(image, sr + 1, sc, currColor, colorToFill);
        floodFillRec(image, sr, sc + 1, currColor, colorToFill);
    }

}
