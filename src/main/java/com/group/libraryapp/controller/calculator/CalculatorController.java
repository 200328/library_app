package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.MultiplyRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import org.springframework.web.bind.annotation.*;

/**
 * 덧셈 기능 (API)를 만들 것
 * API 명세를 정해야 한다!
 * - HTTP Method: GET (덧셈 결과를 달라)
 * - HTTP Path:  /add
 * - 쿼리 (key와 value): 2개 결과 int number1/ int number2
 * - API의 반환 결과 : 숫자 - 두 숫자의 덧셈 결과
 */
// @ 문법: 자바의 어노테이션
@RestController // 이 클래스를 API의 진입 지점으로 만들어준다.
public class CalculatorController {
    @GetMapping("/add") // GetMapping 함수를 GET API로 만든다. path: "/add"
    public int addTwoNumbers(CalculatorAddRequest request){
//            (@RequestParam int number1,@RequestParam int number2){
                             // @RequestParam: 파라미터 이름과 같은 쿼리를 찾아 넣어준다
        return request.getNumber1()+request.getNumber2();
    }

    @GetMapping("/minus")
    public double minusTwoNumbers(
            @RequestParam double num1, @RequestParam double num2) {
        return num1 - num2;
    }
    // 이 어노테이션은 아래 함수를 POST method를 받게 해줌
    // POST 같은 경우는 "클래스"로 데이터를 받아야 함. (Body를 쓰니까)
    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody MultiplyRequest request){
        return request.getNumber1() * request.getNumber2();
    }
}
