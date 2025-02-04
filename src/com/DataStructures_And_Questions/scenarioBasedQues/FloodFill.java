package com.DataStructures_And_Questions.scenarioBasedQues;

/**
 * You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
 * <p>
 * To perform a flood fill:
 * <p>
 * Begin with the starting pixel and change its color to color.
 * Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
 * Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
 * The process stops when there are no more adjacent pixels of the original color to update.
 * <p>
 * Return the modified image after performing the flood fill.
 * <p>
 * <p>
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * <p>
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 *
 * https://leetcode.com/problems/flood-fill/description/
 */
public class FloodFill {

    public static void main(String[] args) {
//        floodFill();
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original=image[sr][sc];
        if(original!=color) helpher(image,sr,sc,original,color);
        return image;
    }

    public static void helpher(int [][]image,int i,int j,int original,int color){
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]!=original|| image[i][j]==color)return;

        image[i][j]=color;
        helpher(image,i-1,j,original,color);
        helpher(image,i+1,j,original,color);
        helpher(image,i,j-1,original,color);
        helpher(image,i,j+1,original,color);
    }

}
