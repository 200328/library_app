package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// 아니 이렇게 비효율적으로 패스패스 하지 말고
// 그냥 바로 Repository가 JdbcTemplate을 받게 하면 안 되나?
// 안 됩니다
// 왜 안됨? UserRepository는 spring 빈이 안 됨.
// 그럼 UserRepository도 스프링 빈으로 만들면 되지 않을까?
// 스프링 빈은 스프링 컨테이너가 관리하는 클래스다.
// 스프링 컨테이너는 서버가 시작되면 생기는 거대한 상자(박스)

//@Repository // 나 스스로를 스프링 빈으로 만듦
public class UserJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UserResponse> getUsers(){
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new RowMapper<UserResponse>(){ //익명 클래스 이름
            // RowMapper를 사용해서 데이터베이스의 검색 결과를 UserResponse로 변경하겠다
            @Override  //익명 클래스 mapRow: 유저 정보를 UserResponse로 바꿔주는 역할을 수행하는 함수
            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                return new UserResponse(id, name, age);
            }
        });
    }

    public List<Integer> findUser(long id){
        //1. 존재하는 유저를 확인, 없는 경우에는 예외를 던지도록 해서.. 유저는 없음~'
        String readSql = "SELECT * FROM user WHERE id = ?";

        // RowMapper - 조회 결과를 우리가 원하는 객체로 변환하는 기능
        // 익명 클라스
        return jdbcTemplate.query(readSql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return 0;
            }
        }, id);
    }

    // 0719 04:35
    public void saveUser(String name, Integer age){
        String sql = "INSERT INTO user (name, age) VALUES (?, ?)";
        jdbcTemplate.update(sql, name, age);
    }

    public void updateUser(String name, long id){
        //2. 유저가 있다, update SQL을 DB에 날려서 실제 유저를 업데이트
        String sql = "UPDATE user SET name =? WHERE id= ?";
        jdbcTemplate.update(sql, name, id);
    }

    public void deleteUser(String name){
        String sql = "DELETE FROM user WHERE name =?";
        jdbcTemplate.update(sql, name);
    }
}
