package com.osatodev.rectangle;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class Rectangle {


    public String containment(Point a1, Point a4, Point b1, Point b4) {
        // Point  a1, Point  a4- represents the diagonal of rectangle A
        // Point  b1, Point  b4- represents the diagonal of rectangle B

        // check if all the sides of the rectangle B fall within rectangle A
        if (a1.x <= b1.x && b4.x <= a4.x && a1.y >= b1.y && b4.y >= a4.y) {
            return "containment";
        } else {
            return "no containment and intersection";
        }

    }

    public String adjacency(Point a1, Point a4, Point b1, Point b4) {
        // Point  a1, Point  a4- represents the diagonal of rectangle A
        // Point  b1, Point  b4- represents the diagonal of rectangle B

        // check if any of the sides touch each other
        if (a1.x == b1.x || b4.x == a4.x || a1.y == b1.y || b4.y == a1.y || a4.x == b1.x || a4.y == b1.y) {
            if (Math.abs(a1.y - a4.y) - Math.abs(b4.y - b1.y) != 0) {
                return "sub-line adjacency";
            } else if (a1.y != b1.y || b4.y != a4.y) {
                return "partial adjacency";
            }
            return "proper adjacency";
        } else {
            return "no adjacency";
        }

    }

    public void doRectangle(Point a1, Point a4, Point b1, Point b4) {

        final String containmentResponse = containment(a1, a4, b1, b4);
        final String adjacencyResponse = adjacency(a1, a4, b1, b4);
        if (containmentResponse.equals("containment")) {
            System.out.println(containmentResponse);
        } else if (adjacencyResponse.equals("no adjacency")) {
            List<Point> pointList = intersection(a1, a4, b1, b4);
            for (Point point : pointList) {
                System.out.println(point.x + "," + point.y);
            }
        } else {
            System.out.println(adjacencyResponse);
        }
    }

    public List<Point> intersection(Point a1, Point a4, Point b1, Point b4) {
        List<Point> coords = new ArrayList<>();

        // Point a1, Point a2, Point a3, Point a4 - represents rectangle A
        // Point b1, Point b2, Point b3, Point b4 - represents rectangle B

        //check for intersection between a1 and a2.
        if (a1.x < b1.x && b1.x < a4.x || a1.x < b4.x && b4.x < a4.x) {
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
            } else if (b1.y > a1.y && b1.x < a1.x && b4.x > a1.x) {
                coords.add(new Point(b4.x, a1.y));
            } else if (b1.y < a1.y && b4.y < a4.y && b1.x < a1.x && b4.x > a1.x) {
                coords.add(new Point(b4.x, a4.y));
            }
//          if both vertical sides of rectangle B is between rectangle A
            if (a1.x < b1.x && a1.x < b4.x && b4.x < a4.x) {
                if (b1.y > a1.y) {
                    coords.add(new Point(b4.x, a1.y));
                } else if (a4.y < b1.y && a4.y < b4.y) {
                    coords.add(new Point(b4.x, a4.y));
                } else if (b4.x < a4.x) {
                    coords.add(new Point(b4.x, a4.y));
                }
            }
        }

        //check for intersection between a1 and a3.
        if (a1.y > b1.y && b1.y > a4.y || b4.y > a4.y && (b1.x < a1.x || b4.x > a4.x)) {
            if (b1.x < a1.x && a1.y > b1.y) {
                coords.add(new Point(a1.x, b1.y));
            } else if (b1.x < a1.x && b4.x > a4.x) {
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
        //check for no intersection
        if (coords.size() < 2) {
            return new ArrayList<>();
        }

        return coords;

    }

    /* Main method to test above function */
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Point a1 = new Point(), a4 = new Point(), b1 = new Point(), b4 = new Point();

        //this assumes that in a rectangle, there are four points
        // a1(x,y) represents one point or coordinate in the rectangle
        a1.x = 3;
        a1.y = 8;

        a4.x = 9;
        a4.y = 2;

        b1.x = 12;
        b1.y = 7;

        b4.x = 12;
        b4.y = 3;

        rectangle.doRectangle(a1, a4, b1, b4);

    }

}
