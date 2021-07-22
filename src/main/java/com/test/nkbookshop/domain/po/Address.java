package com.test.nkbookshop.domain.po;

import java.io.Serializable;

public class Address implements Serializable {

    private Integer userID;
    private String address;
    private String phone;

    public Address() {
    }

    public Address(Integer userID, String address, String phone) {
        this.userID = userID;
        this.address = address;
        this.phone = phone;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Address {" +
                " userID = " + userID +
                " , address = '" + address + '\'' +
                " , phone = " + phone +
                " }";
    }
}
