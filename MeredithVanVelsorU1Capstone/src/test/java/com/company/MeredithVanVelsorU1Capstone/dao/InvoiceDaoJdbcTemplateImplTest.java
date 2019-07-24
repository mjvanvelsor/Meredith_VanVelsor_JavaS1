package com.company.MeredithVanVelsorU1Capstone.dao;

import com.company.MeredithVanVelsorU1Capstone.model.Invoice;
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
public class InvoiceDaoJdbcTemplateImplTest {

    @Autowired
    InvoiceDao invoiceDao;

    @Before
    public void setUp() throws Exception {
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        invoiceList.stream().forEach(invoice -> invoiceDao.deleteInvoice(invoice.getInvoiceId()));
    }

    @Test
    public void addGetDeleteInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Meredith VanVelsor");
        invoice.setStreet("2510 Cranbrook Lane");
        invoice.setCity("Charlotte");
        invoice.setState("NC");
        invoice.setZipcode("28207");
        invoice.setItemType("T-Shirt");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("12.99"));
        invoice.setQuantity(new BigDecimal("2"));
        invoice.setSubtotal(new BigDecimal("13.98"));
        invoice.setTax(new BigDecimal(".03"));
        invoice.setProcessingFee(new BigDecimal("9.99"));
        invoice.setTotal(new BigDecimal("14.00"));

        invoiceDao.addInvoice(invoice);

        assertEquals(invoice, invoiceDao.getInvoice(invoice.getInvoiceId()));

        invoiceDao.deleteInvoice(invoice.getInvoiceId());

        assertNull(invoiceDao.getInvoice(invoice.getInvoiceId()));

    }

    @Test
    public void getAllInvoices() {
        Invoice invoice = new Invoice();
        invoice.setName("Meredith VanVelsor");
        invoice.setStreet("2510 Cranbrook Lane");
        invoice.setCity("Charlotte");
        invoice.setState("NC");
        invoice.setZipcode("28207");
        invoice.setItemType("T-Shirt");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("12.99"));
        invoice.setQuantity(new BigDecimal("2"));
        invoice.setSubtotal(new BigDecimal("13.98"));
        invoice.setTax(new BigDecimal(".03"));
        invoice.setProcessingFee(new BigDecimal("9.99"));
        invoice.setTotal(new BigDecimal("14.00"));

        invoiceDao.addInvoice(invoice);

        Invoice invoice1 = new Invoice();
        invoice1.setName("Cookie Monster");
        invoice1.setStreet("123 Sesame Stree");
        invoice1.setCity("Orlando");
        invoice1.setState("FL");
        invoice1.setZipcode("45698");
        invoice1.setItemType("T-Shirt");
        invoice1.setItemId(1);
        invoice1.setUnitPrice(new BigDecimal("12.99"));
        invoice1.setQuantity(new BigDecimal("1"));
        invoice1.setSubtotal(new BigDecimal("13.98"));
        invoice1.setTax(new BigDecimal(".03"));
        invoice1.setProcessingFee(new BigDecimal("9.99"));
        invoice1.setTotal(new BigDecimal("14.00"));

        invoiceDao.addInvoice(invoice1);

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();

        assertEquals(invoiceList.size(), 2);
    }

    @Test
    public void updateInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Meredith VanVelsor");
        invoice.setStreet("2510 Cranbrook Lane");
        invoice.setCity("Charlotte");
        invoice.setState("NC");
        invoice.setZipcode("28207");
        invoice.setItemType("T-Shirt");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("12.99"));
        invoice.setQuantity(new BigDecimal("2"));
        invoice.setSubtotal(new BigDecimal("13.98"));
        invoice.setTax(new BigDecimal(".03"));
        invoice.setProcessingFee(new BigDecimal("9.99"));
        invoice.setTotal(new BigDecimal("14.00"));

        invoiceDao.addInvoice(invoice);

        invoice.setCity("Raleigh");
        invoice.setItemType("Console");

        invoiceDao.updateInvoice(invoice);

        assertEquals(invoice, invoiceDao.getInvoice(invoice.getInvoiceId()));
    }

}