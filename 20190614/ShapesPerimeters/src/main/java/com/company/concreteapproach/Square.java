package com.company.concreteapproach;

public class Square extends Shape{
    private double side;

    public double area(){
        return side * side;
    }

    public double perimeter(){
        return 4 * side;
    }

}
