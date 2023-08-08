package com.group.libraryapp.domain.content;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Culture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long id = null;

    @Column(nullable=false, length=50)
    private String title;
    private Date register_date;
    @Column(length=20)
    private String type;
    private int rate;
    @Column(length=100)
    private String review;

    protected Culture() {

    }

    public Culture(String title, Date register_date, String type, int rate, String review){
        if ((title == null || title.isBlank())||
                (register_date == null)||
                (type == null || type.isBlank())|| // rate 못 씀
                (title == null || title.isBlank())){
            throw new IllegalArgumentException("모두 필수 입력사항입니다!");
        }
        this.id = id;
        this.title = title;
        this.register_date = register_date;
        this.type = type;
        this.rate = rate;
        this.review = review;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public String getType() {
        return type;
    }

    public int getRate() {
        return rate;
    }

    public String getReview() {
        return review;
    }

    public void updateRate(int rate){
        this.rate = rate;
    }
    public void updateReview(String review){
        this.review = review;
    }
}
