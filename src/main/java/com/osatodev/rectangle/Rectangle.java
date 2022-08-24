package main.java.com.osatodev.rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rectangle {

    static class Point {
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Point() {
        }

        public void setX(double x) {
            this.x = x;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        double x, y;
    }


    static String containment(Point l1, Point r1, Point l2, Point r2) {
        // Point l1, Point r1- represents the diagonal of rectangle A
        // Point l2, Point r2- represents the diagonal of rectangle B

        // check if all the sides of the rectangle B fall within rectangle A
        if (l1.x <= l2.x && r2.x <= r1.x && l1.y >= l2.y && r2.y >= r1.y) {
            return "containment";
        } else {
            return "no containment and intersection";
        }

    }

    static String adjacency(Point l1, Point r1, Point l2, Point r2) {
        // Point l1, Point r1- represents the diagonal of rectangle A
        // Point l2, Point r2- represents the diagonal of rectangle B

        // check if any of the sides touch each other
        if (l1.x == l2.x || r2.x == r1.x || l1.y == l2.y || r2.y == l1.y || r1.x == l2.x || r1.y == l2.y) {
            if (Math.abs(l1.y - r1.y) - Math.abs(r2.y - l2.y) != 0 ) {
                return "sub-line";
            } else if (l1.y != l2.y || r2.y != r1.y) {
                return "partial";
            }
            return "adjacent";
        } else {
            return "no adjacency";
        }

    }

    static void doRectangle(Point a1, Point a2, Point a3, Point a4, Point b1, Point b2, Point b3, Point b4){
        final String containmentResponse = containment(a1, a4, b1, b4);
        final String adjacencyResponse = adjacency(a1, a4, b1, b4);
        if(containmentResponse.equals("containment")){
            System.out.println(containmentResponse);
        }
        else if (adjacencyResponse.equals("no adjacency")){
            List<Point> pointList = intersection(a1, a2, a3, a4, b1, b2, b3, b4);
            for (Point point : pointList) {
                System.out.println(point.x + "," + point.y);
            }
        }else {
            System.out.println(adjacencyResponse);
        }
    }

    static List<Point> intersection(Point a1, Point a2, Point a3, Point a4, Point b1, Point b2, Point b3, Point b4) {
        List<Point> coords = new ArrayList<>();

        // Point a1, Point a2, Point a3, Point a4 - represents rectangle A
        // Point b1, Point b2, Point b3, Point b4 - represents rectangle B

        //check for intersection between a1 and a2.
        if (a1.x < b1.x && b1.x < a2.x || a1.x < b2.x && b2.x < a2.x) {
            // a3 to a4 has the same parameters, so we'll just check the vertical position/point of intersection of
            // rectangle b, get it's x value, and get y depending on its position
            if (b1.y > a1.y && a1.x < b1.x) {
                coords.add(new Point(b1.x, a1.y));
            } else if (a4.y < b1.y && a1.x < b1.x) {
                if (b4.y > a4.y && b1.y > a1.y || (b1.y < a1.y && a4.y > b4.y)) {
                    // means the top of the rectangle b is inside the rectangle A
                    coords.add(new Point(b1.x, a4.y));
                }
//                if rectangle b is to the top of a
            }else if(b1.y > a1.y && b1.x < a1.x && b4.x >a1.x){
                coords.add(new Point(b4.x, a1.y));
            }else if(b1.y < a1.y && b4.y < a4.y && b1.x < a1.x && b4.x >a1.x){
                coords.add(new Point(b4.x, a4.y));
            }
//          if both vertical sides of rectangle B is between rectangle A
            if (a1.x < b1.x && a1.x < b2.x && b2.x < a2.x ) {
                if (b2.y > a1.y) {
                    coords.add(new Point(b2.x, a1.y));
                } else if (a4.y < b2.y && a4.y < b4.y) {
                    coords.add(new Point(b2.x, a4.y));
                }else if (b4.x < a4.x) {
                    coords.add(new Point(b4.x, a4.y));
                }
            }
        }

        //check for intersection between a1 and a3.
        if (a1.y > b1.y && b1.y > a3.y || b4.y > a4.y && (b1.x < a1.x || b4.x > a4.x)) {
            if (b1.x < a1.x && a1.y > b1.y) {
                coords.add(new Point(a1.x, b1.y));
            } else if (b1.x < a1.x && b2.x > a4.x) {
                coords.add(new Point(a4.x, b1.y));
            }

            // if both horizontal sides of rectangle B fall within rectangle A
            if ((b4.y > a4.y && (b1.x < a1.x || b4.x > a4.x)) || (b1.y > a4.y && b1.x > a1.x)) {
                if (b1.y < a1.y && b4.x > a4.x) {
                    coords.add(new Point(a4.x, b1.y));
                }
                if ((b4.x > a4.x && b4.y > a4.y)) {
                    coords.add(new Point(a4.x, b4.y));
                } else if (b4.y > a4.y) {
                    coords.add(new Point(a1.x, b4.y));
                }
            }
        }

        return coords;

    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        Point a1 = new Point(), a2 = new Point(), a3 = new Point(), a4 = new Point(), b1 = new Point(), b2 = new Point(), b3 = new Point(), b4 = new Point();
        Scanner in = new Scanner(System.in).useDelimiter("[,\\s+]");

        //this assumes that in a rectangle, there are four points
        // a1(x,y) represents one point or coordinate in the rectangle
        a1.x = 3;
        a1.y = 8;
        a2.x = 9;
        a2.y = 8;
        a3.x = 3;
        a3.y = 2;
        a4.x = 9;
        a4.y = 2;
        b1.x = 9;
        b1.y = 7;
        b2.x = 12;
        b2.y = 7;
        b3.x = 9;
        b3.y = 3;
        b4.x = 12;
        b4.y = 3;



    doRectangle(a1, a2, a3, a4, b1, b2, b3, b4);
    adjacency(a1, a4, b1, b4);

    }

}
