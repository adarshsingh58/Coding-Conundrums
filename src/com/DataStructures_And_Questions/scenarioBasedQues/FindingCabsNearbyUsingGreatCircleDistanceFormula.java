package com.DataStructures_And_Questions.scenarioBasedQues;

/**
 * Given GPS co-ordinates(in degrees) of a person who needs a cab and
 * co-ordinates of all the cabs in the city stored in a text file in JSON
 * format, find the user-id and name of all the cab drivers available in 50 km
 * proximity.
 * <p>
 * Input : file customers.json which contains GPS co-ordinates of a person who
 * needs a cab in degrees and co-ordinates of all the cabs in the city stored in
 * a text file in JSON format.
 * <p>
 * Output : file answers.json which contains user-id and Name of all the cab
 * drivers available in 50 km proximity stored in a new file.
 * <p>
 * <p>
 * Because earth is a sphere and not a plane we cannot use distance between 2 points in a plane.
 * Here we will use the great circle distance formula which takes care of the spherical nature
 * of plane and use latitude and longitude in degree instead of cordinates to find the distance.
 * <p>
 * The great-circle distance or orthodromic distance is the shortest distance between two points on
 * the surface of a sphere, measured along the surface of the sphere
 */
public class FindingCabsNearbyUsingGreatCircleDistanceFormula {

    public static void main(String[] args) {

    }

    private double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
        double earth_radius = 6371.0;
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);//central angle
        return (earth_radius * dist);
    }

    /* :: This function converts decimal degrees to radians : */
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /* :: This function converts radians to decimal degrees : */
    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
