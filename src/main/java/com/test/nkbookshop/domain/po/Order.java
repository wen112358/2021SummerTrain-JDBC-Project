package com.test.nkbookshop.domain.po;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Order implements Serializable {
    //声明属性
    private Integer orderID;
    private Timestamp timestamp;
    private double totalprice;
    private Integer userId;

    //封装公有setter|getter方法
    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserIdId(Integer userId) {
        this.userId = userId;
    }

    //生成构造方法
    public Order() {
    }

    //给select功能使用
    public Order(Integer orderID, Timestamp timestamp, double totalprice, Integer userId) {
        this.orderID = orderID;
        this.timestamp = timestamp;
        this.totalprice = totalprice;
        this.userId = userId;
    }

    //给insert功能使用
    public Order(Timestamp timestamp, double totalprice, Integer userId) {
        this.timestamp = timestamp;
        this.totalprice = totalprice;
        this.userId = userId;
    }

    //toString方法
    @Override
    public String toString() {
        return "Orders{" +
                "orderID=" + orderID +
                ", timestamp=" + timestamp +
                ", totalprice=" + totalprice +
                ", salemanId=" + userId +
                '}';
    }
}
