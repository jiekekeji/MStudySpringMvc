package com.jk.web;

/**
 * Created by jack on 17/8/9.
 */
public class Address {
    private String city;
    private String road;

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", road='" + road + '\'' +
                '}';
    }
}
