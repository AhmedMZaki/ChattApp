package com.example.ahmedassem.chattapp.Userdata;

/**
 * Created by Ahmed Assem on 11/22/2017.
 */

public class Comment {
    String name,content,date;

    public Comment() {
    }

    public Comment(String name, String content, String date) {
        this.name = name;
        this.content = content;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
