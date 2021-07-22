package com.test.nkbookshop.web.controller;

import com.test.nkbookshop.domain.po.Book;
import com.test.nkbookshop.service.BookService;
import com.test.nkbookshop.service.impl.BookServiceimpl;

import java.util.List;

public class BookController {

    private BookService bookService=new BookServiceimpl();

    private Book book;

    public String addBook()
    {
        boolean res = bookService.register(book);
        if(res)
            return"Add Success!";
        else
            return"Add Fail!";
    }

    public String removeBook()
    {
        boolean res = bookService.remove(book);
        if(res)
            return"Remove Success!";
        else
            return"Remove Fail!";
    }

    public String updateBook()
    {
        boolean res = bookService.modify(book);
        if(res)
            return"Update Success!";
        else
            return"Update Fail!";
    }

    public List<Book> findAllBook()
    {
        return bookService.findAll();
    }

    public Book findBook() {
        return bookService.findbook(book.getBookid());
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}