package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter the width of the driveway in feet.");
        float width = Float.parseFloat(myScanner.nextLine());

        System.out.println("Please enter the length of the driveway in feet.");
        float length = Float.parseFloat(myScanner.nextLine());
        float area = width * length;
        float perimeter = (2 * width) + (2 * length);
        System.out.format("The area of your driveway is %.2f sqft. \n", area);
        System.out.format("The perimeter of your driveway is %.2f ft. \n", perimeter);

        float totalCostCement = (area * 12.50f);
        float totalCostFraming = (perimeter * 8.25f);
        System.out.format("Total cost of cement is $%.2f. \n" , totalCostCement);
        System.out.format("Total cost of cement is $%.2f. \n" , totalCostFraming);

        System.out.println("Please enter the cost of the cement you are using.");
        float userCementCost = Float.parseFloat(myScanner.nextLine());
        System.out.println("Please enter the cost of the framing materials you are using.");
        float userFramingCost = Float.parseFloat(myScanner.nextLine());
        float totalUserCementCost = (area * userCementCost);
        float totalUserFramingCost = (perimeter * userFramingCost);
        System.out.format("Total cost of cement given your cost is $%.2f. \n" , totalUserCementCost);
        System.out.format("Total cost of cement given your cost is $%.2f. \n" , totalUserFramingCost);


    }
}
