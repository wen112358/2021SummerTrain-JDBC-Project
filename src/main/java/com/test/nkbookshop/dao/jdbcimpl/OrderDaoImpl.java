package com.test.nkbookshop.dao.jdbcimpl;

import com.test.nkbookshop.dao.OrdersDao;
import com.test.nkbookshop.domain.po.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends GenericBaseDao implements OrdersDao {

    @Override
    public Order findByID(Integer id) {
        Order order=null;
        try {
            this.getConnection();
            String sql="select* from orders where orderid=?";
            this.executeQuery(sql,id);
            if(rs!=null&&rs.next()){
                order=new Order(rs.getInt("orderID"),rs.getTimestamp("time"),
                        rs.getDouble("totalprice"),rs.getInt("userID")
                        );
            }
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders=null;
        try {
            this.getConnection();
            String sql="select* from orders where orderid=?";
            this.executeQuery(sql);
            if(rs!=null){
                orders=new ArrayList<>();
                while(rs.next()){
                    //将一行记录封装到一个实体类对象中
                    Order order=new Order(rs.getInt("orderID"),
                            rs.getTimestamp("time"),
                            rs.getDouble("totalprice"),
                            rs.getInt("userID")
                    );
                    //将一个实体类对象加入list
                    orders.add(order);
                }
            }
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Order> findBySQL(String sql, Object... params) {
        List<Order> orders=null;
        try {
            this.getConnection();
            this.executeQuery(sql,params);
            if(rs!=null){
                orders=new ArrayList<>();
                while(rs.next()){
                    //将一行记录封装到一个实体类对象中
                    Order order=new Order(rs.getInt("orderID"),
                            rs.getTimestamp("time"),
                            rs.getDouble("totalprice"),
                            rs.getInt("userID")
                    );
                    //将一个实体类对象加入list
                    orders.add(order);
                }
            }
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orders;
    }

    @Override
    public int insert(Order order) {
        int res=-1;
        try {
            this.getConnection();
            String sql="insert into orders values(null,?,?,?)";
            this.executeUpdate(sql,order.getTimestamp(),
                    order.getTotalprice(),order.getUserId()
            );
            res=result;
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public int update(Order order) {
        int res=-1;
        try {
            this.getConnection();
            String sql="update orders set time=?," +
                    "totalprice=?," +
                    "userID=? " +
                    "where orderID=?";
            this.executeUpdate(sql,
                    order.getTimestamp(),
                    order.getTotalprice(),
                    order.getUserId(),
                    order.getOrderID()
            );
            res=result;
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public int delete(Integer id) {
        int res=-1;
        try {
            this.getConnection();
            String sql="delete from orders where orderID=?";
            this.executeUpdate(sql,id);
            res=result;
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public int delete(Order order) {
        return this.delete(order.getOrderID());
    }

    @Override
    public int executeSql(String sql) {
        int result=-1;
        try {
            this.getConnection();
            this.executeQuery(sql);
            if(rs!=null && rs.next()){
                result=rs.getInt(1);
            }
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
