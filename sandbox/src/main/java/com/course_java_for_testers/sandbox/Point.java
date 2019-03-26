package com.course_java_for_testers.sandbox;

public class Point {
    private double x;
    private double y;

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

    public double distance(Point other) {
        return Math.sqrt(Math.pow((other.getX() - x), 2) + Math.pow((other.getY() - y), 2));
    }
}
