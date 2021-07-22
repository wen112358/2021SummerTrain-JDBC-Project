package com.test.nkbookshop.dao.jdbcimpl;

import com.test.nkbookshop.dao.UserDao;
import com.test.nkbookshop.domain.po.User;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class TestUserDaoImpl {
    public static void main(String[] args){
        UserDao userDao=new UserDaoImpl();

//        //1.查询测试
//        User user=userDao.findByID(1);
//        System.out.println(user);
//
//        List<User> users = userDao.findAll();
//        for (User u : users)
//            System.out.println(u);
//
//        //2.插入测试
//        Date birthday = new Date();
//        Timestamp regtime = new Timestamp(System.currentTimeMillis());
//        User newUser = new User("lisi", "password", 21, birthday, 1.2, regtime);
//        int result = userDao.insert(newUser);
//        System.out.println(result);



    }
}
