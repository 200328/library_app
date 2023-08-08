package com.group.libraryapp.dto.content.request;

import java.util.Date;

public class CultureCreateRequest {
    private String title;
    private Date register_date;
    private String type;
    private int rate;
    private String review;

    public CultureCreateRequest(String title, Date register_date, String type, int rate, String review) {

        this.title = title;
        this.register_date = register_date;
        this.type = type;
        this.rate = rate;
        this.review = review;
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
}
