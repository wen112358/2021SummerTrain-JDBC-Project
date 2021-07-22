package com.test.nkbookshop.service;

import com.test.nkbookshop.domain.po.Detail;

import java.util.List;

public interface DetailService {
    //这里写所有的业务
    double getSubprice(int orderid,int bookid);
    boolean adddetail(List<Detail> list);
    List<Detail> getDetails(int orderid);
}
