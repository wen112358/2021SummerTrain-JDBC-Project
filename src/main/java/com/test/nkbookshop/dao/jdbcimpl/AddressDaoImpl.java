package com.test.nkbookshop.dao.jdbcimpl;

import com.test.nkbookshop.dao.AddressDao;
import com.test.nkbookshop.domain.po.Address;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl extends GenericBaseDao implements AddressDao {
    @Override
    public Address findByID(Integer userID) {
        Address address = null;
        try {
            this.getConnection();
            String sql = "select * from addresses where userID = ?";
            this.executeQuery(sql, userID);
            if (rs != null && rs.next()) {
                address = new Address(rs.getInt("userID"), rs.getString("address"),
                        rs.getString("phone"));
            }
            this.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public List<Address> findAll() {
        List<Address> addresses = null;
        try {
            this.getConnection();
            String sql = "select * from addresses";
            this.executeQuery(sql);
            if (rs != null) {
                addresses = new ArrayList<>();
                while (rs.next()) {
                    Address address = new Address(rs.getInt("addressID"), rs.getString("address"),
                            rs.getString("phone"));
                    addresses.add(address);
                }
            }
            this.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    @Override
    public List<Address> findBySQL(String sql, Object... params) {
        List<Address> addresses = null;
        try {
            this.getConnection();
            this.executeQuery(sql, params);
            if (rs != null) {
                addresses = new ArrayList<>();
                while (rs.next()) {
                    Address address = new Address(rs.getInt("userID"), rs.getString("address"),
                            rs.getString("phone"));
                    addresses.add(address);
                }
            }
            this.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    @Override
    public int insert(Address address) {
        int res = -1;
        try {
            this.getConnection();
            String sql = "insert into addresses values(?, ?, ?)";
            this.executeUpdate(sql, address.getUserID(), address.getAddress(), address.getPhone());
            res = result;
            this.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int update(Address address) {
        int res = -1;
        try {
            this.getConnection();
            String sql = "update addresses set address = ?, phone = ? where userID = ?";
            this.executeUpdate(sql, address.getAddress(), address.getPhone(), address.getUserID());
            res = result;
            this.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int delete(Integer userID) {
        int res = -1;
        try {
            this.getConnection();
            String sql = "delete from addresses where userID = ?";
            this.executeUpdate(sql, userID);
            res = result;
            this.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int delete(Address address) {
        return this.delete(address.getUserID());
    }

    @Override
    public Address findByPhone(String phone) {
        Address address = null;
        try {
            this.getConnection();
            String sql = "select * from addresses where phone = ?";
            this.executeQuery(sql, phone);
            if (rs != null && rs.next()) {
                address = new Address(rs.getInt("userID"), rs.getString("address"),
                        rs.getString("phone"));
            }
            this.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }
}