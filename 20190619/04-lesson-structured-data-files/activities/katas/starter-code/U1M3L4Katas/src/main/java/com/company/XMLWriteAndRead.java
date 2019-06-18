package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class XMLWriteAndRead {
    public static void main(String[] args) {
        PrintWriter writer = null;

        List<Car> carList = new ArrayList<>();

        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));

        try {
            XmlMapper mapper = new XmlMapper();
            String XMLCarList = mapper.writeValueAsString(carList);
            carList = mapper.readValue(new File("cars.xml"), new TypeReference<List<Car>>(){});
            for (Car cars: carList) {
                System.out.println("==========");
                System.out.println(cars.getMake());
                System.out.println(cars.getModel());
                System.out.println(cars.getColor());
                System.out.println(cars.getYear());
            }

//            System.out.println(XMLCarList);

            writer = new PrintWriter(new FileWriter("cars.xml"));

            writer.println(XMLCarList);
        } catch (IOException e) {
            System.out.println("ERROR: Could not write to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }
}
