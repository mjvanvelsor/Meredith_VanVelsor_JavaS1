package com.company.MeredithVanVelsorU1Capstone.service;

import com.company.MeredithVanVelsorU1Capstone.dao.*;
import com.company.MeredithVanVelsorU1Capstone.model.*;
import com.company.MeredithVanVelsorU1Capstone.viewmodel.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {

    ConsoleDao consoleDao;
    GameDao gameDao;
    TshirtDao tshirtDao;
    InvoiceDao invoiceDao;
    TaxDao taxDao;
    ProcessingFeeDao processingFeeDao;
    ServiceLayer serviceLayer;

    @Before
    public void setUp() throws Exception {

        setUpConsoleDaoMock();
        setUpTshirtDaoMock();
        setUpGameDaoMock();
        setUpInvoiceDaoMock();
        setUpTaxDaoMock();
        setUpProcessingFeeMock();

        serviceLayer = new ServiceLayer(consoleDao, gameDao, tshirtDao, invoiceDao, taxDao, processingFeeDao);
    }

    private void setUpConsoleDaoMock() {
        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);

        Console console = new Console();
        console.setConsoleId(1);
        console.setModel("Lion 2.0");
        console.setManufacturer("Sony");
        console.setMemoryAmount("a lot");
        console.setProcessor("256 snake");
        console.setPrice(new BigDecimal("199.99"));
        console.setQuantity(new BigDecimal("1"));

        Console console1 = new Console();
        console1.setModel("Lion 2.0");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("a lot");
        console1.setProcessor("256 snake");
        console1.setPrice(new BigDecimal("199.99"));
        console1.setQuantity(new BigDecimal("1"));

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(console);

        doReturn(console).when(consoleDao).addConsole(console1);
        doReturn(console).when(consoleDao).getConsole(1);
        doReturn(consoleList).when(consoleDao).getAllConsoles();
        doReturn(consoleList).when(consoleDao).getAllConsolesByManufacturer("Sony");
    }
    private void setUpTshirtDaoMock() {
        tshirtDao = mock(TshirtDaoJdbcTemplateImpl.class);

        Tshirt tshirt = new Tshirt();
        tshirt.settShirtId(1);
        tshirt.setSize("small");
        tshirt.setColor("red");
        tshirt.setDescription("cotton");
        tshirt.setPrice(new BigDecimal("4.99"));
        tshirt.setQuantity(new BigDecimal("1"));

        Tshirt tshirt1 = new Tshirt();
        tshirt1.setSize("small");
        tshirt1.setColor("red");
        tshirt1.setDescription("cotton");
        tshirt1.setPrice(new BigDecimal("4.99"));
        tshirt1.setQuantity(new BigDecimal("1"));

        List<Tshirt> tshirtList = new ArrayList<>();
        tshirtList.add(tshirt);

        doReturn(tshirt).when(tshirtDao).addTshirt(tshirt1);
        doReturn(tshirt).when(tshirtDao).getTshirt(1);
        doReturn(tshirtList).when(tshirtDao).getAllTshirts();
        doReturn(tshirtList).when(tshirtDao).getAllTshirtsByColor("red");
        doReturn(tshirtList).when(tshirtDao).getAllTshirtsBySize("small");
    }
    private void setUpGameDaoMock() {
        gameDao = mock(GameDaoJdbcTemplateImpl.class);

        Game game = new Game();
        game.setGameId(1);
        game.setTitle("Warzone");
        game.setEsrbRating("R");
        game.setDescription("Gory");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("ABC Studio");
        game.setQuantity(new BigDecimal("4"));

        Game game1 = new Game();
        game1.setTitle("Warzone");
        game1.setEsrbRating("R");
        game1.setDescription("Gory");
        game1.setPrice(new BigDecimal("49.99"));
        game1.setStudio("ABC Studio");
        game1.setQuantity(new BigDecimal("4"));

        List<Game> gameList = new ArrayList<>();
        gameList.add(game);

        doReturn(game).when(gameDao).addGame(game1);
        doReturn(game).when(gameDao).getGame(1);
        doReturn(gameList).when(gameDao).getAllGames();
        doReturn(gameList).when(gameDao).getAllGamesByStudio("ABC Studio");
        doReturn(gameList).when(gameDao).getAllGamesByEsrbRating("R");
        doReturn(gameList).when(gameDao).getAllGamesByTitle("Warzone");
    }
    private void setUpInvoiceDaoMock() {
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(1);
        invoice.setName("Cookie Monster");
        invoice.setStreet("123 Sesame Street");
        invoice.setCity("Orlando");
        invoice.setState("FL");
        invoice.setZipcode("12345");
        invoice.setItemType("t-shirts");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("4.99"));
        invoice.setQuantity(new BigDecimal("1"));
        invoice.setSubtotal(new BigDecimal("4.99"));
        invoice.setTax(new BigDecimal("0.30"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("7.27"));

        Invoice invoice1 = new Invoice();
        invoice1.setName("Cookie Monster");
        invoice1.setStreet("123 Sesame Street");
        invoice1.setCity("Orlando");
        invoice1.setState("FL");
        invoice1.setZipcode("12345");
        invoice1.setItemType("t-shirts");
        invoice1.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("4.99"));
        invoice.setQuantity(new BigDecimal("1"));
        invoice.setSubtotal(new BigDecimal("4.99"));
        invoice.setTax(new BigDecimal("0.30"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("7.27"));

        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoice);

        doReturn(invoice).when(invoiceDao).addInvoice(invoice1);
        doReturn(invoice).when(invoiceDao).getInvoice(1);
        doReturn(invoiceList).when(invoiceDao).getAllInvoices();
    }
    private void setUpTaxDaoMock(){
        taxDao = mock(TaxDaoJdbcTemplateImpl.class);
        Tax tax = new Tax();
        tax.setRate(new BigDecimal("0.06"));
        tax.setState("FL");

        doReturn(tax).when(taxDao).getTaxRateByState("FL");
    }
    private void setUpProcessingFeeMock(){
        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);
        ProcessingFee fee = new ProcessingFee();
        fee.setProductType("t-shirts");
        fee.setFee(new BigDecimal("1.98"));
        doReturn(fee).when(processingFeeDao).getProcessingFeeByType("t-shirts");
    }

