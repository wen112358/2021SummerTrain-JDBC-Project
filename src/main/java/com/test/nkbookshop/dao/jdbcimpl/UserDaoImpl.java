package com.test.nkbookshop.dao.jdbcimpl;

import com.test.nkbookshop.dao.UserDao;
import com.test.nkbookshop.domain.po.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//借助basedao中的共性普适方法实现userdao接口中方法的具体实现
public class UserDaoImpl extends GenericBaseDao implements UserDao {
    /*
        1.打开连接
        2.生成个性|独有的sql语句
        3.调用普适增删改查询方法
        4.处理返回结果
            4.1增删改：获取result的值再返回
            4.2查询：获取rs，遍历结果，将结果集中的记录封装到对应的实体类中，返回实体类
        5.关闭连接
     */

    @Override
    public User findByID(Integer id) {
        User user=null;
        try {
            this.getConnection();
            String sql="select* from users where id=?";
            this.executeQuery(sql,id);
            if(rs!=null&&rs.next()){
                user=new User(rs.getInt("id"),rs.getString("usn"),
                        rs.getString("pwd"),rs.getInt("age"),
                        rs.getDate("birthday"),rs.getDouble("salary"),
                        rs.getTimestamp("regtime")
                        );
            }
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users=null;
        try {
            this.getConnection();
            String sql="select* from users";
            this.executeQuery(sql);
            if(rs!=null){
                users=new ArrayList<>();
                while (rs.next()){
                    //将一行记录封装到一个实体类对象中
                    User user=new User(rs.getInt("id"),rs.getString("usn"),
                            rs.getString("pwd"),rs.getInt("age"),
                            rs.getDate("birthday"),rs.getDouble("salary"),
                            rs.getTimestamp("regtime")
                    );
                    //将一个实体类对象加入list
                    users.add(user);
                }
            }
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> findBySQL(String sql, Object... params) {
        List<User> users=null;
        try {
            this.getConnection();
            this.executeQuery(sql,params);
            if(rs!=null){
                users=new ArrayList<>();
                while (rs.next()){
                    //将一行记录封装到一个实体类对象中
                    User user=new User(rs.getInt("id"),rs.getString("usn"),
                            rs.getString("pwd"),rs.getInt("age"),
                            rs.getDate("birthday"),rs.getDouble("salary"),
                            rs.getTimestamp("regtime")
                    );
                    //将一个实体类对象加入list
                    users.add(user);
                }
            }
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public int insert(User user) {
        int res=-1;
        try {
            this.getConnection();
            String sql="insert into users values(null,?,?,?,?,?,?)";
            this.executeUpdate(sql,user.getUsn(),user.getPwd(),user.getAge(),
                    user.getBirthday(), user.getSalary(),user.getRegtime()
            );
            res=result;
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public int update(User user) {
        int res=-1;
        try {
            this.getConnection();
            String sql="update users set usn=?,pwd=?,age=?,birthday=?," +
                    "salary=?,regtime=? where id=?";
            this.executeUpdate(sql,user.getUsn(),user.getPwd(),user.getAge(),
                    user.getBirthday(), user.getSalary(),user.getRegtime(),user.getId()
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
            String sql="delete from users where id=?";
            this.executeUpdate(sql,id);
            res=result;
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public int delete(User user) {
        return this.delete(user.getId());
    }

    @Override
    public User findByName(String usn) {
        User user=null;
        try {
            this.getConnection();
            String sql="select* from users where usn=?";
            this.executeQuery(sql,usn);
            if(rs!=null&&rs.next()){
                user=new User(rs.getInt("id"),rs.getString("usn"),
                        rs.getString("pwd"),rs.getInt("age"),
                        rs.getDate("birthday"),rs.getDouble("salary"),
                        rs.getTimestamp("regtime")
                );
            }
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
