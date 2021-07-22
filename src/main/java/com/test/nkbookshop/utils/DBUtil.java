package com.test.nkbookshop.utils;

import java.io.IOException;
import java.util.Properties;

//工具类为了简化使用成本：方法和属性 应该是public static
//读取dbconfig.properties文件内容（读其中的key获取对应的value，借助Java Properties类）
public class DBUtil {
    //声明静态私有属性，实例化properties类对象，因为要给public static使用
    private static Properties prop=new Properties();

    //声明静态代码块（其他属性是静态的），借助私有静态属性properties完成dbconfig.properties文件的读入
    //借助getClassLoader保证在web项目中可以定位&读入配置文件
    static{
        try {
            prop.load(DBUtil.class.getClassLoader().getResourceAsStream("dbconfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //声明公有属性，保存获取的数据库配置信息
    public static String driver= prop.getProperty("jdbc.driver");
    public static String url= prop.getProperty("jdbc.url");
    public static String user=prop.getProperty("jdbc.user");
    public static String password= prop.getProperty("jdbc.password");

}
