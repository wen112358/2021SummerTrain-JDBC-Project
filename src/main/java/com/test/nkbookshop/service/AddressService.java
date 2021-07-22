package com.test.nkbookshop.service;


import com.test.nkbookshop.domain.po.Address;
import java.util.List;

public interface AddressService {
    boolean register_add(Address address);

    boolean remove_add(Address address);

    boolean modify_add(Address address);

    String getAddressInfo(Integer userID);

    String getAddressInfoByPhone(String phone);

    List<Address> findAllAddress();
}
