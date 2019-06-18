package com.company;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVWriteAndRead {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        cars.add(new Car(2001, "Honda", "Civic", "Silver"));
        cars.add(new Car(2012, "Toyota", "Camry", "Blue"));
        cars.add(new Car(2018, "Tesla", "Roadster", "Black"));
        cars.add(new Car(1964, "Ford", "Mustang", "Red"));
        try {
            Writer writer = new FileWriter("new_car_file.csv");
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(cars);
            writer.close();

            cars = new CsvToBeanBuilder<Car>(new FileReader("cars.csv")).withType(Car.class).build().parse();
            for (Car car: cars) {
                System.out.println("=============");
                System.out.println(car.getYear());
                System.out.println(car.getMake());
                System.out.println(car.getModel());
                System.out.println(car.getColor());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            System.out.println("ERROR: Something went wrong writing your CSV file: " + e.getMessage());
        }
    }
}
