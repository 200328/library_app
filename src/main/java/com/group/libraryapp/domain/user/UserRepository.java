package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // 함수의 윗부분(시그니처)만 작성하면
    // select * from user where name =?;
    // 있으면 user 반환, 없으면 null
    User findByName(String name); //public은 interface에서 생략 가능!


}
