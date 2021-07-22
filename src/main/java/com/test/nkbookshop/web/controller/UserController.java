package com.test.nkbookshop.web.controller;

import com.test.nkbookshop.domain.po.User;
import com.test.nkbookshop.service.UserService;
import com.test.nkbookshop.service.impl.UserServiceImpl;

import java.util.List;

public class UserController {
    private User user;
    private UserService userService=new UserServiceImpl();

    public String login(){
        //获取视图层前端传入的请求参数    前端完成
        //调用下一层即业务逻辑层的方法
        boolean res=userService.isValidate(user.getUsn(), user.getPwd());
        if(res)
            return "Login Success!";
        else
            return "Login Fail";
    }

    public String register(){
        //获取视图层前端传入的请求参数    前端完成
        //调用下一层即业务逻辑层的方法
        boolean res=userService.register(user);
        if(res)
            return "Register Success!";
        else
            return "Register Fail";
    }

    public List<User> showAllUsers(){
        return userService.findAll();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean modifyUser(User user) {
        return userService.modify(user);
    }

}
