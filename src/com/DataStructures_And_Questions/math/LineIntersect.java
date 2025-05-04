package com.DataStructures_And_Questions.math;

public class LineIntersect {
    public static void main(String[] args) {
        Line line1 = new LineIntersect().new Line(2, 12);
        Line line2 = new LineIntersect().new Line(5, 15);

        boolean isIntersect = isIntersect(line1, line2);
        System.out.println(isIntersect);

    }

    /**
     * A line can be reprsented as y=mx+b.
     * where m is the slope of the line and b is yIntercept of the line.
     * <p>
     * Two lines will never intersect only if they are parallel.
     * And any two line which are parallel have same slope m.
     * <p>
     * So, we check if two lines have same slope, then they are parallel and hence will not intersect.
     * Also, we check if both these lines are equal i.e. their m and yIntercept are equal. In this
     * case also we return false saying both lines are same.
     * <p>
     * If their slopes are different we return true saying they will intersect.
     */
    private static boolean isIntersect(Line line1, Line line2) {
        if (line1.slope == line2.slope) {
            return false;
        } else if (line1.equals(line2)) {
            System.out.println("Same lines");
            return false;
        }
        return true;
    }

    class Line {
        int slope;
        int yIntercept;

        public Line(int slope, int yIntercept) {
            this.slope = slope;
            this.yIntercept = yIntercept;
        }

        @Override
        public boolean equals(Object arg0) {
            Line l2 = (Line) arg0;
            if (this.slope == l2.slope && this.yIntercept == l2.yIntercept) {
                return true;
            } else {
                return false;
            }

        }
    }
}
