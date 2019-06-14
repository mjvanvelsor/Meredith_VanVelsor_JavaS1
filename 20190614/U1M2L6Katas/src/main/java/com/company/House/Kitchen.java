package com.company.House;

public class Kitchen {
    private int kitchenLength;
    private int kitchenWidth;
    private String typeOfFlooring;

    public Kitchen() {
    }

    public void calculateSqft(int kitchenLength, int KitchenWidth) {
    }

    public int getKitchenLength() {
        return kitchenLength;
    }

    public void setKitchenLength(int kitchenLength) {
        this.kitchenLength = kitchenLength;
    }

    public int getKitchenWidth() {
        return kitchenWidth;
    }

    public void setKitchenWidth(int kitchenWidth) {
        this.kitchenWidth = kitchenWidth;
    }

    public String getTypeOfFlooring() {
        return typeOfFlooring;
    }

    public void setTypeOfFlooring(String typeOfFlooring) {
        this.typeOfFlooring = typeOfFlooring;
    }
}
