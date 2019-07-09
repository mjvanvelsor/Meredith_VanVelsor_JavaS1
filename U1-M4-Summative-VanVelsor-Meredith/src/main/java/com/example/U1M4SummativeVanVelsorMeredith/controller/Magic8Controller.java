package com.example.U1M4SummativeVanVelsorMeredith.controller;

import com.example.U1M4SummativeVanVelsorMeredith.model.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class Magic8Controller extends Answer {

    /*
        Instructions:
        Your solution must have the following structural elements:
        Your solution must be in an IntelliJ project called U1-M4-Summative-Lastname-Firstname.
        Your project must be built using Spring Boot and Spring MVC. Initialize your project using start.spring.io.
        Your project must have an in-memory DAO that follows the pattern shown in this module.
        Your REST API must accept and return data in JSON format where appropriate.
        Your REST API must be documented with Swagger. Save the .yaml file in the root of your project directory.

        Magic 8-ball API:
        URI: /magic
        HttpMethod: POST (POST/GET/PUT/DELETE)(CREATE/RETRIEVE/UPDATE/DELETE)
        Request Body: Question
        Response Body: Answer

        Definition Object:
        Question
        Answer

        Used randomGenerator to generate random number to use for
        index and assigned those as cases to a switch statement. Each case has a
        magic 8 ball response assigned to it that is returned if it matches the random index.
         */

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Answer postAnswer(@RequestBody Answer question){
        /*
         I really wanted to add a scanner here, but didn't know how to / couldn't make that work with Spring,
         Realized I had to capture the question inside postman instead and take it in as a parameter.
         Once I did that, it made more sense to assign all the random answers to one object instead of having to have
         SO many objects for such a simple application. Used random index to assign which answer would pop up!
         */

        // assigning random index
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(6);

        // making Answer object and setting question to take the user input via postman
        Answer answer = new Answer();
        answer.setQuestion(question.getQuestion());

        // assigning index to each answer and setting the answer variable to that index for each case
        switch (randomIndex) {
            case 0:
                answer.setAnswer("Reply hazy. Try again.");
                break;
            case 1:
                answer.setAnswer("Yes - definitely");
                break;
            case 2:
                answer.setAnswer("Signs point to yes.");
                break;
            case 3:
                answer.setAnswer("Don't count on it");
                break;
            case 4:
                answer.setAnswer("Better not to tell you now.");
                break;
            case 5:
                answer.setAnswer("It is certain.");
        }

        // required/standard return answer - Answer object return type
        return answer;
    }
}