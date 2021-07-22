package com.test.nkbookshop.dao;

import com.test.nkbookshop.domain.po.Order;

public interface OrdersDao extends GenericDao<Order,Integer>{
    int executeSql(String sql);
}
