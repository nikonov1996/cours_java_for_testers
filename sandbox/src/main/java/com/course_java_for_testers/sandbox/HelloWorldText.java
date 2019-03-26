package com.course_java_for_testers.sandbox;

public class HelloWorldText {
 public static void main(String[] args){

  Point point1 = new Point();
  point1.setX(1);
  point1.setY(3);
  Point point2 = new Point();
  point2.setX(3);
  point2.setY(3);
  System.out.println(point1.distance(point2));


  /*String fio = "Nikonov Vladislav Alekseevich";
  Hi(fio);
  Square square = new Square();
  square.setSide(5);
  Rectangle rectangle = new Rectangle();
  rectangle.setDlina(5);
  rectangle.setShirina(2);
  System.out.println("Area of square, with side's size " + square.getSide() + " = " + square.area() );
  System.out.println("Area of square, with side's sizes " + rectangle.getShirina() + " and " + rectangle.getDlina() + " = " + rectangle.area() );*/

 }


 public static void Hi (String user) {
  System.out.println("Hello, " + user + " !!!");
 }

 }
