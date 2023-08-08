package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // 마법: 나 스스로를 스프링 빈으로 만들어 줌
// Controller 안 씀!
public class UserService {

    // JPA 연습 코드 //
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //트랜잭션 적용 끝!
//    @Transactional // 영속성 컨텍스트도 함께 생겼다가 함께 사라짐(JPA)
    public void saveUser(UserCreateRequest request){
       User user = new User(request.getName(), request.getAge());
       userRepository.save(user);
    }

//    @Transactional
    // select * from user;
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll(); //findAll: 알아서 전체 데이터를 읽어서 user객체로 만들어줌

        List<UserResponse> responses = new ArrayList<>(); // 결과 담아줌
        for (User user : users){// List 안의 데이터를 하나씩 가져오는 (List<User> 안에 user가 하나씩 들어온다)
            UserResponse response = new UserResponse(user.getId(), user.getName(), user.getAge());
            responses.add(response);
        }
        return responses;

        /* 위와 완전히 같은 (어려운) 코드 => get.Id ~~의 줄이 길어질 때 */
//        return userRepository.findAll().stream()
//                .map(UserResponse::new)
//                .collect(Collectors.toList());
    }
    // update: 주어진 id의 name을 바꿔주는 것
    // SELECT를 써서 해당 id를 가진 유저가 있는지 확인 - 없으면 에러
    // UPDATE를 써서 실제 업데이트
//    @Transactional
    public void updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId()).orElseThrow();
        // User 저장소야. 내가 준 아이디를 갖고 찾아주렴. 없다면 에러를 던져버리렴
        user.updateName(request.getName()); //UserUpdateRequest에서 가져온 이름을 update 시킴
        userRepository.save(user);
    }

//    @Transactional
    public void deleteUser(String name) {
        User user = userRepository.findByName(name);
        if (user == null){
            throw new IllegalArgumentException();
        }
        userRepository.delete(user); // 알아서 UserRepository가 이 user를 제거해줌
    }


    // 아래는 3단 분리 코드 //
//    private final JdbcTemplate jdbcTemplate;
//    private final UserRepository userRepository;
//
//    public UserService(JdbcTemplate jdbcTemplate, UserRepository userRepository) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.userRepository = userRepository;
//    }
//
//    //put(수정)
//    public void updateUser(UserUpdateRequest request) throws IllegalAccessException {
//        List<Integer> users = userRepository.findUser(request.getId());
//        if (users.isEmpty()){
//            throw new IllegalAccessException("No User");
//        }
//        userRepository.updateUser(request.getName(), request.getId());
//    }
//    //post(저장)
//    public void saveUser(UserCreateRequest request) throws IllegalAccessException {
//
//    }

    //get (데이터 달라)
//    public List<UserResponse> getUsers(){
//        return userRepository.getUsers();
//    }

//    //데이터 삭제
//    public void deleteUser(){
//        //return deleteRepository.deleteUser();  //수정
//    }
}
