package com.test.nkbookshop.dao;

import com.test.nkbookshop.domain.po.User;

//import java.util.List;

public interface UserDao extends GenericDao<User,Integer> {
    User findByName(String usn);
    //List<User> findBySQL(String sql,Object... params);
}
