package com.book.pojo;

public class Book {

	private int bookid;
	private String bookname;
	private double bookprice;
	private int booktotalpages;
	public Book() {
		super();
	}
	
	public Book(String bookname, double bookprice, int booktotalpages) {
		super();
		this.bookname = bookname;
		this.bookprice = bookprice;
		this.booktotalpages = booktotalpages;
	}

	public Book(int bookid, String bookname, double bookprice, int booktotalpages) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.bookprice = bookprice;
		this.booktotalpages = booktotalpages;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public double getBookprice() {
		return bookprice;
	}

	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}

	public int getBooktotalpages() {
		return booktotalpages;
	}

	public void setBooktotalpages(int booktotalpages) {
		this.booktotalpages = booktotalpages;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + ", bookprice=" + bookprice + ", booktotalpages="
				+ booktotalpages + "]";
	}
	
}
