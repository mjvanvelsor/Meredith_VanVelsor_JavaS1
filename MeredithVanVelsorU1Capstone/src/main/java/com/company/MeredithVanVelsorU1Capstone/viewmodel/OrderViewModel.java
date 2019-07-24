package com.company.MeredithVanVelsorU1Capstone.viewmodel;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class OrderViewModel {

    @NotEmpty(message = "Please enter your name.")
    private String name;
    @NotEmpty(message = "Enter street address.")
    private String street;
    @NotEmpty(message = "Enter city.")
    private String city;
    @NotEmpty(message = "Enter state.")
    private String state;
    @NotEmpty(message = "Enter zipcode.")
    private String zipcode;
    @NotEmpty(message = "Please enter the item type.")
    private String itemType;
    @Min(value = 0L, message = "The value must be positive")
    private int itemId;
    @NotNull
    @DecimalMin(value = "1", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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
        OrderViewModel that = (OrderViewModel) o;
        return getItemId() == that.getItemId() &&
                getName().equals(that.getName()) &&
                getStreet().equals(that.getStreet()) &&
                getCity().equals(that.getCity()) &&
                getState().equals(that.getState()) &&
                getZipcode().equals(that.getZipcode()) &&
                getItemType().equals(that.getItemType()) &&
                getQuantity().equals(that.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStreet(), getCity(), getState(), getZipcode(), getItemType(), getItemId(), getQuantity());
    }
}
