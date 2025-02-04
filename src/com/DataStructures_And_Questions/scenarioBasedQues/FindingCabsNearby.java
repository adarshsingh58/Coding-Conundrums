package com.DataStructures_And_Questions.scenarioBasedQues;

/**
 * Given GPS co-ordinates(in degrees) of a person who needs a cab and co-ordinates of all the cabs in the city stored in a text file in JSON format, find the user-id and name of all the cab drivers available in 50 km proximity.
 * <p>
 * Examples:
 * <p>
 * <p>
 * Input : file customers.json which contains GPS co-ordinates of a person who needs a cab in degrees and co-ordinates of all the cabs in the city stored in a text file in JSON format.
 * <p>
 * Output : file answers.json which contains user-id and Name of all the cab drivers available in 50 km proximity stored in a new file.
 * <p>
 * https://www.geeksforgeeks.org/finding-cabs-nearby-using-great-circle-distance-formula/
 */
public class FindingCabsNearby {

    /**
     * Approach Used:
     * 1. Obtain latitude and longitude of each cab in string format along with their
     * user-id and name from the JSON encoded input file.
     * <p>
     * 2. Convert latitude and longitude of the cab present in string format to double.
     * <p>
     * 3. Convert latitude and longitude of both, the user and the cab present in
     * degrees to radians.
     * <p>
     * 4. Calculate distance between the user’s location and the cab using Great Circle
     * Distance formula.
     * <p>
     * 5. If distance is found to be less than or equal to 50 kms then output the userid and name of the cab driver to a new file else take no action.
     * <p>
     * Procedure to run the program :
     * 1. Save the code and the file customers.json in a same location.
     * 2. Now, compile the code and run it with passing file name customers.json along with proper location.
     * 3. A file named answers.json will be created on the same location where code and customers.json file is existing.
     */

    public static void main(String[] args) {

    }
}
