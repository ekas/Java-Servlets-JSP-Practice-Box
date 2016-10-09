<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.sql.*"%>
<% 
String queryStringVal1 = request.getParameter("name");
String queryStringVal2 = request.getParameter("className");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
out.print("<br>Name: " + queryStringVal1);
out.print("<br>Class: " + queryStringVal2);
%>
<form action="http://localhost:8081/01JspSimpleForm/index.jsp" method="get">
	Name<input name="name" type="text">
	Class<input name="className" type="text">
	<input type="submit" name="Submit">
</form>
</body>
</html>