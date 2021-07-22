package com.test.nkbookshop.service.impl;

import com.test.nkbookshop.dao.UserDao;
import com.test.nkbookshop.dao.jdbcimpl.UserDaoImpl;
import com.test.nkbookshop.domain.po.User;
import com.test.nkbookshop.service.UserService;

import java.util.List;

/*
    所有业务逻辑方法的具体实现，要借助Dao层中方法实现
        1.Dao作为业务逻辑层实现类的一个属性
        2.业务逻辑层实现类中的方法内部要对Dao进行调用实现自身功能
 */

public class UserServiceImpl implements UserService {
    //userDao作为UserServiceIml中的一个属性，并且实例化
    //UserService依赖UserDao
    //UserServiceImpl中的方法要借助UserDao中的方法调用来实现
    private UserDao userDao=new UserDaoImpl();

    @Override
    public boolean register(User user) {
        boolean res=false;
        int result=-1;
        User existuser=userDao.findByName(user.getUsn());
        if(existuser!=null)return false;
        result=userDao.insert(user);
        if(result==1)
            res=true;
        return res;
    }

    @Override
    public boolean isValidate(String usn, String pwd) {
        boolean res=false;
        User user=userDao.findByName(usn);
        if(user!=null&&pwd.equals(user.getPwd()))
            res=true;
        return res;
    }

    @Override
    public boolean remove(User user) {
        boolean res=false;
        int result=-1;
        result=userDao.delete(user);
        if(result!=-1&&result!=0)
            res=true;
        return res;
    }

    @Override
    public boolean modify(User user) {
        boolean res=false;
        int result=-1;
        result=userDao.update(user);
        if(result!=-1&&result!=0)
            res=true;
        return res;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
