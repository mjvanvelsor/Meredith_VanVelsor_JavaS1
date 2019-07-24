package com.company.MeredithVanVelsorU1Capstone.viewmodel;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceViewModel {

    private int invoiceId; // PK

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
    @NotEmpty
    private String itemType;
    @DecimalMin(value = "0.0", inclusive = true)
    private int itemId;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal unitPrice;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal quantity;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal subtotal;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal tax;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal processingFee;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal total;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

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

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return getInvoiceId() == that.getInvoiceId() &&
                getItemId() == that.getItemId() &&
                getName().equals(that.getName()) &&
                getStreet().equals(that.getStreet()) &&
                getCity().equals(that.getCity()) &&
                getState().equals(that.getState()) &&
                getZipcode().equals(that.getZipcode()) &&
                getItemType().equals(that.getItemType()) &&
                getUnitPrice().equals(that.getUnitPrice()) &&
                getQuantity().equals(that.getQuantity()) &&
                getSubtotal().equals(that.getSubtotal()) &&
                getTax().equals(that.getTax()) &&
                getProcessingFee().equals(that.getProcessingFee()) &&
                getTotal().equals(that.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceId(), getName(), getStreet(), getCity(), getState(), getZipcode(), getItemType(), getItemId(), getUnitPrice(), getQuantity(), getSubtotal(), getTax(), getProcessingFee(), getTotal());
    }
}
