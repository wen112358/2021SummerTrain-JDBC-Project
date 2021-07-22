package com.test.nkbookshop.dao.jdbcimpl;

import com.test.nkbookshop.utils.DBUtil;

import java.sql.*;

//是具体Dao实现类的公有父类
//完成数据库访问的共性操作，不处理异常，抛出由调用者处理
//调用者是其具体的子类
public class GenericBaseDao {
    //声明私有静态连接，获取数据库连接和保存配置参数
    private static String driver= DBUtil.driver;
    private static String url=DBUtil.url;
    private static String user=DBUtil.user;
    private static String password=DBUtil.password;

    //通过static静态代码块完成一次性注册驱动程序
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //共性：获取连接\执行语句对象（DUL，DSL）\关闭连接
    //声明基础接口对象
    protected Connection conn;
    protected PreparedStatement pstmt;
    protected ResultSet rs;
    protected int result=-1;  //为什么给-1值的原因，区分影响0行的返回值

    //赋值conn
    public void getConnection() throws SQLException {
        conn= DriverManager.getConnection(url,user,password);
    }

    //关闭连接
    public void closeAll() throws SQLException {
        //先判断（非空&没有关闭的时候），再关闭
        if(rs!=null&&!rs.isClosed())
            rs.close();
        if(pstmt!=null&&!pstmt.isClosed())
            pstmt.close();
        if(conn!=null&&!conn.isClosed())
            conn.close();
        if(result!=-1)
            result=-1;
    }

    //普适的增删改方法
    //生成sql语句容器对象，放入sql语句，执行获取返回结果
    public void executeUpdate(final String sql,final Object... params) throws SQLException {
        pstmt=conn.prepareStatement(sql);
       //判断是否有参数，若有则逐个遍历参数数组，将参数值诸葛传入sql语句对象中
        if(params!=null){
            for(int i=0;i<params.length;i++){
                pstmt.setObject(i+1,params[i]);
            }
        }
        //执行sql语句，将返回结果放入resultset
        result=pstmt.executeUpdate();
    }

    //普适的查询方法
    public void executeQuery(final String sql,final Object... params) throws SQLException {
        pstmt=conn.prepareStatement(sql);
        //判断是否有参数，若有则逐个遍历参数数组，将参数值诸葛传入sql语句对象中
        if(params!=null){
            for(int i=0;i<params.length;i++){
                pstmt.setObject(i+1,params[i]);
            }
        }
        //执行sql语句，将返回结果放入resultset
        rs=pstmt.executeQuery();
    }



}
