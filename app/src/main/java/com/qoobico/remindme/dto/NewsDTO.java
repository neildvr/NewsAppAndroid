package com.qoobico.remindme.dto;

/**
 * Created by neil on 5/14/16.
 */
public class NewsDTO {

    private String title;

    public NewsDTO(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
