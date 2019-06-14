package com.company.Laptop;

public class Laptop {
    private String make;
    private String model;
    private Processor processor;
    private Memory memory;
    private OpticalDrive opticalDrive;

    public Laptop() {
    }

    
    public void changeBrightness(int brightness){

    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public OpticalDrive getOpticalDrive() {
        return opticalDrive;
    }

    public void setOpticalDrive(OpticalDrive opticalDrive) {
        this.opticalDrive = opticalDrive;
    }
}
