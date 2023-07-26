package com.group;

import com.group.libraryapp.Circle;
import com.group.libraryapp.Rectangle;
import com.group.libraryapp.Square;
import com.group.libraryapp.dto.ShapeDto;

import java.util.List;

public abstract class Shape { // 반드시 재정의해야 하는 함수

    abstract public ShapeDto toDto();

/* 예시 //
//    public double calculateRound(){
//        return 0.0;
//    }
//
//    public int a() {
//        return 10;
//    }
//    */

    // * 또 다른 어려운 방법 * //
//    public static Shape of(String str, List<Double> numbers) {
//        if (str.equals("RECTANGLE")) {
//            return new Rectangle(numbers);
//        } else if (str.equals("SQUARE")) {
//            return new Square(numbers);
//        } else if (str.equals("CIRCLE")) {
//            return new Circle(numbers);
//        }
//    }
}
