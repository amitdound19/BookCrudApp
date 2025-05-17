package com.book.dao;

import java.util.List;

import com.book.pojo.Book;

public interface BookDao {

	public boolean saveBook(Book book);
	public boolean updateBook(Book book);
	public boolean deleteBook(int bookid);
	public List<Book>showBookList();
	public Book searchBookById(int bookid);
	public String checkUsertype(String email);
	public boolean isAdmin(String email,String pass);
	
}
