package com.example.U1M4SummativeVanVelsorMeredith.controller;

import com.example.U1M4SummativeVanVelsorMeredith.model.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class WordController {

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getWord(){

        /*
        Instructions:
        Your solution must have the following structural elements:
        Your solution must be in an IntelliJ project called U1-M4-Summative-Lastname-Firstname.
        Your project must be built using Spring Boot and Spring MVC. Initialize your project using start.spring.io.
        Your project must have an in-memory DAO that follows the pattern shown in this module.
        Your REST API must accept and return data in JSON format where appropriate.
        Your REST API must be documented with Swagger. Save the .yaml file in the root of your project directory.

        Word API
        URI: /word
        HTTP Method: GET (POST/GET/PUT/DELETE)(CREATE/RETRIEVE/UPDATE/DELETE)
        Request Body: None
        Response Body: Definition

        Definition Object:
        Word
        Definition

        Used randomGenerator to generate random number to use for
        index and put 10 objects in a list to pull from. Used a list
        because it is ordered and has indexes. Returned using .get() array
        method and assigning it the variable for the random index.
         */

        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(10);

        List<Definition> listOfDefinitions = new ArrayList<>();
        Definition word1 = new Definition("lackadaisical", "Lacking life, spirit, or zest");
        Definition word2 = new Definition("compunction", "A feeling of guilt or moral scruple that prevents or follows the doing of something bad");
        Definition word3 = new Definition("groke", "To stare at somebody while they are eating and hope that they'll share");
        Definition word4 = new Definition("fudgel", "Pretending to work when you're not actually doing anything at all");
        Definition word5 = new Definition("dysania", "The state of finding it hard to get out of bed in the morning");
        Definition word6 = new Definition("ultracrepidarian", "A person who criticizes, judges, or gives advice outside of his or her expertise");
        Definition word7 = new Definition("kakistocracy", "A system of government which is run by the worst, least qualified, or most unscrupulous citizens");
        Definition word8 = new Definition("twattling", "A conversation or reports about other people, typically involving details which are not confirmed as true");
        Definition word9 = new Definition("slugabed", "A person who stays in bed after the usual or proper time to get up");
        Definition word10 = new Definition("frobly-mobly", "a way to say 'not bad' when someone asks you how you're doing");

        listOfDefinitions.add(word1);
        listOfDefinitions.add(word2);
        listOfDefinitions.add(word3);
        listOfDefinitions.add(word4);
        listOfDefinitions.add(word5);
        listOfDefinitions.add(word6);
        listOfDefinitions.add(word7);
        listOfDefinitions.add(word8);
        listOfDefinitions.add(word9);
        listOfDefinitions.add(word10);

        return listOfDefinitions.get(randomIndex);
    }
}