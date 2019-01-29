package com.codingwithmitch.myapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aayush on 18/01/2019.
 */

public class Posts {


    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;


    public Posts(Integer id, String title, String body) {

        this.id = id;
        this.title = title;
        this.body = body;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String url) {
        this.body = body;
    }

}
