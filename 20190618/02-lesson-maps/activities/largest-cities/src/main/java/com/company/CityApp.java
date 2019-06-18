package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CityApp {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        City city1 = new City("New York", 8654321);
        City city2 = new City("Los Angeles", 4563218);
        City city3 = new City("Chicago", 2716520);
        City city4 = new City("Denver", 704621);
        City city5 = new City("Des Moines", 217521);
        City city6 = new City("Atlanta", 486231);

        Map<String, City> cityPopulations = new HashMap<>();

        cityPopulations.put("New York", city1);
        cityPopulations.put("California", city2);
        cityPopulations.put("Illinois", city3);
        cityPopulations.put("Colorado", city4);
        cityPopulations.put("Iowa", city5);
        cityPopulations.put("Georgia", city6);

        for (Map.Entry<String, City> entry : cityPopulations.entrySet()){
            System.out.println( entry.getKey()
                    + " " + entry.getValue().getName()
                    + " " + entry.getValue().getPopulation());
        }

        System.out.println("Please enter a minimum population: ");
        int userMin = Integer.parseInt(myScanner.nextLine());

        for (Map.Entry<String, City> entry : cityPopulations.entrySet()){
            if ( entry.getValue().getPopulation() > userMin){
                System.out.println(entry.getKey());
            }
        }
    }
}
