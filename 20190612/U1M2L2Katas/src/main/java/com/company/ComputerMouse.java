package com.company;

public class ComputerMouse {
    private String manufacturer;
    private String model;
    private int xPosition;
    private int yPosition;
    private int[] lastClickedLocation;

    public ComputerMouse(String manufacturerIn, String modelIn, int xPositionIn, int yPositionIn,
                         int[] lastClickedLocationIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.xPosition = xPositionIn;
        this.yPosition = yPositionIn;
        this.lastClickedLocation = lastClickedLocationIn;
    }

    public void move(int deltaX, int deltaY) {
        this.xPosition += deltaX;
        this.yPosition += deltaY;
    }

    public void click() {
        this.lastClickedLocation[0] = xPosition;
        this.lastClickedLocation[1] = yPosition;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int[] getLastClickedLocation() {
        return lastClickedLocation;
    }

    public void setLastClickedLocation(int[] lastClickedLocation) {
        this.lastClickedLocation = lastClickedLocation;
    }
}

