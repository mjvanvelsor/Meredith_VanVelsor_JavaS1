package com.company.Store;

public class Store {
    private Chips chips;
    private Chocolate chocolate;
    private SodaPop sodaPop;
    private int numRegisters;
    private boolean isOpen;

    public Store() {
    }

    public void takePayment(float payment){

    }

    public Chips getChips() {
        return chips;
    }

    public void setChips(Chips chips) {
        this.chips = chips;
    }

    public Chocolate getChocolate() {
        return chocolate;
    }

    public void setChocolate(Chocolate chocolate) {
        this.chocolate = chocolate;
    }

    public SodaPop getSodaPop() {
        return sodaPop;
    }

    public void setSodaPop(SodaPop sodaPop) {
        this.sodaPop = sodaPop;
    }

    public int getNumRegisters() {
        return numRegisters;
    }

    public void setNumRegisters(int numRegisters) {
        this.numRegisters = numRegisters;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
