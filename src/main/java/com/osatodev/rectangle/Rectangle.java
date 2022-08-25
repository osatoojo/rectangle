package com.osatodev.rectangle;


import java.util.ArrayList;
import java.util.List;

public class Rectangle {

    /**
     *         //this assumes that in a rectangle, there are four points. For this logic, I am only using 2 diagonal points
     *         // Point  rect1Point1, Point  rect1Point2- represents the diagonal of rectangle 1
     *         // Point  rect2Point1, Point  rect2Point2- represents the diagonal of rectangle 2
     */
    public String containment(Point  rect1Point1, Point  rect1Point2, Point rect2Point1, Point rect2Point2) {
        // Point   rect1Point1, Point   rect1Point2- represents the diagonal of rectangle A
        // Point  rect2Point1, Point  rect2Point2- represents the diagonal of rectangle B

        // check if all the sides of the rectangle B fall within rectangle A
        if ( rect1Point1.x <= rect2Point1.x && rect2Point2.x <=  rect1Point2.x &&  rect1Point1.y >= rect2Point1.y && rect2Point2.y >=  rect1Point2.y) {
            return "containment";
        } else {
            return "no containment and intersection";
        }

    }

    /**
     *         //this assumes that in a rectangle, there are four points. For this logic, I am only using 2 diagonal points
     *         // Point  rect1Point1, Point  rect1Point2- represents the diagonal of rectangle 1
     *         // Point  rect2Point1, Point  rect2Point2- represents the diagonal of rectangle 2
     */
    public String adjacency(Point  rect1Point1, Point  rect1Point2, Point rect2Point1, Point rect2Point2) {

        // check if any of the sides touch each other
        if ( rect1Point1.x == rect2Point1.x || rect2Point2.x ==  rect1Point2.x ||  rect1Point1.y == rect2Point1.y || rect2Point2.y ==  rect1Point1.y ||  rect1Point2.x == rect2Point1.x ||  rect1Point2.y == rect2Point1.y) {
            if (Math.abs( rect1Point1.y -  rect1Point2.y) - Math.abs(rect2Point2.y - rect2Point1.y) != 0) {
                return "sub-line adjacency";
            } else if ( rect1Point1.y != rect2Point1.y || rect2Point2.y !=  rect1Point2.y) {
                return "partial adjacency";
            }
            return "proper adjacency";
        } else {
            return "no adjacency";
        }

    }

    /**
     * this method ties all the rectangle checks
     */
    public void doRectangleCheck(Point  rect1Point1, Point  rect1Point2, Point rect2Point1, Point rect2Point2) {

        final String containmentResponse = containment( rect1Point1,  rect1Point2, rect2Point1, rect2Point2);
        final String adjacencyResponse = adjacency( rect1Point1,  rect1Point2, rect2Point1, rect2Point2);
        if (containmentResponse.equals("containment")) {
            System.out.println(containmentResponse);
        } else if (adjacencyResponse.equals("no adjacency")) {
            List<Point> pointList = intersection( rect1Point1,  rect1Point2, rect2Point1, rect2Point2);
            for (Point point : pointList) {
                System.out.println(point.x + "," + point.y);
            }
        } else {
            System.out.println(adjacencyResponse);
        }
    }

