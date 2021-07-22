package com.test.nkbookshop.dao;

import java.io.Serializable;
import java.util.List;

//通用基于泛型接口
//Entity = 实体类  共性：实现了Serializable接口
//ID = 主键   共性：Object
//方法:增删改
public interface GenericDao<Entity extends Serializable,ID extends Object> {
    Entity findByID(ID id);
    List<Entity> findAll();
    List<Entity> findBySQL(String sql, Object... params);

    int insert(Entity entity);
    int update(Entity entity);
    int delete(ID id);
    int delete(Entity entity);
}
