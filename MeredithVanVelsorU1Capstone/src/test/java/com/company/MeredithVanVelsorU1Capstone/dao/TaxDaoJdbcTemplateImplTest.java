package com.company.MeredithVanVelsorU1Capstone.dao;

import com.company.MeredithVanVelsorU1Capstone.model.Tax;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaxDaoJdbcTemplateImplTest {

    @Autowired
    TaxDao taxDao;

    @Test
    public void getTaxRateByState() {
        Tax NcStateTax = new Tax();
        NcStateTax.setRate(new BigDecimal(".05"));
        NcStateTax.setState("NC");

        Tax taxFromDb = taxDao.getTaxRateByState("NC");
        assertEquals(taxFromDb, NcStateTax);

        Tax AzStateTax = new Tax();
        AzStateTax.setRate(new BigDecimal(".04"));
        AzStateTax.setState("AZ");

        Tax taxFromDb2 = taxDao.getTaxRateByState("AZ");
        assertEquals(taxFromDb2, AzStateTax);
    }


}