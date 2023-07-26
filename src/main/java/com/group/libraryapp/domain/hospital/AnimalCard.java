package com.group.libraryapp.domain.hospital;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnimalCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private String name;
    private Integer age;
    private String type;
    private String symptom;

    public AnimalCard() {
    }

    public AnimalCard(String name, Integer age, String type, String symptom) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.symptom = symptom;
    }

    public Long getId() {
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
