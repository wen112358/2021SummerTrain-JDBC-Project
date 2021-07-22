package com.test.nkbookshop.service.impl;

import com.test.nkbookshop.dao.*;
import com.test.nkbookshop.dao.jdbcimpl.*;
import com.test.nkbookshop.domain.po.*;
import com.test.nkbookshop.service.DetailService;
import com.test.nkbookshop.service.OrderService;

import java.sql.Timestamp;
import java.util.List;

public class OrderServiceimpl implements OrderService {
    private Order order=null;
    private User user=null;
    private Address address=null;
    private List<Detail> detailList=null;
    private Book book=null;

    private OrdersDao ordersDao=new OrderDaoImpl();
    private UserDao userDao=new UserDaoImpl();
    private AddressDao addressDao=new AddressDaoImpl();
    private DetailDao detailDao=new DetailDaoImpl();
    private BookDao bookDao=new BookDaoimpl();

    private DetailService detailService=new DetailServiceImpl();

    @Override
    public boolean showoneorder(int orderID) {
        //order信息输出
        //orderid   time    totalprice
        order=ordersDao.findByID(orderID);
        if(order==null)
            return false;
        System.out.println(
                "orderId:"+ order.getOrderID()+"  "+
                "dealtime:"+order.getTimestamp()+"  "+
                "totalprice:"+order.getTotalprice()
        );
        //user信息输出，包括address表中信息
        //userid   address  phone
        user=userDao.findByID(order.getUserId());
        if(user==null)
            return false;
        address=addressDao.findByID(user.getId());
        if(address==null)
            return false;
        System.out.println(
                "username:"+user.getUsn()+"  "+
                "address:"+ address.getAddress()+"  "+
                "phone:"+address.getPhone()
        );
        //detail信息输出：书籍名字+书籍单价+书籍数量+subprice
        //(detail)  bookname    bookprice   subtotalprice
        detailList=detailDao.findByOrderId(orderID);
        if(detailList==null)return false;
        System.out.println("details:");
        for(Detail detail:detailList){
            System.out.println(
                    "bookname:"+detail.getBookname()+"  "+
                    "bookprice:"+detail.getPrice()+"  "+
                    "subprice:"+detail.getSubtotalprice()
            );
        }
        return true;
    }

    @Override
    public boolean addoneorder(List<Detail> list,int userId) {
        //此时details中的detail只有bookID和num，其余为null
        //遍历完善list中的每一条detail信息
        double totalprice=0;
        for(Detail detail:list){
            int bookId=detail.getBookid();
            book=bookDao.findByID(bookId);
            if(book==null)
                return false;
            String bookname=book.getBkname();
            detail.setBookname(bookname);
            double price=book.getPrice();
            detail.setPrice(price);
            int num=detail.getNum();
            detail.setNum(num);
            double subprice=price*num;
            detail.setSubtotalprice(subprice);
            totalprice+=subprice;

        }
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        Order orderforadd=new Order(timestamp,totalprice,userId);
        if(ordersDao.insert(orderforadd)!=1)
            return false;

        String sql="select max(orderid) from orders;";
        int orderIdforadd=ordersDao.executeSql(sql);
        if(orderIdforadd==-1)
            return false;

        for(Detail detail:list){
            detail.setOrderid(orderIdforadd);
        }

        detailService.adddetail(list);
        return true;
    }

}
