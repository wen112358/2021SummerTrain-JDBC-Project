package com.test.nkbookshop.dao;

import com.test.nkbookshop.domain.po.Address;

public interface AddressDao extends GenericDao<Address, Integer> {
    Address findByPhone(String phone);
}

