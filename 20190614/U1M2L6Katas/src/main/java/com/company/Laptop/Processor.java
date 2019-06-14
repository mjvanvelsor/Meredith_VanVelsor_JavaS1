package com.company.Laptop;

public class Processor {
    private String speed;
    private String manufacturer;
    private boolean isPowered;

    public Processor() {
        this.isPowered = isPowered;
    }

    public void togglePower(){
        this.isPowered = !isPowered;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
