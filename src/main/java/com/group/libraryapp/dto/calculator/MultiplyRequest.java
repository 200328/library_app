package com.group.libraryapp.dto.calculator;

// 이러한 객체는 DTO
// Data Transfer Object : 데이터 전달 객체
public class MultiplyRequest {
    private int number1;
    private int number2;

    // 2가지 추가로 만들기! <- 자바의 클래스 만들면 보통 같이 만듦
    // 생성자, getter
    public MultiplyRequest(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }
    public int getNumber1() {
        return number1;
    }
    public int getNumber2() {
        return number2;
    }
}
