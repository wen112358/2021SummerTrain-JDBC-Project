package com.test.nkbookshop.domain.po;

import java.io.Serializable;

public class Detail implements Serializable {
    private Integer orderid;
    private Integer bookid;
    private String bookname;
    private Double price;
    private Integer num;
    private Double subtotalprice;

    public Detail(Integer orderid, Integer bookid, String bookname, Double price, Integer num, Double subtotalprice) {
        this.orderid = orderid;
        this.bookid = bookid;
        this.bookname = bookname;
        this.price = price;
        this.num = num;
        this.subtotalprice = subtotalprice;
    }

    public Detail() {
    }

    public Detail(Integer orderid, Integer bookid, Integer num) {
        this.orderid = orderid;
        this.bookid = bookid;
        this.num = num;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getSubtotalprice() {
        return subtotalprice;
    }

    public void setSubtotalprice(Double subtotalprice) {
        this.subtotalprice = subtotalprice;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "orderid=" + orderid +
                ", bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", subtotalprice=" + subtotalprice +
                '}';
    }
}
