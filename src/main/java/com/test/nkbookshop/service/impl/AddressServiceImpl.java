package com.test.nkbookshop.service.impl;

import com.test.nkbookshop.dao.AddressDao;
import com.test.nkbookshop.dao.jdbcimpl.AddressDaoImpl;
import com.test.nkbookshop.domain.po.Address;
import com.test.nkbookshop.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDao addressDao = new AddressDaoImpl();

    @Override
    public boolean register_add(Address address) {
        boolean res = false;
        int result = -1;
        Address existAddress = addressDao.findByID(address.getUserID());
        if (existAddress != null)
            return false;
        result = addressDao.insert(address);
        if (result == 1)
            res = true;
        return res;
    }

    @Override
    public boolean remove_add(Address address) {
        boolean res = false;
        int result = -1;
        result = addressDao.delete(address);
        if (result != -1 && result != 0)
            res = true;
        return res;
    }

    @Override
    public boolean modify_add(Address address) {
        boolean res = false;
        int result = -1;
        result = addressDao.update(address);
        if (result != -1 && result != 0)
            res = true;
        return res;
    }

    @Override
    public String getAddressInfo(Integer userID) {
        String res = "fail";
        Address existAddress = addressDao.findByID(userID);
        if (existAddress != null)
            res = existAddress.toString();
        return res;
    }

    @Override
    public String getAddressInfoByPhone(String phone) {
        String res = "fail";
        Address existAddress = addressDao.findByPhone(phone);
        if (existAddress != null)
            res = existAddress.toString();
        return res;
    }

    @Override
    public List<Address> findAllAddress() {
        return addressDao.findAll();
    }
}
