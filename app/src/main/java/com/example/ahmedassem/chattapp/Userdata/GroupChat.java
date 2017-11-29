package com.example.ahmedassem.chattapp.Userdata;

/**
 * Created by Ahmed Assem on 11/14/2017.
 */

public class GroupChat {
    String name,number;

    public GroupChat() {
    }

    public GroupChat(String name,String num) {
        this.name = name;
        this.number=num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
