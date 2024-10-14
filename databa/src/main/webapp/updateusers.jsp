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
User name = <input type="text" name= "username" value="${param.username}" required="required"/><br>
email = <input type="email" name="email" value="${param.email}" required="required"/><br>
<input type="hidden" name="users_id" value="${param.users_id}">
<input type="hidden" name="form" value="updateUserOperation">
<input type="submit" value= "Update User">	
</form>
</body>
</html>