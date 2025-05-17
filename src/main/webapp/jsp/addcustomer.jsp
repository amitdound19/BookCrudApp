<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add customer</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<h3 class="m-4">Add Customer here</h3>
	<form action="/BookCrudApp/customerc" method="post">
	<input type="hidden" name="action" value="savecust">
		
		<div class="mb-3">
			<label for="cname" class="form-label">Enter Customer Name</label> 
			<input type="text" class="form-control" id="cname" name="cname" placeholder="Enter customer name">
		</div>
		
		<div class="mb-3">
			<label for="cemail" class="form-label">Enter Customer email</label> 
			<input type="text" class="form-control" id="cemail" name="cemail" placeholder="Enter customer email">
		</div>
		
		<div class="mb-3">
			<label for="ccontact" class="form-label">Enter Customer Contact</label> 
			<input type="text" class="form-control" id="ccontact" name="ccontact" placeholder="Enter customer contact">
		</div>
		
		<div class="mb-3">
			<label for="caddress" class="form-label">Enter Customer Address</label> 
			<input type="text" class="form-control" id="caddress" name="caddress" placeholder="Enter customer address">
		</div>
		
		<div class="mb-3">
			<label for="cpass" class="form-label">Enter Customer pass</label> 
			<input type="password" class="form-control" id="cpass" name="cpass" placeholder="Enter customer pass">
		</div>
		
			<button class="btn btn-primary">Save</button>
			<button class="btn btn-danger" type="reset">clear</button>
		
		</form>
	</div>
</body>
</html>