package com.test.nkbookshop.view;

import com.test.nkbookshop.domain.po.Address;
import com.test.nkbookshop.domain.po.Book;
import com.test.nkbookshop.domain.po.User;
import com.test.nkbookshop.web.controller.AddressController;
import com.test.nkbookshop.web.controller.BookController;
import com.test.nkbookshop.web.controller.UserController;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class AdminView {
    public static void login(){
    //0.控制实例化
    UserController userController=new UserController();
    //1.登录
    //模拟管理员输入usn&psd
    String usn="Lisi";
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
        //管理员输入的内容：
        String usn = "zhaoliu";
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

    public static void addonebook(){
        //0.控制实例化
        BookController bookController=new BookController();
        //模拟管理员输入book信息
        String bookname="红楼梦";
        double price=50;
        int stock=30;
        //完成前端页面请求参数的封装
        Book addbook=new Book(bookname,price,stock);
        //调用控制器层实现控制功能
        bookController.setBook(addbook);
        String resultView=bookController.addBook();
        System.out.println(resultView);
    }

    public static void deleteonebook(){
        //0.控制实例化
        BookController bookController=new BookController();
        //模拟管理员输入book信息
        int bookid=1;
        String bookname="hongloumeng";
        //完成前端页面请求参数的封装
        Book deletebook=new Book(bookid,bookname,0,0);
        //调用控制器层实现控制功能
        bookController.setBook(deletebook);
        String resultView=bookController.removeBook();
        System.out.println(resultView);
    }

    public static void modifyonebook(){
        //0.控制实例化
        BookController bookController=new BookController();
        //模拟管理员输入book信息
        int bookid=1;
        String bookname="hongloumeng";
        double price=50;
        int stock=4;
        //完成前端页面请求参数的封装
        Book modifybook=new Book(bookid,bookname,price,stock);
        //调用控制器层实现控制功能
        bookController.setBook(modifybook);
        String resultView=bookController.updateBook();
        System.out.println(resultView);
    }

    public static void findonebook(){
        //0.控制实例化
        BookController bookController=new BookController();
        //模拟管理员输入book信息
        int bookid=1;
        //完成前端页面请求参数的封装
        Book findbook=new Book(bookid,null,0,0);
        //调用控制器层实现控制功能
        bookController.setBook(findbook);
        Book resultView=bookController.findBook();
        System.out.println(resultView);
    }

    public static void addoneaddress(){
        //0.控制实例化
        AddressController addressController=new AddressController();
        //模拟管理员输入address信息
        int userID=1;
        String address="南开大学";
        String phone="14672";
        //完成前端页面请求参数的封装
        Address addaddress=new Address(userID,address,phone);
        //调用控制器层实现控制功能
        addressController.setAddress(addaddress);
        String resultView=addressController.registerAddress();
        System.out.println(resultView);
    }

    public static void deleteoneaddress(){
        //0.控制实例化
        AddressController addressController=new AddressController();
        //模拟管理员输入address信息
        int userID=1;
        //完成前端页面请求参数的封装
        Address addaddress=new Address(userID,null,null);
        //调用控制器层实现控制功能
        addressController.setAddress(addaddress);
        String resultView=addressController.removeAddress();
        System.out.println(resultView);
    }

    public static void modifyoneaddress(){
        //0.控制实例化
        AddressController addressController=new AddressController();
        //模拟管理员输入address信息
        int userID=1;
        String address="南开大学";
        String phone="17652";
        //完成前端页面请求参数的封装
        Address addaddress=new Address(userID,address,phone);
        //调用控制器层实现控制功能
        addressController.setAddress(addaddress);
        String resultView=addressController.modifyAddress();
        System.out.println(resultView);
    }

    public static void findoneaddress(){
        //0.控制实例化
        AddressController addressController=new AddressController();
        //模拟管理员输入address信息
        int userID=1;
        //完成前端页面请求参数的封装
        Address addaddress=new Address(userID,null,null);
        //调用控制器层实现控制功能
        addressController.setAddress(addaddress);
        String resultView=addressController.getAddressInfo();
        System.out.println(resultView);
    }

    public static void main(String[] args){
//        //1.页面：注册
//        register();
//
//
//        //2.页面：登录
//        login();

//        //3.页面：书籍表管理
//        //增加一种书籍的信息
//        addonebook();
//        //查找一种书籍信息
//        findonebook();
//        //修改一种书籍信息
//        modifyonebook();
//        //删除一种书籍信息
//        deleteonebook();


//        //4.页面：客户地址表管理
//        //增加一个用户的地址
//        addoneaddress();
//        //查找一个用户的地址
//        findoneaddress();
//        //修改一个用户的地址
//        modifyoneaddress();
//        //删除一个用户的地址
//        deleteoneaddress();



    }
}
