package com.questions.array.conundrums;

/**
 * We are given a 2D array where elements in any individual row or column are
 * sorted. In such a matrix, we have to search (find the position of) a given
 * key
 * 
 * inputArr=
 * 2 4  9   13
 * 3 5  11  18
 * 6 8  16  21
 * 9 11 20  25
 * 
 * key=16
 * O/P: 2,2
 * 
 */
public class Matrix_SearchInMatrix {

	public static void main(String[] args) {
		int[][] inputArr = new int[][] { { 2, 4, 9, 13 }, { 3, 5, 11, 18 }, { 6, 8, 16, 21 }, { 9, 11, 20, 25 } };
		int key=16;
		findKey(inputArr,key);
	}

	/**
	 * We will utilize the fact that the matrix has sorted row and columns
	 * >We check for the last element in first row
	 * >If key matches we print indexes
	 * >Else if key is greater than value at last element in first row,
	 *  we increase the row coz column is sorted and the key must be in any of next rows.
	 * >else if key is smaller, then coz we have already traversed column values from top,
	 *  we now reduce col as rows are also sorted and if key is less then value must be before
	 *  current index in vertical space.
	 *  
	 * @TimeComplexity O(m+n)
	 * @SpaceComplexity O(1)
	 *  
	 */
	private static void findKey(int[][] inputArr, int key) {
		boolean notFound=true;
		int row=0;
		int col=inputArr[0].length-1;
		while(notFound) {
			if(key==inputArr[row][col]) {
				notFound=false;
				System.out.println("FOund at index:"+row+","+col);
			}else if(key>inputArr[row][col]){
				row++;
			}else {
				col--;
			}
		}
		
	}
}
