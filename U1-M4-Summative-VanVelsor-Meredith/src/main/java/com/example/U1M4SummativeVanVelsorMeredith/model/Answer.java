package com.example.U1M4SummativeVanVelsorMeredith.model;

public class Answer {

    // Answer Object

    // properties
    private String question;
    private String answer;
    // default constructor
    public Answer() {
    }
    // constructor
    public Answer(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    // getters and setters
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
