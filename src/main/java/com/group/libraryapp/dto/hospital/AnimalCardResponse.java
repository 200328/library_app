package com.group.libraryapp.dto.hospital;

import com.group.libraryapp.domain.hospital.AnimalCard;

public class AnimalCardResponse {
    private long id;
    private String name;
    private Integer age;
    private String type;
    private String symptom;

    public AnimalCardResponse(AnimalCard ac){
        this.id = ac.getId();
        this.name = ac.getName();
        this.age = ac.getAge();
        this.type = ac.getType();
        this.symptom = ac.getSymptom();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    public String getSymptom() {
        return symptom;
    }
}
