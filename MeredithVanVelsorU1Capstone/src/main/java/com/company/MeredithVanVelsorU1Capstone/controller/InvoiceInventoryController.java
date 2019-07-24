package com.company.MeredithVanVelsorU1Capstone.controller;

import com.company.MeredithVanVelsorU1Capstone.exception.NotFoundException;
import com.company.MeredithVanVelsorU1Capstone.service.ServiceLayer;
import com.company.MeredithVanVelsorU1Capstone.viewmodel.InvoiceViewModel;
import com.company.MeredithVanVelsorU1Capstone.viewmodel.OrderViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InvoiceInventoryController   {
    
    @Autowired
    ServiceLayer serviceLayer;
// moved to Order Controller
    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public InvoiceViewModel createInvoice(@RequestBody @Valid OrderViewModel orderViewModel) {
        return serviceLayer.calculateOrder(orderViewModel);
    }

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public InvoiceViewModel getInvoice(@PathVariable("id") int id) {
        InvoiceViewModel invoiceViewModel = serviceLayer.findInvoice(id);
        if (invoiceViewModel == null)
            throw new NotFoundException("Invoice could not be retrieved for given id: " + id);
        return invoiceViewModel;
    }


    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<InvoiceViewModel> getAllInvoices() {
        List<InvoiceViewModel> ivmList = serviceLayer.findAllInvoices();
        if (ivmList == null)
            throw new NotFoundException("Invoices could not be retrieved.");
        return ivmList;
    }

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateInvoice(@PathVariable("id") int id,
                              @RequestBody @Valid InvoiceViewModel invoiceViewModel) {
        if (invoiceViewModel.getInvoiceId() == 0)
            invoiceViewModel.setInvoiceId(id);
        if (id != invoiceViewModel.getInvoiceId()){
            throw new IllegalArgumentException(
                    "Invoice ID on path must match the ID in the Invoice object."
            );
        }
        serviceLayer.updateInvoice(invoiceViewModel);
    }

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteInvoice(@PathVariable(name = "id") int id) {
        serviceLayer.removeInvoice(id);
    }
}