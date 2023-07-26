package com.group.libraryapp.dto;

import com.group.Shape;
import com.group.libraryapp.Circle;
import com.group.libraryapp.Rectangle;
import com.group.libraryapp.Square;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Shape shape = new Shape();
    /* 예시
//        System.out.println(shape.a());  //10
//        System.out.println(shape.calculateRound()); //0.0
//
//        Rectangle rectangle = new Rectangle();
//        System.out.println(rectangle.calculateRound()); //3.0
*/
        // [타입] [변수이름] = 값;
        // [타입] [변수이름] = new 생성자호출;
//        Shape rec = new Rectangle(); // 하위 클래스의 인스턴스를 만들 때 상위 타입으로 선언 가능
    }
    // "RECTANGLE" + 숫자 2개
    // "SQUARE" + 숫자 1개
    // "CIRCLE" + 숫자 1개
    public static ShapeDto calculate(String str, List<Double> numbers) {
        Shape shape;
        // Shape shape = null;  // 변수에 null을 최대한 넣지 않는 게 좋음!!
        if (str.equals("RECTANGLE")) {
            shape = new Rectangle(numbers);
        } else if (str.equals("SQUARE")) {
            shape = new Square(numbers);
        } else {
            shape = new Circle(numbers);
        }

        return shape.toDto();

        // * 또 다른 어려운 방법 * //
//        Shape shape = Shape.of(str, numbers);
    }
}

