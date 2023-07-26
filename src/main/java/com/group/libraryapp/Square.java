package com.group.libraryapp;
import com.group.Shape;
import com.group.libraryapp.dto.ShapeDto;
import java.util.List;

public class Square extends Shape {

    private double num;

    public Square(List<Double> nums) {
        this.num = nums.get(0);
    }

    @Override
    public ShapeDto toDto() {
        return new ShapeDto("정사각형", num*4);
    }
}
