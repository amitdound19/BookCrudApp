package com.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.db.DBConnection;
import com.customer.pojo.Customer;

public class CustomerDaoImpl  implements CustomerDao{

	Connection conn=DBConnection.getConnect();
	String sql;
	PreparedStatement ps;
	ResultSet rs;
	int i;
	
	
	@Override
	public boolean saveCustomer(Customer cust) {
		// TODO Auto-generated method stub
		System.out.println("inside customerdaoimpl save method");
		sql="insert into customer(Cname,Cemail,Ccontact,Cadderss,Cpass)Values(?,?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, cust.getCname());
			ps.setString(2, cust.getCemail());
			ps.setString(3, cust.getCcontact());
			ps.setString(4, cust.getCaddress());
			ps.setString(5, cust.getCpass());
			System.out.println("query:"+ps);
			i=ps.executeUpdate();
			if(i>0)
				return true;
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		System.out.println("inside customerdaoimpl save method");
		sql="update customer set Cname=?,Cemail=?,Ccontact=?,Cadderss=?,Cpass=? where Customerid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, cust.getCname());
			ps.setString(2, cust.getCemail());
			ps.setString(3, cust.getCcontact());
			ps.setString(4, cust.getCaddress());
			ps.setString(5, cust.getCpass());
			ps.setInt(6, cust.getCid());
			System.out.println("query"+ps);
			i=ps.executeUpdate();
			if(i>0)
				return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteCustomer(int custid) {
		// TODO Auto-generated method stub
		System.out.println("inside customerdaoimpl delete method");
		sql="delete from customer where Customerid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, custid);			
			System.out.println("query:"+ps);
			i=ps.executeUpdate();
			if(i>0)
				return true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Customer> showCustomerList() {
		// TODO Auto-generated method stub
		sql="select * from customer";
		List<Customer>clist=new ArrayList<Customer>();
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Customer c=new Customer();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setCemail(rs.getString(3));
				c.setCcontact(rs.getString(4));
				c.setCaddress(rs.getString(5));
				c.setCpass(rs.getString(6));
				clist.add(c);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clist;
	}

	@Override
	public Customer searchCustomerById(int custid) {
		// TODO Auto-generated method stub
		sql="select * from customer where Customerid=?";
		Customer c=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, custid);
			rs=ps.executeQuery();
			System.out.println("query:"+ps);
			while(rs.next()) {
				c=new Customer();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setCemail(rs.getString(3));
				c.setCcontact(rs.getString(4));
				c.setCaddress(rs.getString(5));
				c.setCpass(rs.getString(6));
				
				
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Customer searchCustomerByEmail(String Custemail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkUsertype(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUser(String custemail, String custpass) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
