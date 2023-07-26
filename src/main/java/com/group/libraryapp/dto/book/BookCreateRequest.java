package com.group.libraryapp.dto.book;


/*
  * RequestBody에 사용할 JSON을 받는 DTO의 경우에 사실은 생성자가 필요하지 않음!
  * 필드 여러개에 생성자 있는 것은 상관 X
  * 필드 하나만 있는데 생성자가 있으면 오히려 에러가 남
 * */
public class BookCreateRequest {

    private String name;

    public String getName() {
        return name;
    }
}
