package com.company.MeredithVanVelsorU1Capstone.dao;

import com.company.MeredithVanVelsorU1Capstone.model.Tshirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TshirtDaoJdbcTemplateImpl implements TshirtDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TshirtDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String INSERT_TSHIRT_SQL =
            "insert into t_shirt (size, color, description, price, quantity) values (?, ?, ?, ?, ?)";

    private static final String SELECT_TSHIRT_SQL =
            "select * from t_shirt where t_shirt_id = ?";

    private static final String SELECT_ALL_TSHIRTS_SQL =
            "select * from t_shirt";

    private static final String UPDATE_TSHIRT_SQL =
            "update t_shirt set size = ?, color = ?, description = ?, price = ?, quantity = ? where t_shirt_id = ?";

    private static final String UPDATE_TSHIRT_QTY_SQL =
            "update t_shirt set quantity = ? where t_shirt_id =?";

    private static final String DELETE_TSHIRT =
            "delete from t_shirt where t_shirt_id = ?";

    private static final String SELECT_TSHIRTS_BY_COLOR_SQL =
            "select * from t_shirt where color = ?";

    private static final String SELECT_TSHIRTS_BY_SIZE_SQL =
            "select * from t_shirt where size = ?";

    @Override
    public Tshirt addTshirt(Tshirt tshirt) {
        jdbcTemplate.update(INSERT_TSHIRT_SQL,
                tshirt.getSize(),
                tshirt.getColor(),
                tshirt.getDescription(),
                tshirt.getPrice(),
                tshirt.getQuantity());
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        tshirt.settShirtId(id);
        return tshirt;
    }

    @Override
    public Tshirt getTshirt(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_TSHIRT_SQL, this::mapRowToTshirt, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Tshirt> getAllTshirts() {
        return jdbcTemplate.query(SELECT_ALL_TSHIRTS_SQL, this::mapRowToTshirt);
    }

    @Override
    public void updateTshirt(Tshirt tshirt) {
        jdbcTemplate.update(
                UPDATE_TSHIRT_SQL,
                tshirt.getSize(),
                tshirt.getColor(),
                tshirt.getDescription(),
                tshirt.getPrice(),
                tshirt.getQuantity(),
                tshirt.gettShirtId()
        );
    }

    @Override
    public void updateQtyForTshirt(int id, int quantity) {
        jdbcTemplate.update(
                UPDATE_TSHIRT_QTY_SQL,
                quantity, id
        );
    }

    @Override
    public void deleteTshirt(int id) {
        jdbcTemplate.update(DELETE_TSHIRT, id);
    }

    @Override
    public List<Tshirt> getAllTshirtsByColor(String color) {
        return jdbcTemplate.query(SELECT_TSHIRTS_BY_COLOR_SQL, this::mapRowToTshirt, color);
    }

    @Override
    public List<Tshirt> getAllTshirtsBySize(String size) {
        return jdbcTemplate.query(SELECT_TSHIRTS_BY_SIZE_SQL, this::mapRowToTshirt, size);
    }

    // Helper Method
    private Tshirt mapRowToTshirt(ResultSet rs, int rowNum) throws SQLException {
        Tshirt tshirt = new Tshirt();
        tshirt.settShirtId(rs.getInt("t_shirt_id"));
        tshirt.setSize(rs.getString("size"));
        tshirt.setColor(rs.getString("color"));
        tshirt.setDescription(rs.getString("description"));
        tshirt.setPrice(rs.getBigDecimal("price"));
        tshirt.setQuantity(rs.getBigDecimal("quantity"));

        return tshirt;
    }
}
