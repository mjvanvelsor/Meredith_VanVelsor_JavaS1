package com.company.Laptop;

public class OpticalDrive {
    private boolean isOpen;
    private boolean isPowered;


    public OpticalDrive() {
    }

    public void togglePower(){
        this.isPowered = !isPowered;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
