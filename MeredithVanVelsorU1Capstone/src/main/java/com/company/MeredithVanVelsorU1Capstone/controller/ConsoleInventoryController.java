package com.company.MeredithVanVelsorU1Capstone.controller;

import com.company.MeredithVanVelsorU1Capstone.exception.NotFoundException;
import com.company.MeredithVanVelsorU1Capstone.service.ServiceLayer;
import com.company.MeredithVanVelsorU1Capstone.viewmodel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ConsoleInventoryController {

    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(value = "/console", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ConsoleViewModel createConsole(@RequestBody @Valid ConsoleViewModel consoleViewModel) {
        return serviceLayer.saveConsole(consoleViewModel);
    }

    @RequestMapping(value = "/console/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable("id") int id) {
        ConsoleViewModel consoleViewModel = serviceLayer.findConsole(id);
        if (consoleViewModel == null)
            throw new NotFoundException("Console could not be retrieved for given id: " + id);
        return consoleViewModel;
    }

    @RequestMapping(value = "/consoles", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<ConsoleViewModel> getAllConsoles() {
        List<ConsoleViewModel> cvmList = serviceLayer.findAllConsoles();
        if (cvmList == null)
            throw new NotFoundException("Consoles could not be retrieved.");
        return cvmList;
    }

    @RequestMapping(value = "/console/manufacturer/{manufacturer}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<ConsoleViewModel> getConsolesByManufacturer(@PathVariable("manufacturer") String manufacturer) {
        List<ConsoleViewModel> cvmListByManu = serviceLayer.findConsolesByManufacturer(manufacturer);
        if (cvmListByManu == null)
            throw new NotFoundException("Consoles could not be retrieved for : " + manufacturer);
        return cvmListByManu;
    }

    @RequestMapping(value = "/console/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateConsole(@PathVariable("id") int id,
                              @RequestBody @Valid ConsoleViewModel consoleViewModel) {
        if (consoleViewModel.getConsoleId() == 0)
            consoleViewModel.setConsoleId(id);
        if (id != consoleViewModel.getConsoleId()) {
            throw new IllegalArgumentException(
                    "Console ID on path must match the ID in the Console object."
            );
        }
        serviceLayer.updateConsole(consoleViewModel);
    }

    @RequestMapping(value = "/console/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable(name = "id") int id) {
        serviceLayer.removeConsole(id);
    }
}