// Invoice

    @Test
    public void saveFindInvoice(){
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setInvoiceId(1);
        ivm.setName("Cookie Monster");
        ivm.setStreet("123 Sesame Street");
        ivm.setCity("Orlando");
        ivm.setState("FL");
        ivm.setZipcode("12345");
        ivm.setItemType("t-shirts");
        ivm.setItemId(1);
        ivm.setUnitPrice(new BigDecimal("4.99"));
        ivm.setQuantity(new BigDecimal("1"));
        ivm.setSubtotal(new BigDecimal("4.99"));
        ivm.setTax(new BigDecimal("0.30"));
        ivm.setProcessingFee(new BigDecimal("1.98"));
        ivm.setTotal(new BigDecimal("7.27"));

        InvoiceViewModel ivm2 = serviceLayer.saveInvoice(ivm);
        assertEquals(ivm, ivm2);
        ivm2 = serviceLayer.findInvoice(1);
        assertEquals(ivm, ivm2);
    }

    @Test
    public void calculateOrderFindAllInvoice() {
        OrderViewModel ovm = new OrderViewModel();
        ovm.setName("Cookie Monster");
        ovm.setStreet("123 Sesame Street");
        ovm.setCity("Orlando");
        ovm.setState("FL");
        ovm.setZipcode("12345");
        ovm.setItemType("t-shirts");
        ovm.setItemId(1);
        ovm.setQuantity(new BigDecimal("1"));

        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setName("Cookie Monster");
        ivm.setStreet("123 Sesame Street");
        ivm.setCity("Orlando");
        ivm.setState("FL");
        ivm.setZipcode("12345");
        ivm.setItemType("t-shirts");
        ivm.setItemId(1);
        ivm.setQuantity(new BigDecimal("1"));
        ivm.setUnitPrice(new BigDecimal("4.99"));
        ivm.setQuantity(new BigDecimal("1"));
        ivm.setSubtotal(new BigDecimal("4.99"));
        ivm.setTax(new BigDecimal("0.30"));
        ivm.setProcessingFee(new BigDecimal("1.98"));
        ivm.setTotal(new BigDecimal("7.27"));

        InvoiceViewModel fromService = serviceLayer.calculateOrder(ovm);
        assertEquals(ivm, fromService);

        List<InvoiceViewModel> ivmList = serviceLayer.findAllInvoices();
        assertEquals(1, ivmList.size());
    }
    @Test
    public void updateInvoice() {
        InvoiceViewModel invoiceViewModel = serviceLayer.findInvoice(1);
        invoiceViewModel.setName("Cookie Monster");
        invoiceViewModel.setStreet("123 Sesame Street");
        invoiceViewModel.setCity("Miami");
        invoiceViewModel.setState("FL");
        invoiceViewModel.setZipcode("12345");
        invoiceViewModel.setItemType("tshirt");
        invoiceViewModel.setItemId(1);
        invoiceViewModel.setUnitPrice(new BigDecimal("9.99"));
        invoiceViewModel.setQuantity(new BigDecimal("3"));
        invoiceViewModel.setSubtotal(new BigDecimal("9.99"));
        invoiceViewModel.setTax(new BigDecimal("9.99"));
        invoiceViewModel.setProcessingFee(new BigDecimal("9.99"));
        invoiceViewModel.setTotal(new BigDecimal("9.99"));

        serviceLayer.updateInvoice(invoiceViewModel);

        ArgumentCaptor<Invoice> invoiceCaptor = ArgumentCaptor.forClass(Invoice.class);
        verify(invoiceDao).updateInvoice(invoiceCaptor.capture());
        assertEquals(invoiceViewModel.getCity(), invoiceCaptor.getValue().getCity());
    }
    @Test
    public void removeInvoice() {
        InvoiceViewModel invoiceViewModel = serviceLayer.findInvoice(1);
        serviceLayer.removeInvoice(1);

        ArgumentCaptor<Integer> invoiceCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(invoiceDao).deleteInvoice(invoiceCaptor.capture());
        assertEquals(invoiceViewModel.getInvoiceId(), invoiceCaptor.getValue().intValue());
    }

