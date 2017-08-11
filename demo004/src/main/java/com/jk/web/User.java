package com.jk.web;

/**
 * Created by Handsome on 2017/8/11.
 */
public class User {

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userid;

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    private String userName;
}
