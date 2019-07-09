package com.example.U1M4SummativeVanVelsorMeredith.model;

public class Quote {

    // This is a DTO - data transfer object
    // properties
    private String author;
    private String quote;
    // constructor
    public Quote(String author, String quote) {
        this.author = author;
        this.quote = quote;
    }
    // getters and setters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
