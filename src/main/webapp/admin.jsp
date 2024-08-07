<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="metie.Login" %>
<%@ page import="web.LoginBeans" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>la page pour l'admin </h2>
<p><% LoginBeans lb =(LoginBeans)request.getAttribute("lb");%></p>
<p><% String message  =(String)request.getAttribute("message");%></p>
<table border="1px" width="50%">
	<tr>
		<th>User ID </th>
		<th>User name  </th>
		<th>Password </th>
	</tr>
	<%
	for(Login l : lb.getLogins()){
	%>
	<tr>
		<td><%=l.getId() %></td>
		<td><%=l.getLogin() %></td>
		<td><%=l.getPassword() %></td>
	</tr>
	<%} %>
</table>
<h5><%=message %></h5>
</body>
</html>