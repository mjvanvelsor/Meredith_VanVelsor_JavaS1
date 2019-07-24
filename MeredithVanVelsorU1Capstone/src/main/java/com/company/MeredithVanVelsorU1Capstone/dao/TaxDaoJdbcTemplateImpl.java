package com.company.MeredithVanVelsorU1Capstone.dao;

import com.company.MeredithVanVelsorU1Capstone.model.Tax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository

public class TaxDaoJdbcTemplateImpl implements TaxDao{

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public TaxDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SELECT_TAX_RATE_BY_STATE_SQL =
            "select * from sales_tax_rate where state = ?";

    private static final String SELECT_ALL_STATES_SQL =
            "select state from sales_tax_rate";

    @Override
    public Tax getTaxRateByState(String state) {
        return jdbcTemplate.queryForObject(SELECT_TAX_RATE_BY_STATE_SQL, this::mapRowToTax, state);
    }

    @Override
    public List<String> getAllStates(){
        return jdbcTemplate.query(SELECT_ALL_STATES_SQL, this::mapStringToTax);
    }

    // Helper Method
    private Tax mapRowToTax(ResultSet rs, int rowNum) throws SQLException{
        Tax tax = new Tax();
        tax.setState(rs.getString("state"));
        tax.setRate(rs.getBigDecimal("rate"));

        return tax;
    }

    private String mapStringToTax(ResultSet rs, int rowNum) throws SQLException{
        String state = rs.getString("state");
        return state;
    }
}
