package com.group.libraryapp.dto.content;

import java.util.Date;

public class CultureUpdateRequest {
    private long id;
    private String title;
    private Date register_date;
    private String type;
    private int rate;
    private String review;

    public CultureUpdateRequest(long id, String title, Date register_date, String type, int rate, String review) {
        this.id = id;
        this.title = title;
        this.register_date = register_date;
        this.type = type;
        this.rate = rate;
        this.review = review;
    }

    public long getId() {
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
}
