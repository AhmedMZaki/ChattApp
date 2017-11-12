package com.example.ahmedassem.chattapp;

/**
 * Created by Ahmed Assem on 11/8/2017.
 */

public class msg {

    public static final int TEXT_TYPE=0;
    public static final int IMAGE_TYPE=1;


    public int type;
    public int data;

    String message;
    public msg() {
    }

    public msg(int type,String message,int data) {
        this.message = message;
        this.data=data;
        this.type=data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
