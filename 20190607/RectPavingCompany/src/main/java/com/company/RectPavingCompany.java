package com.company;
import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("What is the width of the driveway in feet? ");
        int width = Integer.parseInt(scan.nextLine());

        System.out.print("What is the length of the driveway in feet? ");
        int length = Integer.parseInt(scan.nextLine());

// is taking the correct inputs for width and length

//        float cementCost = 0.00f;
//        float framingCost = 0.00f;
//        Got rid of these and added later

        System.out.print("What is the cost of cement per square foot? ");
        float cementCost = Float.parseFloat(scan.nextLine());

        System.out.print("What is the cost of framing/footers per linear foot? ");
        float framingCost = Float.parseFloat(scan.nextLine()); // changes cementCost to framingCost

        int area = length * width;
        int perimeter = 2 * length + 2 * width; // chanced minus to plus

        System.out.format("The area of the driveway is %d square feet.%n", area);
        System.out.format("The perimeter of the driveway is %d linear feet.%n", perimeter);

        System.out.format("The cost of the cement is %.2f.%n", area * cementCost);
        System.out.format("The cost of the framing/footers is %.2f.%n", perimeter * framingCost);
        // added .2 to %f for decimal place correction & changed perimeter cost calculation to '*' from '+'
    }
}
