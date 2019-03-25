package com.course_java_for_testers.sandbox;

public class HelloWorldText {
 public static void main(String[] args){
 String fio = "Nikonov Vladislav Alekseevich";
  Hi(fio);
  double x = 8;
  double y = 5.1;
  System.out.println("Area of square, with side's size " + x + " = " + area(x) );
  System.out.println("Area of square, with side's sizes " + x + " and " + y + " = " + area(x,y) );
}

 public static void Hi (String user) {
  System.out.println("Hello, " + user + " !!!");
 }

 public static double area (double x){
  return x*x;
 }

 public static double area (double x, double y){
  return x*y;
 }
}