// Console
    @Test
    public void saveFindFindAllFindAllByManuConsole() {
        ConsoleViewModel cvm = new ConsoleViewModel();
        cvm.setModel("Lion 2.0");
        cvm.setManufacturer("Sony");
        cvm.setMemoryAmount("a lot");
        cvm.setProcessor("256 snake");
        cvm.setPrice(new BigDecimal("199.99"));
        cvm.setQuantity(new BigDecimal("1"));

        cvm = serviceLayer.saveConsole(cvm);

        ConsoleViewModel cvm1 = serviceLayer.findConsole(cvm.getConsoleId());
        assertEquals(cvm, cvm1);

        List<ConsoleViewModel> cvmList = serviceLayer.findAllConsoles();
        assertEquals(1, cvmList.size());
        assertEquals(cvm, cvmList.get(0));
        serviceLayer.findConsolesByManufacturer("Sony");
        assertEquals(1, cvmList.size());
    }
    @Test
    public void updateConsole() {
        ConsoleViewModel consoleVM = serviceLayer.findConsole(1);
        consoleVM.setModel("Lion 2.0");
        consoleVM.setManufacturer("XBOX");
        consoleVM.setMemoryAmount("a lot");
        consoleVM.setProcessor("256 snake");
        consoleVM.setPrice(new BigDecimal("199.99"));
        consoleVM.setQuantity(new BigDecimal("1"));

        serviceLayer.updateConsole(consoleVM);

        ArgumentCaptor<Console> consoleCaptor = ArgumentCaptor.forClass(Console.class);
        verify(consoleDao).updateConsole(consoleCaptor.capture());
        assertEquals(consoleVM.getManufacturer(), consoleCaptor.getValue().getManufacturer());
    }
    @Test
    public void removeConsole() {
        ConsoleViewModel consoleVM = serviceLayer.findConsole(1);
        serviceLayer.removeConsole(1);

        ArgumentCaptor<Integer> consoleCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(consoleDao).deleteConsole(consoleCaptor.capture());
        assertEquals(consoleVM.getConsoleId(), consoleCaptor.getValue().intValue());
    }
// Tshirt
    @Test
    public void saveFindFindAllTshirt() {
        TshirtViewModel tshirt = new TshirtViewModel();
        tshirt.setSize("small");
        tshirt.setColor("red");
        tshirt.setDescription("cotton");
        tshirt.setPrice(new BigDecimal("4.99"));
        tshirt.setQuantity(new BigDecimal("1"));

        tshirt = serviceLayer.saveTshirt(tshirt);

        TshirtViewModel tshirt1 = serviceLayer.findTshirt(tshirt.gettShirtId());
        assertEquals(tshirt, tshirt1);

        List<TshirtViewModel> tvmList = serviceLayer.findAllTshirts();
        assertEquals(1, tvmList.size());
        assertEquals(tshirt, tvmList.get(0));
    }
    @Test
    public void findTshirtBySize() {
        TshirtViewModel tshirt = new TshirtViewModel();
        tshirt.setSize("small");
        tshirt.setColor("red");
        tshirt.setDescription("cotton");
        tshirt.setPrice(new BigDecimal("4.99"));
        tshirt.setQuantity(new BigDecimal("1"));

        tshirt = serviceLayer.saveTshirt(tshirt);

        TshirtViewModel tshirt1 = serviceLayer.findTshirt(tshirt.gettShirtId());
        assertEquals(tshirt, tshirt1);

        List<TshirtViewModel> tvmList = serviceLayer.findTshirtBySize("small");
        assertEquals(1, tvmList.size());

    }
    @Test
    public void findTshirtByColor() {
        TshirtViewModel tshirt = new TshirtViewModel();
        tshirt.setSize("small");
        tshirt.setColor("red");
        tshirt.setDescription("cotton");
        tshirt.setPrice(new BigDecimal("4.99"));
        tshirt.setQuantity(new BigDecimal("1"));

        tshirt = serviceLayer.saveTshirt(tshirt);

        TshirtViewModel tshirt1 = serviceLayer.findTshirt(tshirt.gettShirtId());
        assertEquals(tshirt, tshirt1);

        List<TshirtViewModel> tvmList = serviceLayer.findTshirtByColor("red");
        assertEquals(1, tvmList.size());
    }
    @Test
    public void updateTshirt() {
        TshirtViewModel tshirtVM = serviceLayer.findTshirt(1);
        tshirtVM.setSize("small");
        tshirtVM.setColor("blue");
        tshirtVM.setDescription("cotton");
        tshirtVM.setPrice(new BigDecimal("10.99"));
        tshirtVM.setQuantity(new BigDecimal("3"));

        serviceLayer.updateTshirt(tshirtVM);

        ArgumentCaptor<Tshirt> tshirtCaptor = ArgumentCaptor.forClass(Tshirt.class);
        verify(tshirtDao).updateTshirt(tshirtCaptor.capture());
        assertEquals(tshirtVM.getColor(), tshirtCaptor.getValue().getColor());
    }
    @Test
    public void removeTshirt() {
        TshirtViewModel tshirtViewModel = serviceLayer.findTshirt(1);
        serviceLayer.removeTshirt(1);

        ArgumentCaptor<Integer> tshirtCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(tshirtDao).deleteTshirt(tshirtCaptor.capture());
        assertEquals(tshirtViewModel.gettShirtId(), tshirtCaptor.getValue().intValue());
    }
