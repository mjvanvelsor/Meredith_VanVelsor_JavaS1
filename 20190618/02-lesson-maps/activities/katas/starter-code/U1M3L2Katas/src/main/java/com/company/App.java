package com.company;

import java.util.*;

public class App {

    public void printKeys(Map<String, String> input){
        Set<String> myKeys = input.keySet();
        for (String key : myKeys){
            System.out.println(key);
        }

    }

    public void printValues(Map<String, String> input){
        Collection<String> myValues = input.values();
        for (String value : myValues){
            System.out.println(value);
        }

    }

    public void printKeysAndValues(Map<String, String> input){
        Set<Map.Entry<String, String>> myEntries = input.entrySet();
        for (Map.Entry<String, String> entry : myEntries){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public Map<String, Integer> mapFun(Map<String, Integer> input){
//        Map<String, Integer> funArray = new HashMap<>();

//        funArray.put("Toyota Camry", 2012);
//        funArray.put("Chevy Camaro", 1969);
//        funArray.put("Hyundai Genesis", 2015);
//        funArray.put("Jeep Wrangler", 2003);
//        funArray.put("Honda Civic", 2018);
//        funArray.put("Toyota Supra", 1995);
//        funArray.put("Pontiac GTO", 1964);

        input.put("Ford Explorer", 2012);
        input.put("Smart Fortwo", 2013);

        input.remove("Jeep Wrangler");

//        for(Map.Entry<String, Integer> entry : input.entrySet()){
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

        return input;
    }

//    public Map<String, Car> listCars(Car input){
//        List<Car> toyotaList = new ArrayList<>();
//        List<Car> fordList = new ArrayList<>();
//        List<Car> hondaList = new ArrayList<>();
//
//        Set<Car> myKeys = listCars.keySet();
//        for (Car key : myKeys){
//            System.out.println(key);
//
//            if (key.getMake().contains("Toyota")){
//                toyotaList.add(key);
//            } else if (key.getMake().contains("Ford")){
//                fordList.add(key);
//            } else if (key.getMake().contains("Honda")){
//                hondaList.add(key);
//            }
//        }
//
//        Map<String, Car> carList = new HashMap<>();
//
//        carList.put("Toyota", toyotaList);
//        carList.put("Ford", fordList);
//        carList.put("Honda", hondaList);
//
//        return carList;
//    }
}
