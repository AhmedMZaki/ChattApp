package com.example.ahmedassem.chattapp.Userdata;

/**
 * Created by Ahmed Assem on 11/12/2017.
 */

public class Notificationitem {
    String content,date,name;

    public Notificationitem() {
    }

    public Notificationitem(String content, String date, String name) {
        this.content = content;
        this.date = date;
        this.name=name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
