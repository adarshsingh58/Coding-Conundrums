package com.DataStructures_And_Questions.scenarioBasedQues;

/**
 * We’ll implement methods to calculate the distance between two geographical coordinates
 * <p>
 * https://www.baeldung.com/java-find-distance-between-points
 */
public class CalculateDistanceBetweenTwoCoordinatesinJava {
    static Integer EARTH_RADIUS = 6371;// EARTH_RADIUS is a constant equal to 6371 which is a good approximation of the Earth’s radius in kilometers.

    public static void main(String[] args) {

        double lat1 = 40.714268; // New York
        double lon1 = -74.005974;
        double lat2 = 34.0522; // Los Angeles
        double lon2 = -118.2437;

        double equirectangularDistance = calculateDistance_Equirectangular(lat1, lon1, lat2, lon2);
        double haversineDistance = calculateDistance_Haversine(lat1, lon1, lat2, lon2);
        double vincentyDistance = calculateDistance_Vincenty(lat1, lon1, lat2, lon2);

        double expectedDistance = 3944;

        //testing accuracy
        System.out.println(Math.abs(equirectangularDistance - expectedDistance) < 100);
        System.out.println(Math.abs(haversineDistance - expectedDistance) < 10);
        System.out.println(Math.abs(vincentyDistance - expectedDistance) < 0.5);
    }

    /* Implementation of Equirectangular approximation.
     * Even though it seems a simple formula, equirectangular approximation
     *  isn’t very accurate when calculating long distances.
     * In fact, it treats the Earth as a perfect sphere
     * and maps the sphere to a rectangular grid.*/
    public static double calculateDistance_Equirectangular(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);
        double lon1Rad = Math.toRadians(lon1);
        double lon2Rad = Math.toRadians(lon2);

        double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2);
        double y = (lat2Rad - lat1Rad);
        double distance = Math.sqrt(x * x + y * y) * EARTH_RADIUS;

        return distance;
    }

    /* We’ll implememt using  Haversine formula. Again, it views the Earth as a perfect sphere.
     Nonetheless, it’s more accurate in calculating the distance between long distances.
     */
    public static double calculateDistance_Haversine(double startLat, double startLong, double endLat, double endLong) {

        double dLat = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat = Math.toRadians(endLat);

        double a = haversine(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversine(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }

    static double haversine(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }

    static double SEMI_MAJOR_AXIS_MT = 6378137;
    static double SEMI_MINOR_AXIS_MT = 6356752.314245;
    static double FLATTENING = 1 / 298.257223563;
    static double ERROR_TOLERANCE = 1e-12;

    /*Finally, we must use Vincenty’s formula if we want the highest precision.
    In detail, Vincenty’s formula calculates the distance iteratively until the
    error reaches acceptable values. Moreover, it also takes into consideration the
    elliptical shape of the Earth.
    This formula is compute-heavy. Therefore, we might want to use it when precision is a goal.
    Otherwise, we’ll stick to the Haversine formula.
    */
    public static double calculateDistance_Vincenty(double latitude1, double longitude1, double latitude2, double longitude2) {
        double U1 = Math.atan((1 - FLATTENING) * Math.tan(Math.toRadians(latitude1)));
        double U2 = Math.atan((1 - FLATTENING) * Math.tan(Math.toRadians(latitude2)));

        double sinU1 = Math.sin(U1);
        double cosU1 = Math.cos(U1);
        double sinU2 = Math.sin(U2);
        double cosU2 = Math.cos(U2);

        double longitudeDifference = Math.toRadians(longitude2 - longitude1);
        double previousLongitudeDifference;

        double sinSigma, cosSigma, sigma, sinAlpha, cosSqAlpha, cos2SigmaM;

        do {
            sinSigma = Math.sqrt(Math.pow(cosU2 * Math.sin(longitudeDifference), 2) +
                    Math.pow(cosU1 * sinU2 - sinU1 * cosU2 * Math.cos(longitudeDifference), 2));
            cosSigma = sinU1 * sinU2 + cosU1 * cosU2 * Math.cos(longitudeDifference);
            sigma = Math.atan2(sinSigma, cosSigma);
            sinAlpha = cosU1 * cosU2 * Math.sin(longitudeDifference) / sinSigma;
            cosSqAlpha = 1 - Math.pow(sinAlpha, 2);
            cos2SigmaM = cosSigma - 2 * sinU1 * sinU2 / cosSqAlpha;
            if (Double.isNaN(cos2SigmaM)) {
                cos2SigmaM = 0;
            }
            previousLongitudeDifference = longitudeDifference;
            double C = FLATTENING / 16 * cosSqAlpha * (4 + FLATTENING * (4 - 3 * cosSqAlpha));
            longitudeDifference = Math.toRadians(longitude2 - longitude1) + (1 - C) * FLATTENING * sinAlpha *
                    (sigma + C * sinSigma * (cos2SigmaM + C * cosSigma * (-1 + 2 * Math.pow(cos2SigmaM, 2))));
        } while (Math.abs(longitudeDifference - previousLongitudeDifference) > ERROR_TOLERANCE);

        double uSq = cosSqAlpha * (Math.pow(SEMI_MAJOR_AXIS_MT, 2) - Math.pow(SEMI_MINOR_AXIS_MT, 2)) / Math.pow(SEMI_MINOR_AXIS_MT, 2);

        double A = 1 + uSq / 16384 * (4096 + uSq * (-768 + uSq * (320 - 175 * uSq)));
        double B = uSq / 1024 * (256 + uSq * (-128 + uSq * (74 - 47 * uSq)));

        double deltaSigma = B * sinSigma * (cos2SigmaM + B / 4 * (cosSigma * (-1 + 2 * Math.pow(cos2SigmaM, 2))
                - B / 6 * cos2SigmaM * (-3 + 4 * Math.pow(sinSigma, 2)) * (-3 + 4 * Math.pow(cos2SigmaM, 2))));

        double distanceMt = SEMI_MINOR_AXIS_MT * A * (sigma - deltaSigma);
        return distanceMt / 1000;
    }
}
