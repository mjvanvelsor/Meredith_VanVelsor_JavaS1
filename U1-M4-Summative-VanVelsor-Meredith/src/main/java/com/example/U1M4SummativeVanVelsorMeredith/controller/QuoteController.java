package com.example.U1M4SummativeVanVelsorMeredith.controller;

import com.example.U1M4SummativeVanVelsorMeredith.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController     // Tells Spring this is a restful API
public class QuoteController {

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    // routing app to the URI '/quote'
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuote(){

        /*
        Instructions:
        Your solution must have the following structural elements:
        Your solution must be in an IntelliJ project called U1-M4-Summative-Lastname-Firstname.
        Your project must be built using Spring Boot and Spring MVC. Initialize your project using start.spring.io.
        Your project must have an in-memory DAO that follows the pattern shown in this module.
        Your REST API must accept and return data in JSON format where appropriate.
        Your REST API must be documented with Swagger. Save the .yaml file in the root of your project directory.

        Quote API:
        URI: /quote
        HTTP Method: GET (POST/GET/PUT/DELETE)(CREATE/RETRIEVE/UPDATE/DELETE)
        Request Body: None
        Response Body: Quote

        Quote Object:
        Author
        Quote

        Used randomGenerator to generate random number to use for
        index and put 10 objects in a list to pull from. Used a list
        because it is ordered and has indexes. Returned using .get() array
        method and assigning it the variable for the random index.
         */

        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(10);

        List<Quote> listOfQuotes = new ArrayList<>();
        Quote quote1 = new Quote("Goofy - A Goofy Movie", "Uh, could you back a bit, Mr. Foot? You're outta focus.");
        Quote quote2 = new Quote("Winny - Hocus Pocus", "Oh, look! Another glorious morning; makes me sick!");
        Quote quote3 = new Quote("Anastasia - Anastasia", "Do you really think I'm royalty? Then stop bossing me around!");
        Quote quote4 = new Quote("Mushu - Mulan", "And all because Miss Man decided to take her little drag show on the road.");
        Quote quote5 = new Quote("Rafiki - The Lion King", "The past hurts, but you can either run from it or learn from it.");
        Quote quote6 = new Quote("Dory - Finding Nemo", "When life gets you down, you know what ya gotta do? Just keep swimming.");
        Quote quote7 = new Quote("Genie - Aladdin", "Phenomenal Cosmic Powers... itty bitty living space.");
        Quote quote8 = new Quote("Hiccup - How to Train Your Dragon", "You just gestured to ALL of me.");
        Quote quote9 = new Quote("Marie - Aristocats", "'Cause I'm a lady, that's why!");
        Quote quote10 = new Quote("Marie - Aristocats", "Ladies don't start fights, but they can finish them.");

        listOfQuotes.add(quote1);
        listOfQuotes.add(quote2);
        listOfQuotes.add(quote3);
        listOfQuotes.add(quote4);
        listOfQuotes.add(quote5);
        listOfQuotes.add(quote6);
        listOfQuotes.add(quote7);
        listOfQuotes.add(quote8);
        listOfQuotes.add(quote9);
        listOfQuotes.add(quote10);

        return listOfQuotes.get(randomIndex);
    }
}
