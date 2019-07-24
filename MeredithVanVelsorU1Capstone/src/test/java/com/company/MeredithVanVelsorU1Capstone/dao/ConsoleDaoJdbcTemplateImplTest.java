package com.company.MeredithVanVelsorU1Capstone.dao;

import com.company.MeredithVanVelsorU1Capstone.model.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDaoJdbcTemplateImplTest {

    @Autowired
    ConsoleDao consoleDao;

    @Before
    public void setUp() throws Exception {
        List<Console> consoleList = consoleDao.getAllConsoles();
        consoleList.stream().forEach(console -> consoleDao.deleteConsole(console.getConsoleId()));
    }

    @Test
    public void addGetDeleteConsole() {
        Console console = new Console();
        console.setModel("LG");
        console.setManufacturer("BigName");
        console.setMemoryAmount("laughable");
        console.setProcessor("slow 2.0");
        console.setPrice(new BigDecimal("199.99"));
        console.setQuantity(new BigDecimal("3"));

        consoleDao.addConsole(console);

        assertEquals(console, consoleDao.getConsole(console.getConsoleId()));

        consoleDao.deleteConsole(console.getConsoleId());

        assertNull(consoleDao.getConsole(console.getConsoleId()));

    }

    @Test
    public void getAllConsolesAndGetAllByManufacturer() {
        Console console = new Console();
        console.setModel("LG");
        console.setManufacturer("BigName");
        console.setMemoryAmount("laughable");
        console.setProcessor("slow 2.0");
        console.setPrice(new BigDecimal("199.99"));
        console.setQuantity(new BigDecimal("3"));

        consoleDao.addConsole(console);

        Console console1 = new Console();
        console1.setModel("Sony");
        console1.setManufacturer("XBOX");
        console1.setMemoryAmount("huge");
        console1.setProcessor("fast 3.0");
        console1.setPrice(new BigDecimal("499.99"));
        console1.setQuantity(new BigDecimal("2"));

        consoleDao.addConsole(console1);

        List<Console> consoleList = consoleDao.getAllConsoles();

        assertEquals(consoleList.size(), 2);

        List<Console> conByManuList = consoleDao.getAllConsolesByManufacturer("XBOX");

        //put all manufacturer console into list
        //then compare list size to int value
        assertEquals(1,conByManuList.size());

    }

    @Test
    public void updateConsole() {
        Console console = new Console();
        console.setModel("LG");
        console.setManufacturer("BigName");
        console.setMemoryAmount("laughable");
        console.setProcessor("slow 2.0");
        console.setPrice(new BigDecimal("199.99"));
        console.setQuantity(new BigDecimal("3"));

        consoleDao.addConsole(console);

        console.setModel("XBOX");
        console.setPrice(new BigDecimal("599.99"));

        consoleDao.updateConsole(console);

        assertEquals(console, consoleDao.getConsole(console.getConsoleId()));
    }

    @Test
    public void updateQtyForConsole(){
        Console console = new Console();
        console.setModel("LG");
        console.setManufacturer("BigName");
        console.setMemoryAmount("laughable");
        console.setProcessor("slow 2.0");
        console.setPrice(new BigDecimal("199.99"));
        console.setQuantity(new BigDecimal("3"));

        consoleDao.addConsole(console);

        consoleDao.updateQtyForConsole(3, 3);

        assertEquals(console, consoleDao.getConsole(console.getConsoleId()));
    }

}