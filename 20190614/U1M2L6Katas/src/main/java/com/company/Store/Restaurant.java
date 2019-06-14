package com.company.Store;

public class Restaurant {
    private int guestCapacity;
    private int numTables;
    private String menu;
    private SodaPop sodaPop;

    public Restaurant() {

    }

    public void takePayment(float payment){

    }

    public String printReceipt(){
        return "receipt";
    }

    public int getGuestCapacity() {
        return guestCapacity;
    }

    public void setGuestCapacity(int guestCapacity) {
        this.guestCapacity = guestCapacity;
    }

    public int getNumTables() {
        return numTables;
    }

    public void setNumTables(int numTables) {
        this.numTables = numTables;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public SodaPop getSodaPop() {
        return sodaPop;
    }

    public void setSodaPop(SodaPop sodaPop) {
        this.sodaPop = sodaPop;
    }
}
