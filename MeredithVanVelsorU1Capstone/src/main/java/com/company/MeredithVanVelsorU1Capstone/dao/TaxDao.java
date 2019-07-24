package com.company.MeredithVanVelsorU1Capstone.dao;

import com.company.MeredithVanVelsorU1Capstone.model.Tax;

import java.util.List;

public interface TaxDao {

    Tax getTaxRateByState(String state);
    List<String> getAllStates();

}
