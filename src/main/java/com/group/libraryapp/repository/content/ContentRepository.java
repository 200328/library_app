package com.group.libraryapp.repository.content;

import com.group.libraryapp.dto.content.request.CultureCreateRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContentRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 후기 작성
    public void saveContent(CultureCreateRequest request){ // 매개변수 나중에 확인
        String sql = "INSERT INTO content (title, register_date, type, rate, review) VALUES (?, ?,?,?,?)";
        jdbcTemplate.update(sql, request);
    }
}
