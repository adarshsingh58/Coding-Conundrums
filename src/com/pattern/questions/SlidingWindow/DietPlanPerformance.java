package com.pattern.questions.SlidingWindow;

/**
 * A dieter consumes calories[i] calories on the i-th day.
 * <p>
 * Given an integer k, the dieter reviews their calorie intake over every sequence of k consecutive days (from calories[i] to calories[i+k-1] for all 0 <= i <= n-k). For each sequence, they calculate T, the total calories consumed over those k days:
 * <p>
 * If T is less than lower, the dieter performs poorly and loses 1 point.
 * <p>
 * If T is greater than upper, the dieter performs better and gains 1 point.
 * <p>
 * If T is between lower and upper (inclusive), the dieter’s performance is normal, and their points remain the same.
 * <p>
 * The dieter starts with zero points. Return the total points after the dieter follows this routine for all calories.length days. The total points can be negative.
 * <p>
 * eg:
 * cal: 2 3 5 7 8
 * k 1
 * lower 5
 * upper 5
 * <p>
 * op: 0
 * <p>
 * cal: 2 3 5
 * * k 2
 * * lower 4
 * * upper 6
 * *
 * * op: 2
 */
public class DietPlanPerformance {
}
