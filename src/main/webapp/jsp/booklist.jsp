<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.book.pojo.*"%>
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
	<script>
		function operation(){
			return confirm("Are you sure you want to delete?");
		}
	</script>
</head>
<body>
<%
List<Book>blist=(List<Book>)session.getAttribute("blist");
String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>
<script>
alert("<%=msg%>");
</script>
<%} %>
<div class="container">
<h1>Book list</h1>
	<form>
		<table class="table table-primary">
			<tr>
				<th>Book Id</th>
				<th>Book Name</th>
				<th>Book Price</th>
				<th>Book Pages</th>
				<th colspan=2>Action</th>
			</tr>
			<%for(Book b:blist) {%>
			<tr>
				<td><%=b.getBookid() %></td>
				<td><%=b.getBookname() %></td>
				<td><%=b.getBookprice() %></td>
				<td><%=b.getBooktotalpages() %></td>
				<td><a href="/BookCrudApp/bookc?action=edit&bid=<%=b.getBookid()%>" class="btn btn-success">update</a></td>
				<td><a href="/BookCrudApp/bookc?action=delete&bid=<%=b.getBookid()%>" onclick="return operation()"class="btn btn-danger">delete</a></td>
			</tr>
			<% }%>_
		</table>
	</form>
</div>
</body>
</html>