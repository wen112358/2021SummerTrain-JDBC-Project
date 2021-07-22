package com.test.nkbookshop.web.controller;

import com.test.nkbookshop.domain.po.Detail;
import com.test.nkbookshop.service.OrderService;
import com.test.nkbookshop.service.impl.OrderServiceimpl;

import java.util.List;

public class OrderController {
    private OrderService orderService=new OrderServiceimpl();

    //根据输入的不完善的detail的list生成订单
    public boolean addoneorder(List<Detail> list, int userId){
        return orderService.addoneorder(list,userId);
    }

    //根据订单号输出订单信息
    public boolean print(int orderId){
        return orderService.showoneorder(orderId);
    }

}
