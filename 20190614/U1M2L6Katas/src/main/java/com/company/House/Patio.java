package com.company.House;

public class Patio {
    private int patioLength;
    private int patioWidth;
    private String typeOfFlooring;

    public Patio() {
    }

    public void calculateSqft(int patioLength, int patioWidth){
    }
    public int getPatioLength() {
        return patioLength;
    }

    public void setPatioLength(int patioLength) {
        this.patioLength = patioLength;
    }

    public int getPatioWidth() {
        return patioWidth;
    }

    public void setPatioWidth(int patioWidth) {
        this.patioWidth = patioWidth;
    }

    public String getTypeOfFlooring() {
        return typeOfFlooring;
    }

    public void setTypeOfFlooring(String typeOfFlooring) {
        this.typeOfFlooring = typeOfFlooring;
    }
}
