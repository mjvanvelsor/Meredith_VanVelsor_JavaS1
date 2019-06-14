package com.company.House;

public class Bedroom {
    private int bedroomLength;
    private int bedroomWidth;
    private String typeOfFlooring;

    public Bedroom() {
    }

    public void calculateSqft(int bedroomLength, int bedroomWidth){
    }

    public int getBedroomLength() {
        return bedroomLength;
    }

    public void setBedroomLength(int bedroomLength) {
        this.bedroomLength = bedroomLength;
    }

    public int getBedroomWidth() {
        return bedroomWidth;
    }

    public void setBedroomWidth(int bedroomWidth) {
        this.bedroomWidth = bedroomWidth;
    }

    public String getTypeOfFlooring() {
        return typeOfFlooring;
    }

    public void setTypeOfFlooring(String typeOfFlooring) {
        this.typeOfFlooring = typeOfFlooring;
    }
}
