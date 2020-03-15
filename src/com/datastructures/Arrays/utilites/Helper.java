package import com.datastructures.Arrays.utilites;;

public class Helper {

	
	/**
	 * Print an array
	 * @param outputArr
	 */
	public static void printArray(int[] outputArr) {
		for(int num:outputArr)
		System.out.print(num+" ");
	}

	/**
	 * Swap Two numbers
	 * @param inputArr
	 * @param i
	 * @param j
	 */
	public static void swap(int[] inputArr, int i, int j) {
		int temp=inputArr[i];
		inputArr[i]=inputArr[j];
		inputArr[j]=temp;
	}

	/**
	 * Finds the pivot element considering this is a sorted and rotated arr
	 * 
	 * @param inputArr
	 */
	public static int findPivot(int[] inputArr) {
		for (int i = 0; i < inputArr.length - 1; i++) {
			if (inputArr[i] > inputArr[i + 1]) {
				return i;
			}
		}
		return -1;
	}
}
