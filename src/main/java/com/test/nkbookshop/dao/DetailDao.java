package com.test.nkbookshop.dao;

import com.test.nkbookshop.domain.po.Detail;

import java.util.List;

public interface DetailDao extends GenericDao<Detail,Integer>{
    List<Detail> findByOrderId(Integer orderid);
    List<Detail> findByBookId(Integer bookid);
    Detail findByOrderAndBookId(Integer orderid,Integer bookid);
}