package com.test.nkbookshop.service;

import com.test.nkbookshop.domain.po.Book;
import java.util.List;

public interface BookService {
    boolean register(Book book);
    boolean onsale(String bkname);
    boolean remove(Book book);
    boolean modify(Book book);



    List<Book> findAll();
    Book findbook(Integer bookid);
}

