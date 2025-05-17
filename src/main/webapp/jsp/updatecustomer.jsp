<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.customer.pojo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
<%
Customer c=(Customer)session.getAttribute("customer");
%>
<div class="container">
<h3 class="m-4">Update Customer Details here</h3>
	<form action="/BookCrudApp/customerc" method="post">
	<input type="hidden" name="action" value="updatecustomer">
		<div class="mb-3">
			<label for="Customerid" class="form-label">Customer Id</label> 
			<input type="text" class="form-control" id="Customerid" name="cid" value="<%=c.getCid()%>" placeholder="Customerid" readonly="readonly">
		</div>
		
		<div class="mb-3">
			<label for="customername" class="form-label">Enter Customer Name</label> 
			<input type="text" class="form-control" id="customername" name="cname" value="<%=c.getCname() %>" placeholder="Enter customer name">
		</div>
		
		<div class="mb-3">
			<label for="customeremail" class="form-label">Enter Customer Email</label> <input
				type="text" class="form-control" id="customeremail" name="cemail" value="<%=c.getCemail() %>"
				placeholder="Enter customer email">
		</div>
		
		<div class="mb-3">
			<label for="customercontact" class="form-label">Enter Contact Number</label> <input
				type="text" class="form-control" id="customercontact" name="ccontact" value="<%=c.getCcontact() %>"
				placeholder="Enter customer contact">
		</div>
		
		<div class="mb-3">
			<label for="customeraddress" class="form-label">Enter Customer Address</label> <input
				type="text" class="form-control" id="customeraddress" name="caddress" value="<%=c.getCaddress() %>"
				placeholder="Enter Customer address">
		</div>
		
		<div class="mb-3">
			<label for="customerpass" class="form-label">Enter Password</label> <input
				type="text" class="form-control" id="customerpass" name="cpass" value="<%=c.getCpass() %>"
				placeholder="Enter Customer pass">
		</div>
		
		<div>
			<button class="btn btn-primary">update Details</button>
			<button class="btn btn-danger" type="reset">clear</button>
		</div>
		</form>
</div>
</body>
</html>