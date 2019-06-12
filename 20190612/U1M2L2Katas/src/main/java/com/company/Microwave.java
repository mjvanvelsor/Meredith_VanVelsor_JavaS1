package com.company;

public class Microwave {
    private String manufacturer;
    private String model;
    private int secondsLeft;
    private String time;
    private boolean running;

    public Microwave (String manufacturerIn, String modelIn, int secondsLeftIn, String timeIn, boolean runningIn){
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.secondsLeft = secondsLeftIn;
        this.time = timeIn;
        this.running = runningIn;
    }

    public void start(int secondsLeft){
        this.secondsLeft = secondsLeft;
    }

    public void stop(){
        running = !running;
    }

    public void clear(){
        System.out.println("Cleared. Select a setting.");
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

    public int getSecondsLeft() {
        return secondsLeft;
    }

    public void setSecondsLeft(int secondsLeft) {
        this.secondsLeft = secondsLeft;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
