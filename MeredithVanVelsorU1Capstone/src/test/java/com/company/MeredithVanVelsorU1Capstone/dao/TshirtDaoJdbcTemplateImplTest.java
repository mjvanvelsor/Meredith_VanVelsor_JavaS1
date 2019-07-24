package com.company.MeredithVanVelsorU1Capstone.dao;

import com.company.MeredithVanVelsorU1Capstone.model.Tshirt;
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
public class TshirtDaoJdbcTemplateImplTest {

    @Autowired
    TshirtDao tshirtDao;

    @Before
    public void setUp() throws Exception {
        List<Tshirt> tshirtList = tshirtDao.getAllTshirts();
        tshirtList.stream().forEach(tshirt -> tshirtDao.deleteTshirt(tshirt.gettShirtId()));
    }

    @Test
    public void addGetDeleteTshirt() {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Large");
                tshirt.setColor("Blue");
                tshirt.setDescription("Cotton");
                tshirt.setPrice(new BigDecimal("14.99"));
                tshirt.setQuantity(new BigDecimal("1"));

        tshirt = tshirtDao.addTshirt(tshirt);

        Tshirt tshirt1 = tshirtDao.getTshirt(tshirt.gettShirtId());
        assertEquals(tshirt, tshirt1);

        tshirtDao.deleteTshirt(tshirt.gettShirtId());
        tshirt1 = tshirtDao.getTshirt(tshirt.gettShirtId());

        assertNull(tshirt1);
    }

    @Test
    public void getAllTshirtsOrBySizeOrByColor() {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Large");
        tshirt.setColor("Blue");
        tshirt.setDescription("Cotton");
        tshirt.setPrice(new BigDecimal("14.99"));
        tshirt.setQuantity(new BigDecimal("1"));

        tshirt = tshirtDao.addTshirt(tshirt);

        Tshirt tshirt1 = new Tshirt();
        tshirt1.setSize("Medium");
        tshirt1.setColor("Red");
        tshirt1.setDescription("Cotton");
        tshirt1.setPrice(new BigDecimal("13.99"));
        tshirt1.setQuantity(new BigDecimal("1"));

        tshirt1 = tshirtDao.addTshirt(tshirt1);

        List<Tshirt> tshirtList = tshirtDao.getAllTshirts();

        assertEquals(tshirtList.size(), 2);

        List<Tshirt> tshirtListBySize = tshirtDao.getAllTshirtsBySize("Medium");
        //put all manufacturer console into list
        //then compare list size to int value
        assertEquals(1,tshirtListBySize.size());

        List<Tshirt> tshirtListByColor = tshirtDao.getAllTshirtsByColor("Red");
        assertEquals(1, tshirtListByColor.size());
    }

    @Test
    public void updateTshirt() {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Small");
        tshirt.setColor("Green");
        tshirt.setDescription("Cotton");
        tshirt.setPrice(new BigDecimal("12.99"));
        tshirt.setQuantity(new BigDecimal("1"));

        tshirt = tshirtDao.addTshirt(tshirt);

        tshirt.setQuantity(new BigDecimal("3"));
        tshirt.setPrice(new BigDecimal("69.99"));

        tshirtDao.updateTshirt(tshirt);

        assertEquals(tshirt, tshirtDao.getTshirt(tshirt.gettShirtId()));
    }

    @Test
    public void updateQtyForTshirt(){
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Small");
        tshirt.setColor("Green");
        tshirt.setDescription("Cotton");
        tshirt.setPrice(new BigDecimal("12.99"));
        tshirt.setQuantity(new BigDecimal("1"));

        tshirt = tshirtDao.addTshirt(tshirt);

        tshirtDao.updateQtyForTshirt(3, 3);

        assertEquals(tshirt, tshirtDao.getTshirt(tshirt.gettShirtId()));
    }

}