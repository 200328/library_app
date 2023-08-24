package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {
    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(UserCreateRequest request){
        User u = userRepository.save(new User(request.getName(), request.getAge()));
        u.getId();
        throw new IllegalArgumentException();
    }
    @Transactional(readOnly=true)
    public List<UserResponse> getUsers(){
        List<User> users = userRepository.findAll(); // select * from user와 같음
        return users.stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getAge()))
                //.map(UserResponse::new)
                .collect(Collectors.toList()); // list로 변환
    }
    @Transactional
    public void updateUser(UserUpdateRequest request){
        // select * from user where id = ?
        // Optional<User>
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        user.updateName(request.getName());
        userRepository.save(user);

    }
    @Transactional
    public void deleteUser(String name){
        // SELECT * FROM user WHERE name = ?
        User user = userRepository.findByName(name);
        if (user == null){
            throw new IllegalArgumentException();
        }

        userRepository.delete(user); // delete가 실행된다는 건 무조건 user가 존재한다는 얘끼
    }
}
