package com.company.MeredithVanVelsorU1Capstone.dao;

import com.company.MeredithVanVelsorU1Capstone.model.Game;

import java.math.BigDecimal;
import java.util.List;

public interface GameDao {
    Game addGame(Game game);

    Game getGame(int id);

    List<Game> getAllGames();

    void updateGame(Game game);

    void updateQtyForGame(int id, int quantity);

    void deleteGame(int id);

    List<Game> getAllGamesByStudio(String studio);

    List<Game> getAllGamesByEsrbRating(String esrbRating);

    List<Game> getAllGamesByTitle(String title);

}
