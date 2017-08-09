package com.jk.web;

/**
 * Created by jack on 17/8/9.
 */
public class User {
    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    private String userid;
    private int age;
    private Address address;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
