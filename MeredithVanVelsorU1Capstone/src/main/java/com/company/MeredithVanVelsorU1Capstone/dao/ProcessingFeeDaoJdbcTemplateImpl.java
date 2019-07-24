package com.company.MeredithVanVelsorU1Capstone.dao;

import com.company.MeredithVanVelsorU1Capstone.model.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProcessingFeeDaoJdbcTemplateImpl implements ProcessingFeeDao{

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public ProcessingFeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SELECT_PROCESSING_FEE_SQL =
            "select * from processing_fee where product_type = ?";

    @Override
    public ProcessingFee getProcessingFeeByType(String productType) {
        return jdbcTemplate.queryForObject(SELECT_PROCESSING_FEE_SQL, this::mapRowToProcessingFee, productType);
    }

    // Helper Method
    private ProcessingFee mapRowToProcessingFee(ResultSet rs, int rowNum) throws SQLException {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType(rs.getString("product_type"));
        processingFee.setFee(rs.getBigDecimal("fee"));

        return processingFee;
    }
}
