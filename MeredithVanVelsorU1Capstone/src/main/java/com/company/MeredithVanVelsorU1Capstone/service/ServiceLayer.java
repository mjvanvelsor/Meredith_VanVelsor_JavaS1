package com.company.MeredithVanVelsorU1Capstone.service;

import com.company.MeredithVanVelsorU1Capstone.dao.*;
import com.company.MeredithVanVelsorU1Capstone.model.*;
import com.company.MeredithVanVelsorU1Capstone.viewmodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    ConsoleDao consoleDao;
    GameDao gameDao;
    TshirtDao tshirtDao;
    InvoiceDao invoiceDao;
    TaxDao taxDao;
    ProcessingFeeDao processingFeeDao;

    @Autowired
    public ServiceLayer(ConsoleDao consoleDao, GameDao gameDao, TshirtDao tshirtDao, InvoiceDao invoiceDao, TaxDao taxDao, ProcessingFeeDao processingFeeDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.tshirtDao = tshirtDao;
        this.invoiceDao = invoiceDao;
        this.taxDao = taxDao;
        this.processingFeeDao = processingFeeDao;
    }

    /**
     * ORDER API
     */
    private Invoice validateQtyAndAdjustInventory(OrderViewModel orderViewModel) {
        Invoice invoice = buildInvoiceFromOVM(orderViewModel);
        // Order quantity must be greater than 0.
        if (orderViewModel.getQuantity().intValue() < 1) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        // Order quantity must be <= number of items in inventory.
        if (orderViewModel.getItemType().equalsIgnoreCase("t-shirts")) {
            Tshirt tshirt = tshirtDao.getTshirt(orderViewModel.getItemId());
            if (tshirt.getQuantity().intValue() >= orderViewModel.getQuantity().intValue()) {
                tshirtDao.updateQtyForTshirt(orderViewModel.getItemId(), orderViewModel.getQuantity().intValue());
                invoice.setItemType(orderViewModel.getItemType());
                invoice.setItemId(orderViewModel.getItemId());
                invoice.setUnitPrice(tshirt.getPrice());
                invoice.setSubtotal(tshirt.getPrice().multiply(orderViewModel.getQuantity()).setScale(2, RoundingMode.HALF_UP));
            }
        } else if (orderViewModel.getItemType().equalsIgnoreCase("consoles")) {
            Console console = consoleDao.getConsole(orderViewModel.getItemId());
            if (console.getQuantity().intValue() >= orderViewModel.getQuantity().intValue()) {
                consoleDao.updateQtyForConsole(orderViewModel.getItemId(), orderViewModel.getQuantity().intValue());
                invoice.setItemType(orderViewModel.getItemType());
                invoice.setItemId(orderViewModel.getItemId());
                invoice.setUnitPrice(console.getPrice());
                invoice.setSubtotal(console.getPrice().multiply(orderViewModel.getQuantity()).setScale(2, RoundingMode.HALF_UP));
            }
        } else if (orderViewModel.getItemType().equalsIgnoreCase("games")) {
            Game game = gameDao.getGame(orderViewModel.getItemId());
            if (game.getQuantity().intValue() >= orderViewModel.getQuantity().intValue()) {
                gameDao.updateQtyForGame(orderViewModel.getItemId(), orderViewModel.getQuantity().intValue());
                invoice.setItemType(orderViewModel.getItemType());
                invoice.setItemId(orderViewModel.getItemId());
                invoice.setUnitPrice(game.getPrice());
                invoice.setSubtotal(game.getPrice().multiply(orderViewModel.getQuantity()).setScale(2, RoundingMode.HALF_UP));
            }
        } else {
            throw new IllegalArgumentException("Item type entered is invalid.");
        }
        invoice.setQuantity(orderViewModel.getQuantity());
        return invoice;
    }

    public InvoiceViewModel calculateOrder(OrderViewModel orderViewModel) {
        Invoice invoice = validateQtyAndAdjustInventory(orderViewModel);
        invoice.setProcessingFee(calculateProcessingFee(orderViewModel));
        calculateTax(invoice);

        //  invoice calculation
        invoice.setTotal(invoice.getSubtotal().add(invoice.getProcessingFee().add(invoice.getTax())));
        return buildInvoiceViewModel(invoice);
    }

    /**
     * PROCESSING FEE CALCULATION
     * processing fee is applied only once per order regardless of the number of items in the order
     * unless the number of items on the order is greater than 10 in which case
     * an additional processing fee of $15.49 is applied to the order.
     * if quantity is <= 10, fee * 1; else fee + 15.49
     *
     * @param orderViewModel
     */
    private BigDecimal calculateProcessingFee(OrderViewModel orderViewModel) {
        ProcessingFee fee = new ProcessingFee();
        if (orderViewModel.getItemType().equalsIgnoreCase("t-shirts")) {
            Tshirt tshirt = tshirtDao.getTshirt(orderViewModel.getItemId());
            if (orderViewModel.getQuantity().intValue() <= 10) {
                fee = processingFeeDao.getProcessingFeeByType("t-shirts");
            } else {
                fee.setFee(processingFeeDao.getProcessingFeeByType("t-shirts").getFee().add(new BigDecimal("15.49")));
            }
        } else if (orderViewModel.getItemType().equalsIgnoreCase("consoles")) {
            Console console = consoleDao.getConsole(orderViewModel.getItemId());
            if (orderViewModel.getQuantity().intValue() <= 10) {
                fee = processingFeeDao.getProcessingFeeByType("consoles");
            } else {
                fee.setFee(processingFeeDao.getProcessingFeeByType("consoles").getFee().add(new BigDecimal("15.49")));
            }
        } else if (orderViewModel.getItemType().equalsIgnoreCase("games")) {
            Game game = gameDao.getGame(orderViewModel.getItemId());
            if (orderViewModel.getQuantity().intValue() <= 10) {
                fee = processingFeeDao.getProcessingFeeByType("games");
            } else {
                fee.setFee(processingFeeDao.getProcessingFeeByType("games").getFee().add(new BigDecimal("15.49")));
            }
        }
        return fee.getFee();
    }

    /**
     * SALES TAX CALCULATION
     * Sales tax applies only to the cost of the items.
     * Sales tax does not apply to any processing fees for an invoice.
     *
     * @param invoice
     * @return
     */
    private void calculateTax(Invoice invoice) {
        // order must contain a valid state code
        invoice.setTax(taxDao.getTaxRateByState(invoice.getState()).getRate().multiply(invoice.getSubtotal()).setScale(2, RoundingMode.HALF_UP));
    }

    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel) {
        return invoiceViewModel;
    }

    /**
     * INVOICE API
     */
    public InvoiceViewModel findInvoice(int id) {
        Invoice invoice = invoiceDao.getInvoice(id);
        if (invoice == null)
            return null;
        else
            return buildInvoiceViewModel(invoice);
    }

    public List<InvoiceViewModel> findAllInvoices() {
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        List<InvoiceViewModel> ivmList = new ArrayList<>();

        for (Invoice invoice : invoiceList) {
            ivmList.add(buildInvoiceViewModel(invoice));
        }

        return ivmList;
    }

    public void updateInvoice(InvoiceViewModel invoiceViewModel) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(invoiceViewModel.getInvoiceId());
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipcode(invoiceViewModel.getZipcode());
        invoice.setItemType(invoiceViewModel.getItemType());
        invoice.setItemId(invoiceViewModel.getItemId());
        invoice.setUnitPrice(invoiceViewModel.getUnitPrice());
        invoice.setQuantity(invoiceViewModel.getQuantity());
        invoice.setSubtotal(invoiceViewModel.getSubtotal());
        invoice.setTax(invoiceViewModel.getTax());
        invoice.setProcessingFee(invoiceViewModel.getProcessingFee());
        invoice.setTotal(invoiceViewModel.getTotal());

        invoiceDao.updateInvoice(invoice);
    }

    public void removeInvoice(int id) {
        invoiceDao.deleteInvoice(id);
    }

    /**
     * CONSOLE API
     */
    @Transactional
    public ConsoleViewModel saveConsole(ConsoleViewModel consoleViewModel) {
        Console console = new Console();
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());

        consoleViewModel.setConsoleId(consoleDao.addConsole(console).getConsoleId());
        return consoleViewModel;
    }

    public ConsoleViewModel findConsole(int id) {
        Console console = consoleDao.getConsole(id);
        if (console == null)
            return null;
        else
            return buildConsoleViewModel(console);
    }

    public List<ConsoleViewModel> findAllConsoles() {
        List<Console> consoleList = consoleDao.getAllConsoles();
        List<ConsoleViewModel> cvmList = new ArrayList<>();

        for (Console console : consoleList) {
            cvmList.add(buildConsoleViewModel(console));
        }

        return cvmList;
    }

    public List<ConsoleViewModel> findConsolesByManufacturer(String manufacturer) {
        List<Console> consoleListByManu = consoleDao.getAllConsolesByManufacturer(manufacturer);
        List<ConsoleViewModel> cvmListByManu = new ArrayList<>();

        for (Console console : consoleListByManu) {
            cvmListByManu.add(buildConsoleViewModel(console));
        }

        return cvmListByManu;
    }

    @Transactional
    public void updateConsole(ConsoleViewModel consoleViewModel) {
        Console console = new Console();
        console.setConsoleId(consoleViewModel.getConsoleId());
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());
        consoleDao.updateConsole(console);
    }

    public void removeConsole(int id) {
        consoleDao.deleteConsole(id);
    }

    /**
     * TSHIRT API
     */
    @Transactional
    public TshirtViewModel saveTshirt(TshirtViewModel tshirtViewModel) {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize(tshirtViewModel.getSize());
        tshirt.setColor(tshirtViewModel.getColor());
        tshirt.setDescription(tshirtViewModel.getDescription());
        tshirt.setPrice(tshirtViewModel.getPrice());
        tshirt.setQuantity(tshirtViewModel.getQuantity());

        tshirtViewModel.settShirtId(tshirtDao.addTshirt(tshirt).gettShirtId());
        return tshirtViewModel;
    }

    public TshirtViewModel findTshirt(int id) {
        Tshirt tshirt = tshirtDao.getTshirt(id);
        if (tshirt == null)
            return null;
        else
            return buildTshirtViewModel(tshirt);
    }

    public List<TshirtViewModel> findAllTshirts() {
        List<Tshirt> tshirtList = tshirtDao.getAllTshirts();
        List<TshirtViewModel> tvmList = new ArrayList<>();

        for (Tshirt tshirt : tshirtList) {
            tvmList.add(buildTshirtViewModel(tshirt));
        }

        return tvmList;
    }

    public List<TshirtViewModel> findTshirtBySize(String size) {
        List<Tshirt> tshirtList = tshirtDao.getAllTshirtsBySize(size);
        List<TshirtViewModel> tvmListBySize = new ArrayList<>();

        for (Tshirt tshirt : tshirtList) {
            tvmListBySize.add(buildTshirtViewModel(tshirt));
        }

        return tvmListBySize;
    }

    public List<TshirtViewModel> findTshirtByColor(String color) {
        List<Tshirt> tshirtList = tshirtDao.getAllTshirtsByColor(color);
        List<TshirtViewModel> tvmListByColor = new ArrayList<>();

        for (Tshirt tshirt : tshirtList) {
            tvmListByColor.add(buildTshirtViewModel(tshirt));
        }

        return tvmListByColor;
    }

    @Transactional
    public void updateTshirt(TshirtViewModel tshirtViewModel) {
        Tshirt tshirt1 = new Tshirt();
        tshirt1.settShirtId(tshirtViewModel.gettShirtId());
        tshirt1.setSize(tshirtViewModel.getSize());
        tshirt1.setColor(tshirtViewModel.getColor());
        tshirt1.setDescription(tshirtViewModel.getDescription());
        tshirt1.setPrice(tshirtViewModel.getPrice());
        tshirt1.setQuantity(tshirtViewModel.getQuantity());
        tshirtDao.updateTshirt(tshirt1);
    }

    public void removeTshirt(int id) {
        tshirtDao.deleteTshirt(id);
    }

    /**
     * GAME API
     */
    @Transactional
    public GameViewModel saveGame(GameViewModel gameViewModel) {
        Game game1 = new Game();
        game1.setTitle(gameViewModel.getTitle());
        game1.setEsrbRating(gameViewModel.getEsrbRating());
        game1.setDescription(gameViewModel.getDescription());
        game1.setPrice(gameViewModel.getPrice());
        game1.setStudio(gameViewModel.getStudio());
        game1.setQuantity(gameViewModel.getQuantity());

        gameViewModel.setGameId(gameDao.addGame(game1).getGameId());
        return gameViewModel;
    }

    public GameViewModel findGame(int id) {
        Game game = gameDao.getGame(id);
        if (game == null)
            return null;
        else
            return buildGameViewModel(game);
    }

    public List<GameViewModel> findAllGames() {
        List<Game> gameList = gameDao.getAllGames();
        List<GameViewModel> gvmList = new ArrayList<>();

        for (Game game : gameList) {
            gvmList.add(buildGameViewModel(game));
        }

        return gvmList;
    }

    public List<GameViewModel> findGamesByStudio(String studio) {
        List<Game> gameList = gameDao.getAllGamesByStudio(studio);
        List<GameViewModel> gvmListByStudio = new ArrayList<>();

        for (Game game : gameList) {
            gvmListByStudio.add(buildGameViewModel(game));
        }

        return gvmListByStudio;
    }

    public List<GameViewModel> findGamesByEsrbRating(String esrbRating) {
        List<Game> gameList = gameDao.getAllGamesByEsrbRating(esrbRating);
        List<GameViewModel> gvmListByEsrbRating = new ArrayList<>();

        for (Game game : gameList) {
            gvmListByEsrbRating.add(buildGameViewModel(game));
        }

        return gvmListByEsrbRating;
    }

    public List<GameViewModel> findGamesByTitle(String title) {
        List<Game> gameList = gameDao.getAllGamesByTitle(title);
        List<GameViewModel> gvmListByTitle = new ArrayList<>();

        for (Game game : gameList) {
            gvmListByTitle.add(buildGameViewModel(game));
        }

        return gvmListByTitle;
    }

    @Transactional
    public void updateGame(GameViewModel gameViewModel) {
        Game game1 = new Game();
        game1.setGameId(gameViewModel.getGameId());
        game1.setTitle(gameViewModel.getTitle());
        game1.setEsrbRating(gameViewModel.getEsrbRating());
        game1.setDescription(gameViewModel.getDescription());
        game1.setPrice(gameViewModel.getPrice());
        game1.setStudio(gameViewModel.getStudio());
        game1.setQuantity(gameViewModel.getQuantity());
        gameDao.updateGame(game1);
    }

    public void removeGame(int id) {
        gameDao.deleteGame(id);
    }

    // Helper Methods
    private ConsoleViewModel buildConsoleViewModel(Console console) {
        ConsoleViewModel consoleViewModel = new ConsoleViewModel();
        consoleViewModel.setConsoleId(console.getConsoleId());
        consoleViewModel.setModel(console.getModel());
        consoleViewModel.setManufacturer(console.getManufacturer());
        consoleViewModel.setMemoryAmount(console.getMemoryAmount());
        consoleViewModel.setProcessor(console.getProcessor());
        consoleViewModel.setPrice(console.getPrice());
        consoleViewModel.setQuantity(console.getQuantity());
        return consoleViewModel;
    }

    private GameViewModel buildGameViewModel(Game game) {
        GameViewModel gameViewModel = new GameViewModel();
        gameViewModel.setGameId(game.getGameId());
        gameViewModel.setTitle(game.getTitle());
        gameViewModel.setEsrbRating(game.getEsrbRating());
        gameViewModel.setDescription(game.getDescription());
        gameViewModel.setPrice(game.getPrice());
        gameViewModel.setStudio(game.getStudio());
        gameViewModel.setQuantity(game.getQuantity());
        return gameViewModel;
    }

    private TshirtViewModel buildTshirtViewModel(Tshirt tshirt) {
        TshirtViewModel tshirtViewModel = new TshirtViewModel();
        tshirtViewModel.settShirtId(tshirt.gettShirtId());
        tshirtViewModel.setSize(tshirt.getSize());
        tshirtViewModel.setColor(tshirt.getColor());
        tshirtViewModel.setDescription(tshirt.getDescription());
        tshirtViewModel.setPrice(tshirt.getPrice());
        tshirtViewModel.setQuantity(tshirt.getQuantity());
        return tshirtViewModel;
    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setInvoiceId(invoice.getInvoiceId());
        invoiceViewModel.setName(invoice.getName());
        invoiceViewModel.setStreet(invoice.getStreet());
        invoiceViewModel.setCity(invoice.getCity());
        invoiceViewModel.setState(invoice.getState());
        invoiceViewModel.setZipcode(invoice.getZipcode());
        invoiceViewModel.setItemType(invoice.getItemType());
        invoiceViewModel.setItemId(invoice.getItemId());
        invoiceViewModel.setUnitPrice(invoice.getUnitPrice());
        invoiceViewModel.setQuantity(invoice.getQuantity());
        invoiceViewModel.setSubtotal(invoice.getSubtotal());
        invoiceViewModel.setTax(invoice.getTax());
        invoiceViewModel.setProcessingFee(invoice.getProcessingFee());
        invoiceViewModel.setTotal(invoice.getTotal());
        return invoiceViewModel;
    }

    private Invoice buildInvoiceFromOVM(OrderViewModel ovm) {
        Invoice invoice = new Invoice();
        invoice.setName(ovm.getName());
        invoice.setStreet(ovm.getStreet());
        invoice.setCity(ovm.getCity());
        invoice.setState(ovm.getState());
        invoice.setZipcode(ovm.getZipcode());
        invoice.setItemType(ovm.getItemType());
        invoice.setItemId(ovm.getItemId());
        invoice.setQuantity(ovm.getQuantity());
        return invoice;
    }

    private Invoice buildInvoiceFromIVM(InvoiceViewModel invoiceViewModel) {
        Invoice invoice = new Invoice();
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipcode(invoiceViewModel.getZipcode());
        invoice.setItemType(invoiceViewModel.getItemType());
        invoice.setItemId(invoiceViewModel.getItemId());
        invoice.setQuantity(invoiceViewModel.getQuantity());
        invoice.setUnitPrice(invoiceViewModel.getUnitPrice());
        invoice.setSubtotal(invoiceViewModel.getProcessingFee());
        invoice.setTax(invoiceViewModel.getTax());
        invoice.setProcessingFee(invoiceViewModel.getProcessingFee());
        invoice.setTotal(invoiceViewModel.getTotal());
        return invoice;
    }

}
