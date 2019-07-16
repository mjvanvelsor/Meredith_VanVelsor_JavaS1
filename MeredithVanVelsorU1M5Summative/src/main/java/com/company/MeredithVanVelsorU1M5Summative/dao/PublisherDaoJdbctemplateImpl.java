package com.company.MeredithVanVelsorU1M5Summative.dao;

import com.company.MeredithVanVelsorU1M5Summative.dto.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PublisherDaoJdbctemplateImpl implements PublisherDao {
    // Add a publisher - prepared statement
    private static final String INSERT_PUBLISHER_SQL =
            "insert into publisher (name, street, city, state, postal_code, phone, email) "
                    + "values (?, ?, ?, ?, ?, ?, ?)";
    // Get a publisher - prepared statement
    private static final String SELECT_PUBLISHER_SQL =
            "select * from publisher where publisher_id = ?";
    // Get all publishers - prepared statement
    private static final String SELECT_ALL_PUBLISHERS_SQL =
            "select * from publisher";
    // Delete a publisher - prepared statement
    private static final String DELETE_PUBLISHER_SQL =
            "delete from publisher where publisher_id = ?";
    // Update a publisher - prepared statement
    private static final String UPDATE_PUBLISHER_SQL =
            "update publisher set name = ?, street = ?, city = ?, state = ?, " +
                    "postal_code = ?, phone = ?, email = ? where publisher_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PublisherDaoJdbctemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Publisher addPublisher(Publisher publisher) {
        jdbcTemplate.update(INSERT_PUBLISHER_SQL, publisher.getName(), publisher.getStreet(), publisher.getCity(),
                publisher.getState(), publisher.getPostalCode(), publisher.getPhone(), publisher.getEmail());
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        publisher.setPublisherId(id);
        return publisher;
    }

    @Override
    public Publisher getPublisher(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_PUBLISHER_SQL, this::mapRowToPublisher, id);
        } catch (EmptyResultDataAccessException e){
            // if there is no publisher with this id
            return null;
        }
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return jdbcTemplate.query(SELECT_ALL_PUBLISHERS_SQL, this::mapRowToPublisher);
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        jdbcTemplate.update(UPDATE_PUBLISHER_SQL, publisher.getName(), publisher.getStreet(), publisher.getCity(),
                publisher.getState(), publisher.getPostalCode(), publisher.getPhone(), publisher.getEmail(), publisher.getPublisherId());
    }

    @Override
    public void deletePublisher(int id) {
        jdbcTemplate.update(DELETE_PUBLISHER_SQL, id);
    }

    // Helper Methods
    private Publisher mapRowToPublisher(ResultSet rs, int rowNum) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(rs.getInt("publisher_id"));
        publisher.setName(rs.getString("name"));
        publisher.setStreet(rs.getString("street"));
        publisher.setCity(rs.getString("city"));
        publisher.setState(rs.getString("state"));
        publisher.setPostalCode(rs.getString("postal_code"));
        publisher.setPhone(rs.getString("phone"));
        publisher.setEmail(rs.getString("email"));

        return publisher;
    }
}
