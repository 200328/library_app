package com.group.libraryapp.dto.book;

// 대출 API에서 요청 Body에 사용될 DTO
// HTTP 스펙에 정의된 부분
public class BookLoanRequest {

    private String userName;
    private String bookName;

    public String getUserName() {
        return userName;
    }

    public String getBookName() {
        return bookName;
    }
}
