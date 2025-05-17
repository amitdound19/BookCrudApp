<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
        crossorigin="anonymous">
</head>
<body>
<div class="container">
  <h3>Login Here</h3>
  <form action="/BookCrudApp/LoginC" method="post">
  <input type="hidden" name="action" value="login">
  
  
    <div class="mb-3">
    <label for="username" class="form-label">Enter User Email</label>
    <input type="email" class="form-control" id="username" name="username" placeholder="Enter User Email">
    </div>
    
    <div class="mb-3">
    <label for="userpass" class="form-label">Enter User Password</label>
    <input type="email" class="form-control" id="userpass" name="userpass" placeholder="Enter User Password">
    </div>
  
    <div>
      <button class="btn btn-success">Login</button>
      <button class="btn btn-danger">Cancel</button>
    </div>
  
  </form>
</div>
</body>
</html>