    /**
     *         //this assumes that in a rectangle, there are four points. For this logic, I am only using 2 diagonal points
     *         // Point  rect1Point1, Point  rect1Point2- represents the diagonal of rectangle 1
     *         // Point  rect2Point1, Point  rect2Point2- represents the diagonal of rectangle 2
     */
    public List<Point> intersection(Point  rect1Point1, Point  rect1Point2, Point rect2Point1, Point rect2Point2) {
        List<Point> coords = new ArrayList<>();


        //check for intersection between  rect1Point1 and rect2Point1.
        if ( rect1Point1.x < rect2Point1.x && rect2Point1.x <  rect1Point2.x ||  rect1Point1.x < rect2Point2.x && rect2Point2.x <  rect1Point2.x) {
            // a3 to  rect1Point2 has the same parameters, so we'll just check the vertical position/point of intersection of
            // rectangle 2, get it's x value, and get y depending on its position
            if (rect2Point1.y >  rect1Point1.y &&  rect1Point1.x < rect2Point1.x) {
                coords.add(new Point(rect2Point1.x,  rect1Point1.y));
            } else if ( rect1Point2.y < rect2Point1.y &&  rect1Point1.x < rect2Point1.x) {
                if (rect2Point2.y >  rect1Point2.y && rect2Point1.y >  rect1Point1.y || (rect2Point1.y <  rect1Point1.y &&  rect1Point2.y > rect2Point2.y)) {
                    // means the top of the rectangle 2 is inside the rectangle 1
                    coords.add(new Point(rect2Point1.x,  rect1Point2.y));
                }
//                if rectangle 2 is to the top of 1
            } else if (rect2Point1.y >  rect1Point1.y && rect2Point1.x <  rect1Point1.x && rect2Point2.x >  rect1Point1.x) {
                coords.add(new Point(rect2Point2.x,  rect1Point1.y));
            } else if (rect2Point1.y <  rect1Point1.y && rect2Point2.y <  rect1Point2.y && rect2Point1.x <  rect1Point1.x && rect2Point2.x >  rect1Point1.x) {
                coords.add(new Point(rect2Point2.x,  rect1Point2.y));
            }
//          if both vertical sides of rectangle 2 is between rectangle 1
            if ( rect1Point1.x < rect2Point1.x &&  rect1Point1.x < rect2Point2.x && rect2Point2.x <  rect1Point2.x) {
                if (rect2Point1.y >  rect1Point1.y) {
                    coords.add(new Point(rect2Point2.x,  rect1Point1.y));
                } else if ( rect1Point2.y < rect2Point1.y &&  rect1Point2.y < rect2Point2.y) {
                    coords.add(new Point(rect2Point2.x,  rect1Point2.y));
                } else if (rect2Point2.x <  rect1Point2.x) {
                    coords.add(new Point(rect2Point2.x,  rect1Point2.y));
                }
            }
        }

        //check for intersection between  rect1Point1 and a3.
        if ( rect1Point1.y > rect2Point1.y && rect2Point1.y >  rect1Point2.y || rect2Point2.y >  rect1Point2.y && (rect2Point1.x <  rect1Point1.x || rect2Point2.x >  rect1Point2.x)) {
            if (rect2Point1.x <  rect1Point1.x &&  rect1Point1.y > rect2Point1.y) {
                coords.add(new Point( rect1Point1.x, rect2Point1.y));
            } else if (rect2Point1.x <  rect1Point1.x && rect2Point2.x >  rect1Point2.x) {
                coords.add(new Point( rect1Point2.x, rect2Point1.y));
            }

            // if both horizontal sides of rectangle 2 fall within rectangle 2
            if ((rect2Point2.y >  rect1Point2.y && (rect2Point1.x <  rect1Point1.x || rect2Point2.x >  rect1Point2.x)) || (rect2Point1.y >  rect1Point2.y && rect2Point1.x >  rect1Point1.x)) {
                if (rect2Point1.y <  rect1Point1.y && rect2Point2.x >  rect1Point2.x) {
                    coords.add(new Point( rect1Point2.x, rect2Point1.y));
                }
                if ((rect2Point2.x >  rect1Point2.x && rect2Point2.y >  rect1Point2.y)) {
                    coords.add(new Point( rect1Point2.x, rect2Point2.y));
                } else if (rect2Point2.y >  rect1Point2.y) {
                    coords.add(new Point( rect1Point1.x, rect2Point2.y));
                }
            }
        }
        //check for no intersection
        if (coords.size() < 2) {
            return new ArrayList<>();
        }

        return coords;

    }

    /* Main method to test above function */
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        
        Point rect1Point1 = new Point(3,8);
        Point rect1Point2 = new Point(9,2);

        Point rect2Point1 = new Point(12,7);
        Point rect2Point2 = new Point(12,3);

        rectangle.doRectangleCheck(rect1Point1, rect1Point2, rect2Point1, rect2Point2);
    }

}
