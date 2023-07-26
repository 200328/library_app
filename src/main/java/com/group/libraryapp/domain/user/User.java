package com.group.libraryapp.domain.user;
// Q. UserCreateRequest랑 생긴 건 같아보여도 따로 class를 만드는 이유?
// A. 실제 우리가 관리하는 객체랑 바깥에서 데이터만 들고 오는 객체는 지금 당장 같아보여도 시간이 지나면 다름.

import javax.persistence.*;

// 여기에 JPA 적용 (0718)
// -> 이 객체랑 우리가 만들었던 user 테이블이랑 "매핑"을 할 것.
@Entity // 마법 - 이 객체는 JPA를 적용한 객체야~
// 참고) Entity 뜻 : 저장되고 관리되어야 하는 데이터
public class User {
    // 0으로 구분이 애매할 수 있으니 아예 확실히 null
    @Id  // primary key라는 뜻!
    //GenenratedValue: 이 값은 자동 생성         auto_increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null; // Long을 쓰는 이유: 저장되면 null이 아니고, 저장 안 되면 null

    @Column(length = 20) //없다고 해서 동작 못하는 건 아님(가시적으로 보기 위해 설정)
    private String name;
    private Integer age;

    //JPA를 사용하려면, @Entity 클래스에 아무것도 없는 "기본 생성자" 필수!
    public User() {

    }

    public User(String name, Integer age) {
        if(name.isBlank()){
            throw new RuntimeException("사람의 이름이 비어있습니다!");
        }
        this.name = name;
        this.age = age;
    }

    public void updateName(String name){
       this.name = name; // 내가 가진 이름이(this.name) 들어온 이름(String name)으로 바뀌게
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }
}
