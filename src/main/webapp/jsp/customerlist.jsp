<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.customer.pojo.*"%>
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
List<Customer>clist=(List<Customer>)session.getAttribute("clist");
String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>
<script>
alert("<%=msg%>");
</script>
<%} %>
<div class="container">
<h1>Customer list</h1>
	<form>
		<table class="table table-primary">
			<tr>
				<th>Customer Id</th>
				<th>Customer Name</th>
				<th>Customer Email Id</th>
				<th>Customer Contact No</th>
				<th>Customer Address</th>
				<th>Customer Pass</th>
				<th colspan=2>Action</th>
			</tr>
			<%for(Customer c:clist) {%>
			<tr>
				<td><%=c.getCid()%></td>
				<td><%=c.getCname() %></td>
				<td><%=c.getCemail() %></td>
				<td><%=c.getCcontact() %></td>
				<td><%=c.getCaddress() %></td>
				<td><%=c.getCpass() %></td>
				<td><a href="/BookCrudApp/customerc?action=edit&cid=<%=c.getCid()%>" class="btn btn-success">update</a></td>
				<td><a href="/BookCrudApp/customerc?action=delete&cid=<%=c.getCid()%>" onclick="return operation()"class="btn btn-danger">delete</a></td>
			</tr>
			<% }%>
			</table>
	</form>
</div>
</body>
</html>