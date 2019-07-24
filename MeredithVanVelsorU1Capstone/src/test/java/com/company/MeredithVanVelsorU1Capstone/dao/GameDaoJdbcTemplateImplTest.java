package com.company.MeredithVanVelsorU1Capstone.dao;

import com.company.MeredithVanVelsorU1Capstone.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoJdbcTemplateImplTest {

    @Autowired
    GameDao gameDao;

    @Before
    public void setUp() throws Exception {
        List<Game> gameList = gameDao.getAllGames();
        gameList.stream().forEach(game -> gameDao.deleteGame(game.getGameId()));
    }

    @Test
    public void addGetDeleteGame() {
        Game game = new Game();
        game.setTitle("Game of Thrones");
        game.setEsrbRating("X");
        game.setDescription("Battle of the Sexes");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("ABC Studio");
        game.setQuantity(new BigDecimal("1"));

        game = gameDao.addGame(game);

        Game game1 = gameDao.getGame(game.getGameId());
        assertEquals(game, game1);

        gameDao.deleteGame(game.getGameId());
        game1 = gameDao.getGame(game.getGameId());

        assertNull(game1);
    }

    @Test
    public void getAllGamesOrByStudioOrByEsrbRatingOrByTitle() {
        Game game = new Game();
        game.setTitle("Game of Thrones");
        game.setEsrbRating("X");
        game.setDescription("Battle of the Sexes");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("ABC Studio");
        game.setQuantity(new BigDecimal("1"));

        gameDao.addGame(game);

        Game game1 = new Game();
        game1.setTitle("Warzone");
        game1.setEsrbRating("R");
        game1.setDescription("Bloody");
        game1.setPrice(new BigDecimal("39.99"));
        game1.setStudio("XYZ Studio");
        game1.setQuantity(new BigDecimal("1"));

        gameDao.addGame(game1);

        List<Game> gameList = gameDao.getAllGames();

        assertEquals(gameList.size(), 2);

        List<Game> gameByStudioList = gameDao.getAllGamesByStudio("XYZ Studio");
        //put all manufacturer console into list
        //then compare list size to int value
        assertEquals(1,gameByStudioList.size());

        List<Game> gameByEsrbList = gameDao.getAllGamesByEsrbRating("R");
        assertEquals(1, gameByEsrbList.size());

        List<Game> gameByTitleList = gameDao.getAllGamesByTitle("Warzone");
        assertEquals(1, gameByTitleList.size());
    }

    @Test
    public void updateGame() {
        Game game = new Game();
        game.setTitle("Game of Thrones");
        game.setEsrbRating("X");
        game.setDescription("Battle of the Sexes");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("ABC Studio");
        game.setQuantity(new BigDecimal("1"));

        gameDao.addGame(game);

        game.setQuantity(new BigDecimal("3"));
        game.setPrice(new BigDecimal("69.99"));

        gameDao.updateGame(game);

        assertEquals(game, gameDao.getGame(game.getGameId()));
    }

    @Test
    public void updateQtyForGame(){
        Game game = new Game();
        game.setTitle("Game of Thrones");
        game.setEsrbRating("X");
        game.setDescription("Battle of the Sexes");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("ABC Studio");
        game.setQuantity(new BigDecimal("1"));

        gameDao.addGame(game);

        gameDao.updateQtyForGame(3, 3);

        assertEquals(game, gameDao.getGame(game.getGameId()));
    }
}