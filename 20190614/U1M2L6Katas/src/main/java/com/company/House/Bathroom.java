package com.company.House;

public class Bathroom {
    private int bathroomLength;
    private int bathroomWidth;
    private String typeOfFlooring;

    public Bathroom() {
    }

    public void calculateSqft(int bathroomLength, int bathroomWidth){
    }

    public void getNumSinks(int sinks){

    }

    public int getBathroomLength() {
        return bathroomLength;
    }

    public void setBathroomLength(int bathroomLength) {
        this.bathroomLength = bathroomLength;
    }

    public int getBathroomWidth() {
        return bathroomWidth;
    }

    public void setBathroomWidth(int bathroomWidth) {
        this.bathroomWidth = bathroomWidth;
    }

    public String getTypeOfFlooring() {
        return typeOfFlooring;
    }

    public void setTypeOfFlooring(String typeOfFlooring) {
        this.typeOfFlooring = typeOfFlooring;
    }
}
