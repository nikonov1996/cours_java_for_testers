package com.course_java_for_testers.sandbox;

public class Square {
    private  double side;

    public Square(){

    }

    public double area(){
        return this.getSide()*this.getSide();
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

}