// Game
    @Test
    public void saveFindFindAllGame() {
        GameViewModel game = new GameViewModel();
        game.setTitle("Warzone");
        game.setEsrbRating("R");
        game.setDescription("Gory");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("ABC Studio");
        game.setQuantity(new BigDecimal("4"));

        game = serviceLayer.saveGame(game);
        GameViewModel fromService = serviceLayer.findGame(game.getGameId());
        assertEquals(game, fromService);

        List<GameViewModel> gvmList = serviceLayer.findAllGames();
        assertEquals(1, gvmList.size());
        assertEquals(game, gvmList.get(0));
    }
    @Test
    public void findGamesByStudio() {
        GameViewModel game = new GameViewModel();
        game.setTitle("Warzone");
        game.setEsrbRating("R");
        game.setDescription("Gory");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("ABC Studio");
        game.setQuantity(new BigDecimal("4"));

        game = serviceLayer.saveGame(game);

        List<GameViewModel> gvmList = serviceLayer.findGamesByStudio("ABC Studio");
        assertEquals(1, gvmList.size());
        assertEquals(game, gvmList.get(0));
    }
    @Test
    public void findGamesByEsrbRating() {
        GameViewModel game = new GameViewModel();
        game.setTitle("Warzone");
        game.setEsrbRating("R");
        game.setDescription("Gory");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("ABC Studio");
        game.setQuantity(new BigDecimal("4"));

        game = serviceLayer.saveGame(game);

        List<GameViewModel> gvmList = serviceLayer.findGamesByEsrbRating("R");
        assertEquals(1, gvmList.size());
        assertEquals(game, gvmList.get(0));
    }
    @Test
    public void findGamesByTitle() {
        GameViewModel game = new GameViewModel();
        game.setTitle("Warzone");
        game.setEsrbRating("R");
        game.setDescription("Gory");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("ABC Studio");
        game.setQuantity(new BigDecimal("4"));

        game = serviceLayer.saveGame(game);

        List<GameViewModel> gvmList = serviceLayer.findGamesByTitle("Warzone");
        assertEquals(1, gvmList.size());
        assertEquals(game, gvmList.get(0));
    }
    @Test
    public void updateGame() {
        GameViewModel gameVM = serviceLayer.findGame(1);
        gameVM.setTitle("Warzone");
        gameVM.setEsrbRating("U");
        gameVM.setDescription("Bloody");
        gameVM.setPrice(new BigDecimal("49.99"));
        gameVM.setStudio("ABC Studio");
        gameVM.setQuantity(new BigDecimal("4"));

        serviceLayer.updateGame(gameVM);

        ArgumentCaptor<Game> gameCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameDao).updateGame(gameCaptor.capture());
        assertEquals(gameVM.getDescription(), gameCaptor.getValue().getDescription());
    }
    @Test
    public void removeGame() {
        GameViewModel gameVM = serviceLayer.findGame(1);
        serviceLayer.removeGame(1);

        ArgumentCaptor<Integer> gameCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(gameDao).deleteGame(gameCaptor.capture());
        assertEquals(gameVM.getGameId(), gameCaptor.getValue().intValue());
    }
}