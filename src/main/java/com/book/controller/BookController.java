package com.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.dao.BookDaoImpl;
import com.book.pojo.Book;
import java.util.*;

@WebServlet("/bookc")
public class BookController extends HttpServlet {
	
	PrintWriter out;
	boolean result;
	String action;
	RequestDispatcher rd;
	Book book=null;
	BookDaoImpl bdao;
	int bookid,booktotalpages;
	String bookname;
	double bookprice;
	HttpSession session;
    public BookController() {
       bdao=new BookDaoImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//save 
		out=response.getWriter();
		response.setContentType("text/html");
		action=request.getParameter("action");
		session=request.getSession();
		System.out.println("action:"+action);
		if(action!=null && action.equalsIgnoreCase("savebook")) {
			bookname=request.getParameter("bookname");
			bookprice=Double.parseDouble(request.getParameter("bookprice"));
			booktotalpages=Integer.parseInt(request.getParameter("booktotalpages"));
			book=new Book(bookname, bookprice, booktotalpages);
			result=bdao.saveBook(book);
			System.out.println(result);
			if(result) {
				List<Book>blist=bdao.showBookList();
				if(!blist.isEmpty()) {
					request.setAttribute("msg", "book added");
					session.setAttribute("blist", blist);
					rd=request.getRequestDispatcher("/jsp/booklist.jsp");
					rd.forward(request, response);
				}
			}
				
			else {
				request.setAttribute("msg", "book not added");
				rd=request.getRequestDispatcher("/jsp/addbook.jsp");
				rd.forward(request, response);
			}
				
		}
		else if(action!=null && action.equalsIgnoreCase("delete")) {
			System.out.println("inside delete operation");
			bookid=Integer.parseInt(request.getParameter("bid"));
			System.out.println("bookid:"+bookid);
			result=bdao.deleteBook(bookid);
			if(result) {
				System.out.print("book deleted");
				List<Book>blist=bdao.showBookList();
				if(!blist.isEmpty()) {
					session.setAttribute("blist", blist);
					rd=request.getRequestDispatcher("/jsp/booklist.jsp");
					rd.forward(request, response);
				}
				else {
					System.out.println("book list is emoty");
				}
			}
			else
				out.print("book not deleted");
		}
		else if(action!=null && action.equalsIgnoreCase("edit")) {
			System.out.println("inside edit operation");
			bookid=Integer.parseInt(request.getParameter("bid"));
			System.out.println("bookid:"+bookid);
			book=bdao.searchBookById(bookid);
			System.out.println(book);
			if(book!=null) {
				session.setAttribute("book", book);
				rd=request.getRequestDispatcher("/jsp/updateBook.jsp");
				rd.forward(request, response);
			}
		}
		else if(action!=null && action.equalsIgnoreCase("updatebook")) {
			System.out.println("inside book update");
			bookname=request.getParameter("bookname");
			bookprice=Double.parseDouble(request.getParameter("bookprice"));
			booktotalpages=Integer.parseInt(request.getParameter("booktotalpages"));
			bookid=Integer.parseInt(request.getParameter("bookid"));
			book=new Book(bookid, bookname, bookprice, booktotalpages);
			result=bdao.updateBook(book);
			if(result) {
				List<Book>blist=bdao.showBookList();
				if(!blist.isEmpty()) {
					request.setAttribute("msg", "book updated successfully");
					session.setAttribute("blist", blist);
					rd=request.getRequestDispatcher("/jsp/booklist.jsp");
					rd.forward(request, response);
				}
			}
			else {
				rd=request.getRequestDispatcher("/jsp/updateBook.jsp");
				rd.forward(request, response);
			}
		}
		else {
			System.out.println("inside book show");
			List<Book>blist=bdao.showBookList();
			if(!blist.isEmpty()) {
				session.setAttribute("blist", blist);
				rd=request.getRequestDispatcher("/jsp/booklist.jsp");
				rd.forward(request, response);
			}
			else {
				System.out.println("book list is emoty");
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
