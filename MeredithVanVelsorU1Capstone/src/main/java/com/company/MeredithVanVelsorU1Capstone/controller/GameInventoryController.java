package com.company.MeredithVanVelsorU1Capstone.controller;

import com.company.MeredithVanVelsorU1Capstone.exception.NotFoundException;
import com.company.MeredithVanVelsorU1Capstone.service.ServiceLayer;
import com.company.MeredithVanVelsorU1Capstone.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GameInventoryController {
    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public GameViewModel createGame(@RequestBody @Valid GameViewModel gameViewModel) {
        return serviceLayer.saveGame(gameViewModel);
    }

    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public GameViewModel readGame(@PathVariable("id") int id) {
        GameViewModel gameViewModel = serviceLayer.findGame(id);
        if (gameViewModel == null)
            throw new NotFoundException("Game could not be retrieved for id: " + id);
        return gameViewModel;
    }

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getAllGames() {
        List<GameViewModel> gvmList = serviceLayer.findAllGames();
        if (gvmList == null)
            throw new NotFoundException("Games could not be retrieved.");
        return gvmList;
    }

    @RequestMapping(value = "/game/studio/{studio}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getGameByStudio(@PathVariable("studio") String studio) {
        List<GameViewModel> gvmListByStudio = serviceLayer.findGamesByStudio(studio);
        if (gvmListByStudio == null)
            throw new NotFoundException("Games could not be retrieved for : " + studio);
        return gvmListByStudio;
    }

    @RequestMapping(value = "/game/esrbrating/{esrbrating}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getGameByEsrbRating(@PathVariable("esrbrating") String esrbRating) {
        List<GameViewModel> tvmListByRating = serviceLayer.findGamesByEsrbRating(esrbRating);
        if (tvmListByRating == null)
            throw new NotFoundException("Games could not be retrieved for ESRB Rating: " + esrbRating);
        return tvmListByRating;
    }

    @RequestMapping(value = "/game/title/{title}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getGameByTitle(@PathVariable("title") String title) {
        List<GameViewModel> tvmListByTitle = serviceLayer.findGamesByTitle(title);
        if (tvmListByTitle == null)
            throw new NotFoundException("Games could not be retrieved for title: " + title);
        return tvmListByTitle;
    }

    @RequestMapping(value = "/game/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateGame(@PathVariable("id") int id,
                           @RequestBody @Valid GameViewModel gameViewModel) {
        if (gameViewModel.getGameId() == 0)
            gameViewModel.setGameId(id);
        if (id != gameViewModel.getGameId()) {
            throw new IllegalArgumentException(
                    "Game ID on path must match the ID in the Game object."
            );
        }
        serviceLayer.updateGame(gameViewModel);
    }

    @RequestMapping(value = "/game/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable("id") int id) {
        serviceLayer.removeGame(id);
    }
}