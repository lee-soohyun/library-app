package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.fruit.response.FruitResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class FruitJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public FruitJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isFruitNotExist(long id) {
        String readSql = "SELECT * FROM fruit WHERE id = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) ->0, id).isEmpty();
    }

    public void updateFruit(String name, long id) {
        String sql = "UPDATE fruit SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, id);
    }

    public void saveFruit(String name, LocalDate warehousingDate, long price, boolean isSold) {
        String sql = "INSERT INTO fruit(name, warehousingDate, price, isSold) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, name, warehousingDate, price, isSold);
    }

    public List<FruitResponse> getFruit() {
        String sql = "SELECT * FROM fruit";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            String name = rs.getString("name");
            LocalDate warehousingDate = rs.getDate("warehousingDate").toLocalDate();
            long price = rs.getLong("price");
            boolean isSold = rs.getBoolean("isSold");
            long id = rs.getLong("id");
            return new FruitResponse(name,warehousingDate,price, isSold, id);
        });
    }

    public void countFruit(boolean isSold, long id) {
        String sql = "UPDATE fruit SET isSold = 1 WHERE id = ?";
        jdbcTemplate.update(sql, isSold, id);
    }

}
