package com.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer.dao.CustomerDaoImpl;


@WebServlet("/loginc")
public class LoginController extends HttpServlet {
	boolean result;
	String action;
	RequestDispatcher rd;
	CustomerDaoImpl cdao=new CustomerDaoImpl();
	HttpSession session;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String action=request.getParameter("action");
		String email,pass,type = null;
		if(action!=null && action.equals("login")) {
			email=request.getParameter("username");
			pass=request.getParameter("userpass");
			type=cdao.checkUsertype(email);
			boolean result=cdao.isUser(email, pass);
			if(type!=null && type.equals("admin")) {
				if(result) {
					session.setAttribute("utype", type);
					System.out.println("Welcome admin");
				}
				else {
					System.out.println("please check password");
				}
			}
			else if(type!=null && type.equals("customer")) {
				if(result) {
					session.setAttribute("utype", type);
					System.out.println("welcome "+email);
				}
			}else {
				System.out.println("please check password");
			}
		}
		else if(type==null) {
			System.out.println("invalid!! please check username");
		}
		
	}//login completed

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
