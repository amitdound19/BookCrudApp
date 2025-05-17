package com.book.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.book.db.DBConnection;
import com.book.pojo.Book;

public class BookDaoImpl implements BookDao{

	Connection conn=DBConnection.getConnect();
	String sql;
	PreparedStatement ps;
	ResultSet rs;
	int i;
	@Override
	public boolean saveBook(Book book) {
		System.out.println("inside bookdaoimpl save method");
		sql="insert into book(bookname,bookprice,booktotalpages)values(?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,book.getBookname());
			ps.setDouble(2, book.getBookprice());
			ps.setInt(3, book.getBooktotalpages());
			System.out.println("query:"+ps);
			i=ps.executeUpdate();
			if(i>0)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateBook(Book book) {
		System.out.println("inside bookdaoimpl save method");
		sql="update book set bookname=?,bookprice=?,booktotalpages=? where bookid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,book.getBookname());
			ps.setDouble(2, book.getBookprice());
			ps.setInt(3, book.getBooktotalpages());
			ps.setInt(4, book.getBookid());
			System.out.println("query:"+ps);
			i=ps.executeUpdate();
			if(i>0)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteBook(int bookid) {
		System.out.println("inside bookdaoimpl delete method");
		sql="delete from book where bookid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bookid);			
			System.out.println("query:"+ps);
			i=ps.executeUpdate();
			if(i>0)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Book> showBookList() {
		sql="select *from book";
		List<Book>blist=new ArrayList<Book>();
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Book b=new Book();
				//System.out.println(rs.getInt(1));
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setBookprice(rs.getDouble(3));
				b.setBooktotalpages(rs.getInt(4));
				blist.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return blist;
	}

	@Override
	public Book searchBookById(int bookid) {
		// TODO Auto-generated method stub
		sql="select *from book where bookid=?";
		Book b=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bookid);
			rs=ps.executeQuery();
			System.out.println("query:"+ps);
			while(rs.next()) {
				b=new Book();
				//System.out.println(rs.getInt(1));
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setBookprice(rs.getDouble(3));
				b.setBooktotalpages(rs.getInt(4));
				//blist.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public String checkUsertype(String email) {
		// TODO Auto-generated method stub
		sql="select ctype from customer where cemail=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
			if(rs.next())
				return rs.getString(1);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isAdmin(String email, String pass) {
		// TODO Auto-generated method stub
		sql="select cemail,cpassword from customer where cemail=? and cpassword=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(i, email);
			ps.setString(2, pass);
			System.out.println(ps);
			rs=ps.executeQuery();
			if(rs.next())
				return true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
