package com.company.MeredithVanVelsorU1M5Summative.dao;

import com.company.MeredithVanVelsorU1M5Summative.dto.Book;
import com.company.MeredithVanVelsorU1M5Summative.dto.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
// this is an integration test not a jUnit test because
// it has a database
// AAA pattern is used (Arrange, Act, Assert)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherDaoJdbctemplateImplTest {

    // needs to be accessible to other pieces in this package
    // dependency injection: we do not instantiate bc we want
    // Spring to do it
    // must add annotation 'autowired' to tell Spring to do this
    @Autowired
    protected AuthorDao authorDao;
    @Autowired
    protected PublisherDao publisherDao;
    @Autowired
    protected BookDao bookDao;

    // 'before' annotation tells spring to run this before each
    // of the other test methods are run.
    // 'good state' empty DAO so this will delete all publishers
    // out of the database

    @Before // need to clean out the test db
    public void setUp() throws Exception {
        // Clean up the test db
        List<Book> bookList = bookDao.getAllBooks();
        for (Book b : bookList) {
            bookDao.deleteBook(b.getBookId());
        }

        List<Publisher> pList = publisherDao.getAllPublishers();
        for (Publisher p : pList) {
            publisherDao.deletePublisher(p.getPublisherId());
        }

    }

    @Test   // jUnit annotation that tells jUnit and Spring that this is a test
    public void addGetDeletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Magical Publishers");
        publisher.setStreet("404 Typo Circle");
        publisher.setCity("Charlotte");
        publisher.setState("NC");
        publisher.setPostalCode("28207");
        publisher.setPhone("704-820-2916");
        publisher.setEmail("hello@magicalpublishers.com");

        // id will be generated when added to DB
        publisher = publisherDao.addPublisher(publisher);

        // will go retrieve the publisher added to
        // bring back this variable with autogenerated id
        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisherId());

        // this tests that the getPublisher method is working
        // correctly and everything is working
        assertEquals(publisher, publisher1);

        // this deletes the one we just made with id
        publisherDao.deletePublisher(publisher.getPublisherId());

        // this assigns publisher to publisher1
        publisher1 = publisherDao
                .getPublisher(publisher.getPublisherId());

        // this tests that the publisher1 was deleted properly
        assertNull(publisher1);
    }

    @Test
    public void getAllPublishers() {
        Publisher publisher = new Publisher();
        publisher.setName("Magical Publishers");
        publisher.setStreet("404 Typo Circle");
        publisher.setCity("Charlotte");
        publisher.setState("NC");
        publisher.setPostalCode("28207");
        publisher.setPhone("704-820-2916");
        publisher.setEmail("hello@magicalpublishers.com");

        publisherDao.addPublisher(publisher);

        // publisher is overwritten but is already written to db
        publisher = new Publisher();
        publisher.setName("Wizarding World Publishers");
        publisher.setStreet("662 Tryon Road");
        publisher.setCity("Charlotte");
        publisher.setState("NC");
        publisher.setPostalCode("28216");
        publisher.setPhone("704-935-5421");
        publisher.setEmail("hello@wizardingworldpublishers.com");

        publisherDao.addPublisher(publisher);

        // populates new list with all publishers in DB
        List<Publisher> publisherList = publisherDao.getAllPublishers();

        // tests the expected value to the number of publishers
        // added to the list
        assertEquals(2, publisherList.size());
    }

    @Test
    public void updatePublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("Magical Publishers");
        publisher.setStreet("404 Typo Circle");
        publisher.setCity("Charlotte");
        publisher.setState("NC");
        publisher.setPostalCode("28207");
        publisher.setPhone("704-820-2916");
        publisher.setEmail("hello@magicalpublishers.com");

        publisherDao.addPublisher(publisher);

        publisher.setName("Ministry of Magical Publishers");
        publisher.setStreet("404 Typo Circle");
        publisher.setCity("Charlotte");
        publisher.setState("NC");
        publisher.setPostalCode("28207");
        publisher.setPhone("704-820-2916");
        publisher.setEmail("hello@ministryofmagicalpublishers.com");

        // updates same publisher with new information
        publisherDao.updatePublisher(publisher);

        // retrieves publisher with autoincremented id that was
        // assign in the first place
        // along with the NEW updated information from publisher1
        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisherId());

        // this tests that publisher was updated correctly to publisher1
        assertEquals(publisher1, publisher);
    }
}