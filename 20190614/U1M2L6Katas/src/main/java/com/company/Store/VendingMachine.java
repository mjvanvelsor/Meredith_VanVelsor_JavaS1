package com.company.Store;

public class VendingMachine {
    private Chips chips;
    private Chocolate chocolate;
    private SodaPop sodaPop;
    private Mints mints;
    private Gum gum;
    private Popcorn popcorn;

    public VendingMachine() {
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

    public Mints getMints() {
        return mints;
    }

    public void setMints(Mints mints) {
        this.mints = mints;
    }

    public Gum getGum() {
        return gum;
    }

    public void setGum(Gum gum) {
        this.gum = gum;
    }

    public Popcorn getPopcorn() {
        return popcorn;
    }

    public void setPopcorn(Popcorn popcorn) {
        this.popcorn = popcorn;
    }
}
