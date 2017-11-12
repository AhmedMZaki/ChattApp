package com.example.ahmedassem.chattapp.Userdata;

/**
 * Created by Ahmed Assem on 11/12/2017.
 */

public class chatuser {

        public String username,userinfo;

        public chatuser() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public chatuser(String username,String userinfo) {

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


