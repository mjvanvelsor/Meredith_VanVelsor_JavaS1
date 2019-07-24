package com.company.MeredithVanVelsorU1Capstone.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Tshirt {

    private int tShirtId; // PK
    private String size;
    private String color;
    private String description;
    private BigDecimal price;
    private BigDecimal quantity;

    public int gettShirtId() {
        return tShirtId;
    }

    public void settShirtId(int tShirtId) {
        this.tShirtId = tShirtId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tshirt tshirt = (Tshirt) o;
        return gettShirtId() == tshirt.gettShirtId() &&
                getSize().equals(tshirt.getSize()) &&
                getColor().equals(tshirt.getColor()) &&
                getDescription().equals(tshirt.getDescription()) &&
                getPrice().equals(tshirt.getPrice()) &&
                getQuantity().equals(tshirt.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(gettShirtId(), getSize(), getColor(), getDescription(), getPrice(), getQuantity());
    }
}
