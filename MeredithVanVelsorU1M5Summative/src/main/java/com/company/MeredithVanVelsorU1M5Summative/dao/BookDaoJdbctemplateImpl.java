package com.company.MeredithVanVelsorU1M5Summative.dao;

import com.company.MeredithVanVelsorU1M5Summative.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
// This class holds the data for the database so this annotation is required.
@Repository  // is a spring annotation - declares this as a repository and alerts Spring of it's presence
public class BookDaoJdbctemplateImpl implements BookDao{
    // need to set prepared statements and constants (permanent variables) to prevent
    // sql injection attacks (green is prepared statements)
    //Prepared Statements + Constants
    private static final String INSERT_BOOK_SQL =
            "insert into book (isbn, publish_date, author_id, title, publisher_id, price) "
                    + "values (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_BOOK_SQL =
            "select * from book where book_id = ?";

    private static final String SELECT_ALL_BOOKS_SQL =
            "select * from book";

    private static final String DELETE_BOOK_SQL =
            "delete from book where book_id = ?";

    private static final String UPDATE_BOOK_SQL =
            "update book set isbn = ?, publish_date = ?, author_id = ?, title = ?, publisher_id = ?, price = ? where book_id = ?";

    private static final String SELECT_BOOKS_BY_AUTHOR =
            "select * from book where author_id = ?";

    //Jdbc Template property
    private JdbcTemplate jdbcTemplate;
    // needs constructor and annotation to inject. Called 'constructor injection'
    @Autowired
    public BookDaoJdbctemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    // this makes this method do ALL of the pieces or roll back because otherwise it
    // is vulnerable to someone else updating at the same time and returning the wrong
    // 'last inserted id' and thus the wrong book
    @Transactional
    public Book addBook(Book book) {
        // uses update method to insert data into DB
        // pass in all the parameters as needed
        jdbcTemplate.update(INSERT_BOOK_SQL, book.getIsbn(), book.getPublishDate(), book.getAuthorId(), book.getTitle(),
                book.getPublisherId(), book.getPrice());
        // pass in the 'select last insert id' to call function in sql and
        // retrieve what I just created in an Integer format
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        book.setBookId(id);
        return book;
    }

    @Override
    public Book getBook(int id) {
        // uses row mapper method and query for object method
        // uses id to create book object
        try{
            return jdbcTemplate.queryForObject(SELECT_BOOK_SQL, this::mapRowToBook, id);
        } catch (EmptyResultDataAccessException e){
            // if there is no match for this book_id, return null
            return null;
        }
    }

    @Override
    public List<Book> getAllBooks() {
        // using query bc there will be more than one thing returned
        return jdbcTemplate.query(SELECT_ALL_BOOKS_SQL, this::mapRowToBook);
    }

    @Override
    public void updateBook(Book book) {
        jdbcTemplate.update(UPDATE_BOOK_SQL, book.getIsbn(), book.getPublishDate(), book.getAuthorId(), book.getTitle(),
                book.getPublisherId(), book.getPrice(), book.getBookId());
    }

    @Override
    public void deleteBook(int id) {
        // has to use update because jdbc can only do query / query for object
        // or update. Update is the only one that changes the others add.
        jdbcTemplate.update(DELETE_BOOK_SQL, id);
    }

    @Override
    public List<Book> getBooksByAuthor(int authorId) {
        return jdbcTemplate.query(
                SELECT_BOOKS_BY_AUTHOR,
                this::mapRowToBook,
                authorId);
    }

    // Helper Methods
    private Book mapRowToBook(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBookId(rs.getInt("book_id"));
        book.setIsbn(rs.getString("isbn"));
        book.setPublishDate(rs.getDate("publish_date").toLocalDate());
        book.setAuthorId(rs.getInt("author_id"));
        book.setTitle(rs.getString("title"));
        book.setPrice(rs.getFloat("price"));
        book.setPublisherId(rs.getInt("publisher_id"));

        return book;
    }

}
