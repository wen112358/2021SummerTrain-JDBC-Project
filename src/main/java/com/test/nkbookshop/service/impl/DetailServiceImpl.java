package com.test.nkbookshop.service.impl;

import com.test.nkbookshop.dao.DetailDao;
import com.test.nkbookshop.dao.jdbcimpl.DetailDaoImpl;
import com.test.nkbookshop.domain.po.Detail;
import com.test.nkbookshop.service.DetailService;

import java.util.List;

public class DetailServiceImpl implements DetailService {

    private DetailDao detailDao = new DetailDaoImpl();
    @Override
    public double getSubprice(int orderid, int bookid) {
        double res = -1;
        Detail detail=detailDao.findByOrderAndBookId(orderid,bookid);
        if(detail!=null)
            res = detail.getSubtotalprice();
        return res;
    }

    @Override
    public boolean adddetail(List<Detail> list) {           //先查重，有则直接加数量，没有则新建一个
        for(Detail detail:list){
            if(detail!=null){
                detailDao.insert(detail);
            }
        }
        return true;
    }

    @Override
    public List<Detail> getDetails(int orderid) {
        return detailDao.findByOrderId(orderid);
    }
}