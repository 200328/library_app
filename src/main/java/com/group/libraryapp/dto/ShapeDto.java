package com.group.libraryapp.dto;

public class ShapeDto {
    private String name;
    private double round; // 둘레

    public ShapeDto(String name, double round) {
        this.name = name;
        this.round = round;
    }

    public String getName() {
        return name;
    }

    public double getRound() {
        return round;
    }
}
