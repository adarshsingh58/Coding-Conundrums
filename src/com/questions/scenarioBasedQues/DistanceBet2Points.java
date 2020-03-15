package com.questions.scenarioBasedQues;

import java.awt.geom.Point2D;

/**
 * if co ordinates of two points are x1,y1 and x2,y2, find the distance between
 * them in a plane.
 * 
 * distance= SQUAREROOT{(y2-y2)^2+(x2-x2)^2}
 */
public class DistanceBet2Points {

	public static void main(String[] args) {
		double x1 = 3;
		double y1 = 4;
		double x2 = 7;
		double y2 = 1;
		
		double result1=calculateDistanceBetweenPointsWithHypot(x1, y1, x2, y2);
		double result2=calculateDistanceBetweenPointsWithHypot(x1, y1, x2, y2);
		System.out.println(result1+" "+result2);
		
	}

	public static double calculateDistanceBetweenPointsWithHypot(double x1, double y1, double x2, double y2) {

		double ac = Math.abs(y2 - y1);
		double cb = Math.abs(x2 - x1);

		return Math.hypot(ac, cb);
	}
	
	/**
	 * Here we will use Point2D library from java.awt.geom.Point2D Package
	 */
	public double calculateDistanceBetweenPointsWithPoint2D( 
		    double x1, 
		    double y1, 
		    double x2, 
		    double y2) {
		         
		    return Point2D.distance(x1, y1, x2, y2);
		}
}
