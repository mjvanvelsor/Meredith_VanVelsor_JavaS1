package com.company.MeredithVanVelsorU1Capstone.dao;

import com.company.MeredithVanVelsorU1Capstone.model.Console;

import java.math.BigDecimal;
import java.util.List;

public interface ConsoleDao {
    Console addConsole(Console console);

    Console getConsole(int id);

    List<Console> getAllConsoles();

    void updateConsole(Console console);

    void updateQtyForConsole(int id, int quantity);

    void deleteConsole(int id);

    List<Console> getAllConsolesByManufacturer(String manufacturer);
}
