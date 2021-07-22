package com.test.nkbookshop.dao.jdbcimpl;

import com.test.nkbookshop.dao.DetailDao;
import com.test.nkbookshop.domain.po.Detail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetailDaoImpl extends GenericBaseDao implements DetailDao {

    @Override
    public List<Detail> findByOrderId(Integer orderid) {
        List<Detail> list = null;
        try {
            this.getConnection();
            String sql = "select * from Details where orderid=?;";
            this.executeQuery(sql,orderid);
            if(rs!=null){
                list = new ArrayList<>();
                while(rs.next()){
                    //将一行记录封装到一个实体类对象中，再把对象放到List中
                    Detail detail = new Detail(rs.getInt("orderid"),
                            rs.getInt("bookid"),rs.getString("bookname"),rs.getDouble("price"),
                            rs.getInt("num"), rs.getDouble("subtotalprice"));
                    list.add(detail);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Detail> findByBookId(Integer bookid) {
        List<Detail> list = null;
        try {
            this.getConnection();
            String sql = "select * from Details where bookid=?;";
            this.executeQuery(sql,bookid);
            if(rs!=null){
                list = new ArrayList<>();
                while(rs.next()){
                    //将一行记录封装到一个实体类对象中，再把对象放到List中
                    Detail detail = new Detail(rs.getInt("orderid"),
                            rs.getInt("bookid"),rs.getString("bookname"),rs.getDouble("price"),
                            rs.getInt("num"), rs.getDouble("subtotalprice"));
                    list.add(detail);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Detail findByOrderAndBookId(Integer orderid, Integer bookid) {
        Detail detail = null;
        try {
            this.getConnection();
            String sql = "select * from Details where orderid=? and bookid=?;";
            this.executeQuery(sql,orderid,bookid);
            if(rs!=null){
                detail = new Detail(rs.getInt("orderid"),rs.getInt("bookid"),
                        rs.getString("bookname"),rs.getDouble("price"),
                        rs.getInt("num"),rs.getDouble("subtotalprice"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return detail;
    }

    @Override
    public Detail findByID(Integer orderid) {   //这个应当禁用，因为一个orderid是可以查到多条记录的，返回值不对，应该用List<Detail>
        Detail detail = null;
        try {
            this.getConnection();
            String sql = "select * from Details where orderid=?;";
            this.executeQuery(sql,orderid);
            if(rs!=null && rs.next()){
                detail = new Detail(rs.getInt("orderid"),
                        rs.getInt("bookid"),rs.getString("bookname"),rs.getDouble("price"),
                        rs.getInt("num"), rs.getDouble("subtotalprice"));
            }
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return detail;
    }

    @Override
    public List<Detail> findAll() {
        List<Detail> list = null;
        try {
            this.getConnection();
            String sql = "select * from Details;";
            this.executeQuery(sql);
            if(rs!=null){
                list = new ArrayList<>();
                while(rs.next()){
                    //将一行记录封装到一个实体类对象中，再把对象放到List中
                    Detail detail = new Detail(rs.getInt("orderid"),
                            rs.getInt("bookid"),rs.getString("bookname"),rs.getDouble("price"),
                            rs.getInt("num"), rs.getDouble("subtotalprice"));
                    list.add(detail);
                }
            }
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Detail> findBySQL(String sql, Object... params) {
        List<Detail> list = null;
        try {
            this.getConnection();
            this.executeQuery(sql,params);
            if(rs!=null){
                list = new ArrayList<>();
                while(rs.next()){
                    //将一行记录封装到一个实体类对象中，再把对象放到List中
                    Detail detail = new Detail(rs.getInt("orderid"),
                            rs.getInt("bookid"),rs.getString("bookname"),rs.getDouble("price"),
                            rs.getInt("num"), rs.getDouble("subtotalprice"));
                    list.add(detail);
                }
            }
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public int insert(Detail detail) {
        int res = -1;
        try {
            this.getConnection();
            String sql = "insert into Details values(?, ?, ?, ?, ?, ?)";
            this.executeUpdate(sql,detail.getOrderid(),detail.getBookid(),detail.getBookname(),detail.getPrice(),
                    detail.getNum(),detail.getSubtotalprice());
            res = result;
            this.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int update(Detail detail) {
        int res = -1;
        try {
            this.getConnection();
            String sql = "update Details set price=?,num=?," +
                    "subtotalprice=?,bookname=? where orderid=? and bookid=?;";
            this.executeQuery(sql,detail.getPrice(),detail.getNum(),detail.getSubtotalprice(),detail.getBookname(),detail.getOrderid(),detail.getBookid());
            res = result;
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public int delete(Integer orderid) {
        int res = -1;
        try {
            this.getConnection();
            String sql = "delete from Details where orderid=?;";
            this.executeQuery(sql,orderid);
            res = result;
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public int delete(Detail detail) {
        return this.delete(detail.getOrderid());
    }
}
