package com.group.libraryapp.controller.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.user.UserCreateRequest;
import com.group.libraryapp.dto.user.UserResponse;
import com.group.libraryapp.repository.user.UserRepository;
import com.group.libraryapp.service.user.UserService;
import com.group.libraryapp.service.user.UserUpdateRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 스프링 빈: 스프링 서버가 시작할 때 내부에 거대한 컨테이너 (박스)가 생기는데
// 이 박스 안에 들어있는 클래스
// 들어갈 때 인스턴스화도 자동으로 된다.
@CrossOrigin  // 서버의 에러를 해결해주기 위한 어노테이션(실무에선 함부로 X)
@RestController // 2중 마법: API의 진입 지점, 나 스스로를 스프링 빈으로 만든다.
public class UserController{

    private final JdbcTemplate jdbcTemplate;
    private final UserService userService;

    // new XXX -> 생성자를 호출하는 코드
    // new UserController();

    public UserController(JdbcTemplate jdbcTemplate, UserService userService) {
        this.jdbcTemplate = jdbcTemplate;
        this.userService = userService;  // this 쓰는 이유: 매개변수로 받은 jdbcTemplate를 private으로 선언한 jdbcTemplate으로 저장하고 싶음
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
        // JPA 연습 코드 //
        userService.saveUser(request);

        // 아래는 3단 분리 코드 //
//        String sql = "INSERT INTO user (name, age) VALUES (?, ?)";
//        String name = request.getName();
//        Integer age = request.getAge();
//        jdbcTemplate.update(sql, name, age);
        // jdbcTemplate.update(sql, request.getName(), request.getAge());
    }

    // 객체에 있는 static이 아닌 함수를 실행하려면 가장 먼저 무엇을 해야함?
    // 인스턴스화 new Person(); -> person.함수호출()
    // 이상하다? 분명 new UserController()를 한 적이 없는데..
    // [1] 근데 도대체 언제 누가 new UserController를 만들어줬냐? @RestController
    // JdbcTemplate객체를 매개변수를 받고 있음
    // [2] 근데 new JdbcTemplate는 누가 매개변수?
    // A. build.gradle -> dependencies ~

    // 무려 3가지 일을 하고 있다. (3단 분리)
    // [1] HTTP, API와 관련된 일 - PUT /user, Body를 객체로 변환 -> Controller
    // [2] 예외를 처리하고 있음. (비즈니스상 일어날 수 없는 일) -> Service
    // [3] 실제 DB와 통신해서 SQL을 사용. -> Repository

    /// 유저 반환 API ///
    // 하고 싶은 것: 데이터베이스 user 테이블에 저장되어 있는 데이터를 가져와서 --> SQL
    // 목표: User 객체를 UserResponse 객체로 바꿔서 반환
    // 이 API에 맞게 List<UserResponse>를 반환하는 것!!
    // 문제: User가 List에 들어있음. --> List<User>를 List<UserResponse>로 변경
    @GetMapping("/user")
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }
    // 목표: 2가지 기능을 더 만든다
    // 유저 정보 수정, 유저 삭제
    // API 2개 더 만든다
    // API 만들려면 "스펙!!"
    // 김사원은 HTTP 파싱 관련 규칙 좀 바꿔줘 ~ 나는 여기 DB SQL 보고 있을게!
    // PUT(수정) / user
    // 질문: 해당 id를 가진 유저가 있는 지 없는 지 알 수 있는 방법?
    // DB를 확인한다! -> DB 조회 -> SELECT SQL을 사용해서 조회
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) throws IllegalAccessException {
        userService.updateUser(request);
    }

    // DELETE(삭제) /user
    // 존재하지 않는 유저에 대해서는 200을 주면 안 될 것 같다 (==스펙의 일부)
    // 어떻게 하면 200 말고 다른 응답 상태를 줄 수 있을까?
    // 수정하는 기능이랑 유사하게 DB를 확인해서 유저가 없으면 예외를 던지게 만들 수 있는지
    // 어떤 주어진 이름으로 유저가 없으면 에러, 있으면 삭제!
    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        userService.deleteUser(name);
    }
}
