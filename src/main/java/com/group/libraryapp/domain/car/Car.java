package com.group.libraryapp.domain.car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private String type;
    private Integer number;
    private Integer price;
    private Date registeration_date;
    private String status;

    public Car(Long id, String type, Integer number, Integer price, Date registeration_date, String status) {
        this.id = id;
        this.type = type;
        this.number = number;
        this.price = price;
        this.registeration_date = registeration_date;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getPrice() {
        return price;
    }

    public Date getRegisteration_date() {
        return registeration_date;
    }

    public String getStatus() {
        return status;
    }
}
