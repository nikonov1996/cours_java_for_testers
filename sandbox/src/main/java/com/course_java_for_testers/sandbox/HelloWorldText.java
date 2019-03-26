package com.course_java_for_testers.sandbox;

public class HelloWorldText {
 public static void main(String[] args){
 String fio = "Nikonov Vladislav Alekseevich";
  Hi(fio);
  Square square = new Square();
  square.setSide(5);
  Rectangle rectangle = new Rectangle();
  rectangle.setDlina(5);
  rectangle.setShirina(2);
  System.out.println("Area of square, with side's size " + square.getSide() + " = " + area(square) );
  System.out.println("Area of square, with side's sizes " + rectangle.getShirina() + " and " + rectangle.getDlina() + " = " + area(rectangle) );
}

 public static void Hi (String user) {
  System.out.println("Hello, " + user + " !!!");
 }

 public static double area (Square square){
  return square.getSide()*square.getSide();
 }

 public static double area (Rectangle rectangle){
  return rectangle.getDlina()*rectangle.getShirina();
 }
}