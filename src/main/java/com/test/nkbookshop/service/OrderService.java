package com.test.nkbookshop.service;

import com.test.nkbookshop.domain.po.Detail;

import java.util.List;

public interface OrderService {
    boolean showoneorder(int orderID);
    boolean addoneorder(List<Detail> list,int userId);
}
