package com.company.MeredithVanVelsorU1Capstone.dao;

import com.company.MeredithVanVelsorU1Capstone.model.Tshirt;

import java.util.List;

public interface TshirtDao {
    Tshirt addTshirt(Tshirt tshirt);

    Tshirt getTshirt(int id);

    List<Tshirt> getAllTshirts();

    void updateTshirt(Tshirt tshirt);

    void updateQtyForTshirt(int id, int quantity);

    void deleteTshirt(int id);

    List<Tshirt> getAllTshirtsByColor(String color);

    List<Tshirt> getAllTshirtsBySize(String size);
}
