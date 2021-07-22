package com.test.nkbookshop.dao;

import com.test.nkbookshop.domain.po.Book;

public interface BookDao extends GenericDao<Book, Integer> {
    Book findByName(String bkname);
    Book findByStock(int stock);
}
