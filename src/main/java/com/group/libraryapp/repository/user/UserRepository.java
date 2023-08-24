package com.group.libraryapp.repository.user;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserRepository {

    public boolean isUserNotExist(JdbcTemplate jdbcTemplate, long id){
        String readSql = "SELECT * FROM user WHERE id = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();
    }
}
