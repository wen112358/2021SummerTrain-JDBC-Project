package com.test.nkbookshop.service.impl;

import com.test.nkbookshop.dao.BookDao;
import com.test.nkbookshop.dao.jdbcimpl.BookDaoimpl;
import com.test.nkbookshop.domain.po.Book;
import com.test.nkbookshop.service.BookService;
import java.util.List;

public class BookServiceimpl implements BookService {
    private BookDao bookDao=new BookDaoimpl();

    public boolean register(Book book) {
        // TODO Auto-generated method stub
        boolean res = false;
        int result = -1;
        Book existBook= bookDao.findByName(book.getBkname());
        if (existBook!= null)
            return false;
        result = bookDao.insert(book);
        if (result==1)
            res = true;
        return res;
    }

    public boolean onsale(String bkname) {
        // TODO Auto-generated method stub
        boolean res = false;
        Book book=bookDao.findByName(bkname);
        if (book!=null && bkname.equals(book.getBkname()))
            res = true;
        return res;
    }

    public boolean remove(Book book) {
        // TODO Auto-generated method stub
        boolean res = false;
        int result =-1;
        result=bookDao.delete(book);
        if(result!=-1&&result!=0)
            res=true;
        return res;
    }

    public boolean modify(Book book) {
        // TODO Auto-generated method stub
        boolean res = false;
        int result = -1;
        result=bookDao.update(book);
        if(result!=-1&&result!=0)
            res=true;
        return res;
    }

    public List<Book> findAll() {
        // TODO Auto-generated method stub
        return bookDao.findAll();
    }

    public Book findbook(Integer bookid) {
        // TODO Auto-generated method stub

        return bookDao.findByID(bookid);
    }


}
