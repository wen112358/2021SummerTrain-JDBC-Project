package com.test.nkbookshop.view;

import com.test.nkbookshop.domain.po.Detail;
import com.test.nkbookshop.domain.po.User;
import com.test.nkbookshop.web.controller.OrderController;
import com.test.nkbookshop.web.controller.UserController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UserView {
    public static void login(){
        //0.控制实例化
        UserController userController=new UserController();
        //1.登录
        //模拟用户输入usn&psd
        String usn="zhaoliu";
        String pwd="password";
        //完成前端页面请求参数的封装
        User loginuser=new User();
        loginuser.setUsn(usn);
        loginuser.setPwd(pwd);
        //调用控制器层实现控制功能
        userController.setUser(loginuser);
        String resultView=userController.login();
        System.out.println(resultView);
    }

    public static void register(){
        //0.实例化控制器层
        UserController userController = new UserController();

        //1-页面：注册
        //用户输入的内容：
        String usn = "zhangsan";
        String pwd = "password";
        int age = 20;
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000,0,1);//1月份应该是0
        Date birthday = calendar.getTime();
        double salary = 20;
        //注册时间自动生成
        Timestamp regtime = new Timestamp(System.currentTimeMillis());
        //完成前端页面请求参数的封装
        User loginUser = new User(usn,pwd,age,birthday,salary,regtime);

        //调用控制器层来实现登录功能
        userController.setUser(loginUser);
        String resultView = userController.register();
        System.out.println(resultView);
    }

    public static void showAllUsers(){
        //0.实例化控制器层
        UserController userController = new UserController();
        List<User> users = userController.showAllUsers();
        for(User user:users)
            System.out.println(user);
    }

    public static void addoneorder(){//增加一个订单，添加若干条明细
        OrderController orderController = new OrderController();
        List<Detail> list = new ArrayList<>();
        Detail detail = new Detail(null,1,10);
        list.add(detail);
        detail = new Detail(null,2,5);
        list.add(detail);
        detail = new Detail(null,3,4);
        list.add(detail);
        int userid = 1;
        if(orderController.addoneorder(list,userid)){
            System.out.println("Add successfully!");
        }
        else{
            System.out.println("Failed!");
        }
    }
    public static void queryoneorder(){//查询一个订单并输出相关信息
        OrderController orderController = new OrderController();
        int orderid = 11;
        orderController.print(orderid);
    }
    public static void modifyoneuser(){
        UserController userController = new UserController();
        User user = new User(1,"newname","newpwd",30,new Date(),1000,new Timestamp(System.currentTimeMillis()));
        if(userController.modifyUser(user)){
            System.out.println("modify successfully!");
        }
        else{
            System.out.println("modify failed!");
        }
    }

    public static void main(String[] args) {
//        register();
//
//        login();

//        //3.展示所有用户
//        showAllUsers();
//
//        addoneorder();
//
//        queryoneorder();
//
//        modifyoneuser();
    }
}