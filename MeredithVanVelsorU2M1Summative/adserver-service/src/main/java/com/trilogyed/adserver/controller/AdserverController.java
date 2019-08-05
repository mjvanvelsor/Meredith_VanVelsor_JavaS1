package com.trilogyed.adserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class AdserverController {

//    @Autowired
//    private DiscoveryClient discoveryClient;
//    private RestTemplate restTemplate = new RestTemplate();
//
//    @Value("$taskerService")
//    private String taskerService;
//
//    @Value("${serviceProtocol}")
//    private String serviceProtocol;
//
//    @Value("${servicePath}")
//    private String servicePath;

    private String[] ads = {
            "Home Equity Loans @ 3.87% APR",
            "Click HERE to qualify for a new car loan!",
            "Super Sale on summer clothes!",
            "Summer Show Blowout!!! 30% to 50% off!!!!",
            "Get a new phone NOW!",
            "Alaskan Cruises for as low as $700!",
            "BOGO large 2 topping pizzas!",
            "Free installation with the purchase of 100 square feet of carpet!"
    };

    private Random rnd = new Random();

    @RequestMapping(value = "/ad", method = RequestMethod.GET)
    String getAd() {
        return ads[rnd.nextInt(8)];
    }
}
