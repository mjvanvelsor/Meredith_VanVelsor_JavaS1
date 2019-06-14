package com.company.concreteapproach;

public class Triangle extends Shape{
    private double a;
    private double b;
    private double c;


    public double area(){
        return a * b / 2;
    }

    public double perimeter() {
        return a + b + c;
    }
}
