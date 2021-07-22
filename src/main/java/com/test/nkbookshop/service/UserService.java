package com.test.nkbookshop.service;

import com.test.nkbookshop.domain.po.User;

import java.util.List;

//业务逻辑层中接口
public interface UserService {
    boolean register(User user);
    boolean isValidate(String usn,String pwd);
    boolean remove(User user);
    boolean modify(User user);

    List<User> findAll();
}
