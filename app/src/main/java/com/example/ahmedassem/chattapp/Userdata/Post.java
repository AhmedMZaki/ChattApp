package com.example.ahmedassem.chattapp.Userdata;

/**
 * Created by Ahmed Assem on 11/16/2017.
 */

public class Post {
    String username,date,post;

    public Post() {
    }

    public Post(String username, String date, String post) {
        this.username = username;
        this.date = date;
        this.post = post;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
