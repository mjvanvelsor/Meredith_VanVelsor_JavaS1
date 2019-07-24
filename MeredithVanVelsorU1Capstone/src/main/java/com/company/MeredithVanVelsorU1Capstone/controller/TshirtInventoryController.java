package com.company.MeredithVanVelsorU1Capstone.controller;

import com.company.MeredithVanVelsorU1Capstone.exception.NotFoundException;
import com.company.MeredithVanVelsorU1Capstone.service.ServiceLayer;
import com.company.MeredithVanVelsorU1Capstone.viewmodel.TshirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class TshirtInventoryController {

    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(value = "/tshirt", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TshirtViewModel createTshirt(@RequestBody @Valid TshirtViewModel tshirtViewModel) {
        return serviceLayer.saveTshirt(tshirtViewModel);
    }

    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TshirtViewModel getTshirt(@PathVariable("id") int id) {
        TshirtViewModel tshirtViewModel = serviceLayer.findTshirt(id);
        if (tshirtViewModel == null)
            throw new NotFoundException("Tshirt could not be retrieved for given id: " + id);
        return tshirtViewModel;
    }

    @RequestMapping(value = "/tshirts", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TshirtViewModel> getAllTshirts() {
        List<TshirtViewModel> tvmList = serviceLayer.findAllTshirts();
        if (tvmList == null)
            throw new NotFoundException("Tshirts could not be retrieved.");
        return tvmList;
    }

    @RequestMapping(value = "/tshirt/size/{size}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TshirtViewModel> getTshirtBySize(@PathVariable("size") String size) {
        List<TshirtViewModel> tvmListBySize = serviceLayer.findTshirtBySize(size);
        if (tvmListBySize == null)
            throw new NotFoundException("Tshirts could not be retrieved for size: " + size);
        return tvmListBySize;
    }

    @RequestMapping(value = "/tshirt/color/{color}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TshirtViewModel> getTshirtByColor(@PathVariable("color") String color) {
        List<TshirtViewModel> tvmListByColor = serviceLayer.findTshirtByColor(color);
        if (tvmListByColor == null)
            throw new NotFoundException("Tshirts could not be retrieved for color: " + color);
        return tvmListByColor;
    }

    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateTshirt(@PathVariable("id") int id,
                             @RequestBody @Valid TshirtViewModel tshirtViewModel) {
        if (tshirtViewModel.gettShirtId() == 0)
            tshirtViewModel.settShirtId(id);
        if (id != tshirtViewModel.gettShirtId()){
            throw new IllegalArgumentException(
                    "Tshirt ID on path must match the ID in the Tshirt object."
            );
        }
        serviceLayer.updateTshirt(tshirtViewModel);
    }

    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable(name = "id") int id) {
        serviceLayer.removeTshirt(id);
    }
}
