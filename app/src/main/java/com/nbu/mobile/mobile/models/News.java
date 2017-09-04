package com.nbu.mobile.mobile.models;

/**
 * Created by Sarvar on 04.09.2017.
 */

public class News {

    private int id;
    private String title;
    private String description;
    private String body;

    public News(int id, String title, String description, String body) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getBody() {
        return body;
    }
}
