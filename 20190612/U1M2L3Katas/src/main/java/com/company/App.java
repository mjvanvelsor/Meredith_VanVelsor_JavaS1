package com.company;

public class App {

    public TV createTV(){
        TV newTV = new TV("Zenith", "U2121H", 83, "NBC",
                55, false);
        return newTV;
    }

    public Radio createRadio(){
        Radio newRadio = new Radio("Sony", "V32", 2,
                "WUNV", 30, true);
        return newRadio;
    }

    public Microwave createMicrowave(){
        Microwave newMicrowave = new Microwave("Haier", "X1200w",
                45, "12:00", false);
        return newMicrowave;
    }

    public CoffeeMaker createCoffeeMaker(){
        CoffeeMaker newCoffeeMaker = new CoffeeMaker(
                "Sunbeam", "C12", 12, 8, true);
        return newCoffeeMaker;
    }

    public Car createCar(){
        Car newCar = new Car("Honda", "Accord", "Sedan", "Blue", "2.6L V6",
                "CVT", 4, 31.7, 25218);
        return newCar;
    }

    public ComputerMouse createComputerMouse(){
        int[] lastClickedLocation = {0,0};
        ComputerMouse newComputerMouse = new ComputerMouse("Razer", "Naga",
                960, 540, lastClickedLocation);
        return newComputerMouse;
    }
}
