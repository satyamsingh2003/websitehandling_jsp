<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="org.studyeasy.entity.User"%>
<h1>Listusers</h1>
<table border="1">
<thead>
<tr>
<th>User Id</th>
<th>User name</th>
<th>Email</th>
</tr>
</thead>
<%
	List<User> listusers = (List)request.getAttribute("listusers");
	for(User user1:listusers ){
		out.print("<tr>");
		out.print("<td>"+user1.getUser_id()+"</td>");
		out.print("<td>"+user1.getUsername()+"</td>");
		out.print("<td>"+user1.getEmail()+"</td>");
		out.print("<td> <a href="+request.getContextPath()+"/site?page=updateuser&users_id="+user1.getUser_id()+
				"&username="+user1.getUsername()+"&email="+user1.getEmail()+">Update</a>");
		out.print(" | ");
		out.print("<a href="+request.getContextPath()+"/site?page=deleteuser&users_id="+user1.getUser_id()+">Delete</a></td>");
		out.print("</tr>");
		
		}
%>
</table>