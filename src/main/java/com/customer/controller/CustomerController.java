package com.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer.dao.CustomerDaoImpl;
import com.customer.pojo.Customer;


@WebServlet("/customerc")
public class CustomerController extends HttpServlet {
	PrintWriter out;
	boolean result;
	String action;
	RequestDispatcher rd;
	Customer customer;
	CustomerDaoImpl cdao=new CustomerDaoImpl();
	int cid;
	String cname,cemail,ccontact,caddress,cpass;
	HttpSession session;
	public CustomerController() {
		
	}
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		response.setContentType("text/html");
		action=request.getParameter("action");
		session=request.getSession();
		System.out.println("action:"+action);
		if(action!=null && action.equalsIgnoreCase("savecust")) {
			cname=request.getParameter("cname");
			cemail=request.getParameter("cemail");
			ccontact=request.getParameter("ccontact");
			caddress=request.getParameter("caddress");
			cpass=request.getParameter("cpass");
			customer=new Customer(cname,cemail,ccontact,caddress,cpass);
			result=cdao.saveCustomer(customer);
			System.out.println(result);
			System.out.println("amit");
			if(result) {
				List<Customer>clist=cdao.showCustomerList();
				if(!clist.isEmpty()) {
					request.setAttribute("msg", "Customer Added");
					session.setAttribute("clist", clist);
					rd=request.getRequestDispatcher("/jsp/customerlist.jsp");
					rd.forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "customer not added");
				rd=request.getRequestDispatcher("/jsp/addcustomer.jsp");
				rd.forward(request, response);
			}
		}
		else if(action!=null && action.equalsIgnoreCase("delete")) {
			System.out.println("inside delete operation");
			cid=Integer.parseInt(request.getParameter("cid"));
			result=cdao.deleteCustomer(cid);
			if(result) {
				System.out.println("Customer deleted");
				List<Customer>clist=cdao.showCustomerList();
				if(!clist.isEmpty()) {
					session.setAttribute("clist", clist);
					rd=request.getRequestDispatcher("/jsp/customerlist.jsp");
					rd.forward(request, response);
				}
				else {
					System.out.println("Customer List is Empty...");
				}
			}
			else {
				System.out.println("Customer not deleted");
			}
		}
		else if(action!=null && action.equalsIgnoreCase("edit")) {
			System.out.println("inside edit opeartion");
			cid=Integer.parseInt(request.getParameter("cid"));
			System.out.println("cid:"+cid);
			customer=cdao.searchCustomerById(cid);
			System.out.println(customer);
			if(customer!=null) {
				session.setAttribute("customer", customer);
				rd=request.getRequestDispatcher("/jsp/updatecustomer.jsp");
				rd.forward(request, response);
			}
		}
		
		else if(action!=null && action.equalsIgnoreCase("updatecustomer")) {
			System.out.println("inside customer update");
			cname=request.getParameter("cname");
			cemail=request.getParameter("cemail");
			ccontact=request.getParameter("ccontact");
			caddress=request.getParameter("caddress");
			cpass=request.getParameter("cpass");
			cid=Integer.parseInt(request.getParameter("cid"));
			customer=new Customer(cid,cname, cemail, ccontact,caddress,cpass);
			result=cdao.updateCustomer(customer);
			if(result) {
				List<Customer>clist=cdao.showCustomerList();
				if(!clist.isEmpty()) {
					request.setAttribute("msg", "customer updated successfully");
					session.setAttribute("clist", clist);
					rd=request.getRequestDispatcher("/jsp/customerlist.jsp");
					rd.forward(request, response);
				}
			}
			else {
				rd=request.getRequestDispatcher("/jsp/updatecustomer.jsp");
				rd.forward(request, response);
			}
		}
		else {
			System.out.println("inside customer show");
			List<Customer>clist=cdao.showCustomerList();
			if(!clist.isEmpty()) {
				session.setAttribute("clist", clist);
				rd=request.getRequestDispatcher("/jsp/customerlist.jsp");
				rd.forward(request, response);
			}
			else {
				System.out.println("customer list is empty");
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
