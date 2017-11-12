package com.example.ahmedassem.chattapp;

/**
 * Created by Ahmed Assem on 11/6/2017.
 */
import java.util.ArrayList;

/**
 * The Class ChatUse is a Java Bean class that represents a single user.
 */

public class ChatUser {


    public String username,userinfo;

    public ChatUser() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public ChatUser(String username,String userinfo) {

        this.username = username;
        this.userinfo=userinfo;
    }

    public String getUsername() {
        return username;
    }

    public String getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(String userinfo) {
        this.userinfo = userinfo;
    }
}

