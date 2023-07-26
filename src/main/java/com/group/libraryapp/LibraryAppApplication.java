package com.group.libraryapp;
// 패키지 = 폴더

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 스프링 컨테이너를 만들고 "스프링 빈"들을 찾아 등록하는 마법
@SpringBootApplication
public class LibraryAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(LibraryAppApplication.class, args);
  }

}
