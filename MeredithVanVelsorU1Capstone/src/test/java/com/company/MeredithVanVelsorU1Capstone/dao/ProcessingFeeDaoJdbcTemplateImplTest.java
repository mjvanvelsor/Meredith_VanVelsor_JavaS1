package com.company.MeredithVanVelsorU1Capstone.dao;

import com.company.MeredithVanVelsorU1Capstone.model.*;
import org.junit.After;
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
public class ProcessingFeeDaoJdbcTemplateImplTest {

    @Autowired
    ProcessingFeeDao processingFeeDao;

    @Test
    public void getProcessingFeeByType() {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(new BigDecimal("14.99"));
        processingFee.setProductType("Consoles");

        ProcessingFee consoleFromDb = processingFeeDao.getProcessingFeeByType("Consoles");
        assertEquals(consoleFromDb, processingFee);

        ProcessingFee processingFee1 = new ProcessingFee();
        processingFee1.setFee(new BigDecimal("1.49"));
        processingFee1.setProductType("Games");

        ProcessingFee gameFromDb = processingFeeDao.getProcessingFeeByType("Games");
        assertEquals(gameFromDb, processingFee1);

        ProcessingFee processingFee2 = new ProcessingFee();
        processingFee2.setFee(new BigDecimal("1.98"));
        processingFee2.setProductType("T-Shirts");

        ProcessingFee tshirtFromDb = processingFeeDao.getProcessingFeeByType("T-Shirts");
        assertEquals(tshirtFromDb, processingFee2);

    }
}