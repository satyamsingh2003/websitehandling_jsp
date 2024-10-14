<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>
<form action ="${pageContext.request.contextPath}/site" method="post">
User name = <input type="text" name= "username" required="required"/><br>
email = <input type="email" name="email" required="required"/><br>
<input type="hidden" name="form" value="addUserOperation">
<input type="submit" value= "Add User">	
</form>
</body>
</html>