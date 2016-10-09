<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.jsp.test.Employee" %>

<jsp:useBean id="myBean" class="com.jsp.test.Employee" scope="session">
	<jsp:setProperty name="myBean" property="name" value="Hello World"/>
</jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><jsp:getProperty name="myBean" property="name"/></h1>
	<% myBean.setName("Ekas Preet Singh"); %>
	<%= myBean.getName()%>
</body>
</html>