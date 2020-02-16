package com.billbook.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {
    @SerializedName("level1")
    @Expose
    String level1;
    @SerializedName("level2")
    @Expose
    String level2;
    @SerializedName("level3")
    @Expose
    String level3;
    @SerializedName("area")
    @Expose
    String area;
    @SerializedName("land Mark")
    @Expose
    String landMark;
    @SerializedName("city")
    @Expose
    String city;
    @SerializedName("state")
    @Expose
    String state;
    @SerializedName("country")
    @Expose
    String country;
    @SerializedName("pin")
    @Expose
    int pin;

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public String getLevel3() {
        return level3;
    }

    public void setLevel3(String level3) {
        this.level3 = level3;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
