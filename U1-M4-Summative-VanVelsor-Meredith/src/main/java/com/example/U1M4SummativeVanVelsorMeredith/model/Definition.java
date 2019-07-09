package com.example.U1M4SummativeVanVelsorMeredith.model;

public class Definition {
    // Definition object
    //properties
    private String word;
    private String definition;
    // default constructor
    public Definition() {
    }
    // constructor
    public Definition(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }
    // getters and setters
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
