package com.group.libraryapp.repository.fruit;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class FruitRepository {
    private final JdbcTemplate jdbcTemplate;

    public FruitRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveFruit(String name, int price, String date){
        String sql = "INSERT INTO fruit (name, price, due_date) VALUES(?,?,?)";
        jdbcTemplate.update(sql, name, price, date);

    }

}
