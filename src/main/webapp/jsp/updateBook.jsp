<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.book.pojo.*"%>
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
Book b=(Book)session.getAttribute("book");
%>
<div class="container">
<h3 class="m-4">Update book here</h3>
	<form action="/BookCrudApp/bookc" method="post">
	<input type="hidden" name="action" value="updatebook">
		<div class="mb-3">
			<label for="bookid" class="form-label"> Book Id</label> <input
				type="text" class="form-control" id="bookid" name="bookid" value="<%=b.getBookid() %>"
				placeholder=" book id" readonly="readonly">
		</div>
		<div class="mb-3">
			<label for="bookname" class="form-label">Enter Book Name</label> <input
				type="text" class="form-control" id="bookname" name="bookname" value="<%=b.getBookname() %>"
				placeholder="Enter book name">
		</div>
		<div class="mb-3">
			<label for="bookprice" class="form-label">Enter Book Price</label> <input
				type="text" class="form-control" id="bookprice" name="bookprice" value="<%=b.getBookprice() %>"
				placeholder="Enter book price">
		</div>
		<div class="mb-3">
			<label for="booktotalpages" class="form-label">Enter Book Pages</label> <input
				type="text" class="form-control" id="booktotalpages" name="booktotalpages" value="<%=b.getBooktotalpages() %>"
				placeholder="Enter book total pages">
		</div>
		<div>
			<button class="btn btn-primary">update book</button>
			<button class="btn btn-danger" type="reset">clear</button>
		</div>
		</form>
</div>
</body>
</html>