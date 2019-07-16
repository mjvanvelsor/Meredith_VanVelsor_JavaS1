package com.company.MeredithVanVelsorU1M5Summative.dao;

import com.company.MeredithVanVelsorU1M5Summative.dto.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
// This class holds the data for the database so this annotation is required.
@Repository     // is a spring annotation - declares this as a repository and alerts Spring of it's presence
public class AuthorDaoJdbctemplateImpl implements AuthorDao {
    // need to set prepared statements and constants (permanent variables) to prevent
    // sql injection attacks (green is prepared statements)
    //Prepared Statements + Constants
    // Used to prevent SQL Injection Attacks
    private static final String INSERT_AUTHOR_SQL =
            "insert into author (first_name, last_name, street, city, state, postal_code, phone, email) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_AUTHOR_SQL =
            "select * from author where author_id = ?";

    private static final String SELECT_ALL_AUTHORS_SQL =
            "select * from author";

    private static final String DELETE_AUTHOR_SQL =
            "delete from author where author_id = ?";

    private static final String UPDATE_AUTHOR_SQL =
            "update author set first_name = ?, last_name = ?, street = ?, city = ?, state = ?, " +
                    "postal_code = ?, phone = ?, email = ? where author_id = ?";

    private JdbcTemplate jdbcTemplate;
    // needs constructor and annotation to inject--example of constructor injection
    @Autowired
    public AuthorDaoJdbctemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    // this makes this method do ALL of the pieces or roll back because otherwise it
    // is vulnerable to someone else updating at the same time and returning the wrong
    // 'last inserted id' and thus the wrong author
    public Author addAuthor(Author author) {
        // uses update method to insert data into DB
        // pass in all the parameters as needed
        jdbcTemplate.update(INSERT_AUTHOR_SQL, author.getFirstName(), author.getLastName(), author.getStreet(),
                author.getCity(), author.getState(), author.getPostalCode(), author.getPhone(), author.getEmail());
        // pass in the 'select last insert id' to call function in sql and
        // retrieve what I just created in an Integer format
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        author.setAuthorId(id);
        return author;
    }

    @Override
    public Author getAuthor(int id) {
        // uses row mapper method and query for object method
        // uses id to create author object
        try {
            return jdbcTemplate.queryForObject(SELECT_AUTHOR_SQL, this::mapRowToAuthor, id);
        } catch (EmptyResultDataAccessException e){
            // if nothing is returned, just catch the exception and return null
            return null;
        }
    }

    @Override
    public List<Author> getAllAuthors() {
        // using query bc there will be more than one thing returned
        return jdbcTemplate.query(SELECT_ALL_AUTHORS_SQL, this::mapRowToAuthor);
    }

    @Override
    public void updateAuthor(Author author) {
        jdbcTemplate.update(UPDATE_AUTHOR_SQL, author.getFirstName(), author.getLastName(), author.getStreet(),
                author.getCity(), author.getState(), author.getPostalCode(), author.getPhone(), author.getEmail(), author.getAuthorId());
    }

    @Override
    public void deleteAuthor(int id) {
        // has to use update because jdbc can only do query / query for object
        // or update. Update is the only one that changes the others add.
        jdbcTemplate.update(DELETE_AUTHOR_SQL, id);
    }

    //Helper Methods
    private Author mapRowToAuthor(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setAuthorId(rs.getInt("author_id"));
        author.setFirstName(rs.getString("first_name"));
        author.setLastName(rs.getString("last_name"));
        author.setStreet(rs.getString("street"));
        author.setCity(rs.getString("city"));
        author.setState(rs.getString("state"));
        author.setPostalCode(rs.getString("postal_code"));
        author.setPhone(rs.getString("phone"));
        author.setEmail(rs.getString("email"));

        return author;
    }
}
