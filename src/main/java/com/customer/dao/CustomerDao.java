package com.customer.dao;

import java.util.List;

import com.customer.pojo.Customer;

public interface CustomerDao {
	
	public boolean saveCustomer(Customer cust);
	public boolean updateCustomer(Customer cust);
	public boolean deleteCustomer(int custid);
	public List<Customer>showCustomerList();
	public Customer searchCustomerById(int custid);
	public Customer searchCustomerByEmail(String Custemail);
	public String checkUsertype(String cemail);
	public boolean isUser(String custemail,String custpass);
	
}
