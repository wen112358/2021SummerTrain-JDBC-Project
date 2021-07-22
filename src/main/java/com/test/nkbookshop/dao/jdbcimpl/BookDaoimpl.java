package com.test.nkbookshop.dao.jdbcimpl;

import com.test.nkbookshop.dao.BookDao;
import com.test.nkbookshop.domain.po.Book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoimpl extends GenericBaseDao implements BookDao {

    public Book findByID(Integer bookid) {
        // TODO Auto-generated method stub
        Book book=null;
        try {
            this.getConnection();
            String sql="select * from books where bookid = ?";
            this.executeQuery(sql, bookid);
            if(rs!=null&&rs.next())
            {
                book=new Book(rs.getInt("bookid"),rs.getString("bkname"),rs.getDouble("price"),rs.getInt("stock"));
            }
            this.closeAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return book;
    }

    public List<Book> findAll() {
        // TODO Auto-generated method stub
        List<Book> books=null;
        try {
            this.getConnection();
            String sql="select * from books";
            this.executeQuery(sql);
            if(rs!=null)
            {
                books=new ArrayList<Book>();
                while(rs.next()) {
                    Book book=new Book(rs.getInt("bookid"),rs.getString("bkname"),rs.getDouble("price"),rs.getInt("stock"));
                    books.add(book);
                }
            }
            this.closeAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return books;
    }

    public List<Book> findBySQL(String sql, Object... params) {
        // TODO Auto-generated method stub
        List<Book> books=null;
        try {
            this.getConnection();
            this.executeQuery(sql,params);
            if(rs!=null)
            {
                books=new ArrayList<Book>();
                while(rs.next()) {
                    Book book=new Book(rs.getInt("bookid"),rs.getString("bkname"),rs.getDouble("price"),rs.getInt("stock"));
                    books.add(book);
                }
            }
            this.closeAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return books;
    }

    public int insert(Book book) {
        // TODO Auto-generated method stub
        int res=-1;
        try {
            this.getConnection();
            String sql = "insert into books values(null, ?, ?, ?)";
            this.executeUpdate(sql,book.getBkname(),book.getPrice(),book.getStock());
            res=result;
            this.closeAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return res;
    }

    public int update(Book book) {
        // TODO Auto-generated method stub
        int res=-1;
        try {
            this.getConnection();
            String sql = "update books set bkname=?,price=?,stock=? where bookid=?";
            this.executeUpdate(sql,book.getBkname(),book.getPrice(),book.getStock(),book.getBookid());
            res=result;
            this.closeAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return res;
    }
//	public int updateStock(Book book) {
//		// TODO Auto-generated method stub
//		int res=-1;
//		try {
//			this.getConnetion();
//			String sql = "update books set stock=? where bookid=?";
//			this.executeUpdate(sql,book.getStock(),book.getBookid());
//			res=result;
//			this.closeAll();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return res;
//	}

    public int delete(Integer bookid) {
        // TODO Auto-generated method stub
        int res=-1;
        try {
            this.getConnection();
            String sql = "delete from books where bookid=?";
            this.executeUpdate(sql,bookid);
            res=result;
            this.closeAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return res;
    }

    public int delete(Book book) {
        // TODO Auto-generated method stub
        return this.delete(book.getBookid());
    }

    public Book findByName(String bkname) {
        // TODO Auto-generated method stub
        Book book=null;
        try {
            this.getConnection();
            String sql="select * from books where bkname= ?";
            this.executeQuery(sql, bkname);
            if(rs!=null&&rs.next())
            {
                book=new Book(rs.getInt("bookid"),rs.getString("bkname"),rs.getDouble("price"),rs.getInt("stock"));
            }
            this.closeAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return book;
    }

    public Book findByStock(int stock) {
        // TODO Auto-generated method stub
        Book book=null;
        try {
            this.getConnection();
            String sql="select * from books where stock>= ?";
            this.executeQuery(sql,stock);
            if(rs!=null&&rs.next())
            {
                book=new Book(rs.getInt("bookid"),rs.getString("bkname"),rs.getDouble("price"),rs.getInt("stock"));
            }
            this.closeAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return book;
    }

}

