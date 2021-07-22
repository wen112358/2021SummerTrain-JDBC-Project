package com.test.nkbookshop.domain.po;

import java.io.Serializable;

public class Book implements Serializable {
    private Integer bookid;
    private String bkname;
    private double price;
    private int stock;

    public Book() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Book(Integer bookid, String bkname, double price, int stock) {
        super();
        this.bookid = bookid;
        this.bkname = bkname;
        this.price = price;
        this.stock = stock;
    }

    public Book(String bkname, double price, int stock) {
        super();
        this.bkname = bkname;
        this.price = price;
        this.stock = stock;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBkname() {
        return bkname;
    }

    public void setBkname(String bkname) {
        this.bkname = bkname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Book [bookid=" + bookid + ", bkname=" + bkname + ", price=" + price + ", stock=" + stock + "]";
    }


}
