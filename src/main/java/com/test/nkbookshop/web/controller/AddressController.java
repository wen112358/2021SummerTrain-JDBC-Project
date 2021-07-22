package com.test.nkbookshop.web.controller;

import com.test.nkbookshop.domain.po.Address;
import com.test.nkbookshop.service.AddressService;
import com.test.nkbookshop.service.impl.AddressServiceImpl;

import java.util.List;

public class AddressController {
    private AddressService addressService = new AddressServiceImpl();

    private Address address;

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public String registerAddress() {
        boolean res = addressService.register_add(address);
        if (res)
            return "Register a new address successfully.";
        else
            return "Failed to register a new address.";
    }

    public String removeAddress() {
        boolean res = addressService.remove_add(address);
        if (res)
            return "Delete the address successfully.";
        else
            return "Failed to delete the address.";
    }

    public String modifyAddress() {
        boolean res = addressService.modify_add(address);
        if (res)
            return "Modify the address successfully.";
        else
            return "Failed to modify the address.";
    }

    public String getAddressInfo() {
        String res = addressService.getAddressInfo(address.getUserID());
        if (res.equals("fail"))
            return "Failed to get the address information.";
        else
            return res;
    }

    public String getAddressInfoByPhone(String phone) {
        String res = addressService.getAddressInfoByPhone(phone);
        if (res.equals("fail"))
            return "Failed to get the address information.";
        else
            return res;
    }

    public List<Address> showAllAddress() {
        return addressService.findAllAddress();
    }
}